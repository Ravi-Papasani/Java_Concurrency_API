package Locks_Executors;

public class Notes {
    public static void main(String[] args) {
        /*
         Synchronized Keyword:
         -> Structured locks
         -> Acquire and release handled for you
         -> Nesting possible

         Unstructured locks:
         -> Helps you Acquire and realise the lock by your own using Lock Interface

         => Lock Interface
         //https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/concurrent/locks/Lock.html

         => The Executor service
         -> Manages runnables or "tasks" for you
         -> Provides extra abilities (like thread pool)
         -> Enables results
         -> High level API for executing tasks
         -> Motivation of using Executor service is Thread creation is resource intensive
         -> Solution is to reuse the threads

         => Types of Executors
            -> FixedThreadPool(3); //decide upfront on how many threads required
            -> SingleThreadExecutor // only one thread
            -> CachedThreadPool Executor // no need to decide upfront on how many threads required
            -> ScheduledThreadPool Executor // run a thread after certain time and repeat the same for every 10 seconds
            -> WorkStealingPool Executor



        * */
    }
}
