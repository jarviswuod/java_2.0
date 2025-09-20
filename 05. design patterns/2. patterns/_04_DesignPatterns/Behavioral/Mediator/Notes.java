package _04_DesignPatterns.Behavioral.Mediator;

/*

    NOTES:
    - Mediator Pattern:
        - It defines an object (the mediator) that describes how a set of objects interact with heach other, therefore erducing lofs of chaotic dependecies between those objects


    - Illustration:
        - Let's say we have a blog that lists all of your posts, and you can select a post and then edtit that post's title;



                                Edit posts
            State 1
                - When the page loads we have state1; where we have a list of blog posts and none of those blog posts are intially selected


                _______________
                |  Post1      |                 Initial State -  no post selected
                |  Post2      |
                |  Post3      |
                |_____________|



                                Edit posts
            State 2
                - Select an article from the postsCOntainer on left and the input is populated on the right with the title

                _______________
                |  Post1      |                 POst 3 selected - show input for title and save button
                |  Post2      |         Title
                |  # Post3    |         _______________
                |_____________|         |    Post3    |
                                        |_____________|

                        _______________
                        |  save       |
                        |_____________|




                                Edit posts
            State 3
                - The save button is disabled if no title provided, or no article selcted


                _______________
                |  Post1      |                 No title leads to disabling save button
                |  Post2      |         Title
                |  # Post3    |         _______________
                |_____________|         |             |
                                        |_____________|

                        _______________
                        |             |
                        |_____________|


        - Components (classes) that we need:
            - ListBox that contains the posts(on left)
            - TextBox for editing title
            - Button that can be diabled or enabled

        - The above classes will come froma UI framework we don't have access to the source code

        - When an article is selected form the list box, the text should be populated and the button enabled. When we clear the text box, the button should become disabled

        - Issue:
            - But how do they talk to each other? THey should be able to talk to each other without knowledge of each other

        - SOlutions:
             One solution would be to use inheritance


                _______________         _______________         _______________
                | ListBox     |         | TextBox     |         | Button      |
                |_____________|         |_____________|         |_____________|
                |             |         |             |         |             |
                |_____________|         |_____________|         |_____________|
                        ^                       ^                      ^ 
                        |                       |                      |               UI Framework
            ------------|-----------------------|----------------------|-----------------------
                        |                       |                      |               Our Classes
                        |                       |                      |
                _______________         _______________         _______________
                | PostListBox |         | TitleListBox|         | SaveButton  |
                |_____________|         |_____________|         |_____________|
                |             |         |             |         |             |
                |_____________|         |_____________|         |_____________|


            - Then they could talk to each other, like so:

                _______________         _______________
                | PostListBox |         | TitleListBox|
                |_____________|         |_____________|
                | onSelect()  |         | onChange()  |
                |_____________|         |_____________|
                      |                   |       ^ 
                      |                   |       | 
                      |                   v       |
                      |                 _______________
                      |---------------> | SaveButton  |
                                        |_____________|
                                        | onClick()   |
                                        |_____________|

                - onSelect():
                    - textBox.setText()
                    - button.enable()

                - onChange():
                    if(text == "")
                        button.disable()

                - onClick():
                    -  text = textBox.getText()
                    -  databse.save(post1, text)


            - Whenever a post is selected. PostsListBox xalls it's onChange() method to populate the title text box and enable the button , etc

            - Problem
                - As our form gets more complex, there becomes lots of dependencies/connections between these classes. Also, the logic for this form is spread all over the palce, so to see what's going on in this form, you have to look at multiple classes. It's difficult to understand and maintain


            - SOlution:
                - Using the Mediator pattern, the UI componenets don;t know about heach other, and all interactions logc is in the dialogue box('the Mediator')



        - The Mediator pattern:
            - Using the Mediator pattern, the UI componenets don;t know about heach other, and all interactions logc is in the dialogue box('the Mediator')

                _______________                                 _______________
                | ListBox     |-----------|       |-------------| TextBox     |
                |_____________|           |       |             |_____________|
                |             |           |       |             |             |
                |_____________|           |       |             |_____________|
                                          |       | 
                                          v       v
                                    _______________________
                       |----------> | DialogBox           |<--------------|
                       |            |_____________________|               |
                       |            | changed(UIControl)  |               |
                       |            |_____________________|               |
                       |                                                  |
                ______________________                               _______________
                | PostDialogBox      |                               | Button      |
                |____________________|                               |_____________|
                | changed(UIControl) |                               |             |
                |____________________|                               |_____________|

            - WHenever a UI componenet changes, it notifies its owner, the dialog box, by calline the changed(UICOntrol) methos and passign itself as argument, which then handles updating other components


        - MEDIATOR UML from GoF:

                _______________                     _______________
                | Mediator    |<--------------------| Collegue    |
                |_____________|                     |_____________|
                |             |                     |             |
                |_____________|                     |_____________|
                       ^                                  ^
                       |                                  |
                       |                                  |
                       |                                  |
                ______________________               ______________________
                | ConcreteMediator   |               | ConcreteCollegue   |  
                |____________________|-------------->|____________________|-|
                |                    |               |                    | |-|
                |____________________|               |____________________| | |
                                                       |____________________| |
                                                          |___________________|

            - Here are the abstract names for our previous post-title-editing app:
                - Mediator = DialogueBox
                - ConcreteMediator = PostDialogueBox
                - Colleague = UIControl
                - ConcreteColleague(s) = our concrete UI classes (Button, TextBox, ListBox)

            - The concrete collegues are all unrealted/uncoupled from each other. THey talk to each other indirently via a mediator allowing them to be reused in different contextx i.e we are not coupling a list box to a text box or button

            - The only coupling we have is between ConcreteMediator and ConcreteCollegue. This is fine because in our example the PostsDialogueBox needs to know about all it's UI componenets so they can interact with each other

        
    - Mediator Pattern with Observer pattern:
        - One problem with our previous solution is that the changed() method on PostDialogueBox can get bulky as we add UI componenets -- lots of if/else to see what componenet has changed:

                public class PostDialogBox extends DialogBox {
                    @Override
                    public void changed(UIControl uiControl) {
                        if (uiControl == postListBox) {
                            handlePostChange();
                        } else if (uiControl == titleTextBox) {
                            handleTitleChange();
                        }
                    }
                }

        - To solve for this, we can implement the Mediator pattern using the Observer Pattern

                ________________________            _______________
                |  Subject             |            |  Observer   |
                |______________________|<>--------->|_____________|
                |  attach(obj):        |            |  update()   |
                |  detatch(obj):       |            |_____________|
                |  notify():           |                    ^
                |______________________|                    |
                            ^                               |
                            |                       _____________________
                            |                       |  ConcreteObserver |
                            |                       |___________________|-|
                ________________________            |  update()         | |-|
                |  ConcreteSubject     |            |___________________| | |
                |______________________|              |___________________| |
                |                      |                |___________________|
                |______________________|

        - The subject notifies the Observer when any changes happens

        - Below, the UI controls are the subjects, and the PostDialogBox is the observer. When a UI control changes, PostDialogBox gets notified

                ______________________                    ______________________
                | TitleBox           |----|       |-------| TextBox            |
                |____________________|    |       |       |____________________|
                | attach(observer)   |    |       |       | attach(observer)   |
                |____________________|    |       |       |____________________|
                                          |       | 
                                          v       v
                                    _______________________
                       |----------> | PostsDialogBox      |
                       |            |_____________________|
                       |            | changed(UIControl)  |
                       |            |_____________________|
                       |
                ______________________
                | Button             |
                |____________________|
                | attach(observer)   |
                |____________________|



 */

public class Notes {

}
