package _04_DesignPatterns.Behavioral.State.good;

public class PublishedState implements State {

    private Document document;

    public PublishedState(Document document) {
        this.document = document;
    }

    @Override
    public void publish() {
        // Do nothing if already in published state
    }
}
