/*

    NOTES:
    - Is a behavioral design pattern that allows to change behavior based on change on it's internal state
    - Key players:
        - Context
        - State interface
        - Concrete state

    - Example:
        - Document Editor and enum user class

*/

public class _02_State {
    public static void main(String[] args) {

        _02_Document document = new _02_Document(_02_Users.Admin);
        document.publish();
        document.publish();
        document.publish();
    }
}

enum _02_Users {

    Admin, Editor, Basic;
}

class _02_Document {

    private _02_States_ states_;
    private _02_Users user;

    public _02_Document(_02_Users user) {
        states_ = new _02_DraftState(this);
        this.user = user;
    }

    public _02_States_ getStates_() {
        return states_;
    }

    public void setStates_(_02_States_ states_) {
        this.states_ = states_;
    }

    public void publish() {
        states_.publish();
    }

    public _02_Users getUser() {
        return user;
    }

    public void setUser(_02_Users user) {
        this.user = user;
    }
}

interface _02_States_ {

    void publish();
}

class _02_DraftState implements _02_States_ {

    private _02_Document document;

    public _02_DraftState(_02_Document document) {
        this.document = document;
    }

    @Override
    public void publish() {
        System.out.println("Document in Draft state");
        document.setStates_(new _02_ReviewState(document));
    }
}

class _02_ReviewState implements _02_States_ {

    private _02_Document document;

    public _02_ReviewState(_02_Document document) {
        this.document = document;
    }

    @Override
    public void publish() {
        System.out.println("Document in REVIEW");

        if (document.getUser() != _02_Users.Admin) {
            System.out.println("Only admin can publish documents");
            return;
        }
        document.setStates_(new _02_PublishedState(document));
    }
}

class _02_PublishedState implements _02_States_ {

    private _02_Document document;

    public _02_PublishedState(_02_Document document) {
        this.document = document;
    }

    @Override
    public void publish() {
        System.out.println("Already published!!!");
    }
}
