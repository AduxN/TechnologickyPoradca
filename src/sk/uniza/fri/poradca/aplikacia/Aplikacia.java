package sk.uniza.fri.poradca.aplikacia;

import sk.uniza.fri.poradca.citace.CitacSuboru;
import sk.uniza.fri.poradca.citace.CitacVstupu;

/**
 * 01-May-21 - 14:35
 * Trieda na hlavné ovládanie aplikácie.
 * @author Adam Nagy
 */
public class Aplikacia {
    private final CitacSuboru citacSuboru;
    private final CitacVstupu citacVstupu;
    private final ZoznamPrikazov zoznamPrikazov;

    public Aplikacia() {
        this.citacSuboru = new CitacSuboru();
        this.zoznamPrikazov = new ZoznamPrikazov(this.citacSuboru);
        this.citacVstupu = new CitacVstupu(this.zoznamPrikazov);

    }

    /**
     * Metóda na výpis privítania.
     */
    public void vypisUvod() {
        System.out.println("Vitaj v aplikácii Technologický poradca.");
        System.out.println("Aplikácia ti pomôže s výberom nového zariadenia.");
        System.out.println("V prípade potreby zadaj príkaz 'pomoc'.");
    }

    /**
     * Hlavná metóda slúžiaca na spustenie aplikácie. Aplikácia beží, až kým ju užívateľ neukončí.
     */
    public void start() {
        this.vypisUvod();

        // vykonám vždy aspoň jeden príkaz
        // keď metóda vykonajPrikaz vráti false, končím aplikáciu
        Prikaz prikaz;
        do {
            prikaz = this.citacVstupu.nacitaj();
        } while (this.zoznamPrikazov.vykonajPrikaz(prikaz));

        System.out.println("Vďaka za dôveru, snáď som pomohol :)");
    }

    public CitacSuboru getCitacSuboru() {
        return this.citacSuboru;
    }
}
