package ProcessVSThreads.UsingThreads;

import java.util.Scanner;

public class WithThreadAPI {
    public static void main(String[] args) {
        /*
        give input "n" as follows for observations
        => 10
        => 20
        => 500000
        => 5 //will work even 500000 is still running
        => 15
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
            th.start();
        }
    }
}
