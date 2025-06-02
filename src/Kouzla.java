public class Kouzla {

    public Kouzla() {
    }

    // Vezme inteligenci utocici postavy a prida k ni + 50 a touto soumou ubere poskozene postave zivoty.
    public void fireball(Postava a, Postava b) {
        if (a.isJePouzitFireball()) {
            if (a.typ.equalsIgnoreCase("hrac")){
                System.out.println("Toto kouzlo si uz tento souboj pouzil!");
            }
            a.utok(a, b);
        } else {
            int hit = a.getInteligence() + 25;
            b.setZdravi(b.getZdravi() - hit);
            System.out.println(a.getTyp() + " pouzil fireball!");
            System.out.println("Hit: -" + hit);
            System.out.println(b.getTyp() + " zdravi: " + b.getZdravi());
            System.out.println();
            a.setJePouzitFireball(true);
        }
    }

    // 2. kouzlo: Poison = otrava do te doby, dokud souper nebo hrac nezemre
    public void poison(Postava a, Postava b) {
        if (a.isJePouzitPoison()) {
            if (a.typ.equalsIgnoreCase("hrac")){
                System.out.println("Toto kouzlo si uz tento souboj pouzil!");
            }
            a.utok(a, b);
        } else {
            int hit = a.getInteligence() / 4;
            System.out.println(a.getTyp() + " pouzil poison!");
            a.otraveni(a, b);
            a.setJePouzitPoison(true);
        }
    }

    // Nastavi postave zase zivoty na max a po pouziti muze hrac pokracovat
    public void heal(Postava a, Postava b) {
        if (a.isJePouzitHeal()) {
            if (a.typ.equalsIgnoreCase("hrac")){
                System.out.println("Toto kouzlo si uz tento souboj pouzil!");
            }
            a.utok(a, b);
        } else {
            a.setZdravi(a.getMaxZdravi());
            System.out.println(a.getTyp() + " pouzil heal!");
            System.out.println(a.getTyp() + " zdravi: " + a.getZdravi());
            System.out.println();
            a.utok(a, b);
            a.setJePouzitHeal(true);
        }
    }

    /**
     * Utocici hrac nastavi poskozene postave veskere utocne atributy na polovinu a nasledne muze pokracovat na dalsi utok
     * @param a
     * @param b
     */
    public void weakness(Postava a, Postava b) {
        if (a.isJePouzitWeakness()) {
            if (a.typ.equalsIgnoreCase("hrac")){
                System.out.println("Toto kouzlo si uz tento souboj pouzil!");
            }
            a.utok(a, b);
        } else {
            System.out.println(a.getTyp() + " pouzil weakness!");
            b.oslabeni();
            System.out.println(b.getTyp() + " aktualni sila: " + b.getSila());
            System.out.println(b.getTyp() + " aktualni inteligence: " + b.getInteligence());
            System.out.println();
            a.utok(a, b);
            a.setJePouzitWeakness(true);
        }
    }

    // 5. kouzlo zap = malicky blesk, po kterem muzes pokracovat v tahu
    public void zap(Postava a, Postava b) {
        if (a.isJePouzitZap()) {
            if (a.typ.equalsIgnoreCase("hrac")){
                System.out.println("Toto kouzlo si uz tento souboj pouzil!");
            }
            a.utok(a, b);
        } else {
            int hit = a.getInteligence() / 2;
            b.setZdravi(b.getZdravi() - hit);
            System.out.println(a.getTyp() + " pouzil zap!");
            System.out.println("Hit: -" + hit);
            System.out.println(b.getTyp() + " zdravi: " + b.getZdravi());
            System.out.println();
            a.utok(a, b);
            a.setJePouzitZap(true);
        }
    }



}
