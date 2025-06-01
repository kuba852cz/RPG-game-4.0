import java.util.Scanner;

public class Hrac extends Postava implements Killable {

    private int dovednostniBody;
    Scanner sc = new Scanner(System.in);

    public Hrac(int zdravi, int sila, int inteligence, int stesti, String typ, int dovednostniBody) {
        super(zdravi, sila, inteligence, stesti, typ);
        this.dovednostniBody = dovednostniBody;
    }

    @Override
    public void kill() {
        System.out.println();
        System.out.println("GAME OVER: Zemrel jsi");
        System.exit(0);
    }

    public void vylepsit () {
        if (dovednostniBody > 0) {
            System.out.println(toString());
            System.out.println("Co chces vylepsit?");
            System.out.println("1) Zdravi, 2) Sila, 3) Inteligence, 4) Stesti, 5)Back");
            switch (sc.nextInt()) {
                case 1:
                    zdravi += 100;
                    setMaxZdravi(zdravi);
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
        System.out.println();
    }


    @Override
    public boolean utok(Postava a, Postava b) {
        Kouzla kouzla = new Kouzla();
        System.out.println("Vyber si jaky utok chces pouzit: ");
        System.out.println("1) Klasicky, 2) Magicky");
        int akce = sc.nextInt();
        switch (akce) {
            case 1:
                rucniUtok(a, b);
                return true;
            case 2:
                System.out.println("Vyber kouzlo: 1) Fireball, 2) Poison, 3) Zap, 4) Weakness, 5) Heal");
               int volbaKouzla = sc.nextInt();
               switch (volbaKouzla) {
                   case 1:
                       kouzla.fireball(a, b);
                       return true;
                   case 2:
                       kouzla.poison(a, b);
                       return true;
                   case 3:
                       kouzla.zap(a, b);
                       return false;
                   case 4:
                       kouzla.weakness(a, b);
                       return false;
                   case 5:
                       kouzla.heal(a);
                       return false;
                   default:
                       System.out.println("Chybna volba!");
                       return false;

               }
               default:
                   System.out.println("Chybna volba!");
                   return false;
        }
    }

    @Override
    public String toString() {
        return typ +
                ": zdravi: " + zdravi +
                ", sila: " + sila +
                ", inteligence: " + inteligence +
                ", stesti: " + stesti +
                ", dovednostno body: " + dovednostniBody;


    }

    public int getDovednostniBody() {
        return dovednostniBody;
    }

    public void setDovednostniBody(int dovednostniBody) {
        this.dovednostniBody = dovednostniBody;
    }
}

