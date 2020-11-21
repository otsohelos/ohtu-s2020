package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {

    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;
    Kauppa k;

    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        when(viite.uusi()).thenReturn(42);
        varasto = mock(Varasto.class);
        this.k = new Kauppa(varasto, pankki, viite);
    }

    @Test
    public void ostoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaanOikein() {
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(eq("pekka"), anyInt(), eq("12345"), anyString(), eq(5));
        // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }

    @Test
    public void kahdenOstoksenJalkeenPankinMetodiaTilisiirtoKutsutaanOikein() {
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(2)).thenReturn(20);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "leipä", 10));

        // sitten testattava kauppa 
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);

        k.tilimaksu("marjatta", "54321");
        verify(pankki).tilisiirto(eq("marjatta"), anyInt(), eq("54321"), anyString(), eq(15));

    }

    @Test
    public void kahdenSamanOstoksenJalkeenPankinMetodiaTilisiirtoKutsutaanOikein() {
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);

        k.tilimaksu("minna", "13579");
        verify(pankki).tilisiirto(eq("minna"), anyInt(), eq("13579"), anyString(), eq(10));
    }

    @Test
    public void onnistuneenJaLoppuneenTuotteenOstoksenJalkeenTilisiirtoKutsutaanOikein() {
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        when(varasto.saldo(3)).thenReturn(0);
        when(varasto.haeTuote(3)).thenReturn(new Tuote(2, "makkara", 10));
        // sitten testattava kauppa 
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(3);

        k.tilimaksu("wolfgang", "98765");
        verify(pankki).tilisiirto(eq("wolfgang"), anyInt(), eq("98765"), anyString(), eq(5));

    }

    @Test
    public void aloitaAsiointiNollaaEdellisenOstoksen() {
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("hannelore", "23456");
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("jevgenii", "34567");

        verify(pankki).tilisiirto(eq("jevgenii"), anyInt(), eq("34567"), anyString(), eq(5));
    }

    @Test
    public void kauppaPyytaaUudenViitenumeronJokaMaksutapahtumalle() {
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("er-hong", "45678");
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("galadriel", "56789");

        verify(viite, times(2)).uusi();
        
    }
}
