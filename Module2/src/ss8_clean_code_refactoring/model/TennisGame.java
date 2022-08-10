package ss8_clean_code_refactoring.model;

public class TennisGame {
    private static final int SCORE_0 = 0;
    private static final int SCORE_1 = 1;
    private static final int SCORE_2 = 2;
    private static final int SCORE_3 = 3;

    public static String getScore(int m_score1, int m_score2) {
        if (m_score1 == m_score2) {
            return deuce(m_score1) + "-ALL";
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            int minusResult = m_score1 - m_score2;
            return advantangeScore(minusResult);
        }
        return deuce(m_score1) + " - " + deuce(m_score2);
    }

    /**
     * Chuyển điểm người chơi từ dạng số thành cách gọi tương ứng
     * của điểm đó. 0 -> "Love"
     *
     * @param mScore điểm người chơi đạt được
     * @return Cách gọi tương ứng với điểm của người chơi
     */
    public static String deuce(int mScore) {
        switch (mScore) {
            case SCORE_0:
                return "Love";
            case SCORE_1:
                return "Fifteen";
            case SCORE_2:
                return "Thirty";
            case SCORE_3:
                return "Forty";
            default:
                return "Deuce";
        }
    }
    public static String advantangeScore(int minusResult) {
        if (minusResult == 1) {
            return "Advantage player1";
        }

        if (minusResult == -1) {
            return "Advantage player2";
        }

        if (minusResult >= 2) {
            return "Win for player1";
        }

        return "Win for player2";
    }

}