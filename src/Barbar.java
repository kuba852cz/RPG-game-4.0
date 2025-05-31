public class Barbar extends Postava{

    public Barbar(int zdravi, int sila, int inteligence, int stesti, String typ) {
        super(zdravi, sila, inteligence, stesti, typ);
    }

    @Override
    public void kill() {
        System.out.println("Dobra prace! Zabil si ho!");

    }

}
