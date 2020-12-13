import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class D9P1 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Long> text = new ArrayList<>();

        try (Scanner input = new Scanner(new File("input.txt"))) {
            while (input.hasNextLine()) {
                text.add(input.nextLong());
            }
        }

        // System.out.println(text);

        // i should have learned from day 1 but uhh yeah
        for (int i = 25; i < text.size(); i++) {
            long current = text.get(i);
            boolean ok = false;
            for (int j = 0; j <= 25; j++) {
                for (int k = 0; k <= 25; k++) {
                    // System.out.println(j + " " + k);
                    if (j == k) {
                        continue;
                    }
                    if ((text.get(i - j) + text.get(i - k)) == current) {
                        ok = true;
                    }
                }
            }
            if (!ok) {
                System.out.println("NOT OK!!! NUMBER IS " + current);
                return;
            }
        }
    }
}
