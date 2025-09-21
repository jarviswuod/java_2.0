package _04_DesignPatterns.Behavioral.Mediator;

/*

    - CODE EXPLANATION:

    - CHALLENGE:
        - Let's say we have a blog that lists all of your posts, and you can select a post and then edit that post's title
        - When an article is selected form the list box, the text should be populated and the button enabled. When we clear the text box, the button should become disabled


    - SOLUTION 1;
        - abstract DialogueBox class:
            - This class plays the role of a mediator, so everytime a UI component changed state, it will call it's group DialogueBox
            - The reason why we made this an abstract class and not an interface is in a real world GUI framework we would provide some concrete methods as well as abstract method
            - We provide a public abstract method called change() which takes a UIControl component

                    public abstract class DialogBox {

                        public abstract void changed(UIControl UIControl);
                    }


        - abstract UIControl class:
            - This ensures that each UI component gets put into a DialogueBox, a DialogueBox is a group of UI components
            - We store a reference to DialogueBox,
                - Every component can be grouped into a DialogueBox and and talk to there owner, this allows the owner to change all the UI components accordingly
                - So all UIControl components need a single dialoguebox or mediator owner

            - We also need a constructor where we can pass in the owner to the UIControl to specify which class should be the owner

                    public class UIControl {

                        protected DialogBox owner;

                        public UIControl(DialogBox owner) {
                            this.owner = owner;
                        }
                    }


        - Concrete UIControl class:
            - ListBox class:
                - We are passing a DialogueBox or mediator owner to the list box instructor and setting the owner the super UIcontrol class
                    public class ListBox extends UIControl {

                        public ListBox(DialogBox owner) {
                            super(owner);
                        }

                        ...
                    }


                - In a listBox we need to be able to select a post hence we store a string reference called 'selection'
                    - We will also create setter and getter method too. Under setter method we need to notify the owner that this class has changed(just to let other components know i.e textBox and Button)

                        public class ListBox extends UIControl {

                            private String selection = "";

                            public ListBox(DialogBox owner) {
                                super(owner);
                            }

                            public String getSelection() {
                                return selection;
                            }

                            public void setSelection(String selection) {
                                this.selection = selection;

                                owner.changed(this);
                            }
                        }


            - TextBox class:
                - It has a simple text field String with setter and getter for it
                - Same concept applies as the ListBox under setter method, we need to notify the owner of the change

                    public class TextBox extends UIControl {

                        private String text = "";

                        public TextBox(DialogBox owner) {
                            super(owner);
                        }

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;

                            owner.changed(this);
                        }
                    }


            - Button class:
                - It just needs to store a boolean field to state weather the button is disabled or enabled, we also need it's setter and getter methods

                    public class Button extends UIControl {

                        private boolean isEnabled;

                        public Button(DialogBox owner) {
                            super(owner);
                        }

                        public boolean isEnabled() {
                            return isEnabled;
                        }

                        public void setEnabled(boolean isEnabled) {
                            this.isEnabled = isEnabled;

                            owner.changed(this);
                        }
                    }


            - PostDialogueBox class
                - We create this class that contains all the UI components for our post editing title application and we will update these components depending on which change() method was called
                - The class extends the dialogBox
                - We need all fields for all UI components - ListBox, TextBox, Button
    
                        public class PostDialogBox extends DialogBox {

                            private ListBox postListBox;
                            private TextBox titleTextBox;
                            private Button saveButton;

                            ...
                        }


                - We will initialize them inside a constructor rather than passing them and them we set the button to enabled

                        public class PostDialogBox extends DialogBox {

                            public PostDialogBox() {
                                postListBox = new ListBox(this);
                                titleTextBox = new TextBox(this);
                                saveButton = new Button(this);

                                saveButton.setEnabled(false);
                            }

                            ...
                        }


                - Next is adding logic inside a change
                    - Over here we need to check what the UIControl is then set appropriately the affected component

                        public class PostDialogBox extends DialogBox {

                            @Override
                            public void changed(UIControl uiControl) {
                                if (uiControl == postListBox) {
                                    handlePostChange();
                                } else if (uiControl == titleTextBox) {
                                    handleTitleChange();
                                }
                            }

                            private void handleTitleChange() {
                                boolean isTitleEmpty = titleTextBox.getText() != "";
                                saveButton.setEnabled(isTitleEmpty);
                            }

                            private void handlePostChange() {
                                titleTextBox.setText(postListBox.getSelection());
                                saveButton.setEnabled(true);
                            }

                            ...
                        }


                - We create simulateUserInteration() method inside our PostDialogBox do simulate a user interaction with our solution

                        public class PostDialogBox extends DialogBox {

                            public void simulateUserInteration() {
                                postListBox.setSelection("Post 2");
                                // titleTextBox.setText("");
                                System.out.println("Title text box: " + titleTextBox.getText());
                                System.out.println("Button enabled : " + saveButton.isEnabled());
                            }

                            ...
                        }


            - Main class: Client class;
                - We create a postDialgueBox and then populate a user interaction by calling the simulateUserInteration() method
                        public class Main {
                            public static void main(String[] args) {

                                PostDialogBox postDialogBox = new PostDialogBox();
                                postDialogBox.simulateUserInteration();
                            }
                        }

                - We also test a condition where the user enters no title;
                    - Under the simulateUserInteration() we already made a selection
                    - We set the title to an empty string, essentially the user has selected the "post 2" and apparently selected the title under title box
                            public class PostDialogBox extends DialogBox {

                                public void simulateUserInteration() {
                                    postListBox.setSelection("Post 2");
                                    // titleTextBox.setText("");
                                    System.out.println("Title text box: " + titleTextBox.getText());
                                    System.out.println("Button enabled : " + saveButton.isEnabled());

                                    ...
                                }
                            }



    - MEDIATOR PATTERN WITH OBSERVER PATTERN
        - UIFramework directory:
            - EventHandler interface:
                - This is a fucntional interface

                        @FunctionalInterface
                        public interface EventHandler {
                            void handle();
                        }


            - UIControl class:
                - This is the subject class form the Observer pattern and it basically manages our event handlers i.e, it's gonna keep a list of callback methods for updating the other UIComponents when a user interacts with them

                        public class UIControl {

                            private List<EventHandler> eventHandlers = new ArrayList<>();

                            ...
                        }


                - We also need a method for adding EventHandlers to the list
                - We also need a method for notifying the EventHandlers

                        public class UIControl {

                            private List<EventHandler> eventHandlers = new ArrayList<>();

                            public void addEventHandler(EventHandler eventHandler) {
                                eventHandlers.add(eventHandler);
                            }

                            public void notifyEventHandlers() {
                                for (EventHandler handler : eventHandlers)
                                    handler.handle();
                            }
                        }


                - In summary, each UIComponent is gonna extend the UIControl class meaning we can add certain event handlers to each UIControl component


            - Concrete UI COmponents:
                - ListBox class:
                    - We copy paste the code we had before. It has a String field 'selection', a getter method and a setter method, whenever we set the selection we are notifing the event handler method which we get from the UIControl

                        public class ListBox extends UIControl {

                            private String selection = "";

                            public String getSelection() {
                                return selection;
                            }

                            public void setSelection(String selection) {
                                this.selection = selection;

                                notifyEventHandlers();
                            }
                        }


                - TextBox class:
                    - Same code as the one we had before hand hence we just copy paste


                - Button class:
                    - Same experience as what we had before with only a bit of change

                    - BEFORE::
                            public class ListBox extends UIControl {

                                private String selection = "";

                                public ListBox(DialogBox owner) {
                                    super(owner);
                                }

                                public String getSelection() {
                                    return selection;
                                }

                                public void setSelection(String selection) {
                                    this.selection = selection;

                                    owner.changed(this);
                                }
                            }
 
                    - AFTER::
                            public class ListBox extends UIControl {

                                private String selection = "";

                                public String getSelection() {
                                    return selection;
                                }

                                public void setSelection(String selection) {
                                    this.selection = selection;

                                    notifyEventHandlers();
                                }
                            }


                - This is all the code we need for the UIFramework directory. It's basically code that we downloaded or installed and we don't have access to
                - Next is creating out custom code to consume the UIFramework



        - PostDialogBox class:
            - PostDialogBox is both a mediator containing all the business logic of how a UIComponent should interact with each other as well as being an observer, which is receives notice whenever a UI component changes. So it's now a mediator and an observer
            - First is to declear fields for the UI components and then create a constructor to intialize the fields

                    public class PostsDialogBox {

                        private ListBox postListBox;
                        private TextBox titleTextBox;
                        private Button saveButton;

                        public PostsDialogBox() {
                            postListBox = new ListBox();
                            titleTextBox = new TextBox();
                            saveButton = new Button();
                        }
                    }


            - Then what we need to do is to add our event handler methods to each UIComponent
                    public class PostsDialogBox {

                        public PostsDialogBox() {
                            postListBox.addEventHandler(this::postSelected);
                            titleTextBox.addEventHandler(this::titleChange);

                            ...
                        }

                        private void postSelected() {
                            titleTextBox.setText(postListBox.getSelection());
                        }

                        private void titleChange() {
                            saveButton.setEnabled(!titleTextBox.getText().isEmpty());
                        }

                        ...
                    }


            - We need to create simulateUserInteration() method
                - We are simulating selecting a post from the post list and then we log to check weather the button and little textbox have been updated correctly

                    public class PostsDialogBox {

                        public void simulateUserInteration() {
                            postListBox.setSelection("Post 2");
                            titleTextBox.setText("");

                            System.out.println("Title text box: " + titleTextBox.getText());
                            System.out.println("Button enabled : " + saveButton.isEnabled());
                        }

                        ...
                    }



        - Main class : Client class
            - We create a PostDialogBox then call simulateUserInteration() method
            - It all works perfectly

 */

public class Explanation {

}
