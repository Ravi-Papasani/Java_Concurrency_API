package Locks_Executors;

import ProcessVSThreads.UsingThreads.PrimeNumberUtil;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WithThreadPoolExecutorAPI {
    public static void main(String[] args) {
        /*
        input n for newFixedThreadPool
        //ExecutorService executorService = Executors.newFixedThreadPool(3);
        20000
        20000
        20000
        5 //5 cannot be executed unless one of the above 3 completes its execution to pick(input n = 5)

        input n for newCachedThreadPool
        //ExecutorService es1 = Executors.newCachedThreadPool();
        20000
        20000
        20000
        5 //5 can be executed even one of the above 3 not  completes its execution.

        input n for newSingleThreadExecutor
        //ExecutorService es2 = Executors.newSingleThreadExecutor();
        20000
        5 //5 will wait in queue till the above single thread got complete its execution.
        * */

        ScheduledExecutorService scheduleExecutorService = Executors.newScheduledThreadPool(1);

        Runnable reporterRunnable = () -> {
            System.out.println("running report ");
        };

        scheduleExecutorService.scheduleAtFixedRate(reporterRunnable,1,5, TimeUnit.SECONDS);

        ExecutorService executorService = Executors.newFixedThreadPool(3);


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
            // replacement of the Thread creation
            executorService.execute(r);
            /*Thread th = new Thread(r);
            th.start();*/
        }
    }
}
