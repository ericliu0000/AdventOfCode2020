import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class SumTwo {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");

        // things for the stuff to be stored
        ArrayList<Integer> text = new ArrayList<>();
        ArrayList<Integer> results = new ArrayList<>();
        String temp;

        // read the file things but safely
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((temp = reader.readLine()) != null) {
                text.add(Integer.valueOf(temp));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // not efficient but it works:tm:
        for (int i = 0; i < text.size(); i++) {
            int num = 2020 - text.get(i);
            for (int j = i; j < text.size(); j++) {
                if (num == text.get(j)) {
                    results.add(num);
                    results.add(2020 - num);
                }
            }
        }
        
        System.out.println(results.get(0) * results.get(1));
    }
}