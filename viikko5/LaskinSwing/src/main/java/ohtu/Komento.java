package ohtu;

import javax.swing.JButton;
import javax.swing.JTextField;

public abstract class Komento {

    protected JTextField tuloskentta;
    protected JTextField syotekentta;
    protected JButton nollaa;
    protected JButton undo;
    protected Sovelluslogiikka sovellus;

    public Komento(JTextField tuloskentta, JTextField syotekentta, JButton nollaa, JButton undo, Sovelluslogiikka sovellus) {
        this.nollaa = nollaa;
        this.undo = undo;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovellus = sovellus;
    }

    public abstract void suorita();

    public abstract void peru();
}
