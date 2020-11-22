package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] taulukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int mahtavuus;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        luoTaulukko(KAPASITEETTI);
        mahtavuus = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetti ei saa olla negatiivinen");
        }
        luoTaulukko(kapasiteetti);
        mahtavuus = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    private void luoTaulukko(int koko) {
        taulukko = new int[koko];

        for (int i = 0; i < koko; i++) {
            this.taulukko[i] = 0;
        }
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetti ei saa olla negatiivinen");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kavatuskoko ei saa olla negatiivinen");
        }
        luoTaulukko(kapasiteetti);
        mahtavuus = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            taulukko[mahtavuus] = luku;
            mahtavuus++;
            if (taulukko.length - mahtavuus == 0) {
                kasvata();
            }
            return true;
        }
        return false;
    }

    public void kasvata() {
        int[] uusiTaulukko = new int[mahtavuus + kasvatuskoko];
        for (int i = 0; i < mahtavuus; i++) {
            uusiTaulukko[i] = taulukko[i];
        }
        taulukko = uusiTaulukko;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < mahtavuus; i++) {
            if (luku == taulukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int poistettavanIndeksi = -1;
        for (int i = 0; i < mahtavuus; i++) {
            if (luku == taulukko[i]) {
                poistettavanIndeksi = i;
                break;
            }
        }
        if (poistettavanIndeksi != -1) {
            for (int j = poistettavanIndeksi; j < mahtavuus - 1; j++) {
                taulukko[j] = taulukko[j + 1];
            }
            mahtavuus--;
            return true;
        }
        return false;
    }

    public int getMahtavuus() {
        return mahtavuus;
    }

    @Override
    public String toString() {
        if (mahtavuus == 0) {
            return "{}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < mahtavuus - 1; i++) {
                tuotos += taulukko[i];
                tuotos += ", ";
            }
            tuotos += taulukko[mahtavuus - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[mahtavuus];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = taulukko[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        yhdiste.lisaaTaulu(aTaulu);
        yhdiste.lisaaTaulu(bTaulu);
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            if (b.kuuluu(aTaulu[i])) {
                leikkaus.lisaa(aTaulu[i]);
            }
        }
        return leikkaus;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        erotus.lisaaTaulu(aTaulu);
        erotus.poistaTaulu(bTaulu);
        return erotus;
    }

    public void lisaaTaulu(int[] taulu) {
        for (int i = 0; i < taulu.length; i++) {
            lisaa(taulu[i]);
        }
    }

    public void poistaTaulu(int[] taulu) {
        for (int i = 0; i < taulu.length; i++) {
            poista(taulu[i]);
        }
    }

}
