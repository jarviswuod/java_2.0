package _04_DesignPatterns.Creational.AbstractFactory;

/*

    - CODE EXPLANATION:

    - CHALLENGE:
        - Say that you have an app for Windows and Mac. The UI components - such as buttons, checkboxes and textboxes are different for each OS, but each type of UI component will have the same behaviours e.g a checkbox will have an onSelect() method
        - So, our app needs a way of knowing what the current OS is, and then select the appropriate family of UI components for that OS


    - SOLUTION 1:
        - OperatingSystemType enum:
            - This enum class contains different types of operating systems that our application can support we have Windows and Mac

                    public enum OperatingSystemType {

                        Windows, Mac;
                    }


        - UIComponent interface:
            - This is for the different UI we will have(Windows or Mac) it
            - We have a render() method for rendering a UIComponent into the UI or the GUI

                    public interface UIComponent {

                        public void render();
                    }


        - Checkbox interface:
            - It extends the UIComponent interface - this means all Checkboxex are UICompoents
            - For simplicity we ahve no methods or fields but we could have like onSelect()

                    public interface CheckBox extends UIComponent {

                        // Checkbox- specific methods here...
                    }


        - Button interface:
            - Just like the Checkbox, it also extends the UIComponent interface

                    public interface Button extends UIComponent {

                        // Button- specific methods here...
                    }


        - Concrete Windows Components:
            - UIWindows/WindowsButton class:
                - This is a concrete class that implements the Button interface and overrides the render() method with a simple console log message

                    public class WindowsButton implements Button {

                        @Override
                        public void render() {
                            System.out.println("Windows: render button");
                        }
                    }


            - UIWindows/WindowsCheckbox class:
                - Just like the WindowsButton class it implements the Checkbox interface and overrides the render() method

                    public class WindowsCheckBox implements CheckBox {

                        @Override
                        public void render() {
                            System.out.println("Windows: render Checkbox");
                        }
                    }



        - Concrete Mac Components:
            - UIMac/MacButton class:
                - This is a concrete class that implements the Button interface and overrides the render() method 

            - UIMac/MacCheckbox class:
                - Just like the WindowsButton class it implements the Checkbox interface and overrides the render() method

            
            NOTES;;;
                - All the above would be probably installed as some sort of package



        - UserSettingsForm class:
            - All the above would be probably installed as some sort of package
            - This is a class that is part of our own code
            - It has a render method which will accept the OS type and then we can check what the OS type is then create a custom Window custom Button and Window custom Checkbox classes calling render() method after each concrete class creation
            - Same thing applies to mac OS type

                    public class UserSettingForm {

                        public void render(OperatingSystemType os) {
                            if (os == OperatingSystemType.Windows) {
                                new WindowsButton().render();
                                new WindowsCheckBox().render();
                            } else if (os == OperatingSystemType.Mac) {
                                new MacButton().render();
                                new MacCheckBox().render();
                            } else {

                            }
                        }
                    }



        - Main class: Client class:
            - This is where we will be using our solution as a client would
            - Firt we specify the OS our app is running on -  probabely this would be some sort of environment/system variable that our variable that we obtain that our app will be running on
            - Then we create a userSettingsForm object and render the object by calling the render() method on it passing the OS Type instance we created above

                    public class Main {
                        public static void main(String[] args) {

                            // OperatingSystemType os = OperatingSystemType.Windows;
                            OperatingSystemType os = OperatingSystemType.Mac;
                            UserSettingForm usersSettingForm = new UserSettingForm();
                            usersSettingForm.render(os);
                        }
                    }



        - OBSERVATION:
            - The program works perfectly as expected for both Windows and Mac OS types
            - Problem that comes with this solution is that the userFormSetting class; for every UI that we develop we'll be adding conditionals to check what the current OS is  and render the correct concrete UI componenet for that particular UI which is a maintance nightmare
            - Another issue is that we have conditionally render our concrete UI components - this is by creating our Concrete UI components by having to use the 'new' keyword every time example;

                if (os == OperatingSystemType.Windows) {
                    new WindowsButton().render();
                    new WindowsCheckbox().render();
                }

            - In this case it's easy to make mistakes such as to accidentally rendering a Windows checkbox on the Mac Operating system because we're going to have lots of different forms(homePage, aboutPage), OS, and or concrete UI componenets -  lots of different Ui elements that will be create from our UI components; with this as the application grows it becomes easier to accidentally render a wrong UI components for a certain particular OS and our program is not gonna know we've actually done the mistakce and will result to an error when an application run on that particular OS

        - SOLUTION:
            - Create an Abstract Facotry class to create families of UI components, such as the family of WindowsUI components or a family of MacUI components



    - SOLUTION 2: Abstract Factory pattern;
        - UIComponentFactory interface:
            - Here we create 2 methods; one for creating buttons and the other for creating a checkbox
            - Next thing is to create our concrete factories

                    public interface UIComponentFactory {

                        Button createButton();
                        CheckBox createCheckBox();
                    }


        - MacUIComponentFactory class:
            - It implements UIComponentFactory interface and hence overrding the createButton() and createCheckbox() methods
            - Under createButton() we return a new MacButton() while for createCheckBox() we will create a MacCheckbox()

                    public class MacUIComponentFactory implements UIComponentFactory {

                        @Override
                        public Button createButton() {
                            return new MacButton();
                        }

                        @Override
                        public CheckBox createCheckBox() {
                            return new MacCheckBox();
                        }
                    }


        - WindowsUIComponentFactory class:
            - It implements UIComponentFactory interface and hence overrding the createButton() and createCheckbox() methods
            - Under createButton() we return a new WindowsButton() while for createCheckBox() we will create a WindowsCheckbox()

                    public class WindowsUIComponentFactory implements UIComponentFactory {

                        @Override
                        public Button createButton() {
                            return new WindowsButton();
                        }

                        @Override
                        public CheckBox createCheckBox() {
                            return new WindowsCheckBox();
                        }
                    }



        - UserSettingsForm class:
            - Now in our form class we now don't have to check for our OS type before rendering the OS system specific UI components. We can use polymorphism instead so that the client (UserSettingsForm) doesn't have knowledge of our  the specific os, basically it just calls the UIComponentFactory to create a button or checkbox and then render it to the screen - we can do this because we can pass in the UIComponentFactory into the render() method in place of OperatingSystemType enum class

            - OLD::
                    public class UserSettingsForm {

                        public void render(OperatingSystemType os) {

                            if (os == OperatingSystemType.Windows) {
                                new WindowsButton().render();
                                new WindowsCheckbox().render();
                            } else if(...) {

                                ...
                            }
                        }
                    }


            - NEW::
                    public class UserSettingsForm {

                        public void render(UIComponentFactory uiComponentFactory) {

                            uiComponentFactory.createButton().render();
                            uiComponentFactory.createCheckbox().render();
                        }
                    }



            - NOTE;
                - Here we are using polymorphism by talking to a Factory interface to create UICompoents and this client requires no knowledge of the specific  OS
                - This is a much cleaner code and we no longer have to perform all the if-else checks in every single UI we create - such as UsersSettingsForm


        - Main class: Client class:
            - First we create a OperatingSystemType instance
            - Then we create a UIComponentFactory object and initially not gonna assign any specific object. This is because what we need to do is to perform for OS type checks inside our Main/Client class assigning either MacUIComponent() or WindowsUIComponent() objects to it
            - We then create aUserSettingsForm object and call the render() method on it passing the uiComponentFactory

                    public class Main {
                        public static void main(String[] args) {

                            OperatingSystemType os = OperatingSystemType.Mac;
                            UIComponentFactory uiComponentFactory;

                            if (os == OperatingSystemType.Mac) {
                                uiComponentFactory = new MacUIComponentFactory();
                            } else if (os == OperatingSystemType.Windows) {
                                uiComponentFactory = new WindowsUIComponentFactory();
                            } else {
                                uiComponentFactory = new WindowsUIComponentFactory();

                                System.out.println("Unsupported OS");
                            }

                            new UserSettingForm().render(uiComponentFactory);
                        }
                    }



        - OBSERVATION:
            - This is all working super well
            - One might wonder what's the benefit of using the abstract factory pattern compared to what we had before because we still have to do the conditional checks to check the OS type and we are doing it in a different place(Main/Client class) rather than within our UserSettingsForm class; The ADVANTAGE is that this checks only need to be done once upon app initialization  then throughout the application  the UI component factory can be used to ensure that the correct family of UI components are used for the current OS all throughout the application - this means we no longer to check for the OS type in every sort of UI class we create(e.g UserSettingsForm we can add OrdersPage)

 */

public class Explanation {

}
