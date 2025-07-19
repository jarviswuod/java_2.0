/*
    NOTE:
      - Most of the time threads will be created automatically for us via framework 
      - We can explicitly want to create 2 or multiple threads depending on our application
      - Threads & mutation together is not a good idea
          - Threads --> t1, t2
          - Mutation --> int i = 5; i++; i = 6;
    
      - If you working with thread. Make sure you are working with;
          - 1. Variables which are not mmutable or
          - 2. Use Thread safe
    
      - thread-safe
          - This is a condition where only one thread can work with a variable at a particular one point
    

      - This methods are joning back to the main thread using .join() before taking the final reading
      - If .join() is not availed, the final reading greatly varies.

      - public synchronized
      -  The "synchronized" keyword helps call the method ones at a time preventing any multiple concurrent calls
      -  It ensures only one Thread is called at a time.

 */

public class _59_ThreadConditions {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Runnable objA = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Runnable objB = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(objA);
        Thread t2 = new Thread(objB);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.count);
    }
}

class Counter {
    int count;

    public synchronized void increment() {
        count++;
    }
}