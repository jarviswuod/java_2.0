package _04_DesignPatterns.Behavioral.State.bad;

public class Document {

    private DocumentState state;
    private UserRoles currentUserRole;

    public void publish() {
        if (state == DocumentState.Draft) {
            state = DocumentState.Moderation;

        } else if (state == DocumentState.Moderation) {

            if (currentUserRole == UserRoles.Admin) {
                state = DocumentState.Published;
            }

        } else if (state == DocumentState.Published) {
            // do nothing
        }
    }

    public DocumentState getState() {
        return state;
    }

    public void setState(DocumentState state) {
        this.state = state;
    }

    public UserRoles getCurrentUserRole() {
        return currentUserRole;
    }

    public void setCurrentUserRole(UserRoles currentUserRole) {
        this.currentUserRole = currentUserRole;
    }

}
