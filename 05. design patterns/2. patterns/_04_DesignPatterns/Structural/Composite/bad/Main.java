package _04_DesignPatterns.Structural.Composite.bad;

public class Main {
    public static void main(String[] args) {

        // The big package to deliver, containing box1 and box2
        Box packageBox = new Box();

        // box1 contains a microphone
        Box box1 = new Box();
        box1.add(new Microphone());

        // box2 contains box3 and box4
        Box box2 = new Box();

        // box3 contains a mouse
        Box box3 = new Box();
        box3.add(new Mouse());

        // box4 contains a keyboard
        Box box4 = new Box();
        box4.add(new Keyboard());

        box2.add(box3);
        box2.add(box4);

        packageBox.add(box1);
        packageBox.add(box2);

        System.out.println("Total price of package : " + packageBox.calculateTotalPrice());
    }
}