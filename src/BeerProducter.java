
public class BeerProducter extends Thread{

    public final int stock= 100;
    public int tanksbeer = 250;
    public BeerHouse House;
    private boolean condition = true;
    private boolean NeedonoNeed = true;

    public BeerProducter(BeerHouse house) {
        super();
        House = house;
    }
    public BeerProducter() {
        super();
    }

    public void run(){
        while (condition){ //Esto va a generar un bucle infinito que va a validar dos condiciones.
            if(tanksbeer > 0){ //1: Valido si hay cerveza en los barriles.
                if(tanksbeer >= 100){//2: Valido que alla variles para reponer sino fabrico mas cerveza.
                    int previousStock = stock - House.getStock();
                    try {
                        this.NeedonoNeed = false;
                        House.loadStock();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    this.tanksbeer = this.tanksbeer - previousStock;
                }
                else{
                    this.NeedonoNeed = true;
                    House.setStock(tanksbeer);
                    this.tanksbeer = this.tanksbeer - this.tanksbeer;
                }
            }
            else{//Detengo el sistema porque no ahi mas stock de servezas.
                try {
                    this.condition = House.stopProduct(this.tanksbeer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getStock() {
        return stock;
    }

    public int getTanksbeer() {
        return tanksbeer;
    }

    public void setTanksbeer(int tanksbeer) {
        this.tanksbeer = tanksbeer;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    public boolean isNeedonoNeed() {
        return NeedonoNeed;
    }

    public void setNeedonoNeed(boolean needonoNeed) {
        NeedonoNeed = needonoNeed;
    }
}
