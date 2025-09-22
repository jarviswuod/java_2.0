package _04_DesignPatterns.Structural.Composite.bad;

public class Main {
    public static void main(String[] args) {

        Box packageBox = new Box();

        Box box1 = new Box();
        box1.add(new Microphone());

        Box box2 = new Box();

        Box box3 = new Box();
        box3.add(new Mouse());

        Box box4 = new Box();
        box4.add(new Keyboard());

        box2.add(box3);
        box2.add(box4);

        packageBox.add(box1);
        packageBox.add(box2);

        System.out.println("Total price of package : " + packageBox.calculateTotalPrice());
    }
}
