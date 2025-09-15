package _04_DesignPatterns.Behavioral.State.bad;

public class Main {
    public static void main(String[] args) {

        Document document = new Document();

        document.setState(DocumentStates.Moderation);
        // document.setCurrentUserRole(UserRoles.Admin);
        document.setCurrentUserRole(UserRoles.Editor);

        System.out.println(document.getState());

        document.publish();
        System.out.println(document.getState());
    }
}
