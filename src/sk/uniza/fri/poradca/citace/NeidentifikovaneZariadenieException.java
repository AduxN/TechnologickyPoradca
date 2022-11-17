package sk.uniza.fri.poradca.citace;

/**
 * 01-May-21 - 14:35
 * Výnimka v prípade nájdenia neznámeho typu zariadenia v databáze.
 * @author Adam Nagy
 */
public class NeidentifikovaneZariadenieException extends Exception {

    public NeidentifikovaneZariadenieException(String message) {
        super(message);
    }
}
