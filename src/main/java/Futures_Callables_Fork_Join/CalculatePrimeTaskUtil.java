package Futures_Callables_Fork_Join;

import ProcessVSThreads.UsingThreads.PrimeNumberUtil;

import java.util.concurrent.RecursiveTask;

public class CalculatePrimeTaskUtil extends RecursiveTask<Integer> {
    int[] array;
    int start;
    int end;

    public CalculatePrimeTaskUtil() {
    }

    public CalculatePrimeTaskUtil(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (start == end) {
            System.out.println(array[start] + ":" + PrimeNumberUtil.primeNumberValue(array[start]));
            return PrimeNumberUtil.primeNumberValue(array[start]);
        }
        if (end - start == 1) {
            System.out.println(array[start] + ":" + PrimeNumberUtil.primeNumberValue(array[start]));
            System.out.println(array[end] + ":" + PrimeNumberUtil.primeNumberValue(array[end]));
            return PrimeNumberUtil.primeNumberValue(array[start]) + PrimeNumberUtil.primeNumberValue(array[end]);
        }
        int mid = (start + end) / 2;
        CalculatePrimeTaskUtil subTask1 = new CalculatePrimeTaskUtil(array, start, mid);
        CalculatePrimeTaskUtil subTask2 = new CalculatePrimeTaskUtil(array, mid + 1, end);
        invokeAll(subTask1,subTask2);
        return subTask1.join() + subTask2.join();
    }
}
