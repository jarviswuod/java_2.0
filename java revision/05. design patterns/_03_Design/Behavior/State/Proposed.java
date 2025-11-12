import java.util.Objects;

public class Proposed {
    public static void main(String[] args) {

        Document document = new Document(UserRoles.Admin);
        // Document document = new Document(UserRoles.Editor);
        System.out.println(document.getState()); // DraftState

        document.publish();
        System.out.println(document.getState()); // ModerationState

        document.publish();
        System.out.println(document.getState()); // PublishState

        document.setState(new DraftState(document));
        System.out.println(document.getState()); // DraftState

        // document.setState(new DraftState(document));
        // System.out.println(document.getState());
    }
}

enum UserRoles {

    Reader, Editor, Admin;
}

abstract class State {

    protected final Document document;

    protected State(Document document) {
        this.document = Objects.requireNonNull(document, "Document cannot be null");
    }

    public abstract void publish();
}

class Document {

    private State state;
    private UserRoles currentUserRole;

    public Document(UserRoles currentUserRole) {
        state = new DraftState(this);
        this.currentUserRole = currentUserRole;
    }

    public void publish() {
        state.publish();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public UserRoles getCurrentUserRole() {
        return currentUserRole;
    }

    public void setCurrentUserRole(UserRoles currentUserRole) {
        this.currentUserRole = currentUserRole;
    }
}

class DraftState extends State {

    public DraftState(Document document) {
        super(document);
    }

    @Override
    public void publish() {
        document.setState(new ModerationState(document));
    }
}

class ModerationState extends State {

    public ModerationState(Document document) {
        super(document);
    }

    @Override
    public void publish() {
        if (document.getCurrentUserRole() == UserRoles.Admin) {
            document.setState(new PublishedState(document));
        }
    }
}

class PublishedState extends State {

    public PublishedState(Document document) {
        super(document);
    }

    @Override
    public void publish() {
        // Do nothing if already in published state
    }
}
