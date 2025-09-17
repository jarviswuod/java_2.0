package _04_DesignPatterns.Behavioral.Mediator.good;

public class PostDialogBox extends DialogBox {

    private ListBox postListBox;
    private TextBox titleTextBox;
    private Button saveButton;

    public PostDialogBox() {
        postListBox = new ListBox(this);
        titleTextBox = new TextBox(this);
        saveButton = new Button(this);

        saveButton.setEnabled(false);
    }

    public void simulateUserInteration() {
        postListBox.setSelection("Post 2");
        // titleTextBox.setText("");
        System.out.println("Title text box: " + titleTextBox.getText());
        System.out.println("Button enabled : " + saveButton.isEnabled());
    }

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

}
