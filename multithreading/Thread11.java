//Thread A
class A extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            if(i==3) Thread.yield();
            System.out.println("Thread A" + i);
        }
        System.out.println("Exit from A");
    }
}

// Thread B
class B extends Thread {
    public void run() {
        // Thread t = Thread.currentThread();
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread B" + i);

        }
        getThreadName();
        System.out.println("Exit from B");
    }

    public void getThreadName() {
        System.out.println("I am ");
        System.out.println(Thread.currentThread().getName());
    }
}

// Thread C
class C extends Thread {

    public void run() {
        Thread t = Thread.currentThread();
        t.setName("Thread C");
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread C" + i);
            System.out.println(t.getName());
            // try {
            // Thread.sleep(1000);
            // } catch (InterruptedException e) {
            // System.out.println("thread got interrupted");
            // }
        }
        System.out.println("Exit from C");
    }
}

public class Thread11 extends Thread {
    public static void main(String[] args) {
        // cretatin thread object
        A t1 = new A();
        B t2 = new B();
        C t3 = new C();
        
        //setting priority
        t1.setPriority(MIN_PRIORITY);
        t2.setPriority(t2.getPriority()+1);
        t3.setPriority(MAX_PRIORITY);


        // running the thread
        t1.start(); // it automatically calls the run method
        t2.start();
        t3.start();

    }
}
