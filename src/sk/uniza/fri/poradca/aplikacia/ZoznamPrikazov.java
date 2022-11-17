package sk.uniza.fri.poradca.aplikacia;

import sk.uniza.fri.poradca.citace.CitacSuboru;
import sk.uniza.fri.poradca.zariadenia.Mobil;
import sk.uniza.fri.poradca.zariadenia.Notebook;
import sk.uniza.fri.poradca.zariadenia.Tablet;
import sk.uniza.fri.poradca.zariadenia.Zariadenie;
import sk.uniza.fri.poradca.zariadenia.parametre.OperacnySystem;

import java.util.ArrayList;

/**
 * 01-May-21 - 14:35
 * Trieda reprezentujúca zoznam funkčných príkazov v aplikácii, obsahuje metódy na prípadné vykonanie zadaných príkazov.
 * Základ tejto triedy je inšpirovaný príkladom World of FRI z prednášok, drvivú väčšinu som implementoval sám.
 * @author Adam Nagy
 */
public class ZoznamPrikazov {
    private static final String[] FUNKCNE_PRIKAZY = {"hladam", "koniec", "pomoc", "podla"};
    private final CitacSuboru citacSuboru;
    private ArrayList<Zariadenie> aktualnyZoznam;


    public ZoznamPrikazov(CitacSuboru citacSuboru) {
        this.citacSuboru = citacSuboru;
        this.aktualnyZoznam = this.citacSuboru.getZoznamZariadeni();
    }

    /**
     * Zistí či je príkaz funkčný.
     * @param nazovPrikazu príkaz na ktorý sa pýtame
     * @return true ak je v zozname príkazov
     */
    public boolean jeFunkcny(String nazovPrikazu) {
        for (String s : FUNKCNE_PRIKAZY) {
            if (nazovPrikazu.equals(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metóda vykoná zadaný príkaz.
     * @param prikaz príkaz, ktorý sa má vykonať
     * @return true, ak aplikácia pokračuje v činnosti, inak false
     */
    public boolean vykonajPrikaz(Prikaz prikaz) {
        if (prikaz == null) {
            System.out.println("Neznámy príkaz. Zadaj 'pomoc' pre zobrazenie nápovedy.");
            return true;
        }

        switch (prikaz.getNazov()) {
            case "pomoc":
                this.vypisPomoc();
                break;
            case "hladam":
                if (prikaz.maParameter()) {
                    ArrayList<Zariadenie> novyZoznam = this.filtrujTyp(prikaz.getParameter());
                    if (novyZoznam == null) {
                        System.out.println("Neznámy parameter príkazu 'hladam', alebo sa hľadané zariadenie nenachádza v databáze.");
                    } else {
                        this.aktualnyZoznam = novyZoznam;
                        System.out.println("Filter úspešne zadaný.");
                    }
                } else {
                    System.out.println("Príkaz 'hladam' potrebuje parameter.");
                }
                break;
            case "podla":
                if (prikaz.maParameter()) {
                    Zariadenie vysledne = this.najdiIdeal(prikaz.getParameter());
                    if (vysledne != null) {
                        System.out.println(vysledne);
                    } else {
                        System.out.println("Neznámy parameter príkazu 'podla'.");
                    }
                } else {
                    System.out.println("Príkaz 'podla' potrebuje parameter.");
                }
                break;
            case "koniec":
                return false;
        }
        return true; // aplikácia nekončí

    }

    /**
     * Metóda na filtrovanie zoznamu zariadení podľa požiadaviek používateľa.
     * @param typ typ zariadení o ktorý máme záujem
     * @return vyfiltrovaný zoznam zariadení
     */
    public ArrayList<Zariadenie> filtrujTyp(String typ) {
        ArrayList<Zariadenie> novyZoznam = new ArrayList<>();
        ArrayList<Zariadenie> povodnyZoznam = this.citacSuboru.getZoznamZariadeni();

        switch (typ) {

            // vráti zoznam mobilov
            case "m":
            case "M":
            case "mobil":
                for (Zariadenie zariadenie : povodnyZoznam) {
                    if (zariadenie instanceof Mobil) {
                        novyZoznam.add(zariadenie);
                    }
                }
                return novyZoznam;

            // vráti zoznam notebookov
            case "n":
            case "N":
            case "ntb":
            case "nb":
            case "laptop":
            case "notebook":
                for (Zariadenie zariadenie : povodnyZoznam) {
                    if (zariadenie instanceof Notebook) {
                        novyZoznam.add(zariadenie);
                    }
                }
                return novyZoznam;

            // vráti zoznam tabletov
            case "t":
            case "T":
            case "tb":
            case "tablet":
                for (Zariadenie zariadenie : povodnyZoznam) {
                    if (zariadenie instanceof Tablet) {
                        novyZoznam.add(zariadenie);
                    }
                }
                return novyZoznam;

            // vráti zoznam Apple zariadení
            case "apple":
                for (Zariadenie zariadenie : povodnyZoznam) {
                    if (zariadenie.getZnacka().equals("Apple")) {
                        novyZoznam.add(zariadenie);
                    }
                }
                return novyZoznam;

            // vráti zoznam Samsung zariadení
            case "samsung":
                for (Zariadenie zariadenie : povodnyZoznam) {
                    if (zariadenie.getZnacka().equals("Samsung")) {
                        novyZoznam.add(zariadenie);
                    }
                }
                return novyZoznam;

            // vráti zoznam zariadení s operačným systémom Android
            case "android":
                for (Zariadenie zariadenie : povodnyZoznam) {
                    if (zariadenie.getSystem().equals(OperacnySystem.ANDROID)) {
                        novyZoznam.add(zariadenie);
                    }
                }
                return novyZoznam;

            // vráti zoznam zariadení s operačným systémom Windows
            case "win":
            case "windows":
                for (Zariadenie zariadenie : povodnyZoznam) {
                    if (zariadenie.getSystem().equals(OperacnySystem.WINDOWS)) {
                        novyZoznam.add(zariadenie);
                    }
                }
                return novyZoznam;

            // vráti zoznam zariadení s operačným systémom iOS
            case "ios":
                for (Zariadenie zariadenie : povodnyZoznam) {
                    if (zariadenie.getSystem().equals(OperacnySystem.IOS)) {
                        novyZoznam.add(zariadenie);
                    }
                }
                return novyZoznam;

            // vráti celý pôvodný zoznam
            case "vsetko":
                return this.citacSuboru.getZoznamZariadeni();

            default:
                return null;
        }
    }

    /**
     * Metóda vypíše nápovedu na výstup.
     */
    public void vypisPomoc() {
        System.out.println("Nápoveda:");
        System.out.println("hladam _ - upresní vyhľadávanie - na mobily, tablety alebo notebooky");
        System.out.println("                                - na Apple alebo Samsung zariadenia");
        System.out.println("                                - na zariadenia s konkrétnym operačným systémom");
        System.out.println("         - parametre: 'mobil' ('m', 'M'); 'notebook' ('laptop', 'n', 'N', 'nb', 'ntb');");
        System.out.println("                      'tablet' ('t', 'T', 'tb'); 'apple'; 'samsung';");
        System.out.println("                      'android'; 'windows' ('win'); 'ios'");
        System.out.println("Skús napr. 'hladam notebook'");
        System.out.println();
        System.out.println("podla _ - vyhľadávanie podľa kľúčovej vlastnosti zariadenia");
        System.out.println("        - parametre: 'cena+' - najdrahšie zariadenie, 'cena-' - najlacnejšie zariadenie");
        System.out.println("                     'RAM' - najviac RAM pamäte, 'bateria' - najväčšia batéria");
        System.out.println("Skús napr. 'podla cena-', 'podla RAM'");
        System.out.println();
        System.out.println("koniec - ukončenie aplikácie.");
    }

    /**
     * Metóda vráti zariadenie podľa zadanej požiadavky.
     * @param parameter požiadavka, podľa ktorej chceme zariadenie vybrať
     * @return hľadané zariadenie
     */
    public Zariadenie najdiIdeal (String parameter) {
        switch (parameter) {

            // vráti najlacnejšie zariadenie z aktuálneho zoznamu. (ak je ich viac, prvé v poradí)
            case "cenamin":
            case "cena-":
                double minCena = Double.POSITIVE_INFINITY;
                Zariadenie najlacnejsie = null;
                for (Zariadenie zariadenie : this.aktualnyZoznam) {
                    if (zariadenie.getCenaEUR() < minCena) {
                        najlacnejsie = zariadenie;
                        minCena = zariadenie.getCenaEUR();
                    }
                }
                return najlacnejsie;

            // vráti najdrahšie zariadenie z aktuálneho zoznamu. (ak je ich viac, prvé v poradí)
            case "cenamax":
            case "cena+":
                double maxCena = 0;
                Zariadenie najdrahsie = null;
                for (Zariadenie zariadenie : this.aktualnyZoznam) {
                    if (zariadenie.getCenaEUR() > maxCena) {
                        najdrahsie = zariadenie;
                        maxCena = zariadenie.getCenaEUR();
                    }
                }
                return najdrahsie;

            // vráti zariadenie s najväčšou kapacitou RAM pamäte. (ak je ich viac, prvé v poradí)
            case "ram":
            case "RAM":
                int maxRAM = 0;
                Zariadenie najviacRAM = null;
                for (Zariadenie zariadenie : this.aktualnyZoznam) {
                    if (zariadenie.getVelkostRAM() > maxRAM) {
                        najviacRAM = zariadenie;
                        maxRAM = zariadenie.getVelkostRAM();
                    }
                }
                return najviacRAM;

            // vráti zariadenie s najväčšou kapacitou batérie. (ak je ich viac, prvé v poradí)
            case "mah":
            case "bateria":
                int maxBat = 0;
                Zariadenie najVydrz = null;
                for (Zariadenie zariadenie : this.aktualnyZoznam) {
                    if (zariadenie.getKapacitaBaterie() > maxBat) {
                        najVydrz = zariadenie;
                        maxBat = zariadenie.getKapacitaBaterie();
                    }
                }
                return najVydrz;

            // neznámy parameter
            default:
                return null;

        }
    }
}