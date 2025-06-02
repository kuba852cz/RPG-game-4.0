public class Barbar extends Postava{

    public Barbar(int zdravi, int sila, int inteligence, int stesti, String typ, int dovednostniBody) {
        super(zdravi, sila, inteligence, stesti, typ, dovednostniBody);
    }

    @Override
    public boolean utok(Postava a, Postava b) {
        if (a.isJeOtravena()){
            a.otraveni(a, b);
        }
        Kouzla kouzla = new Kouzla();
        if (rd.nextInt(0,100) < 80){
            rucniUtok(a, b);
            return true;
        }else{
            kouzla.fireball(a, b);
            return true;
        }
    }

    @Override
    public void kill() {
        System.out.println("Dobra prace! Zabil si ho!");
        System.out.println("Obdrzel si z nej " + dovednostniBody + " bodu!");
        System.out.println();

    }

}
