package ohtu.kivipaperisakset;

public class KPSParempiTekoaly extends KPS {

  private TekoalyParannettu tekoaly = new TekoalyParannettu(20);


  @Override
  protected String toisenSiirto() {
    String tokanSiirto = tekoaly.annaSiirto();
    System.out.println("Tietokone valitsi: " + tokanSiirto);
    return tokanSiirto;
  }
}
