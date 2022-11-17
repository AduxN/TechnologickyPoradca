package sk.uniza.fri.poradca.citace;

import sk.uniza.fri.poradca.zariadenia.parametre.OperacnySystem;
import sk.uniza.fri.poradca.zariadenia.parametre.Rozlisenie;
import sk.uniza.fri.poradca.zariadenia.parametre.TypDispleja;
import sk.uniza.fri.poradca.zariadenia.Mobil;
import sk.uniza.fri.poradca.zariadenia.Notebook;
import sk.uniza.fri.poradca.zariadenia.Tablet;
import sk.uniza.fri.poradca.zariadenia.Zariadenie;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 01-May-21 - 14:35
 * Trieda slúžiaca na čítanie údajov z databázy zariadení.
 * @author Adam Nagy
 */
public class CitacSuboru {
    private final ArrayList<Zariadenie> zoznamZariadeni;

    public CitacSuboru() {
        this.zoznamZariadeni = new ArrayList<>();
    }


    /**
     * Metóda načíta databázu zariadení z textového súboru do príslušných tried.
     * @param nazovSuboru súbor s databázou zariadení
     * @throws IOException chyba pri čítaní súboru
     * @throws NeidentifikovaneZariadenieException neznáme zariadenie v databáze
     */
    public void nacitajSubor(String nazovSuboru) throws IOException, NeidentifikovaneZariadenieException {

        Scanner citac = new Scanner(new File(nazovSuboru));
        String riadok = citac.nextLine();
        Zariadenie zariadenie;

        while (riadok != null) {
            if (riadok.startsWith(">M")) {
                zariadenie = new Mobil();
            } else if (riadok.startsWith(">N")) {
                zariadenie = new Notebook();
            } else if (riadok.startsWith(">T")) {
                zariadenie = new Tablet();
            } else {
                throw new NeidentifikovaneZariadenieException("Našlo sa neidentifikované zariadenie, skontrolujte zdrojový súbor");
            }
            this.zoznamZariadeni.add(zariadenie);

            // postupne prechádzam riadky súboru a nastavujem parametre
            riadok = citac.nextLine();
            while (!riadok.startsWith(">")) {
                zariadenie.setZnacka(riadok.split(" ")[0]);     // prvé slovo v riadku
                zariadenie.setModel(riadok.substring(riadok.split(" ")[0].length() + 1)); // zvyšok riadku

                riadok = citac.nextLine();
                zariadenie.setProcesor(riadok);

                riadok = citac.nextLine();
                zariadenie.setKapacitaBaterie(Integer.parseInt(riadok.split(" ")[0]));

                riadok = citac.nextLine();
                zariadenie.setRozlisenie(Rozlisenie.valueOf(riadok));

                riadok = citac.nextLine();
                try {
                    zariadenie.setDisplej(TypDispleja.valueOf(riadok));
                } catch (IllegalArgumentException ex) {
                    zariadenie.setDisplej(TypDispleja.INY_TYP);
                }

                riadok = citac.nextLine();
                try {
                    zariadenie.setSystem(OperacnySystem.valueOf(riadok));
                } catch (IllegalArgumentException ex) {
                    zariadenie.setSystem(OperacnySystem.INY_OS);
                }

                riadok = citac.nextLine();
                zariadenie.setVelkostRAM(Integer.parseInt(riadok.split(" ")[0]));

                riadok = citac.nextLine();
                zariadenie.setUhlopriecka(Double.parseDouble(riadok.split(" ")[0]));

                riadok = citac.nextLine();
                zariadenie.setDostupneFarby(new ArrayList<>(Arrays.asList(riadok.split(", "))));

                riadok = citac.nextLine();
                zariadenie.setCenaEUR(Double.parseDouble(riadok.split(" ")[0]));

                if (zariadenie instanceof Mobil) {
                    riadok = citac.nextLine();
                    ((Mobil)zariadenie).setDualSIM(riadok.split(" ")[0].equals("áno"));

                    riadok = citac.nextLine();
                    ((Mobil)zariadenie).setMicroSD(riadok.split(" ")[0].equals("áno"));

                    riadok = citac.nextLine();
                    ((Mobil)zariadenie).setRychleNabijanie(riadok.split(" ")[0].equals("áno"));

                    riadok = citac.nextLine();
                    ((Mobil)zariadenie).setVodeodolnost(riadok.split(" ")[0].equals("áno"));

                    riadok = citac.nextLine();
                    ((Mobil)zariadenie).setFotoaparatMP(Integer.parseInt(riadok.split(" ")[0]));

                } else if (zariadenie instanceof Notebook) {
                    riadok = citac.nextLine();
                    ((Notebook)zariadenie).setGrafickaKarta(riadok);

                    riadok = citac.nextLine();
                    ((Notebook)zariadenie).setPodsvietenaKlavesnica(riadok.split(" ")[0].equals("áno"));

                    riadok = citac.nextLine();
                    ((Notebook)zariadenie).setHerny(riadok.split(" ")[0].equals("áno"));

                } else {
                    riadok = citac.nextLine();
                    ((Tablet)zariadenie).setPodporaHovorov(riadok.split(" ")[0].equals("áno"));
                }
                if (citac.hasNextLine()) {
                    riadok = citac.nextLine();  // ak mám ďalšie zariadenie, prechádzam naň
                } else {
                    riadok = null;
                    break;
                }
            }
        }
        citac.close();
    }

    public ArrayList<Zariadenie> getZoznamZariadeni() {
        return this.zoznamZariadeni;
    }
}