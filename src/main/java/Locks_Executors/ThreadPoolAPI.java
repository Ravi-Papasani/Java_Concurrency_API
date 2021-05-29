package Locks_Executors;

import ProcessVSThreads.UsingThreads.PrimeNumberUtil;

import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadPoolAPI {
    public static void main(String[] args) {

        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        ScheduledExecutorService scheduleExecutorService = Executors.newScheduledThreadPool(1);
        Runnable reporterRunnable = () -> {
            System.out.println("running report ");
            System.out.println("Active Threads " + executorService.getActiveCount());
            System.out.println("Completed Threads " + executorService.getCompletedTaskCount());
        };

        scheduleExecutorService.scheduleAtFixedRate(reporterRunnable,1,5, TimeUnit.SECONDS);

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Your nth prime number value. Enter the n: ");
            int input_N = sc.nextInt();
            if (input_N == 0) break;
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    int number = PrimeNumberUtil.primeNumberValue(input_N);
                    System.out.println("Result : ");
                    System.out.println("Value of " + input_N +
                            "th prime number is : " + number);
                }
            };
            executorService.execute(r);
        }
    }
}
