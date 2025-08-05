public class _51_Threads {

    public static void main(String[] args) {

        RandomClass random = new RandomClass();
        random.start();
    }
}

class RandomClass extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello");
        }
    }
}