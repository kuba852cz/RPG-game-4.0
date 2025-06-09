/**
 * Tato trida spravuje veskera kouzla, ktere postavy mohou pouzit
 */
public class Kouzla {

    public Kouzla() {
    }

    /**
     * Vezme inteligenci utocici postavy a prida k ni polovinu a touto soumou ubere poskozene postave zivoty.
     * @param a Utocnik
     * @param b Na koho se utoci
     */
    public void fireball(Postava a, Postava b) {
        if (a.isJePouzitFireball()) {
            if (a.typ.equalsIgnoreCase("hrac")){
                System.out.println("Toto kouzlo si uz tento souboj pouzil!");
            }
            a.utok(a, b);
        } else {
            a.setJePouzitFireball(true);
            int hit = a.getInteligence() + (a.getInteligence()/2);
            b.setZdravi(b.getZdravi() - hit);
            System.out.println(a.getTyp() + " pouzil fireball!");
            System.out.println("Hit: -" + hit);
            System.out.println(b.getTyp() + " zdravi: " + b.getZdravi());
            System.out.println();
        }
    }

    /**
     * Spojuje metodu otraveni se zbytkem.
     * Nastavi poison a urci na kolik kol a spusti stav JeOtraven
     * @param a Utocnik
     * @param b Na koho se utoci
     */
    public void poison(Postava a, Postava b) {
        if (a.isJePouzitPoison()) {
            if (a.typ.equalsIgnoreCase("hrac")){
                System.out.println("Toto kouzlo si uz tento souboj pouzil!");
            }
        } else {
            System.out.println(a.getTyp() + " pouzil poison!");
            a.setJePouzitPoison(true);
            b.setPocetKolOtravy(3);
            b.setJeOtravena(true);
            System.out.println();
        }
        a.utok(a,b);
    }

    /**
     * Stara se o damage poisnu a pokud uz pocet kol spadne na nula, tak se stav zrusi
     * @param a Otraveny
     * @param b Kym byl otraven
     */
    public void otraveni(Postava a, Postava b) {
        if (a.isJeOtravena()) {
            int hit = b.getInteligence()/2;
            a.setZdravi(a.getZdravi() - hit);
            a.setPocetKolOtravy(a.getPocetKolOtravy() - 1);
            System.out.println(a.getTyp()+ " otrava: -" + hit);
            System.out.println(a.getTyp() + " zdravi: " + a.getZdravi());
            System.out.println("Zbyvajici pocet kol otravy: " + a.getPocetKolOtravy());
        }
        if (a.getPocetKolOtravy() == 0) {
            a.setJeOtravena(false);
            System.out.println("Poison uz vyprchal");
        }
        System.out.println();
    }

    /**
     * Nastavi postave zase zivoty na max a po pouziti muze hrac pokracovat
     * @param a Utocnik
     * @param b Na koho se utoci
     */
    public void heal(Postava a, Postava b) {
        if (a.isJePouzitHeal()) {
            if (a.typ.equalsIgnoreCase("hrac")){
                System.out.println("Toto kouzlo si uz tento souboj pouzil!");
            }
        } else {
            a.setJePouzitHeal(true);
            a.setZdravi(a.getMaxZdravi());
            System.out.println(a.getTyp() + " pouzil heal!");
            System.out.println(a.getTyp() + " zdravi: " + a.getZdravi());
            System.out.println();
        }
        a.utok(a,b);
    }

    /**
     * Nastavi postave na kterou se utoci veskere utocne atributy pro pristi utok na polovinu
     * @param a Utocnik
     * @param b Na koho se utoci
     */
    public void weakness(Postava a, Postava b) {
        if (a.isJePouzitWeakness()) {
            if (a.typ.equalsIgnoreCase("hrac")){
                System.out.println("Toto kouzlo si uz tento souboj pouzil!");
            }
        } else {
            a.setJePouzitWeakness(true);
            System.out.println(a.getTyp() + " pouzil weakness!");
            if (!b.isOslaben()) {
                b.setSila(b.getSila()/2);
                b.setInteligence(b.getInteligence()/2);
                b.setOslaben(true);
            }
            System.out.println(b.getTyp() + " aktualni sila: " + b.getSila());
            System.out.println(b.getTyp() + " aktualni inteligence: " + b.getInteligence());
            System.out.println();
        }
        a.utok(a,b);
    }

    /**
     * Nastavi vsechny utocne parametry zpet na puvodni velikost po kazdem utoku.
     * @param a Komu se to rusi
     */
    public void zrusitOslabeni(Postava a) {
        if (a.isOslaben()) {
            a.setSila(a.getMaxSila());
            a.setInteligence(a.getMaxInteligence());
            a.setOslaben(false);
        }
    }

    /**
     * Slaby uder, po kterem muze utocnik znovu pokracovat.
     * @param a Utocnik
     * @param b Na koho se utoci
     */
    public void zap(Postava a, Postava b) {
        if (a.isJePouzitZap()) {
            if (a.typ.equalsIgnoreCase("hrac")){
                System.out.println("Toto kouzlo si uz tento souboj pouzil!");
            }
        } else {
            a.setJePouzitZap(true);
            int hit = a.getInteligence() / 2;
            b.setZdravi(b.getZdravi() - hit);
            System.out.println(a.getTyp() + " pouzil zap!");
            System.out.println("Hit: -" + hit);
            System.out.println(b.getTyp() + " zdravi: " + b.getZdravi());
            System.out.println();
        }
        a.utok(a,b);
    }

    /**
     * Po souboji veskera kouzla zresetuji, aby se v dalsim souboji mohli pouzit.
     * @param a Komu se resetuji kouzla
     */
    public void resetKouzel(Postava a) {
        a.setJePouzitFireball(false);
        a.setJePouzitPoison(false);
        a.setJePouzitZap(false);
        a.setJePouzitWeakness(false);
        a.setJePouzitHeal(false);
    }

}
