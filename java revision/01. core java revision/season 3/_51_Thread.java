/*
 class RandomClass extends Thread {
    public void run() {
        System.out.println("Hi");
    }
 }
 */

public class _51_Thread {

    public static void main(String[] args) {

        RandomClass rClass = new RandomClass();
        rClass.start();
    }

}

class RandomClass extends Thread {
    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println("Hi");
        }
    }
}