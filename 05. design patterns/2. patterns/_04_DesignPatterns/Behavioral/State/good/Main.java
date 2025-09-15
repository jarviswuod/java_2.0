package _04_DesignPatterns.Behavioral.State.good;

public class Main {
    public static void main(String[] args) {

        // Document document = new Document(UserRoles.Admin);
        Document document = new Document(UserRoles.Editor);
        System.out.println(document.getState());

        document.publish();
        System.out.println(document.getState());

        document.publish();
        System.out.println(document.getState());

        document.setState(new DraftState(document));
        System.out.println(document.getState());

    }
}
