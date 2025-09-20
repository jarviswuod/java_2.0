package _04_DesignPatterns.Behavioral.Mediator;

/*

    NOTES:
    - Trying to solve for a problem


    - SOLUTION 1;
        - abstract DialogueBox class:
            - This class plays the role of a mediator, so everytime a UI componenet changed state, it will call it's group DialogueBox
            - The reason why we made this an abstract class and not an interface is in a readl world GUI framework we would provide some concrete methods as weel as abstrct method
            - We provide a public abstract method called change() which takes a UIControl compomenet

                    public abstract class DialogBox {

                        public abstract void changed(UIControl UIControl);
                    }

        - abstract UICOntrol class:
            - This ensures that each UI component gets put into a dialogue box, a dialogue box is a group of UI componenets
            - we store a reference to DialogueBox,
                - Every compomenet can be grouped into a dialogue box and know and talk to there owner, this allows the owner to change all the UI componenets accordingly
                - SO all UIControl componenets need a single dialoguebox or mediator owner

            - We also need a contrctor where we can pass in the owner to the UICOntrol to speicy which class should be the owner

                    public class UIControl {

                        protected DialogBox owner;

                        public UIControl(DialogBox owner) {
                            this.owner = owner;
                        }
                    }


        - Concrete UIControl class
            - ListBox:
                - We are passin in a dialogue box or mediator owner to the list box instructor and setting the owner the super UIcontrol class
                    public class ListBox extends UIControl {

                        public ListBox(DialogBox owner) {
                            super(owner);
                        }

                        ...
                    }

                - In a listBox we need to be able to select a post hence we store a string reference called 'selection'
                    - We will also create settera and getters method for it too, under setter method we need to notify the owner that this class has changed(just to let other componenets know) textBox and Button

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
                - it has a simple text field String with setters and getters for it
                - same concept applies as the ListBox under setter method, we need to notify the owner of the change

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
                - it just need to store a boolean field to state weather the button is disabled or enabled, we also need it's settera and getters

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
                - We create this class that contains all the UI componenets for our post editing title application and we will update these compomenets depending on which change() method was called]
                - The class extends the dialogBox
                - We need all fields for all UI components, - [ListBox, TextBox, Button]
    
                        public class PostDialogBox extends DialogBox {

                            private ListBox postListBox;
                            private TextBox titleTextBox;
                            private Button saveButton;

                            ...
                        }

                - We will intialize them inside a constructor rather than passing them and then we set the button to enabled

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
                    - Over here we need to check what the UIControl is then set appropriately the affected componenet

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

                - We create simulateUserInteration() method inside our PostDialogBox do simulate a user interaction with our splution

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
                - we create a postDialgueBox and then solulate a uder interaction by calling the sisimulateUserInteration() method
                        public class Main {
                            public static void main(String[] args) {

                                PostDialogBox postDialogBox = new PostDialogBox();
                                postDialogBox.simulateUserInteration();
                            }
                        }

                - We also test a condition where the user enters no title;
                    - Under the simulateUserInteration() we already made a selection
                    - we set the title to an empty string, essentially the user has selected the "post 2" and apparently delected the title under title box
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
                - this is a fucntional interface
                        @FunctionalInterface
                        public interface EventHandler {
                            void handle();
                        }

            - UIControl class:
                - THis is the subject class form the Observer pattern  and it bacially manages our event handlers i.e, it's gonna keep a list of callback emthods for updating the other UICompoenets when a user interacts with them

                        public class UIControl {

                            private List<EventHandler> eventHandlers = new ArrayList<>();

                            ...
                        }

                    - We also need a method for adding event handlers to the list
                    - We also need a method for notifying the event handlers
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


                    - IN summary , each UI compomenet is gonna extend the UICOntrol class meaning we can add certail event handlers to each UIControl component and whaenever. Example;


            - Concrete UI COmponents:
                - ListBox class:
                    - We copy paste teh code we had before. It had a String field 'selection' a getter method and a setter method that made, whenever we set the selction we are notifing the event handler method which we get from the  UICOntrol

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
                    - Same code as teh one we had before hand hence we just copy paste

                - Button class:
                    - same excperience as what we had before with only the bit of

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

            - THis is all the code we need for the UIFramework directory. it's all basically code that we downloaded or installed and we dont have access to
            - Next is creating out custom code to consume the UIFramework

        - PostDIalogueBox class:
            - PostDialogBox is both a mediator containing all the business logic of how a UIComponenet should interact with each other as well as being an observer, which is receivs notice whenever a UI componenet changes. SO it's now a mediator and an observer
            - FIrst is to declear fields for the UI componenets and then create a constructor to intialize the fields
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

                - THen what we need to do is to add our event handler methods to each UICompomenet

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
                    - we are simulatin selecting a post from post list and then we log out to check weather teh button and  little textbox have been updated correctly

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
            - we create a PostDialogBox then call simulateUserInteration() method
            - It all sowks perfectly

 */

public class Explanation {

}
