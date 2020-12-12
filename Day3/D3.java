import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class D3 {
    public static void main(String[] args) {
        File file = new File("input.txt");
        ArrayList<String> text = new ArrayList<>();
        String temp;

        // read the file things but safely
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((temp = reader.readLine()) != null) {
                text.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // part 1
        System.out.println(findTrees(text, 3, 1));

        // part 2
        int p2sum = 1;
        p2sum *= findTrees(text, 1, 1);
        p2sum *= findTrees(text, 3, 1);
        p2sum *= findTrees(text, 5, 1);
        p2sum *= findTrees(text, 7, 1);
        p2sum *= findTrees(text, 1, 2);
        System.out.println(p2sum);
    }

    // method for finding tree crashes
    public static int findTrees(ArrayList<String> text, int hOff, int Voff) {
        int count = 0;

        // iterate through and find trees w/offset
        for (int i = 0; i < text.size(); i += Voff) {
            char[] x = text.get(i).toCharArray();
            // aw darn i should have probably done this another way but i can't be bothered to fix it
            if (x[((i / Voff) * hOff) % 31] == '#') count++;
        }

        return count;
    }
}