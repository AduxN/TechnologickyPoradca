package sk.uniza.fri.poradca.zariadenia;

import java.util.Arrays;

/**
 * 01-May-21 - 14:35
 * Trieda reprezentuje mobilný telefón v aplikácii.
 * @author Adam Nagy
 */
public class Mobil extends Zariadenie {
    private boolean dualSIM;
    private boolean microSD;
    private boolean rychleNabijanie;
    private boolean vodeodolnost;
    private int fotoaparatMP;

    public void setDualSIM(boolean dualSIM) {
        this.dualSIM = dualSIM;
    }

    public void setMicroSD(boolean microSD) {
        this.microSD = microSD;
    }

    public void setRychleNabijanie(boolean rychleNabijanie) {
        this.rychleNabijanie = rychleNabijanie;
    }

    public void setVodeodolnost(boolean vodeodolnost) {
        this.vodeodolnost = vodeodolnost;
    }

    public void setFotoaparatMP(int fotoaparatMP) {
        this.fotoaparatMP = fotoaparatMP;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nfotoapárat: " + this.fotoaparatMP + " MP" +
                "\ndualSIM: " + (this.dualSIM ? "áno" : "nie") +
                "\nmicroSD slot: " + (this.microSD ? "áno" : "nie") +
                "\nrýchle nabíjanie: " + (this.rychleNabijanie ? "áno" : "nie") +
                "\nvodeodolnosť: " + (this.vodeodolnost ? "áno" : "nie") +
                "\ndostupné farby: " + Arrays.toString(super.getDostupneFarby().toArray()).replace("[", " ").replace("]", " ").trim() +
                "\ncena: " + super.getCenaEUR() + " €";
    }
}
