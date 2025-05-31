public class Kouzla {

    public Kouzla() {
    }

    // 1. kouzlo: Fireball = silnejsi utokk
    public void fireball(Postava a, Postava b){
        int hit = a.getInteligence() + 25;
        b.setZdravi(b.getZdravi() - hit);
        System.out.println(a.getTyp() + " pouzil fireball!");
        System.out.println("Hit: -" + hit);
        System.out.println(b.getTyp() + " zdravi: " + b.getZdravi());
    }

    // 2. kouzlo: Poison = otrava do te doby, dokud souper nebo hrac nezemre
    public void poison(Postava a, Postava b){
        int hit = a.getInteligence()/4;
        System.out.println(a.getTyp() + " pouzil poison!");
        while (a.getZdravi() != 0 && b.getZdravi() != 0){
            b.setZdravi(b.getZdravi() - hit);
            System.out.println("Hit: -" + hit);
            System.out.println(b.getTyp() + " zdravi: " + b.getZdravi());
        }
    }

    // 3. kouzlo: Heal = Uzdraveni zivotu
    public void heal(Postava a){
        a.setZdravi(a.getMaxZdravi());
        System.out.println(a.getTyp() + " pouzil heal!");
        System.out.println(a.getTyp() + " zdravi: " + a.getZdravi());
    }

    // 4. kouzlo weakness = Oslabeni protihrace na pristi uder
    public void weakness(Postava a, Postava b){
        int maxSila = b.getSila();
        int maxInteligence = b.getInteligence();
        System.out.println(a.getTyp() + " pouzil weakness!");
        b.setSila(b.getSila()/2);
        b.setInteligence(b.getInteligence()/2);
        System.out.println("Aktualni sila: " + b.getSila());
        System.out.println("Aktualni inteligence: " + b.getInteligence());
        if(a.getZdravi() == 0){
            b.setSila(maxSila);
            b.setInteligence(maxInteligence);
        }
    }

    // 5. kouzlo zap = malicky blesk, po kterem muzes pokracovat v tahu
    public void zap(Postava a, Postava b){
        int hit = a.getInteligence()/2;
        b.setZdravi(b.getZdravi()-hit);
        System.out.println(a.getTyp() + " pouzil zap!");
        System.out.println("Hit: -" + hit);
        System.out.println(b.getTyp() + " zdravi: " + b.getZdravi());
    }

}
