import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class D2P1 {
    public static void main(String[] args) {
        File file = new File("input.txt");
        ArrayList<String> text = new ArrayList<>();
        String temp, value;
        char letter;
        int correctPasswords = 0;
        int min, max;

        // read the file things but safely
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((temp = reader.readLine()) != null) {
                text.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String x : text) {
            int letterCount = 0;
            String[] spaces = x.split(" ");
            min = Integer.parseInt(spaces[0].split("-")[0]);
            max = Integer.parseInt(spaces[0].split("-")[1]);
            
            letter = spaces[1].toCharArray()[0];
            value = spaces[2];

            for (char i : value.toCharArray()) {
                if (i == letter) letterCount++;
            }

            if ((min <= letterCount) && (letterCount <= max)) correctPasswords++;
        }

        System.out.println(correctPasswords);
        // System.out.println(text);
    }
}