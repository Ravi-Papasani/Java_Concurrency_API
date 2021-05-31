package Futures_Callables_Fork_Join;

import ProcessVSThreads.UsingThreads.PrimeNumberUtil;

import java.util.Scanner;
import java.util.concurrent.*;

public class PrimeWithSemaphores {

    public static void main(String[] args)  {

        Semaphore semaphore = new Semaphore(3); // n = 100000,200000,300000,(8,9) not sure 8 or 9, which will execute first after first three
        Semaphore semaphore1 = new Semaphore(3, true); // n = 100000,200000,300000,(8,9) then for sure 8 will execute before 9, once first three executed

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Your nth prime number value. Enter the n: ");
            int input_N = sc.nextInt();
            if (input_N == 0) break;

            Runnable r = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("Now calculating for the " + input_N);
                        int number = PrimeNumberUtil.primeNumberValue(input_N);
                        System.out.println("Result : ");
                        System.out.println("Value of " + input_N +
                                "th prime number is : " + number);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("Interrupted while acquiring");
                    }finally {
                        semaphore.release();
                    }

                }
            };
            Thread th = new Thread(r);
            th.start();
        }

    }
}
