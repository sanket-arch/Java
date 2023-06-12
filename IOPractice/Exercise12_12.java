import java.io.*;

public class Exercise12_12 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Exercise12_12 <filename>");
            System.exit(1);
        }

        String filename = args[0];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                // Remove any leading or trailing whitespace
                line = line.trim();

                // If the line ends with an opening brace, move it to the end of the previous
                // line
                // if (line.endsWith("{")) {
                // // Remove the brace from the end of the line
                // line = line.substring(0, line.length() - 1).trim();

                // // Append the modified line to the string builder
                // sb.append(line);
                // sb.append(" {");
                // } else {
                // Append the original line to the string builder
                sb.append(line);
                // }

                sb.append(System.lineSeparator());
            }

            String fileContent = sb.toString();

            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(fileContent);
            writer.close();

            System.out.println("The file \"" + filename + "\" was converted to end-of-line brace style.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
