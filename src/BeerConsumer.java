
public class BeerConsumer extends Thread{

    private BeerHouse beerHouse;
    private boolean continuee;
    private int abeer ;
    private int cantclientes;

    public BeerConsumer(BeerHouse House, int cantClients){
        super();
        this.cantclientes = cantClients;
        this.continuee = true;
        this.beerHouse = House;
        this.abeer = 0;
    }

    public void run(){
        int castumer = 1;
        int beers = this.random();
        int cantBeers = 0 ;
        int cantbuy = 0;
        while(continuee) {
            System.out.println("\n** El cliente # " + castumer + " solicita " + beers + " #Beer# **");
            try {
                cantBeers = beerHouse.getBeers(beers);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cantbuy = cantbuy + cantBeers;
            this.abeer = this.abeer + cantBeers;
            this.printcant(cantBeers,castumer);

            if(cantBeers < beers)
            {
                this.continuee = false;
                this.printferst(castumer,cantBeers,cantbuy);
            }
            castumer++;
            /*if (this.cantclientes == castumer){//Canselo la linea de entraga de beers.
                this.printferst(castumer,cantBeers,cantbuy);
                beerHouse.setInUser(false);
                continuee = false;
            }*/
        }
    }

    private int random(){
        int beers = (int) ((Math.random() * 30) + 1);
        return beers;
    }

    private void printcant(int cantBeers, int castumer){
        System.out.println("\n");
        System.out.println("*-#----#" + " *-#----#" + " *-#----#" + " Cant Beers = " + cantBeers );
        System.out.println("|-#Beer#" + " |-#Beer#" + " |-#Beer#" + " Cliente numero#" + castumer);
        System.out.println("*-#----#" + " *-#----#" + " *-#----#" + " ****************");
    }

    private void printferst(int castumer, int cantBeers, int cantbuy)
    {
        System.out.println("\n*Game Over*" + " *Game Over*" + " *Game Over*" + " *Game Over*");
        System.out.println("El ultimo cliente de la venta fue el:# "+ castumer + " y compro un total de:# " + cantBeers);
        System.out.println("*Game Over*" + " *Game Over*" + " *Game Over*" + " *Game Over*");
        System.out.println("La venta total fue de: " + cantbuy);
        System.out.println("***************************************");
    }

}
