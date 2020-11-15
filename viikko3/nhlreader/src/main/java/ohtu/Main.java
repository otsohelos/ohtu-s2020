package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

//        System.out.println("json-muotoinen data:");
//        System.out.println(bodyText);

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);

        System.out.println("Oliot:");

        String muotoilu = " %1$-25s %2$-12s %3$-7s %4$-7s %5$-7s\n";

        System.out.format(muotoilu, "Name", "Nationality", "Goals", "Assists", "Total");
        System.out.println("-------------------------------------------------------------");

        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                System.out.format(muotoilu, player.getName(), player.getNationality(), player.getGoals(), player.getAssists(), player.getGoals() + player.getAssists());
            }
        }
    }

}
