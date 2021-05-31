package Futures_Callables_Fork_Join;

import ProcessVSThreads.UsingThreads.PrimeNumberUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class PrimeWithCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Future<Integer>> futures = new ArrayList<>();

        ExecutorService executorService = Executors.newCachedThreadPool();

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Your nth prime number value. Enter the n: ");
            int input_N = sc.nextInt();
            if (input_N == 0) break;

            Callable<Integer> callable = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    //System.out.println("Inside Callable Method");
                    return PrimeNumberUtil.primeNumberValue(input_N);
                }
            };

            Future<Integer> primeNumberFuture = executorService.submit(callable);
            futures.add(primeNumberFuture);

            Iterator<Future<Integer>> iterator = futures.iterator();
            while (iterator.hasNext()) {
                Future<Integer> f = iterator.next();
                if (f.isDone()) {
                    System.out.println(f.get());
                    iterator.remove();
                }
            }
        }
    }
}
