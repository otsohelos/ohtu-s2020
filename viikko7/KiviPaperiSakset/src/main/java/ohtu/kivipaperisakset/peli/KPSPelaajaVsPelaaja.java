package ohtu.kivipaperisakset.peli;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KPS {

  private static final Scanner scanner = new Scanner(System.in);

  @Override
  protected String toisenSiirto() {
    System.out.print("Toisen pelaajan siirto: ");
    return scanner.nextLine();
  }
}