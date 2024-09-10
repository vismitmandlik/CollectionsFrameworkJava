public class YieldExample {
    public static void main(String[] args) {
       Thread producer = new Producer();
       Thread consumer = new Consumer();
       Thread worker = new Worker();
 
       // All threads have the same priority
       producer.setPriority(Thread.NORM_PRIORITY);
       consumer.setPriority(Thread.NORM_PRIORITY);
       worker.setPriority(Thread.NORM_PRIORITY);
 
       producer.start();
       consumer.start();
       worker.start();
    }
 }
 
 class Producer extends Thread {
    public void run() {
       for (int i = 0; i < 10; i++) {
          System.out.println("I am Producer : Produced Item " + i);
        //   Thread.yield(); // Giving a hint to the scheduler
          try {
             Thread.sleep(10); // Added delay
          } catch (InterruptedException e) {
             e.printStackTrace();
          }
       }
    }
 }
 
 class Consumer extends Thread {
    public void run() {
       for (int i = 0; i < 10; i++) {
          System.out.println("I am Consumer : Consumed Item " + i);
        //   Thread.yield(); // Giving a hint to the scheduler
          try {
             Thread.sleep(10); // Added delay
          } catch (InterruptedException e) {
             e.printStackTrace();
          }
       }
    }
 }
 
 class Worker extends Thread {
    public void run() {
       for (int i = 0; i < 10; i++) {
          System.out.println("I am Worker : Working on Task " + i);
        //   Thread.yield(); // Giving a hint to the scheduler
          try {
             Thread.sleep(10); // Added delay
          } catch (InterruptedException e) {
             e.printStackTrace();
          }
       }
    }
 }
 