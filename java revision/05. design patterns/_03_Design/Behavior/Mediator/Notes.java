package _03_Design.Behavior.Mediator;

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


 */

public class Notes {

}