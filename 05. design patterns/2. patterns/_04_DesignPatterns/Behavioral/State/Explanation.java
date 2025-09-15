package _04_DesignPatterns.Behavioral.State;

/*

    NOTES:
    - SOLUTION 1: If else;
        - First we create an enum class called DocumentState
                public enum DocumentStates {

                    Draft, Moderation, Published;
                }

        - We also create an enum to store our UserRoles
                public enum UserRoles {

                    Reader, Editor, Admin;
                }

        - Then we create a Document class
            - In here we refer to current DocumentStates
            - Same case with current UserRole

                    public class Document {

                        private DocumentStates state;
                        private UserRoles currentUserRole;

                        ...
                    }

            - Then we create our publish() method
                - This method is responsible for updating or upgrading the state of the Document(DocumentState) to the next stage
                    - Here we need to check  the current UserROle as only admins are allowed to post/publish Documents

                    public class Document {

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

                        ...
                    }


            - Testing
                - Observation made; if you set the UserRoles to anything lower than 'Admin' you cannot proceed to "publish" the Document i.e upgrade the doc state to publish

                    public class Main {
                        public static void main(String[] args) {

                            Document document = new Document();

                            document.setState(DocumentStates.Moderation);
                            //   document.setCurrentUserRole(UserRoles.Admin);
                            document.setCurrentUserRole(UserRoles.Editor);

                            System.out.println(document.getState());

                            document.publish();
                            System.out.println(document.getState());
                        }
                    }


            - ISSUE:
                - This solution works great but we have an issue with the implementation

                    1. The publish() method has got lots of if-else conditions; This means we are violating the open-closed principle because if we add any other states we gonna have to modify lots of methods not only publish(). Example if we add another UserRole, we gonna have to bloat our methods even further

                    - With more states this Document class is gonna bloated, unwiedly and difficult to understand and the code witll be very difficult to maintan becasue any changes in logic may require changing states conditionals

            - SOLUTION:
                - We solve for this issue with introduction of State Pattern which suggests that we should create state classes for each possible state of the Document object, and extract all state-specific logic into these classes ( Draft, Moderation, Published)

                - The Document class will store a reference to one of the state classes to represent the current state that it is in then, instead of Document implementing state-specific behaviour by itself, it delegates all the state-related work to the state object that it has a reference to



    - SOLUTION 2: State Pattern;
        - State
            - First we create State interface which only has publish() method, if it was a real Document, we would love much more methods

                    public interface State {

                        void publish();
                    }


        - Document
            - Second thing is creating a Document; we give it a property of State for cupsturing current state of the document, then we also need the currentUserRole to

                    public class Document {

                        private State state;
                        private UserRoles currentUserRoles;

                        ...
                    }

            - We then create a constructor passing in UserRole and intilaizing the State to the first Document state we need *DraftState* instance passing in 'this' keyword. We also initialize **currentUserRole** too inside the constructor

                    public class Document {
                        public Document(UserRoles currentUserRoles) {

                            state = new DraftState(this);
                            this.currentUserRoles = currentUserRoles;
                        }
                        ...
                        ...
                    }

            - We create publish() method, where we call state.publish() delegating all the state specific work to these concrete State objects we are creating

                    public class Document {

                        public void publish() {
                            state.publish();
                        }
                        ...
                    }


        - DraftState:
            - We create a DraftState implementing State interface and all States need a reference to the Document object and a contructor

                    public class DraftState implements State {
                        private Document document;

                        public DraftState(Document document) {
                            this.document = document;
                        }
                    }

            - If we are in DraftState and the user clicks publish, at that point we should change the State of Document from DraftState to ModerationState; (so that the admin can review the document)
                NOTE:
                    - We need the 'document' passed becasue in each and every state we have the ability to change the State field within the documents

                    public class DraftState implements State {

                        @Override
                        public void publish() {
                            document.setState(new ModerationState(document));
                        }
                    }


        - ModerationState:
            - We create ModerationState class where we still need to store reference to the Document plus a constructor which sets Document
                - Over here within the publish() method we add our logic where we check the currentUserRole as only Admins are allowed to upgrade the state to "Published"

                    public class ModerationState implements State {

                        private Document document;

                        public ModerationState(Document document) {
                            this.document = document;
                        }

                        @Override
                        public void publish() {
                            if (document.getCurrentUserRoles() == UserRoles.Admin) {
                                document.setState(new PublishedState(document));
                            }
                        }
                    }


        - PublishState:
            - We create PublishState class and the same principe as DraftState and MederationState applies, the unique thing here is that, If we area already in the pushc state snd a under clicks 'publish' button we do nothing

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


        - UserRoles:
            - We create the UserRoles enum;
                    public enum UserRoles {

                        Reader, Editor, Admin;
                    }



        - Testing:

                public class Main {
                    public static void main(String[] args) {

                        Document document = new Document(UserRoles.Admin);
                        //   Document document = new Document(UserRoles.Editor);
                        System.out.println(document.getState()); // DraftState

                        document.publish();
                        System.out.println(document.getState()); // ModerationState

                        document.publish();
                        System.out.println(document.getState()); // PublishState
                    }
                }


            - It's also possible to change the document state directly to any state
                public class Main {
                    public static void main(String[] args) {

                        document.setState(new DraftState(document));
                        System.out.println(document.getState());
                    }
                }

        - Observation:
            - Now it we create a new Document state we dont have to modify the Document class as the publish() method (Inside Document class) delegates the work to a concrete class (Via help of State interface)

 */

public class Explanation {

}
