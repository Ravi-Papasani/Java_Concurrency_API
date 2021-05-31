package Futures_Callables_Fork_Join;

import ProcessVSThreads.UsingThreads.PrimeNumberUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class PrimeWithCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Your nth prime number value. Enter the n: ");
            int input_N = sc.nextInt();
            if (input_N == 0) break;

            /*CompletableFuture.supplyAsync(() -> "Hello")
                    .thenAccept((String str) -> System.out.println(str));*/

            //Approach 1
            /*CompletableFuture.supplyAsync(() -> PrimeNumberUtil.primeNumberValue(input_N))
                    .thenAccept((Integer returnPrimeValue) -> System.out.println(returnPrimeValue));*/

            //Approach 2
            /*CompletableFuture.supplyAsync(() -> PrimeNumberUtil.primeNumberValue(input_N))
                    .thenAccept(System.out::println);*/

            //Approach 3 using ThreadPool ExecutorService
            CompletableFuture.supplyAsync(() -> PrimeNumberUtil.primeNumberValue(input_N), executorService)
                     .thenAccept(System.out::println);

        }
    }
}
