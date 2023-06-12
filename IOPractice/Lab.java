import java.io.*;

class Lab {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        FileOutputStream fos = new FileOutputStream(args[1]);
        int data;
        while ((data = fis.read()) != -1) {
            fos.write(data);
        }
        InputStreamReader ir=new InputStreamReader(System.in);
        ir.read();
        

        // String name = "sanket";
        // byte[] n = name.getBytes();
        // fos.write(n);
        // System.out.println("written succesfully");
        fis.close();
        fos.close();
    }
}