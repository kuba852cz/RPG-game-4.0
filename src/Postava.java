import java.util.Random;

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

    /**
     * Abstrakntni metoda, ktera je pro kazdou postavu upravena
     * @param a Utocnik
     * @param b Na koho se utoci
     * @return typ utoku
     */
    public abstract boolean utok(Postava a, Postava b);

    /**
     * Utok, pri kterem se nahodne vybere cislo a pokud je vetsi nez stesti utocnika, tak se poskozeni zdvojnasobi
     * @param a Utocnik
     * @param b Na koho se utoci
     */
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
        System.out.println();
    }

    public int getZdravi() {
        return zdravi;
    }

    /**
     * setter, ktery zaroven hlida, aby nebylo zaporne
     * @param zdravi zdravi
     */
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

    public String getTyp() {
        return typ;
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

    public int getMaxSila() {
        return maxSila;
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

    public boolean isJeOtravena() {
        return jeOtravena;
    }

    public void setJeOtravena(boolean jeOtravena) {
        this.jeOtravena = jeOtravena;
    }

    public int getPocetKolOtravy() {
        return pocetKolOtravy;
    }

    public void setPocetKolOtravy(int pocetKolOtravy) {
        this.pocetKolOtravy = pocetKolOtravy;
    }

    public boolean isJePouzitFireball() {
        return jePouzitFireball;
    }

    public boolean isJePouzitPoison() {
        return jePouzitPoison;
    }

    public boolean isJePouzitZap() {
        return jePouzitZap;
    }

    public boolean isJePouzitWeakness() {
        return jePouzitWeakness;
    }

    public boolean isJePouzitHeal() {
        return jePouzitHeal;
    }

    public void setJePouzitFireball(boolean jePouzitFireball) {
        this.jePouzitFireball = jePouzitFireball;
    }

    public void setJePouzitPoison(boolean jePouzitPoison) {
        this.jePouzitPoison = jePouzitPoison;
    }

    public void setJePouzitZap(boolean jePouzitZap) {
        this.jePouzitZap = jePouzitZap;
    }

    public void setJePouzitWeakness(boolean jePouzitWeakness) {
        this.jePouzitWeakness = jePouzitWeakness;
    }

    public void setJePouzitHeal(boolean jePouzitHeal) {
        this.jePouzitHeal = jePouzitHeal;
    }

    @Override
    public String toString() {
        return typ +
                ": zdravi = " + zdravi +
                ", sila = " + sila +
                ", inteligence = " + inteligence +
                ", stesti = " + stesti;
    }
}

