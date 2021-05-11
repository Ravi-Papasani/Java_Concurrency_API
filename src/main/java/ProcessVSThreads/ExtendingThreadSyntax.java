package ProcessVSThreads;

public class ExtendingThreadSyntax extends Thread {
    public static void main(String[] args) {
        new ExtendingThreadSyntax().start();
    }

    public void run() {
        System.out.println("My Runnable Method");
    }
}
