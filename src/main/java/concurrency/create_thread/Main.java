package concurrency.create_thread;

public class Main {
    public static void main(String[] args) {
//        Thread thread = new Thread(new Runnable() {
//            @Override public void run() {
//                System.out.println("calling from thread " +
//                        Thread.currentThread().getName());
//            }
//        }
//        );
//
//        thread.setName("New Worker");
//
//        System.out.println("We are calling thread: " +
//                Thread.currentThread().getName() +
//                " before starting a thread...");
//        thread.start();
//        System.out.println("We are calling thread: " +
//                Thread.currentThread().getName() +
//                " after starting a thread...");

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm going for a walk");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm going to swim");
            }
        });

        thread1.start();
        thread2.start();
        System.out.println("I'm going home");

    }
}
