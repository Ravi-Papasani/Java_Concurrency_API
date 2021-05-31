package Futures_Callables_Fork_Join;

import java.util.concurrent.*;

public class Callable_Example {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing from Runnable");
            }
        };

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Printing from Callable");
                Thread.sleep(2000);
                return "Value from callable";
            }
        };

        //Executing the Callable using Executor
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(runnable); //execute method only take runnable object
        //executorService.submit(runnable);
        Future<String> result = executorService.submit(callable); //submit method accepts both runnable and callable objects
        String returnValue = result.get();

        System.out.println(returnValue);
    }
}
