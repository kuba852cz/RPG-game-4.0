import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Console {

    Scanner sc = new Scanner(System.in);
    ArrayList<Postava> enemy = new ArrayList();

    public Console() {
    }

    public void start(){

        Hrac hrac = new Hrac(10000,100,100,100,"Hrac",100);
        enemy.add(new Barbar(100,100,100,100,"Barbar"));
        enemy.add(new Barbar(100,100,100,100,"Barbar"));
        enemy.add(new Barbar(100,100,100,100,"Barbar"));
        enemy.add(new Barbar(100,100,100,100,"Barbar"));
        enemy.add(new Barbar(100,100,100,100,"Barbar"));
        enemy.add(new Barbar(100,100,100,100,"Barbar"));
        enemy.add(new Barbar(100,100,100,100,"Barbar"));
        enemy.add(new Barbar(100,100,100,100,"Barbar"));
        enemy.add(new Barbar(100,100,100,100,"Barbar"));

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

        if (sc.nextLine().equalsIgnoreCase("start")){
            for (int i = 0; i < enemy.size(); i++) {
                System.out.println("Prejes si neco udelat pred tim nez se vrhnem do boje?");
                System.out.println("1) Continue, 2) Vylepsit,  3) Exit");
                switch (sc.nextInt()){
                    case 1:
                        break;
                    case 2:
                        hrac.vylepsit();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                }
                System.out.println("Mame tady:");
                System.out.println(enemy.get(i));
                System.out.println();
                while(enemy.get(i).getZdravi() >0 && hrac.getZdravi() >0){
                    if (enemy.get(i).getTyp().equalsIgnoreCase("barbar")){
                        enemy.get(i).rucniUtok(enemy.get(i), hrac);
                        if (hrac.getZdravi() < 0){
                            hrac.kill();
                            break;
                        }

                        hrac.utok(hrac, enemy.get(i));
                        if(enemy.get(i).getZdravi() <= 0) {
                            enemy.get(i).kill();
                            break;
                        }
                    }else{
                        hrac.utok(hrac, enemy.get(i));
                        if(enemy.get(i).getZdravi() <= 0) {
                            enemy.get(i).kill();
                            hrac.setDovednostniBody(hrac.getDovednostniBody() + 1);
                            hrac.setZdravi(hrac.getMaxZdravi());
                            System.out.println("Aktualni pocet dovednostnich bodu: " + hrac.getDovednostniBody());
                            System.out.println();
                            break;
                        }
                        enemy.get(i).rucniUtok(enemy.get(i), hrac);
                        if (hrac.getZdravi() < 0){
                            hrac.kill();
                            break;
                        }
                    }
                }
            }
            try (BufferedReader br = new BufferedReader(new FileReader("src/zaver.txt"))) {
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
            System.out.println("GRATULUJU! Vyhral si! Porazil si Sedovouse Mrzuteho a odesel si spolecne se svou zenou domu.");
        }

    }

}
