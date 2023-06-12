class Data {
    private int data; // this can be an array when the buffer size > 1
    private boolean found = false; // no item found in the buffer

    synchronized int consume() { // executed by the consumer thread
        while (!found) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        } // while
        System.out.println("Got: " + data);
        found = false;
        notify();
        return data;
    }

    synchronized void produce(int m /* item to be produced */) {
        // executed by the producer thread
        while (found) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        } // while
        data = m;
        found = true;
        System.out.println("Put: " + data);
        notify();
    }// drop
}

class Producer implements Runnable {
    private Data d;

    Producer(Data d) {
        this.d = d;
    }

    public void run() {
        while (true) {
            int m = 10;
            d.produce(m);
        }
    }
}// Producer

class Consumer implements Runnable {
    private Data dd;

    Consumer(Data dd) {
        this.dd = dd;
    }

    public void run() {
        while (true)
            dd.consume();
    }
}// Consumer

public class PC {
    public static void main(String[] args) {
        Data dt = new Data();
        new Thread(new Producer(dt)).start();
        new Thread(new Consumer(dt)).start();
    }
}
