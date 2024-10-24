import java.util.Scanner;

public class Timer {
    public static void main(String[] args) {
        String opt;
        boolean running = false;
        Thread t = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Press space to start the timer and press any key to stop it");
        while (true) {
            opt = sc.nextLine();  // Reading the user input

            if (opt.equals(" ") && !running) { // If the user presses space

                t = new Thread(new StartTimer(), "Timer"); // Start the timer thread if not already running
                t.start();
                running = true;
                System.out.println("Timer started...");
            } else {
                if (running) { // Stop the timer when any other key is pressed

                    t.interrupt();  // Interrupt the timer thread
                    System.out.println("Timer stopped.");
                }
                System.out.println("Exiting....");
                break; //Exit the loop
            }
        }
    }
}

// Runnable class that contains the logic for counting time
class StartTimer implements Runnable {
    @Override
    public void run() {
        int i = 0;  // Counter to keep track of seconds
        // Loop until the thread is interrupted
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Count: " + i); // Print the current count
            i++; // Increment the counter
            try {
                Thread.sleep(1000);  // Sleep for 1 second to simulate a timer
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();  // Re-interrupt the thread if interrupted during sleep
            }
        }
    }
}
