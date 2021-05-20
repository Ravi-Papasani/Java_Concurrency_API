package ProcessVSThreads;

public class ImplementingThreadSyntax implements Runnable{
    public static void main(String[] args) {

        //Syntax 1 using Thread class start method
        Runnable r = new ImplementingThreadSyntax();
        r.run();//fine, but does not start a separate call stack
        Thread t = new Thread(r);
        t.start();// a separate call stacks happens using thread class start method

        //Syntax 2 Using Runnable inner class
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                    System.out.println("My Runnable Method");
            }
        };

        //Syntax 3 Using Lambdas
        Runnable r2 = () -> System.out.println("My Runnable Method");

        //Syntax 4 Using Thread class constructor start method
        new Thread(()->System.out.println("My Runnable Method")).start();

    }

    @Override
    public void run() {
        System.out.println("My Runnable Method");
    }
}
