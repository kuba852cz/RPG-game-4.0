import java.util.Random;

public class Carodej extends Postava{

    Random rd = new Random();

    public Carodej(int zdravi, int sila, int inteligence, int stesti, String typ, int dovednostniBody) {
        super(zdravi, sila, inteligence, stesti, typ, dovednostniBody);
    }

    /**
     * Metoda, ktera nahodne vybere typ utoku a jeste predtim zkontroluje zda neni postva otravena.
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
        if (rd.nextInt(0,100) >50){
            magickyUtok(a, b);
        }else{
            rucniUtok(a, b);
        }
        kouzla.zrusitOslabeni(b);
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

    /**
     * Metoda, ktera nahodne privola urcite kouzlo podle nastavene pravdepodobnosti.
     * @param a Utocnik
     * @param b Na koho se utoci
     */
    public void magickyUtok(Postava a, Postava b) {
        int random = rd.nextInt(0,100);
        Kouzla kouzla = new Kouzla();
        if (random < 30){
            kouzla.fireball(a, b);
        } else if (30<random && random <=40 ) {
            kouzla.poison(a, b);
        } else if (40< random && random <=50 ) {
            kouzla.weakness(a, b);
        } else if (50< random && random<=80) {
            kouzla.zap(a, b);
        } else if (80< random && random <99 && zdravi>= 100) {
            kouzla.heal(a, b);
        }
    }

}
