package Futures_Callables_Fork_Join;

public class Notes {
    public static void main(String[] args) {
        /*
        Semaphores:
        => "Permit-based" access
        => Used for managing limited resources in a concurrent environment
        => Limited no of threads at a time
        Locks vs Semaphores:
        => Locks: Only one thread at a time
        => Semaphores: Limited no of threads at a time
        => Locks enables synchronization, but semaphores are not


        Fork-Join:
        => Fork-Join is similar example to what a "map-reduce" does
        => Designed for work that can be broken into smaller pieces recursively
          Example: process all the elements in a list
          Pseudo Code:
             if(my portion of the work is small enough){
                  do that work directly
             }
             else(split my work into two pieces){
                  invoke the two pieces and wait for the results
             }
         ForkJoinPool:
           -> Special implementation of ExecutorService for this specific usecase
         ForkJoinTask:
           -> Special type of task designed to run in a ForkJoinPool
         Steps to implement:
           -> Create an implementation of ForkJoinTask
           -> Get an instance of the ForkJoinPool
           -> Submit an instance of the ForkJoinTask implementation to the ForkJoinPool
         Implementation usecase:
           -> RecursiveAction = doesn't return any value
           -> RecursiveTask = does returns a value
        * */
    }
}
