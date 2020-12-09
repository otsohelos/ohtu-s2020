package ohtu.kivipaperisakset;

import java.util.Scanner;

import ohtu.kivipaperisakset.peli.KPS;

public class Paaohjelma {

  private static final Scanner scanner = new Scanner(System.in);
  private static Pelitehdas pelitehdas = new Pelitehdas();

  public static void main(String[] args) {

    KPS kps = pelitehdas.luo("a");

    while (kps != null) {
      System.out.println("\nValitse pelataanko" + "\n (a) ihmistä vastaan " + "\n (b) tekoälyä vastaan"
          + "\n (c) parannettua tekoälyä vastaan" + "\nmuilla valinnoilla lopetataan");

      String vastaus = scanner.nextLine();

      String valintamerkki = "";
      if (vastaus.length() > 0) {
        valintamerkki = vastaus.substring(vastaus.length() - 1);
      }
      kps = pelitehdas.luo(valintamerkki);
      if (kps != null) {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        kps.pelaa();
      }
    }
  }

}
