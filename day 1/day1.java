import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class day1 {
    private static final String FILENAME = "C:/Users/Emily/Documents/Code/advent of code 2022/day 1/input.txt";
    public static void main(String[] args) throws IOException {
        // remember to add 1 to the index to get the number of the elf with the most
        // initializing data structure, list can work well and it resizes automatically
        // im choosing an arraylist as my data structure because i can store the count of each elf in one index.
        // an array may have better space complexity, however i think using an array resizing helper method
        // would add more time complexity than its worth. therefore an arraylist works well.
        List<Integer> list = new ArrayList<>();

        //initializing input readers and surrounding by try catch block in case of file not existing

        try (FileReader fr = new FileReader(FILENAME); BufferedReader br = new BufferedReader(fr)) {
            
            //counting amount of calories each elf has
            int count = 0;
            while(br.ready()) {
                String currLine = br.readLine();
                if (!currLine.equals("")) {
                    count += Integer.parseInt(currLine);
                } else if (currLine.equals("")) {
                    list.add(count);
                    count = 0;
                }
            }

            //determining the highest amount of calories a single elf is carrying
            int highest = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > highest) {
                    highest = list.get(i);
                }
            }

            //printing answer!
            System.out.println("The highest number of calories one of the elves has is: " + highest);


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            
    }


}