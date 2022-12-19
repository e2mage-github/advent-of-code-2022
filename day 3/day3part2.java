import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class day3part2 {
    private static final String FILENAME = "C:/Users/Emily/Documents/Code/advent of code 2022/day 3/input.txt";
    public static void main(String[] args) {
        try (FileReader fr = new FileReader(FILENAME); BufferedReader br = new BufferedReader(fr)) {
            ArrayList<String> list = new ArrayList<>();
            int sum = 0;
            while (br.ready()) {
                String currLine = br.readLine();
                list.add(currLine);
                

                if (list.size() == 3) {
                    char c = badgeFinder(list);
                    sum += priorityFinder(c);
                    
                    list = new ArrayList<>();
                }
            }

            System.out.println("the total sum is: " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static char badgeFinder(ArrayList<String> l) {
        HashSet<Character> s1 = new HashSet<>();
        HashSet<Character> s2 = new HashSet<>();
        HashSet<Character> s3 = new HashSet<>();

        for (int i = 0; i < l.size(); i++) {
            char[] arr = l.get(i).toCharArray();
            switch (i) {
                case 0:
                    s1 = charAdder(arr, s1);
                    break;
                case 1:
                    s2 = charAdder(arr, s2);
                    break;
                case 2:
                    s3 = charAdder(arr, s3);
                    break;
            }
        }

        return tripleFinder(s1, s2, s3);
    }

    static char tripleFinder(HashSet<Character> s1, HashSet<Character> s2, HashSet<Character> s3) {
        char ans = ' ';
        for (char c : s1) {
            if (s2.contains(c) && s3.contains(c)) {
                ans = c;
            }
        }
        return ans;
    }

    static HashSet<Character> charAdder(char[] arr, HashSet<Character> s) {
        for (int i = 0; i < arr.length; i++) {
            s.add(arr[i]);
        }
        return s;
    }

    static int priorityFinder(char c) {
        int add = 0;
        if (Character.isLowerCase(c)) {
            add = c - 96;
        } else if (Character.isUpperCase(c)) {
            add = c - 38;
        }
        return add;
    }
}
