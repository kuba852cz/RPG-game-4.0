import java.util.Random;
import java.util.Scanner;

public abstract class Postava implements Killable {

    protected int zdravi;
    protected int sila;
    protected int inteligence;
    protected int stesti;
    protected String typ;
    protected int dovednostniBody;
    private int maxZdravi;
    private int maxSila;
    private int maxInteligence;
    private boolean oslaben = false;
    private boolean jeOtravena;
    private int pocetKolOtravy;
    private boolean jePouzitFireball;
    private boolean jePouzitPoison;
    private boolean jePouzitZap;
    private boolean jePouzitWeakness;
    private boolean jePouzitHeal;


    Random rd = new Random();

    public Postava(int zdravi, int sila, int inteligence, int stesti, String typ, int dovednostniBody) {
        setZdravi(zdravi);
        this.sila = sila;
        this.inteligence = inteligence;
        this.stesti = stesti;
        this.typ = typ;
        this.dovednostniBody = dovednostniBody;
        this.maxZdravi = zdravi;
        this.maxSila = sila;
        this.maxInteligence = inteligence;
    }

    public abstract boolean utok(Postava a, Postava b);


    //klasicky utok
    public void rucniUtok(Postava a, Postava b) {
        if (rd.nextInt(0, 100) < stesti) {
            int hit = a.getSila() *2;
            b.setZdravi(b.getZdravi() - hit);
            System.out.println(a.getTyp() + " pouzil utok!");
            System.out.println("Critical hit!: -" + hit);
            System.out.println(b.getTyp() + " zdravi: " + b.getZdravi());
        }else {
            int hit = a.getSila();
            b.setZdravi(b.getZdravi() - hit);
            System.out.println(a.getTyp() + " pouzil utok!");
            System.out.println("Hit: -" + hit);
            System.out.println(b.getTyp() + " zdravi: " + b.getZdravi());
        }
        b.zrusitOslabeni();
        System.out.println();
    }

    public void oslabeni() {
        if (!oslaben) {
            this.setSila(this.getSila()/2);
            this.setInteligence(this.getInteligence()/2);
            oslaben = true;
        }
    }

    public void zrusitOslabeni() {
        if (oslaben) {
            this.setSila(this.getMaxSila());
            this.setInteligence(this.getMaxInteligence());
            oslaben = false;
        }
    }

    public void otraveni(Postava a, Postava b) {
        if (!jeOtravena) {
            b.setZdravi(b.getZdravi() - (a.getInteligence()/4));
            jeOtravena = true;
        } else if (pocetKolOtravy > 0 && jeOtravena) {
            pocetKolOtravy--;
        }
    }

    public void resetKouzel(Postava a) {
        jePouzitFireball = false;
        jePouzitPoison = false;
        jePouzitZap = false;
        jePouzitWeakness = false;
        jePouzitHeal = false;
    }

    public int getZdravi() {
        return zdravi;
    }

    public void setZdravi(int zdravi) {
        if (zdravi < 0) {
            this.zdravi = 0;
        } else {
            this.zdravi = zdravi;
        }
    }

    public int getSila() {
        return sila;
    }

    public void setSila(int sila) {
        this.sila = sila;
    }

    public int getInteligence() {
        return inteligence;
    }

    public void setInteligence(int inteligence) {
        this.inteligence = inteligence;
    }

    public int getStesti() {
        return stesti;
    }

    public void setStesti(int stesti) {
        this.stesti = stesti;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public int getMaxZdravi() {
        return maxZdravi;
    }

    public void setMaxZdravi(int maxZdravi) {
        this.maxZdravi = maxZdravi;
    }

    public int getMaxInteligence() {
        return maxInteligence;
    }

    public void setMaxInteligence(int maxInteligence) {
        this.maxInteligence = maxInteligence;
    }

    public int getMaxSila() {
        return maxSila;
    }

    public void setMaxSila(int maxSila) {
        this.maxSila = maxSila;
    }

    public boolean isOslaben() {
        return oslaben;
    }

    public void setOslaben(boolean oslaben) {
        this.oslaben = oslaben;
    }

    public int getDovednostniBody() {
        return dovednostniBody;
    }

    public void setDovednostniBody(int dovednostniBody) {
        this.dovednostniBody = dovednostniBody;
    }

    @Override
    public String toString() {
        return typ +
                ": zdravi = " + zdravi +
                ", sila = " + sila +
                ", inteligence = " + inteligence +
                ", stesti = " + stesti;
    }

    public int ohlidaniVolby(int min, int max, String vyber){
        Scanner sc = new Scanner(System.in);
        int volba;
        while(true){
            System.out.println(vyber);
            if (sc.hasNextInt()) {
                volba = sc.nextInt();
                if (volba >= min && volba <= max) {
                    return volba;
                }else{
                    System.out.println("Zadal si spatne cislo.");
                }
            }else{
                System.out.println("Toto neni cislo!");
                sc.next();
            }
        }
    }

}

