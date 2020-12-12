import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class D2P2 {
    public static void main(String[] args) {
        File file = new File("input.txt");
        ArrayList<String> text = new ArrayList<>();
        String temp;

        char letter;
        char[] value;

        int correctPasswords = 0;
        int i1, i2;

        // read the file things but safely
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((temp = reader.readLine()) != null) {
                text.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String x : text) {
            String[] spaces = x.split(" ");
            i1 = Integer.parseInt(spaces[0].split("-")[0]);
            i2 = Integer.parseInt(spaces[0].split("-")[1]);

            letter = spaces[1].toCharArray()[0];
            value = spaces[2].toCharArray();

            if (((value[i1 - 1]) == letter) != ((value[i2 - 1]) == letter)) {
                correctPasswords++;
                System.out.println("\n\n");
                System.out.println((value[i1 - 1]));
                // System.out.println(letter);
                // System.out.println(i1);
                // System.out.println(i2);
                System.out.println(value);
            }
        }

        System.out.println(correctPasswords);
        // System.out.println(text);
    }
}