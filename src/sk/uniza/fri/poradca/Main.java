package sk.uniza.fri.poradca;

import sk.uniza.fri.poradca.aplikacia.Aplikacia;
import sk.uniza.fri.poradca.citace.NeidentifikovaneZariadenieException;

import java.io.IOException;

/**
 * 01-May-21 - 14:35
 * Hlavná trieda na spustenie aplikácie.
 * @author Adam Nagy
 */
public class Main {

    public static void main(String[] args) {

        Aplikacia aplikacia = new Aplikacia();

        try {
            aplikacia.getCitacSuboru().nacitajSubor("DatabazaProduktov.txt");
            aplikacia.start();
        } catch (IOException ioe) {
            System.err.println("Chyba pri načítavaní zdrojového súboru.");
        } catch (NeidentifikovaneZariadenieException nze) {
            System.err.println(nze.getMessage());
        }
    }
}
