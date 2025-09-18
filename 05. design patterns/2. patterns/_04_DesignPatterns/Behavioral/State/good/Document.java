package _04_DesignPatterns.Behavioral.State.good;

public class Document {

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
