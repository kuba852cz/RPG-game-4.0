import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class PocitacRadkuProjektu {

    public static void main(String[] args) {
        String slozka = "src"; // změň podle toho, kde máš třídy
        int celkemRadku = 0;

        try (Stream<Path> paths = Files.walk(Paths.get(slozka))) {
            for (Path path : (Iterable<Path>) paths.filter(Files::isRegularFile)::iterator) {
                if (path.toString().endsWith(".java")) {
                    int radky = spocitejCisteRadky(path.toFile());
                    System.out.println(path + ": " + radky + " čistých řádků");
                    celkemRadku += radky;
                }
            }
            System.out.println("🔢 Celkem čistých řádků kódu ve složce '" + slozka + "': " + celkemRadku);
        } catch (IOException e) {
            System.out.println("Chyba: " + e.getMessage());
        }
    }

    private static int spocitejCisteRadky(File file) {
        int pocet = 0;
        boolean vKomentari = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String radek;
            while ((radek = reader.readLine()) != null) {
                radek = radek.trim();
                if (radek.isEmpty()) continue;

                if (vKomentari) {
                    if (radek.contains("*/")) {
                        vKomentari = false;
                        radek = radek.substring(radek.indexOf("*/") + 2).trim();
                        if (radek.isEmpty()) continue;
                    } else {
                        continue;
                    }
                }

                if (radek.startsWith("/*")) {
                    if (!radek.contains("*/")) {
                        vKomentari = true;
                        continue;
                    } else {
                        radek = radek.substring(radek.indexOf("*/") + 2).trim();
                        if (radek.isEmpty()) continue;
                    }
                }

                if (radek.startsWith("//")) continue;
                if (radek.contains("//")) radek = radek.substring(0, radek.indexOf("//")).trim();
                if (radek.contains("/*")) radek = radek.substring(0, radek.indexOf("/*")).trim();

                if (!radek.isEmpty()) pocet++;
            }
        } catch (IOException e) {
            System.out.println("Chyba při čtení souboru " + file.getName() + ": " + e.getMessage());
        }

        return pocet;
    }
}

//by ChatGPT: Pouze pocitadlo radku
