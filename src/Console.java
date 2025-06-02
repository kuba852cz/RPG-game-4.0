/**
 * Tato trida ma za ukol spojit veskere metody a tridy a utvorit z toho hlavni smycku hry
 */

import java.io.*;
import java.util.ArrayList;

public class Console {

    ArrayList<Postava> enemy = new ArrayList();
    private boolean prectenZaver;

    public Console() {
    }

    /**
     * Hlavni metoda programu, ktera spousti cely program
     * Privola uvod a po te podle velikosti arraylistu uda kolikrat se smycka boje bude odehravat
     */
    public void start() {

        Hrac hrac = new Hrac(500, 100, 100, 15, "Hrac", 3);
        enemy.add(new Barbar(400, 150, 75, 10, "Barbar", 1));
        enemy.add(new Barbar(500, 175, 100, 15, "Barbar", 1));
        enemy.add(new Carodej(550, 75, 100, 20, "Carodej", 1));
        enemy.add(new Barbar(600, 200, 125, 20, "Barbar", 2));
        enemy.add(new Carodej(650, 100, 100, 30, "Carodej", 1));
        enemy.add(new Carodej(700, 125, 100, 35, "Carodej", 1));
        enemy.add(new Barbar(800, 250, 150, 35, "Barbar", 1));
        enemy.add(new Carodej(900, 150, 100, 100, "Carodej", 1));
        enemy.add(new Barbar(1000, 300, 175, 40, "Barbar", 3));
        enemy.add(new Carodej(1500, 200, 200, 50, "Sedovous Mrzuty", 0));

        try (BufferedReader br = new BufferedReader(new FileReader("src/uvod.txt"))) {
            String text;
            while ((text = br.readLine()) != null) {
                System.out.println(text);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Soubor nenalezen");
        } catch (IOException e) {
            System.out.println("Problem se souborem");
        }
        if (hrac.ohlidaniVolby(1, 1, "") == 1) {
            for (int i = 0; i < enemy.size(); i++) {
                System.out.println("Aktualni pocet dovednostnich bodu: " + hrac.getDovednostniBody());
                vyberAkce(hrac);
                System.out.println("Mame tady:");
                System.out.println(enemy.get(i));
                System.out.println();
                boj(hrac, enemy.get(i));
            }
        }
    }

    /**
     * Smycka boje, ktera hlida proti komu hrac jde bojovat a podle toho bude zacinat urcita postava
     * U final boss fightu je to stejne, akorat se predtim priola zaver a ujisti se aby uz nebyl privolan.
     * Po kazdem utoku ze zkontroluje, zda to nebyl smrtici utok a pokud by byl, tak privola metodu kill
     * @param hrac hrac
     * @param b protihrac
     */
    public void boj(Postava hrac, Postava b){
        Kouzla kouzla = new Kouzla();
        while (b.getZdravi() > 0 && hrac.getZdravi() > 0) {
            if (b.getTyp().equalsIgnoreCase("barbar")) {
                b.utok(b, hrac);
                if (hrac.getZdravi() <= 0) {
                    hrac.kill();
                    break;
                }

                hrac.utok(hrac, b);
                if (b.getZdravi() <= 0) {
                    b.kill();
                    hrac.setDovednostniBody(hrac.getDovednostniBody() + b.dovednostniBody);
                    hrac.setZdravi(hrac.getMaxZdravi());
                    kouzla.resetKouzel(hrac);
                    break;
                }
            } else if (b.getTyp().equalsIgnoreCase("carodej")) {
                hrac.utok(hrac, b);
                if (b.getZdravi() <= 0) {
                    b.kill();
                    hrac.setDovednostniBody(hrac.getDovednostniBody() + 1);
                    hrac.setZdravi(hrac.getMaxZdravi());
                    System.out.println();
                    kouzla.resetKouzel(hrac);
                    break;
                }
                b.utok(b, hrac);
                if (hrac.getZdravi() <= 0) {
                    hrac.kill();
                    break;
                }
            } else if (b.getTyp().equalsIgnoreCase("Sedovous mrzuty")) {
                if (!prectenZaver) {
                    try (BufferedReader br = new BufferedReader(new FileReader("src/zaver.txt"))) {
                        String text;
                        while ((text = br.readLine()) != null) {
                            System.out.println(text);
                        }
                        br.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("Soubor nenalezen");
                    } catch (IOException e) {
                        System.out.println("Problem se souborem");
                    }
                    System.out.println();
                    prectenZaver = true;
                }
                hrac.utok(hrac, b);
                if (b.getZdravi() <= 0) {
                    System.out.println("GRATULUJU! Vyhral si! Porazil si Sedovouse Mrzuteho a odesel si spolecne se svou zenou domu.");
                    System.out.println();
                    break;
                }
                b.utok(b, hrac);
                if (hrac.getZdravi() <= 0) {
                    hrac.kill();
                    System.out.println();
                    break;
                }
            }
        }
    }

    /**
     * Jednoduchy cyklus, ve kterem hrac si vybira, zda chce neco vylepsit a pokud jo privola metodu hrace jmenem vylepsit
     * @param hrac hrac
     */
    public void vyberAkce(Hrac hrac){
       int volba;
        do {
            System.out.println("Prejes si neco udelat pred tim nez se vrhnem do boje?");
            volba = hrac.ohlidaniVolby(1, 3, "1) Continue, 2) Vylepsit,  3) Exit");
            switch (volba) {
                case 1:
                    break;
                case 2:
                    hrac.vylepsit();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        } while (volba != 1);
    }

}
