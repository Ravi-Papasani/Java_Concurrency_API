package Synchronization;

public class Counter implements Runnable {

    private int value = 0;

    public void increment() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value++;
    }

    public void decrement() {
        value--;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void run() {
        this.increment();
        System.out.println(Thread.currentThread().getName() + " increments: " + this.getValue());
        this.decrement();
        System.out.println(Thread.currentThread().getName() + " decrements: " + this.getValue());
    }
}

class ConcurrencyWithOutSynchronization {
    public static void main(String[] args) {
        Counter counter = new Counter();
        new Thread(counter, "ThreadOne").start();
        new Thread(counter, "ThreadTwo").start();
        new Thread(counter, "ThreadThree").start();
        new Thread(counter, "ThreadFour").start();
    }
}
