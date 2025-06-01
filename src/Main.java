public class Main {
    public static void main(String[] args) {

        Barbar barbar = new Barbar(1000,100,100,100,"Barbar");
        Carodej carodej = new Carodej(1000,100,100,100,"Carodej");
        Hrac hrac = new Hrac(1000,100,100,50,"Hrac",100);

        Console console = new Console();
        console.start();

    }
}