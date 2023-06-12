import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PracticeSelf {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String filename = args[0];
        String removeString = args[1];
        FileInputStream fis = new FileInputStream(filename);
        StringBuilder sb = new StringBuilder();

        int line;
        while ((line = fis.read()) != -1) {
            sb.append(line);
            sb.append(System.lineSeparator());
        }
        String filecontent = sb.toString();
        filecontent = filecontent.replaceAll(removeString, "better");

        FileOutputStream fos = new FileOutputStream(filename, true);
        byte[] filecontentByte = filecontent.getBytes();
        fos.write(filecontentByte);
        fos.close();
        fis.close();
    }
}
