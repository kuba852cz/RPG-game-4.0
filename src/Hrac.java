import java.util.ArrayList;
import java.util.Scanner;

public class Hrac extends Postava implements Killable {

    private int dovednostniBody;
    Scanner sc = new Scanner(System.in);

    public Hrac(int zdravi, int sila, int inteligence, int stesti, String typ, int maxZdravi, int dovednostniBody) {
        super(zdravi, sila, inteligence, stesti, typ, maxZdravi);
        this.dovednostniBody = dovednostniBody;
    }

    @Override
    public void kill() {
        System.out.println("GAME OVER: Zemrel jsi");
        System.exit(0);
    }

    public void vylepsit () {
        if (dovednostniBody > 0) {
            System.out.println("Co chces vylepsit?");
            System.out.println("1) Zdravi, 2) Sila, 3) Inteligence, 4) Stesti, 5)Back");
            switch (sc.nextInt()) {
                case 1:
                    zdravi += 100;
                    dovednostniBody--;
                    System.out.println("Tve soucasne zdravi je nyni: " + zdravi);
                    break;
                case 2:
                    sila += 100;
                    dovednostniBody--;
                    System.out.println("Tve soucasne sila je nyni: " + sila);
                    break;
                case 3:
                    inteligence += 100;
                    dovednostniBody--;
                    System.out.println("Tve soucasne inteligence je nyni: " + inteligence);
                    break;
                case 4:
                    stesti += 10;
                    dovednostniBody--;
                    System.out.println("Tve soucasne stesti je nyni: " + stesti);
                    break;
                default:
                    System.out.println("Chybne vybrani");
                    break;
                case 5:
                    break;
            }
        }
        System.out.println("Tvuj aktualni pocet dovednostich bodu je: " + dovednostniBody);
    }

    public void magickyUtok(Postava a, Postava b) {
        Kouzla kouzla = new Kouzla();
        System.out.println("Vyber si jakou magii chces pouzit: ");
        System.out.println("1) Fireball, 2) Poison, 3) Zap, 4) Weakness, 5) Heal");
        switch (sc.nextInt()) {
            case 1:
                kouzla.fireball(a, b);
                break;
            case 2:
                kouzla.poison(a, b);
                break;
            case 3:
                kouzla.zap(a, b);
                break;
            case 4:
                kouzla.weakness(a, b);
                break;
            case 5:
                kouzla.heal(a);
                break;
            default:
                System.out.println("Chybna volba!");

        }


    }

    public void utok(Postava a, Postava b){
        System.out.println("Vyber si utok: ");
        System.out.println("1) Klasicky utok, 2) Magicky utok");

        if (sc.nextInt() == 1) {
            a.rucniUtok(a,b);
        } else if (sc.nextInt() == 2) {
            magickyUtok(a,b);
        }else{
            System.out.println("Chyba");
        }
    }



}

