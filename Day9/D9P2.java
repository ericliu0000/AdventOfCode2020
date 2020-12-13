import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class D9P2 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Long> text = new ArrayList<>();
        long answer = 217430975;
        long finalAns = 0;

        try (Scanner input = new Scanner(new File("input.txt"))) {
            while (input.hasNextLine()) {
                text.add(input.nextLong());
            }
        }

        for (int i = 0; i < text.size(); i++) {
            long sum = 0;

            for (int j = i; j < text.size(); j++) {
                sum += text.get(j);

                if (sum == answer) {
                    long max = 0;
                    // can't believe i spent 30 minutes not noticing this
                    long min = 999999999;

                    for (int k = i; k <= j; k++) {
                        long temp = text.get(k);

                        if (temp > max) {
                            max = temp;
                        }
                        if (temp < min) {
                            min = temp;
                        }
                    }
                    System.out.println(min + max);
                    return;
                }
                if (sum > answer) {
                    break;
                }
            }
        }
    }
}
