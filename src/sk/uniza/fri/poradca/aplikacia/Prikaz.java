package sk.uniza.fri.poradca.aplikacia;

/**
 * 01-May-21 - 14:35
 * Trieda reprezentuje príkaz v aplikácii, ktorý môže ale nemusí mať parameter.
 * @author Adam Nagy
 */
public class Prikaz {
    private final String nazov;
    private String parameter;

    public Prikaz(String nazov, String parameter) {
        this.nazov = nazov;
        this.parameter = parameter;
    }

    public Prikaz(String nazov) {
        this.nazov = nazov;
    }

    public boolean maParameter() {
        return this.parameter != null;
    }

    public String getNazov() {
        return this.nazov;
    }

    public String getParameter() {
        return this.parameter;
    }
}
