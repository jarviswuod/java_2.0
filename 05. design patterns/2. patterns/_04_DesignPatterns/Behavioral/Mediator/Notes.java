package _04_DesignPatterns.Behavioral.Mediator;

/*

    NOTES:
    - Mediator Pattern:
        - It defines an object (the mediator) that describes how a set of objects interact with heach other, therefore erducing lofs of chaotic dependecies between those objects


    - CHALLENGE:
        - Let's say we have a blog that lists all of your posts, and you can select a post and then edit that post's title;


                                State 1
                                                                Edit post:
                                                                    - When the page loads we have state 1; where we have a list of blog posts and none of those blog posts are intially selected
                _______________
                |  Post1      |            Initial State -  no post selected
                |  Post2      |
                |  Post3      |
                |_____________|



                                State 2
                                                                Edit post:
                                                                    - Select an article from the postsContainer on left and the input is populated on the right with the title

                _______________
                |  Post1      |            Post 3 selected - show input for title and save button
                |  Post2      |         Title
                |  # Post3    |         _______________
                |_____________|         |    Post3    |
                                        |_____________|
                        _______________
                        |  save       |
                        |_____________|



                                State 3
                                                                Edit post:
                                                                    - The save button is disabled if no title provided, or no article selcted


                _______________
                |  Post1      |             No title leads to disabling save button
                |  Post2      |         Title
                |  # Post3    |         _______________
                |_____________|         |             |
                                        |_____________|

                        _______________
                        |             |
                        |_____________|


        - Explanation:
            -Components (classes) that we need:
                - ListBox that contains the posts(on left)
                - TextBox for editing title
                - Button that can be diabled or enabled

            - The above classes will come from a UI framework we don't have access to the source code

            - When an article is selected form the list box, the text should be populated and the button enabled. When we clear the text box, the button should become disabled

        - ISSUE:
            - But how do they talk to each other? They should be able to talk to each other without knowledge of each other

        - Solutions:
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
                _______________         _______________         _______________
                | PostListBox |         | TitleListBox|         | SaveButton  |
                |_____________|         |_____________|         |_____________|
                |             |         |             |         |             |
                |_____________|         |_____________|         |_____________|


            - Then they could talk to each other, like so:

                _______________         _______________
                | PostListBox |         | TitleListBox|             - onSelect():
                |_____________|         |_____________|                 - textBox.setText()
                | onSelect()  |         | onChange()  |                 - button.enable()
                |_____________|         |_____________|
                      |                   |       ^                 - onChange():
                      |                   |       |                     if(text == "")
                      |                   v       |                     button.disable()
                      |                 _______________
                      |---------------> | SaveButton  |             - onClick():
                                        |_____________|                 - text = textBox.getText()
                                        | onClick()   |                 - databse.save(post1, text)
                                        |_____________|
    


            - Whenever a post is selected. PostsListBox calls it's onChange() method to populate the TitleTextBox and enable the SaveButton, etc


        - PROBLEM:
            - As our form gets more complex, there becomes lots of dependencies/connections between these classes
            - Also, the logic for this form is spread all over the place, so to see what's going on in this form, you have to look at multiple classes which makes it difficult to understand and maintain



    - SOLUTION 1: THE MEDIATOR PATTERN;
        - Using the Mediator pattern, the UI components doesn't know about each other, and all interactions logic is in the DialogueBox(the Mediator)

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

            - Whenever a UI componenet changes, it notifies it's owner, the DialogBox this is by calling the changed(UIControl) method and passing itself as argument, which then handles updating other components



    - MEMENTO PATTERN UML: From GoF book:
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

        - The ConcreteColleagues are all unrelated/uncoupled from each other. They talk to each other indirently via a mediator allowing them to be reused in different contexts i.e we are not coupling a list box to a text box or button

        - The only coupling we have is between ConcreteMediator and ConcreteCollegue. This is fine because in our example the PostsDialogueBox needs to know about all it's UI components so they can interact with each other



    - SOLUTION 2: THE MEDIATOR PATTERN WITH OBSERVER PATTERN;
        - One problem with our previous solution is that the changed() method on PostDialogueBox can get bulky as we add UI components -- lots of if/else to see what component has changed:

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
            - The subject notifies the Observer when any changes happens

                ___________________            _______________
                | Subject         |            |  Observer   |
                |_________________|<>--------->|_____________|
                | attach(obj):    |            |  update()   |
                | detatch(obj):   |            |_____________|
                | notify():       |                    ^
                |_________________|                    |
                           ^                           |
                           |                   _____________________
                           |                   |  ConcreteObserver |
                           |                   |___________________|-|
                ___________________            |  update()         | |-|
                | ConcreteSubject |            |___________________| | |
                |_________________|              |___________________| |
                |                 |                |___________________|
                |_________________|


        - Below, the UI controls are the subjects, and the PostDialogBox is the observer. When a UI control changes, PostDialogBox gets notified

                ______________________                    ______________________
                | TitleBox           |----|       |-------| TextBox            |
                |____________________|    |       |       |____________________|
                | attach(observer)   |    |       |       | attach(observer)   |
                |____________________|    |       |       |____________________|
                                          v       v
                                    _______________________
                       |----------> | PostsDialogBox      |
                       |            |_____________________|
                       |            | changed(UIControl)  |
                       |            |_____________________|
                ______________________
                | Button             |
                |____________________|
                | attach(observer)   |
                |____________________|

 */

public class Notes {

}
