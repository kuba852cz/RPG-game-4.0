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
        System.out.println();
    }

    // 2. kouzlo: Poison = otrava do te doby, dokud souper nebo hrac nezemre
    public void poison(Postava a, Postava b){
        int hit = a.getInteligence()/4;
        System.out.println(a.getTyp() + " pouzil poison!");
        a.otraveni(a,b);
    }

    // 3. kouzlo: Heal = Uzdraveni zivotu
    public void heal(Postava a, Postava b){
        a.setZdravi(a.getMaxZdravi());
        System.out.println(a.getTyp() + " pouzil heal!");
        System.out.println(a.getTyp() + " zdravi: " + a.getZdravi());
        System.out.println();
        a.utok(a, b);
    }

    // 4. kouzlo weakness = Oslabeni protihrace na pristi uder
    public void weakness(Postava a, Postava b){
        System.out.println(a.getTyp() + " pouzil weakness!");
        b.oslabeni();
        System.out.println(b.getTyp() +" aktualni sila: " + b.getSila());
        System.out.println(b.getTyp() +" aktualni inteligence: " + b.getInteligence());
        System.out.println();
        a.utok(a, b);
    }

    // 5. kouzlo zap = malicky blesk, po kterem muzes pokracovat v tahu
    public void zap(Postava a, Postava b){
        int hit = a.getInteligence()/2;
        b.setZdravi(b.getZdravi()-hit);
        System.out.println(a.getTyp() + " pouzil zap!");
        System.out.println("Hit: -" + hit);
        System.out.println(b.getTyp() + " zdravi: " + b.getZdravi());
        System.out.println();
        a.utok(a, b);
    }

}
