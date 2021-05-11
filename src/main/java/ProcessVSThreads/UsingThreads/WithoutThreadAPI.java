package ProcessVSThreads.UsingThreads;

import java.util.Scanner;

public class WithoutThreadAPI {
    /*
    Calculate the nth Prime Number
    -> Get user input for n
    -> Calculate the nth prime number
    -> Repeat
    -> Quit when the user input(n) is zero
    * */

    public static void main(String[] args) {
        int number;
        /*
        give input "n" as follows for observations
        => 10
        => 20
        => 500000
        => 5 //wont work since 500000 is still running
        * */
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Your nth prime number value. Enter the n: ");
            int input_N = sc.nextInt();
            if(input_N == 0) break;
            number = PrimeNumberUtil.primeNumberValue(input_N);
            System.out.println("Result : ");
            System.out.println("Value of " + input_N +
                    "th prime number is : " + number);
        }
    }
}
