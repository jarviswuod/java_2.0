package _04_DesignPatterns.Behavioral.State.good;

public class ModerationState implements State {

    private Document document;

    public ModerationState(Document document) {
        this.document = document;
    }

    @Override
    public void publish() {
        if (document.getCurrentUserRole() == UserRoles.Admin) {
            document.setState(new PublishedState(document));
        }
    }
}