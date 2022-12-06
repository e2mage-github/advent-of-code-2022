import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day2part2 {
    private static final String FILENAME = "C:/Users/Emily/Documents/Code/advent of code 2022/day 2/input.txt";
    /*
     * A for rock, 1 point
     * B for paper, 2 points
     * C for scissors, 3 points
     * 
     * X for loss, 0 points
     * Y for draw, 3 points
     * Z for win, 6 points
     */
    public static void main(String[] args) {
        try (FileReader fr = new FileReader(FILENAME); BufferedReader br = new BufferedReader(fr)) {
            int score = 0;

            while (br.ready()) {
                String currLine = br.readLine().replaceAll("[^a-zA-Z]", "");
                score += scoreCalculator(currLine);
            }

            System.out.println("the total score is: " + score);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int scoreCalculator(String str) {
        String opponent = Character.toString(str.charAt(0));
        String team = Character.toString(str.charAt(1));
        int score = 0;

        if (team.equals("X")) {
            score += loseHand(opponent);
        } else if (team.equals("Y")) {
            score += drawHand(opponent);
        } else if (team.equals("Z")) {
            score += winHand(opponent);
        }

        return score;
    }

    static int winHand(String opp) {
        int i = 6;
        if (opp.equals("A")) {
            i += 2;
        } else if (opp.equals("B")) {
            i += 3;
        } else if (opp.equals("C")) {
            i += 1;
        }

        return i;
    }
    static int drawHand(String opp) {
        int i = 3;
        if (opp.equals("A")) {
            i += 1;
        } else if (opp.equals("B")) {
            i += 2;
        } else if (opp.equals("C")) {
            i += 3;
        }

        return i;
    }
    static int loseHand(String opp) {
        int i = 0;
        if (opp.equals("A")) {
            i += 3;
        } else if (opp.equals("B")) {
            i += 1;
        } else if (opp.equals("C")) {
            i += 2;
        }

        return i;
    }

}
