/**
 * Potomek tridy postava, ktera ma sve specifikace
 */
public class Barbar extends Postava{

    public Barbar(int zdravi, int sila, int inteligence, int stesti, String typ, int dovednostniBody) {
        super(zdravi, sila, inteligence, stesti, typ, dovednostniBody);
    }

    /**
     * Metoda, ktera podle urcene pravdepodobnosti vybere typ utoku a jeste predtim zkontroluje zda neni postva otravena.
     * @param a Utocnik
     * @param b Na koho se utoci
     * @return
     */
    @Override
    public boolean utok(Postava a, Postava b) {
        Kouzla kouzla = new Kouzla();
        if (a.isJeOtravena()){
            kouzla.otraveni(a,b);
        }
        if (rd.nextInt(0,100) < 80){
            rucniUtok(a, b);
        }else{
            kouzla.fireball(a, b);
        }
        kouzla.zrusitOslabeni(a);
        return true;
    }

    /**
     * Metoda, ktera po zemreni postavy vypise ze ho hrac zabil a kolik dovednostnich bodu z nej dostal.
     */
    @Override
    public void kill() {
        System.out.println("Dobra prace! Zabil si ho!");
        System.out.println("Obdrzel si z nej " + dovednostniBody + " bodu!");
        System.out.println();

    }

}
