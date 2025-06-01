import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Barbar barbar = new Barbar(1000,100,100,100,"Barbar", 5);
        Carodej carodej = new Carodej(1000,100,100,100,"Carodej", 5);
        Hrac hrac = new Hrac(1000,100,100,50,"Hrac",100);

        //Console console = new Console();
        //console.start();

        hrac.utok(hrac, barbar);


    }
}