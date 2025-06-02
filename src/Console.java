import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Console {

    Scanner sc = new Scanner(System.in);
    ArrayList<Postava> enemy = new ArrayList();

    public Console() {
    }

    //Start programu, ktery ma na svedomi prubeh cele hry, to jest: Spravne printnuti uvod a zaveru. Cyklus souboje, aby kdyz se bojuje proti barbarovi, tak aby zacinal a kouzelnik naopak.
    //Predtim nez zacne boj, tak hrac musi potvrdit, ze chce pokracovat a nechce hru ukoncit ci si neco vylepsit. Pokud v prubehu boje da smrtici ranu hrac, tak se privola enemy postave metoda kill.
    //Cela logika bezi dokud vsechny z arraylistu neporazi hrac. v tom pripade nastane boss fight, ve kterem kdyz hrac vyhraje, tak mu program pogratuluje a ukonci se.
    public void start(){

        Hrac hrac = new Hrac(500,100,100,15,"Hrac",3);
        enemy.add(new Barbar(400,150,75,10,"Barbar",1));
        enemy.add(new Barbar(500,175,100,15,"Barbar",1));
        enemy.add(new Carodej(550,75,100,100,"Carodej",1));
        enemy.add(new Barbar(600,200,125,20,"Barbar",1));
        enemy.add(new Carodej(650,100,100,100,"Carodej",1));
        enemy.add(new Carodej(700,125,100,100,"Carodej",1));
        enemy.add(new Barbar(800,250,150,35,"Barbar",1));
        enemy.add(new Carodej(900,150,100,100,"Carodej",1));
        enemy.add(new Barbar(100,300,175,40,"Barbar",1));

        try (BufferedReader br = new BufferedReader(new FileReader("src/uvod.txt"))) {
            String text;
            while((text = br.readLine()) != null){
                System.out.println(text);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Soubor nenalezen");
        } catch (IOException e) {
            System.out.println("Problem se souborem");
        }
        if (hrac.ohlidaniVolby(1,1,"") == 1) {
            for (int i = 0; i < enemy.size(); i++) {
                int volba = 0;
                System.out.println("Aktualni pocet dovednostnich bodu: " + hrac.getDovednostniBody());
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
                System.out.println("Mame tady:");
                System.out.println(enemy.get(i));
                System.out.println();
                while (enemy.get(i).getZdravi() > 0 && hrac.getZdravi() > 0) {
                    if (enemy.get(i).getTyp().equalsIgnoreCase("barbar")) {
                        enemy.get(i).rucniUtok(enemy.get(i), hrac);
                        if (hrac.getZdravi() <= 0) {
                            hrac.kill();
                            break;
                        }

                        hrac.utok(hrac, enemy.get(i));
                        if (enemy.get(i).getZdravi() <= 0) {
                            enemy.get(i).kill();
                            hrac.setDovednostniBody(hrac.getDovednostniBody() + enemy.get(i).dovednostniBody);
                            hrac.setZdravi(hrac.getMaxZdravi());
                            hrac.resetKouzel(hrac);
                            break;
                        }
                    } else {
                        hrac.utok(hrac, enemy.get(i));
                        if (enemy.get(i).getZdravi() <= 0) {
                            enemy.get(i).kill();
                            hrac.setDovednostniBody(hrac.getDovednostniBody() + 1);
                            hrac.setZdravi(hrac.getMaxZdravi());
                            System.out.println();
                            hrac.resetKouzel(hrac);
                            break;
                        }
                        enemy.get(i).rucniUtok(enemy.get(i), hrac);
                        if (hrac.getZdravi() <= 0) {
                            hrac.kill();
                            break;
                        }
                    }
                }
            }
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

            Carodej SedovousMrzuty = new Carodej(1000, 20, 200, 50, "Sedovous Mrzuty", 0);
            if (hrac.ohlidaniVolby(1,1,"") == 1) {
                while (SedovousMrzuty.getZdravi() > 0 && hrac.getZdravi() > 0) {
                    hrac.utok(hrac, SedovousMrzuty);
                    if (SedovousMrzuty.getZdravi() <= 0) {
                        SedovousMrzuty.kill();
                        System.out.println();
                        break;
                    }
                    SedovousMrzuty.rucniUtok(SedovousMrzuty, hrac);
                    if (hrac.getZdravi() <= 0) {
                        hrac.kill();
                        System.out.println();
                        break;
                    }
                }
            }
        }
            System.out.println("GRATULUJU! Vyhral si! Porazil si Sedovouse Mrzuteho a odesel si spolecne se svou zenou domu.");
        }

    }
