package ProcessVSThreads.UsingThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreadStates {
    /*
    n = 5, 10, 25, 500000, 19
    result: Threads status :
TERMINATED
TERMINATED
TERMINATED
RUNNABLE
TERMINATED
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
            if (input_N == 0)
                //reportedThread.interrupt();
                break;
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

    private static void printThreads(List<Thread> threads) {
        System.out.println("Threads status : ");
        threads.forEach(thread -> {
            System.out.println(thread.getState() + " ");
        });
        System.out.println("  ");
    }
}
