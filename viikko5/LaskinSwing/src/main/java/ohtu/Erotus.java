/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Erotus extends Komento {

    protected int arvo = 0;

    public Erotus(JTextField tuloskentta, JTextField syotekentta, JButton nollaa, JButton undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    public void suorita() {
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
            System.out.println("virhe: " + e);
        }
        sovellus.miinus(arvo);
        int tulos = sovellus.tulos();
        tuloskentta.setText(String.valueOf(tulos));
        syotekentta.setText("");
        if (tulos != 0) {
            nollaa.setEnabled(true);
        } else {
            nollaa.setEnabled(false);
        }
        arvo = 0;
    }

    @Override
    public void peru() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
