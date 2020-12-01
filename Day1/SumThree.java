import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class SumThree {
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

        // something something big O notation bad aaaaaa
        for (int i = 0; i < text.size(); i++) {
            int num = 2020 - text.get(i);
            // please don't mind this
            // this part checks the numbers and contributes to the high o i think
            for (int x = i; x < text.size(); x++) {
                for (int y = x; y < text.size(); y++) {
                    if ((text.get(x) + text.get(y) == num)) {
                        results.add(text.get(x));
                        results.add(text.get(y));
                        results.add(2020 - num);
                        // kill it after here for marginal time savings
                        break;
                    }
                }
            }
        }

        System.out.println(results);
        System.out.println(results.get(0) * results.get(1) * results.get(2));

    }
}