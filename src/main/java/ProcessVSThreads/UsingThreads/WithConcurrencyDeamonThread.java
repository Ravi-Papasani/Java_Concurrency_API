package ProcessVSThreads.UsingThreads;

import java.util.Scanner;

public class WithConcurrencyDeamonThread {
    public static void main(String[] args) {
        /*
        give input "n" as follows for observations
        => 10
        => 500000
        => 0 // process exit here when 500000 still running behind
        * */
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
            Thread th = new Thread(r);
            th.setDaemon(true);
            th.start();
        }
    }
}
