package garbagecollector;

import app.Counter;

public class Main {

    public static void main(String[] args) throws Exception {

        Counter c = new Counter();

        Worker t1 = new Worker(c);
        Worker t2 = new Worker(c);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count = " + c.count);

        // Remove the only reference from main
        c = null;

        System.out.println("Counter reference removed.");
    }
}
