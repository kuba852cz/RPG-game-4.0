import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Console {

    Scanner sc = new Scanner(System.in);
    private boolean spusteno;
    ArrayList<Postava> enemy = new ArrayList();

    public Console() {
    }

    public void start(){

        Hrac hrac = new Hrac(100,100,100,100,"Hrac",100,100);



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
                while(enemy.get(i).getZdravi() >0 && hrac.getZdravi() >0){
                    if (enemy.get(i).getTyp().equalsIgnoreCase("barbar")){
                        enemy.get(i).rucniUtok(enemy.get(i), hrac);
                        hrac.utok(hrac, enemy.get(i));
                    }else{
                        hrac.utok(hrac, enemy.get(i));
                        enemy.get(i).rucniUtok(enemy.get(i), hrac);
                    }
                }
                if (enemy.get(i).getZdravi() == 0){
                    enemy.get(i).kill();
                }else{
                    hrac.kill();
                }
                System.out.println("GRATULUJU! Vyhral si!");
            }
            System.out.println("CHYBA");
        }

    }
}
