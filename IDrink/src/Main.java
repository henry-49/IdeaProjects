import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){
        ArrayList<Getrinke> getrank = new ArrayList<>();

        getrank.add(new Getrinke(1, "Cola", 2.00));
        getrank.add(new Getrinke(2, "Fanta", 2.00));
        getrank.add(new Getrinke(3, "Pepsi", 2.00));
        getrank.add(new Getrinke(4, "Pepsi", 2.00));
        getrank.add(new Getrinke(5, "Sprite", 2.00));
        int auswhal = 0;

        do {
            System.out.print("Bitte wahlen sie")
            System.out.println("1:  Artikel anzeigen"+ " \n" +
                    "2: Artikel Kaufen  "+ "\n" +
                    "3: Artikel hinfugen");
            Scanner sc = new Scanner(System.in);
             auswhal = sc.nextInt();

        }while (auswhal < 1 || auswhal > 4);

        switch (auswhal){
            case 1:
                artikel_hinzufugen();
                break;

            case 2:
                artikel_kaufen();
                break;

            case 3:

                break;
        }


        for (Getrinke tranken: getrank) {
            System.out.println("Id:"+ tranken.getId()+ " \n" +
                    "Getrank Name: "+ tranken.getGName()+ "\n" +
                    "Getrank Prise: "+ tranken.getGPrise());
        }


        for (Getrinke tranken: getrank) {
            System.out.println(tranken.toString());
        }


    }

    public void  artikel_kaufen(){
        System.out.println();
    }

    public void  artikel_hinzufugen(){
        System.out.println();
    }

}
