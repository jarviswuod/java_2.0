package _04_DesignPatterns.Behavioral.State.bad;

public class Document {

    private DocumentStates state;
    private UserRoles currentUserRole;

    public void publish() {
        if (state == DocumentStates.Draft) {
            state = DocumentStates.Moderation;

        } else if (state == DocumentStates.Moderation) {

            if (currentUserRole == UserRoles.Admin) {
                state = DocumentStates.Published;
            }

        } else if (state == DocumentStates.Published) {
            // do nothing
        }
    }

    public DocumentStates getState() {
        return state;
    }

    public void setState(DocumentStates state) {
        this.state = state;
    }

    public UserRoles getCurrentUserRole() {
        return currentUserRole;
    }

    public void setCurrentUserRole(UserRoles currentUserRole) {
        this.currentUserRole = currentUserRole;
    }

}
