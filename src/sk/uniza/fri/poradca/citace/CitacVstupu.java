package sk.uniza.fri.poradca.citace;

import sk.uniza.fri.poradca.aplikacia.Prikaz;
import sk.uniza.fri.poradca.aplikacia.ZoznamPrikazov;

import java.util.Scanner;

/**
 * 01-May-21 - 14:35
 * Trieda slúžiaca na čítanie vstupu od používateľa.
 * @author Adam Nagy
 */
public class CitacVstupu {
    private final Scanner citac;
    private final ZoznamPrikazov prikazy;

    public CitacVstupu(ZoznamPrikazov prikazy) {
        this.citac = new Scanner(System.in);
        this.prikazy = prikazy;
    }

    /**
     * Metóda načíta vstup od používateľa a vráti ho ako príkaz.
     * Metóda vráti null, ak príkaz nieje funkčný.
     * @return príkaz zo vstupu
     */
    public Prikaz nacitaj() {
        System.out.print("=> ");
        String poziadavka = this.citac.nextLine();

        if (this.prikazy.jeFunkcny(poziadavka.split(" ")[0])) {
            if (poziadavka.split(" ").length > 1) {
                return new Prikaz(poziadavka.split(" ")[0], poziadavka.split(" ")[1]);
            } else {
                return new Prikaz(poziadavka.split(" ")[0]);
            }
        } else {
            return null;
        }
    }
}
