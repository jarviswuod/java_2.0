package _03_Design.Behavior.Mediator;

import java.util.ArrayList;
import java.util.List;

/*

    NOTES:
    - Mediator pattern:
        - Is a behavior design pattern that utelizes an object as a place of communication to other objects

    - 4 key players:
        - Mediator
        - Concrete Mediator
        - Components
        - Concrete Components


            public class Notes {
                public static void main(String[] args) {

                    DialogBox dialogBox = new DialogBox();
                    dialogBox.simulated();
                }
            }

            abstract class Mediator {

                public abstract void changed(UIControl uiControl);
            }

            abstract class UIControl {

                protected Mediator mediator;

                public UIControl(Mediator mediator) {
                    this.mediator = mediator;
                }
            }

            class SelectBox extends UIControl {
                public SelectBox(Mediator mediator) {
                    super(mediator);

                }

                private String selection = "";

                public String getSelection() {
                    return selection;
                }

                public void setSelection(String selection) {
                    this.selection = selection;

                    mediator.changed(this);
                }
            }

            class TextBox extends UIControl {
                public TextBox(Mediator mediator) {
                    super(mediator);

                }

                private String text = "";

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;

                    mediator.changed(this);
                }
            }

            class Button extends UIControl {

                private boolean enabled;

                public Button(Mediator mediator) {
                    super(mediator);
                }

                public boolean isEnabled() {
                    return enabled;
                }

                public void setEnabled(boolean enabled) {
                    this.enabled = enabled;

                    mediator.changed(this);
                }
            }

            class DialogBox extends Mediator {

                private SelectBox selectBox;
                private Button button;
                private TextBox textBox;

                public DialogBox() {
                    button = new Button(this);
                    selectBox = new SelectBox(this);
                    textBox = new TextBox(this);

                    button.setEnabled(false);
                }

                @Override
                public void changed(UIControl uiControl) {

                    if (selectBox == uiControl) {
                        selectedBox();
                    }
                    if (textBox == uiControl) {
                        textBox();
                    }
                }

                private void selectedBox() {
                    textBox.setText(selectBox.getSelection());
                    button.setEnabled(true);
                }

                private void textBox() {
                    boolean change = textBox.getText() != "";
                    button.setEnabled(change);
                }

                public void simulated() {
                    selectBox.setSelection("Box 2 selected");
                    // textBox.setText("");

                    System.out.println("textBox : " + textBox.getText());
                    System.out.println("button : " + button.isEnabled());
                }
            }


    // SECOND ATTEMPT::: ::: ::: :::
    Mediator desing pattern:
        - Is a behavioral pattern that facilitates communication between different objects without them directly talking to each other

    - 4 key players
        - Mediator:
            - Is a class that holds provides a skeleton to be implemented by concrete mediator

        - Concrete Mediator:
            - Is a class that acts a common source of communication with reference to other objects that wanna communicate via it

        - Component:
            - Is a class that provides a template to be implemented by concrete component

        - Concrete Component:
            - Are classes that implement component and once that need to comminicate with each other


                    public class Notes {
                        public static void main(String[] args) {

                            DialogBox dialogBox = new DialogBox();

                            dialogBox.simulation();
                        }
                    }

                    abstract class Mediator {
                        public abstract void changed(UIControl uiControl);
                    }

                    class UIControl {

                        protected Mediator mediator;

                        public UIControl(Mediator mediator) {
                            this.mediator = mediator;
                        }
                    }

                    class SelectBox extends UIControl {
                        private String selection = "";

                        public SelectBox(Mediator mediator) {
                            super(mediator);
                        }

                        public String getSelection() {
                            return selection;
                        }

                        public void setSelection(String selection) {
                            this.selection = selection;

                            mediator.changed(this);
                        }
                    }

                    class TextBox extends UIControl {
                        private String title = "";

                        public TextBox(Mediator mediator) {
                            super(mediator);
                        }

                        public String getTitle() {
                            return title;
                        }

                        public void setTitle(String title) {
                            this.title = title;

                            mediator.changed(this);
                        }
                    }

                    class Button extends UIControl {

                        private boolean enabled;

                        public Button(Mediator mediator) {
                            super(mediator);
                        }

                        public boolean isEnabled() {
                            return enabled;
                        }

                        public void setEnabled(boolean enabled) {
                            this.enabled = enabled;

                            mediator.changed(this);
                        }
                    }

                    class DialogBox extends Mediator {

                        private SelectBox selectBox;
                        private TextBox textBox;
                        private Button button;

                        public DialogBox() {
                            selectBox = new SelectBox(this);
                            textBox = new TextBox(this);
                            button = new Button(this);

                            button.setEnabled(false);
                        }

                        @Override
                        public void changed(UIControl uiControl) {
                            if (selectBox == uiControl) {
                                boxSelected();
                            }
                            if (textBox == uiControl) {
                                titleChange();
                            }
                        }

                        private void titleChange() {
                            button.setEnabled(textBox.getTitle() != "");
                        }

                        private void boxSelected() {
                            textBox.setTitle(selectBox.getSelection());

                            button.setEnabled(true);
                        }

                        public void simulation() {
                            selectBox.setSelection("Box 2 selected");
                            // textBox.setTitle("");

                            System.out.println("Text Title : " + textBox.getTitle());
                            System.out.println("button : " + button.isEnabled());

                        }
                    }

 */

public class Notes {
    public static void main(String[] args) {

        DialogBox dialogBox = new DialogBox();
        dialogBox.simulated();
    }
}

interface EventHandler {

    void handle();
}

class UIControl {

    List<EventHandler> eventHandlers = new ArrayList<>();

    public void addHandler(EventHandler eventHandler) {
        eventHandlers.add(eventHandler);
    }

    public void removeHandler(EventHandler eventHandler) {
        eventHandlers.remove(eventHandler);
    }

    public void notifyHandlers() {
        for (EventHandler handler : eventHandlers) {

            handler.handle();
        }
    }
}

class SelectBox extends UIControl {

    private String selection = "";

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;

        notifyHandlers();
    }
}

class TextBox extends UIControl {

    private String title = "";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;

        notifyHandlers();
    }
}

class Button extends UIControl {
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;

        notifyHandlers();
    }
}

class DialogBox implements EventHandler {

    private Button button;
    private TextBox textBox;
    private SelectBox selectBox;

    public DialogBox() {

        button = new Button();
        textBox = new TextBox();
        selectBox = new SelectBox();

        handle();
    }

    @Override
    public void handle() {
        selectBox.addHandler(this::boxSelected);
        textBox.addHandler(this::titleChanged);
    }

    private void boxSelected() {
        textBox.setTitle(selectBox.getSelection());
    }

    private void titleChanged() {
        button.setEnabled(!textBox.getTitle().isEmpty());
    }

    public void simulated() {

        selectBox.setSelection("Box Selected");
        // textBox.setTitle("");

        System.out.println("Text title : " + textBox.getTitle());
        System.out.println("Button : " + button.isEnabled());
    }
}