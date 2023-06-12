import java.io.*;

public class Practice {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java Exercise12_11 <string> <filename>");
            System.exit(1);
        }

        String stringToRemove = args[0];
        String filename = args[1];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }

            String fileContent = sb.toString();
            fileContent = fileContent.replaceAll(stringToRemove, "");

            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(fileContent);
            writer.close();
            reader.close();
            System.out.println("The string \"" + stringToRemove + "\" was removed from the file \"" + filename + "\".");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
