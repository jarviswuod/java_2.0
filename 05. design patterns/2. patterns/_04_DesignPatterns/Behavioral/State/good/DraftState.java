package _04_DesignPatterns.Behavioral.State.good;

public class DraftState implements State {

    private Document document;

    public DraftState(Document document) {
        this.document = document;
    }

    @Override
    public void publish() {
        document.setState(new ModerationState(document));
    }
}
