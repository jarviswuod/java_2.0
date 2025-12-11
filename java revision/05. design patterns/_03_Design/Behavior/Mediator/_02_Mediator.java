package _03_Design.Behavior.Mediator;

/*

    NOTES:
    - Is a behavioral pattern that uses an object as a mean of communication between different objects
    - Key players:
        - Mediator interface
        - Concrete Mediator
        - Component interface
        - Concrete Component

    - Example:
        - UIControl; button, titlebox, selectBox
        - Mediator and Observer patterns 

*/

public class _02_Mediator {
    public static void main(String[] args) {

        _02_ConcreteMediator mediator = new _02_ConcreteMediator();
        mediator.simulateUserInteraction();

    }
}

interface _02_Mediator_ {

    void changed(_02_UIControls uiControls);
}

class _02_UIControls {

    protected _02_Mediator_ mediator;

    public _02_UIControls(_02_Mediator_ mediator) {
        this.mediator = mediator;
    }
}

class _02_SelectBox extends _02_UIControls {

    private String selectBox;

    public _02_SelectBox(_02_Mediator_ mediator) {
        super(mediator);
    }

    public String getSelectBox() {
        return selectBox;
    }

    public void setSelectBox(String selectBox) {
        this.selectBox = selectBox;

        mediator.changed(this);
    }
}

class _02_TitleText extends _02_UIControls {

    private String title;

    public _02_TitleText(_02_Mediator_ mediator) {
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

class _02_Button extends _02_UIControls {

    private boolean isEnabled;

    public _02_Button(_02_Mediator_ mediator) {
        super(mediator);
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;

        mediator.changed(this);
    }
}

class _02_ConcreteMediator implements _02_Mediator_ {

    private _02_SelectBox selectBox;
    private _02_TitleText titleText;
    private _02_Button button;

    public _02_ConcreteMediator() {
        selectBox = new _02_SelectBox(this);
        titleText = new _02_TitleText(this);
        button = new _02_Button(this);

        button.setEnabled(false);
    }

    @Override
    public void changed(_02_UIControls uiControls) {
        if (uiControls == selectBox)
            selectBoxUpdate();

        if (uiControls == titleText)
            titleTextUpdate();
    }

    private void selectBoxUpdate() {
        titleText.setTitle(selectBox.getSelectBox());
        button.setEnabled(true);
    }

    private void titleTextUpdate() {
        button.setEnabled(!titleText.getTitle().isEmpty());
    }

    public void simulateUserInteraction() {
        selectBox.setSelectBox("Box 2");
        titleText.setTitle("");

        System.out.println("button " + button.isEnabled());
        System.out.println("titleText " + titleText.getTitle());
    }
}
