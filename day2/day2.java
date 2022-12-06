import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day2 {
    /*
     * A, X; for rock. 1 point
     * B, Y; for paper. 2 points
     * C, Z; for scissors. 3 points
     */

    private static final String FILENAME = "C:/Users/Emily/Documents/Code/advent of code 2022/day2/input.txt";
    public static void main(String[] args) {
        try (FileReader fr = new FileReader(FILENAME); BufferedReader br = new BufferedReader(fr)) {
            int score = 0;
            while (br.ready()) {
                String currLine = br.readLine().replaceAll("[^a-zA-Z]", "");
                score += scoreCalculator(currLine);

            }

            System.out.println("the total score is: " + score);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    static int scoreCalculator(String str) {
        int opponent = letterConverter(Character.toString(str.charAt(0)));
        int team = letterConverter(Character.toString(str.charAt(1)));
        int score = team;
        
        if (opponent == team) {
            score += 3;
        } else if ((opponent == 1 && team == 2) || (opponent == 2 && team == 3) || (opponent == 3 && team == 1)) {
            score += 6;
        }

        return score;
    }

    static int letterConverter(String str) {
        int res = 0;
        if (str.equals("A") || str.equals("X")) {              //rock
            res = 1;
        } else if (str.equals("B") || str.equals("Y")) {       //paper
            res = 2;
        } else if (str.equals("C") || str.equals("Z")) {       //scissors
            res = 3;
        }
        
        return res;
    }

}
