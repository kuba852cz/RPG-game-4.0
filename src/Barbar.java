public class Barbar extends Postava{

    public Barbar(int zdravi, int sila, int inteligence, int stesti, String typ, int maxZdravi) {
        super(zdravi, sila, inteligence, stesti, typ, maxZdravi);
    }

    @Override
    public void kill() {
        System.out.println("Dobra prace! Zabil si ho!");

    }

}
