/*

    NOTES:
    - Threads share the same memory space, i.e. they can share reources(objects)
    - However, there are critical situation where it is desirable that only one thread at a time has access to a shared resource

    - Exception in thread "Pusher" java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 5
 */

public class _04_Synchronization {
    public static void main(String[] args) {

        System.out.println("Main is starting ...");

        Stack stack = new Stack(5);

        new Thread(() -> {
            int counter = 0;
            while (++counter < 10)
                System.out.println("Pushed " + stack.push(100));
        }, "Pusher").start();

        new Thread(() -> {
            int counter = 0;
            while (++counter < 10)
                System.out.println("Popped " + stack.pop());
        }, "Popper").start();

        System.out.println("Main is exiting ...");

    }
}

class Stack {
    private int[] array;
    private int stackTop;

    public Stack(int capacity) {
        array = new int[capacity];
        stackTop = -1;
    }

    public boolean isEmpty() {
        return stackTop < 0;
    }

    public boolean isFull() {
        return stackTop >= array.length - 1;
    }

    public synchronized boolean push(int element) {
        if (isFull())
            return false;
        ++stackTop;

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        array[stackTop] = element;
        return true;
    }

    public synchronized int pop() {
        if (isEmpty())
            return Integer.MAX_VALUE;

        int obj = array[stackTop];
        array[stackTop] = Integer.MIN_VALUE;

        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        stackTop--;
        return obj;
    }
}

class StackStaticMethods {
    private int[] array;
    private int stackTop;

    public StackStaticMethods(int capacity) {
        array = new int[capacity];
        stackTop = -1;
    }

    public boolean isEmpty() {
        return stackTop < 0;
    }

    public boolean isFull() {
        return stackTop >= array.length - 1;
    }

    // public static boolean push(int element) {
    public boolean push(int element) {
        synchronized (StackStaticMethods.class) {
            if (isFull())
                return false;
            ++stackTop;

            try {
                Thread.sleep(5000);
            } catch (Exception e) {
            }
            array[stackTop] = element;
            return true;
        }
    }

    // public static int pop() {
    public int pop() {
        synchronized (StackStaticMethods.class) {
            if (isEmpty())
                return Integer.MAX_VALUE;

            int obj = array[stackTop];
            array[stackTop] = Integer.MIN_VALUE;

            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            stackTop--;
            return obj;
        }
    }
}

class StackSyncMethod {
    private int[] array;
    private int stackTop;

    public StackSyncMethod(int capacity) {
        array = new int[capacity];
        stackTop = -1;
    }

    public boolean isEmpty() {
        return stackTop < 0;
    }

    public boolean isFull() {
        return stackTop >= array.length - 1;
    }

    public synchronized boolean push(int element) {
        if (isFull())
            return false;
        ++stackTop;

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        array[stackTop] = element;
        return true;
    }

    public synchronized int pop() {
        if (isEmpty())
            return Integer.MAX_VALUE;

        int obj = array[stackTop];
        array[stackTop] = Integer.MIN_VALUE;

        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        stackTop--;
        return obj;
    }

    public int popSameAss() {
        synchronized (this) {
            // Happens Internally when you use synchronized method
            if (isEmpty())
                return Integer.MAX_VALUE;

            int obj = array[stackTop];
            array[stackTop] = Integer.MIN_VALUE;

            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            stackTop--;
            return obj;
        }
    }
}

class StackMultiSyncBlock {
    private int[] array;
    private int stackTop;
    Object lock1, lock2;

    public StackMultiSyncBlock(int capacity) {
        array = new int[capacity];
        stackTop = -1;
        lock1 = new Object();
        lock2 = new Object();
    }

    public boolean isEmpty() {
        return stackTop < 0;
    }

    public boolean isFull() {
        return stackTop >= array.length - 1;
    }

    // t1, t2, t3
    public boolean push(int element) {
        synchronized (lock1) {
            if (isFull())
                return false;
            ++stackTop;

            try {
                Thread.sleep(5000);
            } catch (Exception e) {
            }
            array[stackTop] = element;
            return true;
        }
    }

    // t1, t4, t5
    public int pop() {
        synchronized (lock2) {
            if (isEmpty())
                return Integer.MAX_VALUE;

            int obj = array[stackTop];
            array[stackTop] = Integer.MIN_VALUE;

            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            stackTop--;
            return obj;
        }
    }
}

class StackSyncBlock {
    private int[] array;
    private int stackTop;
    Object lock;

    public StackSyncBlock(int capacity) {
        array = new int[capacity];
        stackTop = -1;
        lock = new Object();
    }

    public boolean isEmpty() {
        return stackTop < 0;
    }

    public boolean isFull() {
        return stackTop >= array.length - 1;
    }

    public boolean push(int element) {
        synchronized (lock) {
            if (isFull())
                return false;
            ++stackTop;

            try {
                Thread.sleep(5000);
            } catch (Exception e) {
            }
            array[stackTop] = element;
            return true;
        }
    }

    public int pop() {
        synchronized (lock) {
            if (isEmpty())
                return Integer.MAX_VALUE;

            int obj = array[stackTop];
            array[stackTop] = Integer.MIN_VALUE;

            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            stackTop--;
            return obj;
        }
    }

    public int popBlock() {
        synchronized (lock) { // int NOT USED
            // new Interger() or new String("ss") or new Object() YES
            if (isEmpty())
                return Integer.MAX_VALUE;

            int obj = array[stackTop];
            array[stackTop] = Integer.MIN_VALUE;

            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            stackTop--;
            return obj;
        }
    }
}

class StackNoSync {
    private int[] array;
    private int stackTop;

    public StackNoSync(int capacity) {
        array = new int[capacity];
        stackTop = -1;
    }

    public boolean isEmpty() {
        return stackTop < 0;
    }

    public boolean isFull() {
        return stackTop >= array.length - 1;
    }

    public boolean push(int element) {
        if (isFull())
            return false;
        ++stackTop;

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        array[stackTop] = element;
        return true;
    }

    public int pop() {
        if (isEmpty())
            return Integer.MAX_VALUE;

        int obj = array[stackTop];
        array[stackTop] = Integer.MIN_VALUE;

        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        stackTop--;
        return obj;
    }
}