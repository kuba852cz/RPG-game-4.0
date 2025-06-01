public class Barbar extends Postava{

    public Barbar(int zdravi, int sila, int inteligence, int stesti, String typ) {
        super(zdravi, sila, inteligence, stesti, typ);
    }

    @Override
    public boolean utok(Postava a, Postava b) {
        rucniUtok(a, b);
        return true;
    }

    @Override
    public void kill() {
        System.out.println("Dobra prace! Zabil si ho!");
        System.out.println("Obdrzel si z nej 1 dovednostni bod!");
        System.out.println();

    }

}
