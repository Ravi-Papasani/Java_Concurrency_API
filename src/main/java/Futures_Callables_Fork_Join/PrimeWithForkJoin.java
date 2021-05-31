package Futures_Callables_Fork_Join;

// Accept in input array of numbers
// Calculate the nth prime (where n is the value of i in that array arr[i])
// Add all the nth primes

import java.util.concurrent.ForkJoinPool;

public class PrimeWithForkJoin {

    public void runForkJoinExample() {

        int[] inputNumbers = {2, 3, 4, 5, 6, 7, 8, 9, 10};

        ForkJoinPool forkJoinFool = ForkJoinPool.commonPool();
        CalculatePrimeTaskUtil calculatePrimeTaskUtil = new CalculatePrimeTaskUtil(inputNumbers, 0, inputNumbers.length - 1);
        Integer result = forkJoinFool.invoke(calculatePrimeTaskUtil);
        System.out.println("The sum of the primes " + result);
    }

    public static void main(String[] args) {
        new PrimeWithForkJoin().runForkJoinExample();
    }
}
