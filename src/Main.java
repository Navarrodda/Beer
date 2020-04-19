
public class Main {

    public static void main(String[] args){
        System.out.println("***************************************");
        System.out.println("*-#----------#" + " |-----------|" + " *-#------#");
        System.out.println("|-#Bienvenido#" + " |#Cerveceria|" + " |-#Homero#");
        System.out.println("*-#----------#" + " |-----------|" + " *-#------#");
        BeerHouse beerHouse = new BeerHouse();
        BeerProducter beerProducter = new BeerProducter(beerHouse);
        BeerConsumer beerConsumer = new BeerConsumer(beerHouse, 30);
        beerConsumer.start();
        beerProducter.start();
    }



}
