/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Nollaa extends Komento {

    private int vanhaArvo = 0;

    public Nollaa(JTextField tuloskentta, JTextField syotekentta, JButton nollaa, JButton undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    public void suorita() {
        vanhaArvo = sovellus.tulos();
        sovellus.nollaa();
        tuloskentta.setText("");
        syotekentta.setText("");
        nollaa.setEnabled(false);
        undo.setEnabled(true);
    }

    @Override
    public void peru() {
        sovellus.plus(vanhaArvo);
        int tulos = sovellus.tulos();
        tuloskentta.setText(String.valueOf(tulos));
        syotekentta.setText("");

        nollaa.setEnabled(false);
        undo.setEnabled(false);
        syotekentta.requestFocusInWindow();
    }

}
