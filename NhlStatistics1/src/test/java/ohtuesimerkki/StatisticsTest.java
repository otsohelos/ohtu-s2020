/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author otsohelos
 */
public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;
    double tarkkuus = 0.0001;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void topScorersToimii() {
        List<Player> tops = stats.topScorers(2);
        assertEquals(2, tops.size(), tarkkuus);
        assertEquals("Gretzky", tops.get(0).getName());
    }
    
    @Test
    public void teamToimii() {
        List<Player> edmissa = stats.team("EDM");
        assertEquals(3, edmissa.size(), tarkkuus);
        assertEquals("Semenko", edmissa.get(0).getName());
    }
    
    @Test
    public void searchToimii() {
        Player player = stats.search("rri");
        assertEquals("Kurri", player.getName());
    }
    
        @Test
    public void searchToimiiKunEiLöydy() {
        Player player = stats.search("Kekkonen");
        assertEquals(null, player);
    }
}
