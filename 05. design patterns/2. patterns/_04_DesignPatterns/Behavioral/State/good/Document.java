package _04_DesignPatterns.Behavioral.State.good;

public class Document {

    private State state;
    private UserRoles currentUserRoles;

    public Document(UserRoles currentUserRoles) {
        state = new DraftState(this);
        this.currentUserRoles = currentUserRoles;
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

    public UserRoles getCurrentUserRoles() {
        return currentUserRoles;
    }

    public void setCurrentUserRoles(UserRoles currentUserRoles) {
        this.currentUserRoles = currentUserRoles;
    }

}
