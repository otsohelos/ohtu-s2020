package ohtu.kivipaperisakset;

public class KPSTekoaly extends KPS {

    Tekoaly tekoaly = new Tekoaly();

    @Override
    protected String toisenSiirto() {
      String tokanSiirto = tekoaly.annaSiirto();
      System.out.println("Tietokone valitsi: " + tokanSiirto);
      return tokanSiirto;
    }
}