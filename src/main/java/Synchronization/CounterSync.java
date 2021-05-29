package Synchronization;

public class CounterSync implements Runnable {

    private int value = 0;
    private Integer i = 10;

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
        synchronized (this) {
        //synchronized (i) {
            this.increment();
            System.out.println(Thread.currentThread().getName() + " increments: " + this.getValue());
            this.decrement();
            System.out.println(Thread.currentThread().getName() + " decrements: " + this.getValue());
        }
    }
}

class ConcurrencyWithSynchronization {
    public static void main(String[] args) {
        CounterSync counter = new CounterSync();
        new Thread(counter, "ThreadOne").start();
        new Thread(counter, "ThreadTwo").start();
        new Thread(counter, "ThreadThree").start();
        new Thread(counter, "ThreadFour").start();

        //Another Problem statement
        /*CounterSync counter1 = new CounterSync();
        new Thread(counter1, "2nd_ThreadOne").start();*/
    }
}

