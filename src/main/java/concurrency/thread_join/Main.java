package concurrency.thread_join;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNums = Arrays.asList(100_000_000L, 0L, 3435L, 35435L, 2324L, 4656L,
                23L, 2435L, 5566L);

        List<FactorialThread> threads = new ArrayList<>();

        for (Long i : inputNums) {
            threads.add(new FactorialThread(i));
        }

        for (Thread t : threads) {
            t.setDaemon(true);
            t.start();
        }

        for (Thread t : threads) {
            t.join(2_000);
        }

        for (int i=0; i<inputNums.size(); i++) {
            FactorialThread t = threads.get(i);
            if (t.isFinished()) {
                System.out.println("The number is: " + inputNums.get(i) + " - the factorial is: " + t.getResult());
            }
            else {
                System.out.println("Result of " + inputNums.get(i) + " is still in progress...");
            }
        }
    }
}
