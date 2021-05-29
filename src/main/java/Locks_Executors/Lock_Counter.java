package Locks_Executors;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock_Counter implements Runnable {

    private int value = 0;
    private Lock l = new ReentrantLock();

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
            //Acquire a lock
            l.lock();
        try{
            this.increment();
            System.out.println(Thread.currentThread().getName() + " increments: " + this.getValue());
            this.decrement();
            System.out.println(Thread.currentThread().getName() + " decrements: " + this.getValue());
        }
        finally {
            //Release a lock
            l.unlock();
        }
    }
}

class ConcurrencyWithSynchronization {
    public static void main(String[] args) {
        Lock_Counter counter = new Lock_Counter();
        new Thread(counter, "ThreadOne").start();
        new Thread(counter, "ThreadTwo").start();
        new Thread(counter, "ThreadThree").start();
        new Thread(counter, "ThreadFour").start();
    }
}

