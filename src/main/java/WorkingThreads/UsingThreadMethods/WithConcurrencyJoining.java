package WorkingThreads.UsingThreadMethods;

import ProcessVSThreads.UsingThreads.PrimeNumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class WithConcurrencyJoining {
    /*
    n = 5, 10, 25, 500000, 0
    result: Threads status :
    * */
    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();

        Runnable statusReporter = () -> {
            try {
                while (true) {
                    // pause for 5 seconds
                    Thread.sleep(5000);
                    printThreads(threads);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Status report thread interrupted. Ending status updates..");
            }
        };

        Thread reportedThread = new Thread(statusReporter);
        reportedThread.setDaemon(true);
        reportedThread.start();

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Your nth prime number value. Enter the n: ");
            int input_N = sc.nextInt();
            if (input_N == 0) {
                reportedThread.interrupt();
                try{
                    System.out.println("Waiting for all threads to finish...");
                    waitForThreads(threads);
                    System.out.println("Done with the application. " + threads.size() + " primes calculated");
                }catch (InterruptedException e){
                    System.out.println("\n Got interrupted when waiting for threads. Quitting ..... ");
                }
                break;
            }
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    int number = PrimeNumberUtil.primeNumberValue(input_N);
                    System.out.println("Result : ");
                    System.out.println("Value of " + input_N +
                            "th prime number is : " + number);
                }
            };
            Thread th = new Thread(r);
            threads.add(th);
            th.start();
        }
    }

    private static void waitForThreads(List<Thread> threads) throws InterruptedException {
        for (Thread thread : threads){
           // if(!thread.getState().equals(Thread.State.TERMINATED)) {
                thread.join();
           // }
        }
    }

    private static void printThreads(List<Thread> threads) {
        System.out.println("Threads status : ");
        threads.forEach(thread -> {
            System.out.println(thread.getState() + " ");
        });
        System.out.println("  ");
    }
}
