package ohtu;

public class TennisGame {

    private int player1Score;
    private int player2Score;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1Score = 0;
        this.player2Score = 0;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    public String getScore() {
        if (howMuchDifference() == 0) {
            return getEvenScore(player1Score);
        }
        if (player1Score >= 4 || player2Score >= 4) {
            return (getAdvantageOrWinnerScore());
        }
        String scoreString = getScoreName(player1Score);
        scoreString += "-";
        scoreString += getScoreName(player2Score);
        return scoreString;
    }

    private String getEvenScore(int score) {
        String scoreString = "";
        if (score > 3) {
            return "Deuce";
        }
        scoreString += getScoreName(score);
        scoreString += "-All";
        return scoreString;
    }

    private String getScoreName(int score) {
        String scoreString = "";
        switch (score) {
            case 0:
                scoreString = "Love";
                break;
            case 1:
                scoreString = "Fifteen";
                break;
            case 2:
                scoreString = "Thirty";
                break;
            case 3:
                scoreString = "Forty";
                break;
        }
        return scoreString;
    }

    private String getAdvantageOrWinnerScore() {
        String scoreString = "";
        if (howMuchDifference() == 1) {
            scoreString = "Advantage " + whoIsAhead();
        } else {
            scoreString = "Win for " + whoIsAhead();
        }
        return scoreString;
    }

    private String whoIsAhead() {
        String whoIsAhead = player1Name;
        if (player1Score < player2Score) {
            whoIsAhead = player2Name;
        }
        return whoIsAhead;
    }

    private int howMuchDifference() {
        return Math.abs(player1Score - player2Score);
    }
}
