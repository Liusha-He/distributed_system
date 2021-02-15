package concurrency.thread_interruption;

public class BlockingTask implements Runnable {
    @Override public void run() {
        try {
            Thread.sleep(10_000);
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}
