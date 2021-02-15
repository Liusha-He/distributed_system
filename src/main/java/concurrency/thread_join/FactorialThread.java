package concurrency.thread_join;

import java.math.BigInteger;

public class FactorialThread extends Thread {
    private Long inputNumber;
    private BigInteger result = BigInteger.ZERO;
    private boolean isFinished = false;

    public FactorialThread(Long inputNumber) {
        this.inputNumber = inputNumber;
    }

    public BigInteger factorial(Long n) {
        BigInteger tempResult = BigInteger.ONE;

        for (Long i = n; i>0; i--) {
            tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
        }
        return tempResult;
    }

    public BigInteger getResult() {
        return result;
    }

    public void run() {
        this.result = factorial(inputNumber);
        this.isFinished = true;
    }

    public boolean isFinished() {
        return isFinished;
    }
}
