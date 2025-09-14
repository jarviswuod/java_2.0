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
            - In here we store the current DocumentStates
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
                        ...
                    }

            - Testing the solution:
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
        - 


 */

public class Explanation {

}
