package concurrency.thread_subclass;

public class Main {
    public static void main(String[] args) {
        Thread myThread = new MyThread();
        myThread.setName("new worker");
        myThread.start();
    }

    private static class MyThread extends Thread {
        public void run() {
            System.out.println("run in my thread: " + this.getName());
        }
    }
}
