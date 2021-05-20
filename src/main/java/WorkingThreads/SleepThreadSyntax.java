package WorkingThreads;

public class SleepThreadSyntax {
    public static void main(String[] args) {
        //Sleep Syntax Using Lambdas
        Runnable r = () -> {
            System.out.println("My Runnable Method");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
