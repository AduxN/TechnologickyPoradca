package sk.uniza.fri.poradca.zariadenia;

import java.util.Arrays;

/**
 * 01-May-21 - 14:35
 * Trieda reprezentuje tablet v aplikácii.
 * @author Adam Nagy
 */
public class Tablet extends Zariadenie {
    private boolean podporaHovorov;

    public void setPodporaHovorov(boolean podporaHovorov) {
        this.podporaHovorov = podporaHovorov;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\npodpora hovorov: " + (this.podporaHovorov ? "áno" : "nie") +
                "\ndostupné farby: " + Arrays.toString(super.getDostupneFarby().toArray()).replace("[", " ").replace("]", " ").trim() +
                "\ncena: " + super.getCenaEUR() + " €";
    }
}
