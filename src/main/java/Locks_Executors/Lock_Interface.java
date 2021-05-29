package Locks_Executors;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Lock_Interface implements Runnable {

    private int value = 0;
    private Lock l = new ReentrantLock();
    //https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/concurrent/locks/Lock.html


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

        while (true) {
            //Acquire a lock
            if (l.tryLock()) {
                try {
                    this.increment();
                    System.out.println(Thread.currentThread().getName() + " increments: " + this.getValue());
                    this.decrement();
                    System.out.println(Thread.currentThread().getName() + " decrements: " + this.getValue());
                } finally {
                    //Release a lock
                    l.unlock();
                }
            } else {
                //do something else
            }
        }
    }
}

class F_Synchronization {
    public static void main(String[] args) {
        Lock_Counter counter = new Lock_Counter();
        new Thread(counter, "ThreadOne").start();
        new Thread(counter, "ThreadTwo").start();
        new Thread(counter, "ThreadThree").start();
        new Thread(counter, "ThreadFour").start();
    }
}

