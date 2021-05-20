package WorkingThreads;

import java.util.List;

public class JoinThreads {
    public static void main(String[] args) {
        /*
        myThread.start();
        //...
        myThread.join();
        // this executes after myThread has ended
        * */

    }
    private static void waitForThreads(List<Thread> threads) throws InterruptedException {
        for (Thread th : threads){
            th.join();
        }
    }
}
