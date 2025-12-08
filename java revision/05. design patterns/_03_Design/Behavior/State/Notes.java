/*

    NOTES:
    - State Pattern:

    - Is a behavioral pattern that allows an object to change it's behavior when it's internal implementation changes

    - 3 state Key players:
        - Context
        - State
        - Concrete state

    - Example:
        - Something that has a state that changes, a doc state with allowance to change based on editor
        - enum Document
        - enum Permission; Admin, Editor, User

 */

public class Notes {
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

interface State {

    void publish();
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

class DraftState implements State {

    private Document document;

    public DraftState(Document document) {
        this.document = document;
    }

    @Override
    public void publish() {
        document.setState(new ModerationState(document));
    }
}

class ModerationState implements State {

    private Document document;

    public ModerationState(Document document) {
        this.document = document;
    }

    @Override
    public void publish() {

        if (document.getCurrentUserRole() == UserRoles.Admin)
            document.setState(new PublishedState(document));
    }
}

class PublishedState implements State {

    private Document document;

    public PublishedState(Document document) {
        this.document = document;
    }

    @Override
    public void publish() {
        // Do nothing if already in published state
    }
}
