package sk.uniza.fri.poradca.zariadenia;

import java.util.Arrays;

/**
 * 01-May-21 - 14:35
 * Trieda reprezentuje notebook v aplikácii.
 * @author Adam Nagy
 */
public class Notebook extends Zariadenie {
    private String grafickaKarta;
    private boolean herny;
    private boolean podsvietenaKlavesnica;

    public void setGrafickaKarta(String grafickaKarta) {
        this.grafickaKarta = grafickaKarta;
    }

    public void setHerny(boolean herny) {
        this.herny = herny;
    }

    public void setPodsvietenaKlavesnica(boolean podsvietenaKlavesnica) {
        this.podsvietenaKlavesnica = podsvietenaKlavesnica;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\ngrafická karta: " + this.grafickaKarta +
                "\nherný: " + (this.herny ? "áno" : "nie") +
                "\npodsvietená klávesnica: " + (this.podsvietenaKlavesnica ? "áno" : "nie") +
                "\ndostupné farby: " + Arrays.toString(super.getDostupneFarby().toArray()).replace("[", " ").replace("]", " ").trim() +
                "\ncena: " + super.getCenaEUR() + " €";
    }
}
