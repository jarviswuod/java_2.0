public class _53_Runnable {

    public static void main(String[] args) {

        Runnable rClass = new RandomClass();
        Runnable arClass = new AnotherRandomClass();

        Thread t1 = new Thread(rClass);
        Thread t2 = new Thread(arClass);

        t1.start();
        t2.start();
    }

}

class RandomClass implements Runnable {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hi");
        }
    }
}

class AnotherRandomClass implements Runnable {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello");
        }
    }
}
