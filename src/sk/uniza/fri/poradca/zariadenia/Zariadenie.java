package sk.uniza.fri.poradca.zariadenia;

import sk.uniza.fri.poradca.zariadenia.parametre.OperacnySystem;
import sk.uniza.fri.poradca.zariadenia.parametre.Rozlisenie;
import sk.uniza.fri.poradca.zariadenia.parametre.TypDispleja;

import java.util.ArrayList;

/**
 * 01-May-21 - 14:35
 * Abstraktná trieda reprezentujúca rôzne zariadenia v aplikácii.
 * @author Adam Nagy
 */
public abstract class Zariadenie {
    private String znacka;
    private String model;
    private String procesor;
    private int kapacitaBaterie;
    private Rozlisenie rozlisenie;
    private TypDispleja displej;
    private OperacnySystem system;
    private int velkostRAM;
    private double uhlopriecka;
    private ArrayList<String> dostupneFarby;
    private double cenaEUR;

    public String getZnacka() {
        return this.znacka;
    }

    public void setZnacka(String znacka) {
        this.znacka = znacka;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }

    public int getKapacitaBaterie() {
        return this.kapacitaBaterie;
    }

    public void setKapacitaBaterie(int kapacitaBaterie) {
        this.kapacitaBaterie = kapacitaBaterie;
    }

    public void setRozlisenie(Rozlisenie rozlisenie) {
        this.rozlisenie = rozlisenie;
    }

    public void setDisplej(TypDispleja displej) {
        this.displej = displej;
    }

    public OperacnySystem getSystem() {
        return this.system;
    }

    public void setSystem(OperacnySystem system) {
        this.system = system;
    }

    public int getVelkostRAM() {
        return this.velkostRAM;
    }

    public void setVelkostRAM(int velkostRAM) {
        this.velkostRAM = velkostRAM;
    }

    public void setUhlopriecka(double uhlopriecka) {
        this.uhlopriecka = uhlopriecka;
    }

    public ArrayList<String> getDostupneFarby() {
        return this.dostupneFarby;
    }

    public void setDostupneFarby(ArrayList<String> dostupneFarby) {
        this.dostupneFarby = dostupneFarby;
    }

    public double getCenaEUR() {
        return this.cenaEUR;
    }

    public void setCenaEUR(double cenaEUR) {
        this.cenaEUR = cenaEUR;
    }

    @Override
    public String toString() {
        return this.znacka + " " + this.model +
                "\nprocesor: " + this.procesor +
                "\nbatéria: " + this.kapacitaBaterie + " mAH" +
                "\nRAM: " + this.velkostRAM + " GB" +
                "\ndisplej: " + this.uhlopriecka + "\", " + this.rozlisenie + " " + this.displej.name() +
                "\noperačný systém: " + this.system.name();
    }
}
