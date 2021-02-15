package concurrency.thread_interruption;

public class Main {
    public static void main(String[] args) {
        Thread block = new Thread(new BlockingTask());
        block.start();
        block.interrupt();
    }
}
