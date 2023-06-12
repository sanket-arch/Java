import java.io.*;
import java.util.*;

public class LabCat {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string");
        String data = sc.nextLine();

        BufferedWriter bw = new BufferedWriter(new FileWriter("cat.txt"));
        bw.write(data);
        System.out.println("written successfully");

        BufferedReader br = new BufferedReader(new FileReader("cat.txt"));
        StringBuilder sb = new StringBuilder();
        // sb.append("sanket");
        // System.out.println(sb);
        String line;
        while ((line = br.readLine()) != null) {
            // sb.append(line);
            // sb.append(System.lineSeparator());
            System.out.println(line);
        }
        System.out.println(sb);
        bw.close();
        br.close();
        sc.close();
    }
}
