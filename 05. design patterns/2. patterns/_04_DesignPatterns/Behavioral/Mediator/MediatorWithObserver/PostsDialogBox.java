package _04_DesignPatterns.Behavioral.Mediator.MediatorWithObserver;

import _04_DesignPatterns.Behavioral.Mediator.MediatorWithObserver.UIFramework.*;

public class PostsDialogBox {

    private ListBox postListBox;
    private TextBox titleTextBox;
    private Button saveButton;

    public PostsDialogBox() {
        postListBox = new ListBox();
        titleTextBox = new TextBox();
        saveButton = new Button();

        postListBox.addEventHandler(this::postSelected);
        titleTextBox.addEventHandler(this::titleChange);
    }

    public void simulateUserInteration() {
        postListBox.setSelection("Post 2");
        titleTextBox.setText("");
        System.out.println("Title text box: " + titleTextBox.getText());
        System.out.println("Button enabled : " + saveButton.isEnabled());
    }

    private void postSelected() {
        titleTextBox.setText(postListBox.getSelection());
    }

    private void titleChange() {
        saveButton.setEnabled(!titleTextBox.getText().isEmpty());
    }
}