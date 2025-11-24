package _04_DesignPatterns.Structural.Adapter;

/*

    NOTES:
    - The Adapter Pattern:
        - Is a structural design pattern that allow objects with incompatible interfaces to work together by providing a bridge between them
        - It acts as a translator allowing two classes with different interfaces to communicate and collaborate seamlessly



    - CHALLENGE:
        - Say we have a video editing application that allows users to upload a video and change the color of the video. The application provides preset color options for the user to select, such as black and white or midnight purple

                    ____________________                ____________________
                    |  Original video  |  Black and     |   Edited video   |
                    |  with multiple   |--------------> |    in black &    |
                    |    colors        |     white      |      white       |
                    |__________________|                |__________________|

        - The classes that change the color of the application are built by us and implement a Color interface

        - We then decide to install a 3rd-party library into our application one that allow users to apply more types of colors to their videos


        - PROBLEM:
            - The issue here is that all concrete color classes are expected to implement our Color interface and have an apply() method. But the concrete color classes from the installed library do not meaning that we can't pass them to our videoEditor.applyColor() method
                    NOTE: Rainbow is a color from the 3rd party library
                        - videoEditor.applyColor(new Rainbow()); 


            - We cannot modify the 3rd-party library code to make the Color classes implement our Color interface. We solve for this by converting the interface of the 3rd party color classes to a different form using the Adaper Pattern



    - SOLUTION 2 - ADAPTER PATTERN
        - So far we can't use Rainbow because it doesn't implement Color and we can't make it implement Color because it's inside a 3rd party package:

                    ______________________                ________________
                    | VideoEditor        |--------------> | Color        |
                    |____________________|                |______________|
                    | applyColor(Color)  |                | app;y(Video) |
                    |____________________|                |______________|
                                                                ^
                                                                |
                                ???                             |
                        _________________            _______________________
                    ??? | Rainbow       | ???        | MidnightpurpleColor |
                        |_______________|            |_____________________|
                    ??? | update(video) | ???        | apply(video)        |
                        |_______________|            |_____________________|


        - SOLUTION:
            - We create a RainbowColor class that implements Color and is composed of the 3rd party Rainbow class. We can then call the apply() method in RainbowColor and inside it call whatever methods we need to call from Rainbow to apply the filter. Basically adapting the class to a different form

                        _____________________                ________________
                        | VideoEditor       |--------------> | Color        |
                        |___________________|                |______________|
                        | applyColor(Color) |                | apply(Video) |
                        |___________________|                |______________|
                                                                    ^
                                                                    |
                                                                    |
                           _________________                _________________
                           | Rainbow       | <-----------<> | Rainbow       |
                           |_______________|                |_______________|
                           | update(video) |                | apply(video)  |   rainbow.update(video)
                           |_______________|                |_______________|


            - RainbowColor is the adapter and it's converting the interface of the Rainbow("adaptee") class into a different form(Color)

 */

public class Notes {

}
