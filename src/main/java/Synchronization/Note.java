package Synchronization;

public class Note {
    public static void main(String[] args) {
        /*
        Synchronization : Make sure two threads don't simultaneously access a critical data element.
        => controlling data, not code

        Synchronized block:
        //some code
        synchronized (objectReference){
        //code to be executed one thread at a time
        }
        => Thread tries to get access to the monitor lock
        => if thread gets it, it executes the block
        => releases the monitor lock when exiting the block
        => Any other thread needs to wait (can't get the monitor lock)

        Synchronized Method:
        => Lock is associated with the object whose method is being called
        What Synchronization achieves
        => Mutual exclusion(mutex)
        => Visibility
           -> Value is read from memory before block execution
           -> Value is written to memory after execution completes
        => Structured Lock
           -> Block structure using Synchronized
           -> Acquiring and releasing locks are implicit
           -> Example: Exception causing control to exit: lock auto-released
        => How to handle concurrency issues
           -> Don't have shared state
           -> Share only immutable values
           -> use Synchronization
        => which we called Thread Safe!

        => Liveness
           -> State of general activity and motion
           -> Requires a system to make progress
           -> Not "stuck"
           -> Something good will eventually occur
        => Program Execution
           -> Starts
           -> Executes
           -> Completes successfully or errors out
           -> Hangs (Liveness issue)
         => What can cause liveness issues?
           -> The infinite loop
         => Liveness issues with Concurrency caused by
           -> Deadlock
              -> Multiple threads are waiting for other threads
              -> The dependency is circular
                 Example: The "No, you hang up first" problem
           -> Livelock
              -> A smarter deadlock
           -> Starvation
              -> Thread is ready to run but is never given a chance
         => How to avoid Liveness issue?
            -> No Java/JVM feature to avoid these
            -> Careful use of locks
            -> Example: Avoid using more than one lock

         => The volatile keyword(solution to visibility problem)
            -> Marks a variable as don not cache
            -> Every read from a thread is directly from the main memory
            -> Every write from a thread is made directly to the main memory
            public class Test{
              private volatile int value;
            }
            Behaviour - has given order and guarantee
            -> Thread 1 writes variable (to memory)
            -> Thread 2 reads variable (from memory)

          => Understanding thread local
            -> Generic class
            -> Almost like a wrapper
            -> Each thread sets and gets a different value
           -> Declaring thread local
              ThreadLocal<Integer> threadLocalUserId = new ThreadLocal<>();\
           -> Accessing ThreadLocal
              threadLocalUserId.set(1234);
              Integer userId = threadLocalUserId.get();

        * */
    }
}
