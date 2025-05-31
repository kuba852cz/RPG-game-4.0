public class Main {
    public static void main(String[] args) {

        Barbar barbar = new Barbar(1000,100,100,100,"Barbar",100);
        Carodej carodej = new Carodej(1000,100,100,100,"Carodej",100);
        Hrac hrac = new Hrac(1000,100,100,100,"Hrac",100,100);

        Console console = new Console();
        console.start();

        System.out.println("Zkouska");

    }
}