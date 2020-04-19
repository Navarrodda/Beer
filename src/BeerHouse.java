import javax.swing.*;

public class BeerHouse{
    private BeerProducter producter;
    private String nombreHause;
    private int stock;
    private boolean inUser = false;
    private boolean tanksbeerempty = true;

    public BeerHouse() {
        this.stock = 0;
        producter = new BeerProducter();
    }

    public synchronized void loadStock() throws IllegalAccessException{
        while (inUser){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int thisbeer = producter.getStock();
        boolean tanksbeerempty = producter.isNeedonoNeed();
        if((thisbeer + this.stock) == 100 || tanksbeerempty) { // Debo confirmar, antes de dormirse se quedo con un dato viejo, por lo que hay que refrescar los datos.
           this.printload();
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.stock = this.stock + thisbeer;
            this.printbeerloadStock(thisbeer);
            tanksbeerempty = true;
            notify();

            this.inUser = tanksbeerempty;
        }
        if(this.getStock() < 100 && tanksbeerempty){
            tanksbeerempty = true;
            notify();
        }
    }

    public synchronized int getBeers( int cantBeers) throws InterruptedException {
        while(!inUser){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        if (this.stock < cantBeers && !tanksbeerempty) {
            this.inUser = false;

            notify();

            while (!inUser) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        Thread.sleep(500);

        if (this.stock < cantBeers) {
            cantBeers = this.stock;
            this.stock = 0;
        }
        else{
            this.stock = this.stock - cantBeers;
        }

        return cantBeers;
    }

    public boolean isInUser() {
        return inUser;
    }

    public void setInUser(boolean inUser) {
        this.inUser = inUser;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public synchronized boolean stopProduct ( int tanksbeer) throws InterruptedException {
        System.out.println("\nEn produccion quedo:" + "#Beer# "+ tanksbeer);
        System.out.println("En BeerHouse quedo:" + "#Beer# "+ this.getStock());
        return false;
    }

    private void printload(){
        System.out.println("\n");
        System.out.println("#----#" + " |-------------| |-------------|" + " #----#");
        System.out.println("#Beer#" + " |--Generando--| |---Cerveza---|" + " #Beer#");
        System.out.println("#----#" + " |-------------| |-------------|" + " #----#");
    }

    private void printbeerloadStock(int thisbeer){
        System.out.println("\n");
        System.out.println("Fueron generadas: " + thisbeer + "Cerveza y ahi un Total :" + this.getStock());
    }
}
