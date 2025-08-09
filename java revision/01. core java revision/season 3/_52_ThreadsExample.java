public class _52_ThreadsExample {

    public static void main(String[] args) {

        RandomClass rClass = new RandomClass();
        AnotherRandomClass arClass = new AnotherRandomClass();
        rClass.start();
        arClass.start();
    }

}

class RandomClass extends Thread {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hi");
        }
    }
}

class AnotherRandomClass extends Thread {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello");
        }
    }
}
