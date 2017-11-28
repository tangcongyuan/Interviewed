import java.io.*;
import java.util.*;

/**
 * Created by eric on 11/19/17.
 */
public class Main {
    public static void main(String[] args) {
        String filepath = "numbers.txt";
        sortFileInPlace(filepath);
    }

    private static void sortFileInPlace(String filepath) {
        FileInputStream fis = null;
        ArrayList<Long> array = new ArrayList<Long>();
        try {
            fis = new FileInputStream(filepath);
            Scanner sc = new Scanner(fis);
            while(sc.hasNextLine()) {
                String s = sc.nextLine().trim();
                if (!s.equals("")) {
                    // System.out.println(s);
                    array.add(Long.parseLong(s));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        Collections.sort(array);

        FileWriter fw = null;
        try {
            fw = new FileWriter(filepath + ".out.txt");
            for(Long l : array) {
                fw.write(l.toString() + "\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        for(Long l : array) {
            System.out.println(l);
        }
    }
}