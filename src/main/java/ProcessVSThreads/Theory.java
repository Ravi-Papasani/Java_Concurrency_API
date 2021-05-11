package ProcessVSThreads;

public class Theory {
    public static void main(String[] args) {
        //Process
        /*
        => Binary instructions loaded into memory
        => Gets access to resources like memory
        => (Its own stack, heap, registers)
        => Resource is protected from other processes
        => Does its thing
        //Processes are independent
        => Can be started and stopped without affecting others
        => Cannot talk to each other (unless mechanisms are coded into them)
        * */

        //Thread
        /*
        => Unit of execution within a process
        => Does the work of a process
        => Usually has a shared objective
        => Has shared resources like memory, heap storage
        * */

        //Java Application
        /*
        => A single process (JVM)
        => Consists of various threads
        => Application thread - responsible for running the main method
        => GC thread - thread that runs garbage collector
        => similar like main, garbage collector many other threads run simultaneously.
        * */

        //Creating new threads
        /*
        => Using the Thread class
        * */

        //Runnable
        /*
        => Something that can be run
        => Has a run method
        //Steps
        => Identify the code you want to run in a separate thread
        => Put it into a Runnable
        => Create a new Thread from that Runnable
        => Start the thread
        //How this works
        => JVM calls the underlying OS threading APIs
        //When does a thread end?
        => when the run method returns
        => An exception is thrown
        * */

        //Summary
        /*
        => Runnable is a functional interface
        => Lambdas can be used instead of Runnable instances
        => Thread can be subclassed to create a Runnable
        => Recommended creating a new Runnable interface instead of subclassing Thread
        * */

        //When does the application end?
        /*
        => Usually, when the main method thread ends
        => when you spawn threads: when the last thread ends
        => i.e when all the user threads have exited
        //What if you don't want the application exit to wait for a thread?
        => Answer is Daemon threads
        * */

        //Two types of threads
        /*
        => 1) User threads
        => 2) Daemon threads
             Thread th = new Thread(r);
             th.setDaemon(true);
             th.start();
        //Examples of user threads
        => The main method
        => Your new Thread(runnable).start();
        * */

        //Thread life cycle - Thread status
        /*
        => Every thread goes through a life cycle - with stages
        //High level thread states
        => Just created
        => Running
        => Blocked
        => Terminated
        //Actual Thread states
        https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/Thread.State.html
        => New
        => Runnable
        => Blocked
        => Waiting
        => Timed Waiting
        => Terminated
        * */
    }
}
