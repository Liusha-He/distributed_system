package concurrency.critical_sections;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        InventoryCounter counter = new InventoryCounter();
        IncrementingThread thread1 = new IncrementingThread(counter);
        DecrementingThread thread2 = new DecrementingThread(counter);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("we currently have " + counter.getItems() + " items...");
    }

    public static class IncrementingThread extends Thread {
        private final InventoryCounter counter;

        public IncrementingThread(InventoryCounter counter) {
            this.counter = counter;
        }

        public void run() {
            for (int i=0; i<10_000; i++) {
                counter.increment();
            }
        }
    }

    public static class DecrementingThread extends Thread {
        private final InventoryCounter counter;

        public DecrementingThread(InventoryCounter counter) {
            this.counter = counter;
        }

        public void run() {
            for (int i=0; i<10_000; i++) {
                counter.decrement();
            }
        }
    }

    public static class InventoryCounter {
        private int items = 0;
        private final Object lock = new Object();

        public void increment() {
            synchronized (lock) {
                items++;
            }
        }

        public void decrement() {
            synchronized (lock) {
                items--;
            }
        }

        public int getItems() {
            synchronized (lock) {
                return items;
            }
        }
    }
}
