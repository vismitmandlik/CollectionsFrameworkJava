import java.util.Scanner;
import java.util.TimerTask;
import java.util.Timer;

public class StopThreadOnEvent implements Runnable {

    private volatile boolean running = true;
    private final long startTime;
    private final long duration;

    public StopThreadOnEvent(long duration) {
        this.startTime = System.currentTimeMillis();
        this.duration = duration;
    }

    public void run(){
        while (running) {
            System.out.println("Thread started...");
            try {
                while (running && (System.currentTimeMillis() - startTime) < duration) {
                    System.out.println(Thread.currentThread().getName() + " is running.");
                    Thread.sleep(500); 
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
            }
        }

        System.out.println(Thread.currentThread().getName() + " has stopped.");
        System.exit(0);
    }

    public void stop() {
        running = false; 
        System.out.println("Thread stopping manually...");

    }


    @SuppressWarnings("resource")
    public static void main(String args[]){
        StopThreadOnEvent s = new StopThreadOnEvent(5000);

        Thread t = new Thread(s);
        t.start();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                s.stop(); // Request to stop the thread
                System.out.println("Thread stopping after timeout...");
            }
        }, 5000);

        System.out.println("Type 0 to stop the thread : ");
        Scanner sc = new Scanner(System.in);
        Thread userInputThread = new Thread(() -> {
            int input = sc.nextInt();
            if (input == 0) {
                s.stop(); 
                System.out.println("Thread stopping manually...");
            }
        });

        userInputThread.start();
        try {
            t.join(); // Wait for the worker thread to finish
            userInputThread.join(); // Ensure the user input thread finishes
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted while waiting for the worker thread to finish.");
        }
        

        
        System.out.println("Main executed...");
        System.exit(0);
    }
}