package ohtu.kivipaperisakset.peli;

import ohtu.kivipaperisakset.Tekoaly;

public class KPSTekoaly extends KPS {

    Tekoaly tekoaly = new Tekoaly();

    @Override
    protected String toisenSiirto() {
      String tokanSiirto = tekoaly.annaSiirto();
      System.out.println("Tietokone valitsi: " + tokanSiirto);
      return tokanSiirto;
    }
}