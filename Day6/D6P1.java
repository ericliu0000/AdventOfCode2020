import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class D6P1 {
    public static void main(String[] args) {
        File file = new File("input.txt");
        ArrayList<String> text = new ArrayList<>();
        String temp, x = "";

        // pls don't mind this
        String[] pleaseDontLookAtThis = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
                "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        int count = 0;

        // read the file, seperating by newlines
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((temp = reader.readLine()) != null) {
                if (temp.length() >= 1) {
                    x += temp;
                } else {
                    text.add(x);
                    x = "";
                }
            }
            // x += temp;
            text.add(x);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // finding the uniques
        for (String i : text) {
            for (String j : pleaseDontLookAtThis) {
                if (i.contains(j)) {
                    count++;
                }
            }
            // System.out.println(count);
        }

        System.out.println(count);
    }
}
