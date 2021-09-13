package _08_clean_code_and_refactor.exercise.refactoring;

public class TennisGame {
    static final int LOVE = 0;
    static final int FIFTEEN = 1;
    static final int THIRTY = 2;
    static final int FORTY = 3;
    static final String SUBTRACTION = "-";

    public static String getScore(String player1, String player2, int player1Score, int player2Score) {
        String score = "";

        if (player1Score == player2Score) {
            score += printDeuce(player1Score);
        } else if (player1Score >= 4 || player2Score >= 4) {
            score += printAdvantage(player1Score, player2Score);
        } else {
            score += printWin(player1Score, player2Score);
        }
        return score;
    }

    public static String printDeuce(int player1Score) {
        switch (player1Score) {
            case LOVE:
                return "Love-All";
            case FIFTEEN:
                return "Fifteen-All";
            case THIRTY:
                return "Thirty-All";
            case FORTY:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    public static String printAdvantage(int player1Score, int player2Score) {
        int minusScore = player1Score - player2Score; //Tính sự chênh lệch điểm số giữa 2 người chơi
        if (minusScore == 1) return "Advantage player1";
        else if (minusScore == -1) return "Advantage player2";
        else if (minusScore >= 2) return "Win for player1";
        else return "Win for player2";
    }

    public static String printWin(int player1Score, int player2Score) {
        int temp = 0;
        String score = "";
        for (int i = 1; i < 3; i++) {
            if (i == 1) temp = player1Score;
            else {
                score += SUBTRACTION;
                temp = player2Score;
            }
            switch (temp) {
                case LOVE:
                    score += "Love";
                    break;
                case FIFTEEN:
                    score += "Fifteen";
                    break;
                case THIRTY:
                    score += "Thirty";
                    break;
                case FORTY:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }
}