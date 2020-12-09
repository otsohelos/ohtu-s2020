package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    boolean jatketaan = true;

    while (jatketaan) {
      System.out.println("\nValitse pelataanko" + "\n (a) ihmistä vastaan " + "\n (b) tekoälyä vastaan"
          + "\n (c) parannettua tekoälyä vastaan" + "\nmuilla valinnoilla lopetataan");

      String vastaus = scanner.nextLine();

      String valintamerkki = "";
      if (vastaus.length() > 0) {
        valintamerkki = vastaus.substring(vastaus.length() - 1);
      }
      jatketaan = pelaa(valintamerkki);
    }
  }

  private static Boolean pelaa(String merkki) {
    switch (merkki) {
      case "a":
        tulostaPeliohje();
        KPSPelaajaVsPelaaja kaksinpeli = new KPSPelaajaVsPelaaja();
        kaksinpeli.pelaa();
        return true;
      case "b":
        tulostaPeliohje();
        KPSTekoaly yksinpeli = new KPSTekoaly();
        yksinpeli.pelaa();
        return true;
      case "c":
        tulostaPeliohje();
        KPSParempiTekoaly pahaYksinpeli = new KPSParempiTekoaly();
        pahaYksinpeli.pelaa();
        return true;
      default:
        return false;
    }

  }

  private static void tulostaPeliohje() {
    System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");

  }

}
