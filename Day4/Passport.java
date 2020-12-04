import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Passport {
    public static void main(String[] args) {
        File file = new File("input.txt");
        ArrayList<String> text = new ArrayList<>();

        String temp, x = "";
        String[] passValues = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
        int validCount = 0;

        // read the file, seperating by newlines
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((temp = reader.readLine()) != null) {
                if (temp.length() > 1) {
                    x += temp;
                } else {
                    text.add(x);
                    x = "";
                }
            }
            text.add(x);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // iterate through all values
        for (String i : text) {
            boolean tempFlag = true;

            // checking for the required keys
            for (String j : passValues) {
                if (!i.contains(j)) {
                    tempFlag = false;
                    break;
                }
            }

            validCount += tempFlag ? 1 : 0;
        }   

        System.out.println(validCount);

    }
}