import java.util.ArrayList;
import java.util.Scanner;

public class Hrac extends Postava implements Killable {

    private int dovednostniBody;
    Scanner sc = new Scanner(System.in);
    ArrayList<Kouzla> kouzla;

    public Hrac(int zdravi, int sila, int inteligence, int stesti, String typ, int maxZdravi, int dovednostniBody) {
        super(zdravi, sila, inteligence, stesti, typ, maxZdravi);
        this.dovednostniBody = dovednostniBody;
        kouzla = new ArrayList<>();
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

    public void magickyUtok(Postava postava){
        System.out.println("Vyber si jakou magii chces pouzit: ");

    }

}

