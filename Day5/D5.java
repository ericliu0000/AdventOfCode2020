import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class D5 {
    public static void main(String[] args) {
        File file = new File("input.txt");
        ArrayList<String> text = new ArrayList<>();
        String temp;
        int max = 0;

        // part two stuff, comically oversized
        ArrayList<Integer> idList = new ArrayList<>();
        boolean[] valueMap = new boolean[900];

        // read the file things
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((temp = reader.readLine()) != null) {
                text.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String i : text) {
            String row = "";
            for (char j : i.substring(0, 7).toCharArray()) {
                row += (j == 'B') ? '1' : '0';
            }

            String col = "";
            for (char j : i.substring(7).toCharArray()) {
                col += (j == 'R') ? '1' : '0';
            }

            int rowNum = Integer.parseInt(row, 2);
            int colNum = Integer.parseInt(col, 2);

            int id = rowNum * 8 + colNum;

            if ((id) > max) { 
                max = id;
            }

            // used in part 2
            idList.add(id);
        }

        // part 1 result
        System.out.println(max);

        // part 2: add all existing values to a bool array
        for (int i : idList) {
            valueMap[i] = true;
        }

        // filter to catch all the stuff from me oversizing the array by like 80
        int last = 0;
        for (int i = 0; i < valueMap.length; i++) {
            if (!valueMap[i]) {
                // ignore the last input it's 12am and i can't be bothered
                if ((i - last) > 1) System.out.println(i);
                last = i;
            }
        }
    }
}
