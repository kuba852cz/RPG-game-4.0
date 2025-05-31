import java.util.Random;

public class Carodej extends Postava{

    Random rd = new Random();

    public Carodej(int zdravi, int sila, int inteligence, int stesti, String typ) {
        super(zdravi, sila, inteligence, stesti, typ);
    }

    @Override
    public void kill() {
        System.out.println("Dobra prace! Zabil si ho!");
    }

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
            kouzla.heal(a);
        }
    }

    public void utok(Postava a, Postava b) {
        if (rd.nextInt(0,100) >70){
            magickyUtok(a, b);
        }else{
            rucniUtok(a, b);
        }
    }

}
