package _04_DesignPatterns.Behavioral.State;

/*

    NOTES:
    - SOLUTION 1: Conditional If else;
        - First we create an enum class called DocumentState
                public enum DocumentStates {

                    Draft, Moderation, Published;
                }

        - We also create an enum to store our UserRoles
                public enum UserRoles {

                    Reader, Editor, Admin;
                }

        - Then we create a Document class
            - In here we store reference to current DocumentStates
            - Same case with current UserRole

                    public class Document {

                        private DocumentStates state;
                        private UserRoles currentUserRole;

                        ...
                    }

            - Then we create our publish() method
                - This method is responsible for updating or upgrading the state of the Document(DocumentState) to the next stage
                    - Here we need to check  the current UserRole as only admins are allowed to post/publish Documents

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

                    - With more states this Document class becomes bloated, unwiedly and difficult to understand to maintan becasue any changes in logic may require changing states conditionals

            - SOLUTION:
                - We solve for this issue with State Pattern which suggests that we should create state classes for each possible state of the Document object, and have all state-specific logic into these classes (Draft, Moderation, Published)

                - The Document class will store a reference to one of the state classes to represent the current Document state. Instead of Document implementing all state-specific behaviour by itself, it delegates all the state-related work to the state object that it has a reference to



    - SOLUTION 2: STATE PATTERN;
        - State class: State
            - First we create State interface which only has publish() method
                - NOTE:
                    - If it was a real Document, we would have much more methods

                        public interface State {

                            void publish();
                        }


        - Document class: Context
            - Second thing is creating a Document; we give it a property of State for capturing current state of the document, then we also need the currentUserRole

                    public class Document {

                        private State state;
                        private UserRoles currentUserRole;

                        ...
                    }

            - We then create a constructor passing in UserRole and initializing the State to the first Document state we need *DraftState* instance passing in 'this' keyword. We also initialize *currentUserRole* too

                    public class Document {
                        public Document(UserRoles currentUserRole) {

                            state = new DraftState(this);
                            this.currentUserRole = currentUserRole;
                        }

                        ...
                    }

            - We create publish() method, where we call state.publish() delegating all the state specific work to these concrete State objects we are creating

                    public class Document {
                        public void publish() {
                            state.publish();
                        }

                        ...
                    }


        - DraftState class: ConcreteStates
            - We create a DraftState implementing State interface. All States need a reference to the Document object and a contructor

                    public class DraftState implements State {
                        private Document document;

                        public DraftState(Document document) {
                            this.document = document;
                        }
                    }

            - If we are in DraftState and the user clicks publish(), at that point we should change the State of Document from DraftState to ModerationState
                NOTE:
                    - We need the 'document' passed because in each and every state we have the ability to change the State field within the documents

                    public class DraftState implements State {

                        @Override
                        public void publish() {
                            document.setState(new ModerationState(document));
                        }
                    }


        - ModerationState class: ConcreteStates
            - We create ModerationState class where we still need to store reference to the Document plus a constructor which sets Document
                - At this document state level within the publish() method we add a logic where we check the currentUserRole as only Admins are allowed to upgrade the document's state to "published"

                    public class ModerationState implements State {

                        private Document document;

                        public ModerationState(Document document) {
                            this.document = document;
                        }

                        @Override
                        public void publish() {
                            if (document.getCurrentUserRole() == UserRoles.Admin) {
                                document.setState(new PublishedState(document));
                            }
                        }
                    }


        - PublishState class: ConcreteStates
            - We create PublishState class and the same principe in DraftState and ModerationState applies, the only unique thing is we are already in the document 'publish' state hence we do nothing under 'publish' button clicks

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


        - UserRoles: enum
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

                        document.setState(new DraftState(document));
                        System.out.println(document.getState()); // DraftState
                    }
                }


            - NOTE:
                - It's also possible to change the document state directly to any state
                    public class Main {
                        public static void main(String[] args) {

                            document.setState(new DraftState(document));
                            System.out.println(document.getState());
                        }
                    }

        - Observation:
            - Now it we create a new Document state we don't have to modify the Document class as the publish() method (Inside Document class) delegates the work to a concrete class (Via help of State interface)

 */

public class Explanation {

}
