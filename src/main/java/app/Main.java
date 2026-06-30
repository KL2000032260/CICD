package app;

public class Main {

    public static void main(String[] args) throws Exception {

        Counter c = new Counter();
        final Counter counter = c;   // Final reference for the threads

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count = " + counter.count);

        // Remove the original reference
        c = null;

        System.out.println("Counter object is now eligible for GC if no other references exist.");
    }
}