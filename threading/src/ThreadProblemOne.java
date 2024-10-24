public class ThreadProblemOne {
    public static void main(String[] args) {
        /* Calling Start method to evoke the thread*/
//        Problem p1 = new Problem(1, "Thread-A");
//        Problem p2 = new Problem(6, "Thread-B");
//        p1.startMethod();
//        p2.startMethod();
        Thread t1 = new Thread(new Problem(1), "Thread-A");
        Thread t2 = new Thread(new Problem(6), "Thread-B");
        t1.start();
        t2.start();
    }
}

class Problem implements Runnable {
//    private Thread t;
    private int value;
//    private String name;

    Problem(int value) {
//        this.name = name;
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread: " + Thread.currentThread().getName() + " value is: " + (value++));
            try {
                // Sleep to simulate some delay
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* For initializing the thread instance within this class*/
//    public void startMethod() {
//        if (t == null) {
//            t = new Thread(this, name);
//            t.start();
//        }
//    }
}
