import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class D6P2 {
    public static void main(String[] args) {
        File file = new File("input.txt");
        ArrayList<String> text = new ArrayList<>();
        String temp, x = "";

        // actually please do not look at this
        String[] pleaseDontLookAtThis = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
                "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        int count = 0;

        // read the file, seperating by newlines
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((temp = reader.readLine()) != null) {
                if (temp.length() >= 1) {
                    x += temp + "\n";
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

        // finding the uniques but except more extreme style
        for (String i : text) {
            String[] group = i.split("\n");
            for (String j : pleaseDontLookAtThis) {
                boolean ans = true;
                for (String k : group) {
                    if (!k.contains(j)) {
                        ans = false;
                    }
                }
                if (ans) {
                    count++;
                    // System.out.println(j);
                }
            }
        }

        System.out.println(count);
    }
}
