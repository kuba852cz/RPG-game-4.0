import java.util.Scanner;

public class Hrac extends Postava implements Killable {

    Scanner sc = new Scanner(System.in);

    public Hrac(int zdravi, int sila, int inteligence, int stesti, String typ, int dovednostniBody) {
        super(zdravi, sila, inteligence, stesti, typ, dovednostniBody);
        this.dovednostniBody = dovednostniBody;
    }

    @Override
    public void kill() {
        System.out.println("GAME OVER: Zemrel jsi");
        System.exit(0);
    }

    public void vylepsit() {
        int volba;
        do {
            System.out.println(toString());
            System.out.println("Tvuj aktualni pocet dovednostnich bodu je: " + dovednostniBody);
            volba = ohlidaniVolby(1, 5, "1) Zdravi, 2) Sila, 3) Inteligence, 4) Stesti, 5) Back");

            if (volba == 5){
                break;
            }

            if (dovednostniBody <= 0) {
                System.out.println("Nemas dostatek dovednostnich bodu.");
                System.out.println();
                break;
            }

            switch (volba) {
                case 1:
                    zdravi += 100;
                    setMaxZdravi(zdravi);
                    System.out.println("Tvoje aktualni zdravi je nyni: " + zdravi);
                    break;
                case 2:
                    sila += 50;
                    System.out.println("Tvoje aktualni sila je nyni: " + sila);
                    break;
                case 3:
                    inteligence += 50;
                    System.out.println("Tvoje aktualni inteligence je nyni: " + inteligence);
                    break;
                case 4:
                    if (stesti >= 100) {
                        System.out.println("Stesti uz je na maximu!");
                        System.out.println();
                        vylepsit();
                    }
                        stesti += 10;
                        System.out.println("Tvoje aktualni stestí je nyni: " + stesti);
                        break;
            }

            dovednostniBody--;
            System.out.println();
        } while (volba != 5);
    }


    @Override
    public boolean utok(Postava a, Postava b) {
        Kouzla kouzla = new Kouzla();
        if (a.isJeOtravena()){
            a.otraveni(a, b);
        }
        System.out.println("Vyber si jaky utok chces pouzit: ");
        switch (ohlidaniVolby(1,2,"1) Klasicky, 2) Magicky")) {
            case 1:
                rucniUtok(a, b);
                return true;
            case 2:
               switch (ohlidaniVolby(1,6,"Vyber kouzlo: 1) Fireball, 2) Poison, 3) Zap, 4) Weakness, 5) Heal, 6) Back")) {
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
                       kouzla.heal(a, b);
                       return false;
                   case 6:
                       a.utok(a,b);
                       break;
                   default:
                       return false;

               }
               default:
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
}

