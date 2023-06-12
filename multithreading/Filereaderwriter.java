import java.io.*;

class WriterReader {
    int writecount = 0;

    public synchronized void increment() throws FileNotFoundException, IOException {
        String s = "Hello my name is sanket";
        BufferedWriter writer = new BufferedWriter(new FileWriter("code.txt", true));
        writer.write(s);
        writer.close();

    }

    public void display() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("code.txt"));
        String line;
        StringBuilder s = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            s.append(line);
            s.append(System.lineSeparator());
        }
        System.out.println(s);
        System.out.println("succesfuuly done");
        reader.close();
    }
}

class Reader extends Thread {
    WriterReader wr;

    Reader(WriterReader wr) {
        this.wr = wr;
    }

    public void run() {
        try {
            wr.display();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}

class Writer extends Thread {
    WriterReader wr;

    Writer(WriterReader wr) {
        this.wr = wr;
    }

    public void run() {
        try {
            wr.increment();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}

public class Filereaderwriter extends Thread {

    public static void main(String[] args) {
        WriterReader wr = new WriterReader();
        Writer w1 = new Writer(wr);
        Writer w2 = new Writer(wr);
        Writer w3 = new Writer(wr);

        Reader r1 = new Reader(wr);

        w1.start();
        w2.start();
        w3.start();

        try {
            w1.join();
            w2.join();
            w3.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        r1.start();

    }
}