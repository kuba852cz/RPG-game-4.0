import java.util.Random;

public abstract class Postava implements Killable {

    protected int zdravi;
    protected int sila;
    protected int inteligence;
    protected int stesti;
    protected String typ;
    protected int maxZdravi;

    Random rd = new Random();

    public Postava(int zdravi, int sila, int inteligence, int stesti, String typ, int maxZdravi) {
        this.zdravi = zdravi;
        this.sila = sila;
        this.inteligence = inteligence;
        this.stesti = stesti;
        this.typ = typ;
        this.maxZdravi = zdravi;
    }

    //klasicky utok
    public void rucniUtok(Postava a, Postava b) {
        if (rd.nextInt(0, 100) < stesti) {
            int hit = a.getSila() *2;
            b.setZdravi(b.getZdravi() - hit);
            System.out.println(a.getTyp()+ " ti dal Critical hit!: -" + hit);
            System.out.print(b.getTyp() + " zdravi: " + b.getZdravi());
        }else {
            int hit = a.getSila();
            b.setZdravi(b.getZdravi() - hit);
            System.out.println(a.getTyp()+ " ti dal hit: -" + hit);
            System.out.print(b.getTyp() + " zdravi: " + b.getZdravi());
        }
        if (b.getZdravi() <= 0){
            b.kill();
        }
    }

    public int getZdravi() {
        return zdravi;
    }

    public void setZdravi(int zdravi) {
        this.zdravi = zdravi;
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

    @Override
    public String toString() {
        return typ +
                ": zdravi = " + zdravi +
                ", sila = " + sila +
                ", inteligence = " + inteligence +
                ", stesti = " + stesti;
    }

}

