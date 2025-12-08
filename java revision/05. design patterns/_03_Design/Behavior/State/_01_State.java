/*

    NOTES:
    - State is a behavioral pattern that changes an object's behavior based on changes on internal state
    - Key players:
         - Context
         - State interface
         - Concrete State

    - Example:
        - Document Editor based on a logged in user


            public class _01_State {
                public static void main(String[] args) {

                    _Document document = new _Document();
                    document.setRoles(_Roles.Admin);

                    document.publish();
                    document.publish();
                    document.publish();

                    System.out.println();

                    document.setDocumentState(new _EditState(document));
                    document.publish();
                }
            }

            enum _Roles {

                Admin, Editor, Viewer;
            }

            class _Document {

                private _DocumentState documentState;
                private _Roles roles;

                public _Document() {
                    this.documentState = new _EditState(this);
                }

                public _DocumentState getDocumentState() {
                    return documentState;
                }

                public void setDocumentState(_DocumentState documentState) {
                    this.documentState = documentState;
                }

                public _Roles getRoles() {
                    return roles;
                }

                public void setRoles(_Roles roles) {
                    this.roles = roles;
                }

                public void publish() {
                    documentState.publish();
                }
            }

            abstract class _DocumentState {

                protected _Document document;

                public _DocumentState(_Document document) {
                    this.document = document;
                }

                public abstract void publish();
            }

            class _EditState extends _DocumentState {

                public _EditState(_Document document) {
                    super(document);
                }

                @Override
                public void publish() {
                    System.out.println("In Edit state");
                    document.setDocumentState(new _ReviewState(document));
                }
            }

            class _ReviewState extends _DocumentState {

                public _ReviewState(_Document document) {
                    super(document);
                }

                @Override
                public void publish() {
                    if (document.getRoles() == _Roles.Admin) {
                        System.out.println("In review state");
                        document.setDocumentState(new _PostState(document));
                    }
                }
            }

            class _PostState extends _DocumentState {

                public _PostState(_Document document) {
                    super(document);
                }

                @Override
                public void publish() {
                    System.out.println("In post state");
                    System.out.println("Do nothing");
                }
            }

*/

import java.util.Objects;

public class _01_State {
    public static void main(String[] args) {

        _Document document = new _Document(_Roles.Admin);

        document.publish();
        document.publish();
        document.publish();

        System.out.println();

        document.setState(new _DraftState(document));
        document.publish();
    }
}

enum _Roles {

    Admin, Editor, Viewer;
}

class _Document {

    private _State state;
    private _Roles roles;

    public _Document(_Roles roles) {
        this.state = new _DraftState(this);
        this.roles = roles;
    }

    public _State getState() {
        return state;
    }

    public void setState(_State state) {
        this.state = state;
    }

    public _Roles getRoles() {
        return roles;
    }

    public void setRoles(_Roles roles) {
        this.roles = roles;
    }

    public void publish() {
        state.publish();
    }
}

interface _State {

    void publish();
}

class _DraftState implements _State {
    protected _Document document;

    public _DraftState(_Document document) {
        this.document = document;
    }

    @Override
    public void publish() {
        System.out.println("In Edit state");
        document.setState(new _ModerationState(document));
    }
}

class _ModerationState implements _State {
    private final _Document document;

    public _ModerationState(_Document document) {
        this.document = Objects.requireNonNull(document);
    }

    @Override
    public void publish() {
        if (document.getRoles() != _Roles.Admin)
            throw new IllegalStateException("Only Admins can moderate");

        System.out.println("In review state");
        document.setState(new _PublishedState(document));
    }
}

class _PublishedState implements _State {

    protected _Document document;

    public _PublishedState(_Document document) {
        this.document = document;
    }

    @Override
    public void publish() {
        System.out.println("In post state");
        System.out.println("Do nothing");

        // throw new IllegalStateException("Document is already published");
    }
}
