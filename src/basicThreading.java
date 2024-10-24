/*
We can use both the Runnable(interface) and Thread(class) for creating thread
-> In Runnable we have to create the instance for the Class Thread separately to start the execution by calling
obj.start() which indirectly calls the run() where the execution code is present

-> In Thread class, we can create the instance for subclass which extends the Thread class for the
execution purposes

Runnable defines the task whereas the Thread executed it
* */







class RunnableDemo extends Thread {
    final private String threadName;

    RunnableDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() { // To run the execution part
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }


}

public class basicThreading {

    public static void main(String[] args) {
        RunnableDemo R1 = new RunnableDemo( "Thread-1");
        R1.start(); // To evoke the run() for Thread-1
        /* For Runnable interface
        Thread t1 = new Thread(R1);
        t1.start ();

        **instead we can initialize a single obj for the class and define it in the
        function implements Runnable**

        */

        RunnableDemo R2 = new RunnableDemo( "Thread-2");
        R2.start(); // To evoke the run() for Thread-2
        /* For Runnable interface
        Thread t2 = new Thread(R2);
        t2.start ();
        */
    }
}