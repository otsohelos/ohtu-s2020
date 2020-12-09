package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.peli.KPS;
import ohtu.kivipaperisakset.peli.KPSPelaajaVsPelaaja;
import ohtu.kivipaperisakset.peli.KPSTekoaly;
import ohtu.kivipaperisakset.peli.KPSParempiTekoaly;

public class Pelitehdas {

  public Pelitehdas() {
  }

  public KPS luo(String merkki) {
    switch (merkki) {
      case "a":
        return new KPSPelaajaVsPelaaja();
      case "b":
        return new KPSTekoaly();
      case "c":
        return new KPSParempiTekoaly();
      default:
        return null;
    }
  }

}
