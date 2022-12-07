import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;

public class day3 {
    private static final String FILENAME = "C:/Users/Emily/Documents/Code/advent of code 2022/day 3/input.txt";

    public static void main(String[] args) {
        try (FileReader fr = new FileReader(FILENAME); BufferedReader br = new BufferedReader(fr)) {
            int sum = 0;
            while (br.ready()) {
                String currLine = br.readLine();
                sum += compartCompare(currLine);
            }

            System.out.println("the total sum is: " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String toString(char[] a) {
        return new String(a);
    }

    static int compartCompare(String str) {
        int res = 0;
        HashSet<Character> set1 = new HashSet<Character>();
        HashSet<Character> set2 = new HashSet<Character>();
        char[] s1 = str.substring(0, str.length() / 2).toCharArray();
        char[] s2 = str.substring(str.length() / 2, str.length()).toCharArray();
        char duplicate = '-';
        for (int i = 0; i < s1.length; i++) {
            char currCharS1 = s1[i];
            char currCharS2 = s2[i];
            
            if (currCharS1 == currCharS2) {
                duplicate = currCharS1;
                break;
            } else if (set2.contains(currCharS1) || set1.contains(currCharS2)) {
                if (set2.contains(currCharS1)) {
                    duplicate = currCharS1;
                    break;
                } else if (set1.contains(currCharS2)) {
                    duplicate = currCharS2;
                    break;
                }
            } else {
                set1.add(currCharS1);
                set2.add(currCharS2);
            }
        }
        res += respectiveNumFinder(duplicate);

        return res;
    }


    static int respectiveNumFinder(char c) {
        int res = 0;
        if (Character.isLowerCase(c)) {
            res = c - 96;
        } else if (Character.isUpperCase(c)) {
            res = c - 38;
        }

        return res;
    }

}
