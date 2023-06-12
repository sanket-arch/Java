import java.util.Random;

public class TaskThread {
    
    public static void main(String[] args) {
       
        PrintHelloWorld helloWorldTask = new PrintHelloWorld();
        PrintRandomNumbers randomNumbersTask = new PrintRandomNumbers();
     
        Thread helloWorldThread = new Thread(helloWorldTask);
        Thread randomNumbersThread = new Thread(randomNumbersTask);

        helloWorldThread.start();
        randomNumbersThread.start();
    }

    private static class PrintHelloWorld implements Runnable {
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("Hello World");
            }
        }
    }

    private static class PrintRandomNumbers implements Runnable {
        public void run() {
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                int randomNumber = random.nextInt(141) + 110;
                System.out.println(randomNumber);
            }
        }
    }
}
