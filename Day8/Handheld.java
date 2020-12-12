import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Handheld {
    public static void main(String[] args) {
        File file = new File("input.txt");
        ArrayList<String> text = new ArrayList<>();

        String temp, op;

        // read instructinos
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((temp = reader.readLine()) != null) {
                text.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // uhh part one yea
        System.out.println(evaluate(text));
        ArrayList<String> copyText = text;

        // aw crap
        int z = 0;
        System.out.println(text.size());
        for (int i = 0; i < text.size(); i++) {
            copyText = text;

            temp = text.get(i).substring(0, 3);
            op = text.get(i).substring(4);
            // System.out.println("\nz:" + z++);
            // System.out.println(temp);

            // System.out.println(temp);
            if (!temp.equals("acc")) {
                if (temp.equals("jmp"))
                    copyText.set(i, ("nop " + op));
                else if (temp.equals("nop"))
                    copyText.set(i, ("jmp " + op));

                // System.out.println(copyText.get(i));

                int res = evaluate(copyText);
                System.out.println(res);

            } else {
                System.out.println("nope");
            }
        }
    }

    public static int evaluate(ArrayList<String> code) {
        String instruction;
        String temp;
        boolean[] visitedMap = new boolean[code.size()];

        int acc = 0;
        int line = 0;
        int op;

        // try {
        while (true) {
            temp = code.get(line);
            instruction = temp.substring(0, 3);
            op = Integer.parseInt(temp.substring(4));

            if (line > 619) {
                System.out.println("exceedance");
                return acc;
            }

            if (visitedMap[line]) {
                return acc;
            }

            visitedMap[line] = true;

            if (instruction.equals("jmp")) {
                line += op;
            } else if (instruction.equals("acc")) {
                acc += op;
                line++;
            } else {
                line++;
            }
        }
        // } catch (Exception e) {
        // // e.printStackTrace();

        // return 10000 + acc;
        // }
    }
}
