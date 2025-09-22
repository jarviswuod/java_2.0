package _04_DesignPatterns.Structural.Adapter;

/*

    NOTES:
    - The Adapter Pattern:
        - Is a structural design pattern that allows incompatible interfaces between classes to work together by providing a wrapper that translates one interface into another



    - CHALLENGE:
        - Say we have a video editing application that allows users to upload a video and change the color of the video. The application provides preset color options for the user to select, such as black and white or midnight purple

                    ____________________                ____________________
                    |  Original video  |  Black and     |  Edited video    |
                    |  with multiple   |     white      |   in black &     |
                    |    colors        |--------------> |     white        |
                    |__________________|                |__________________|

        - The classes that change the color of the application are built by us, and implement a Color interface

        - We then decide to install a 3rd-party library into our application that allows users to apply more types of colors to their videos


        - PROBLEM:
            - The probem is that all concrete color classes are expected to implement our Color interface and have an apply() method. But, the concrete color classes from the installed library do not, meaning that we can't pass them to our videoEditor.applyColor() method
                    videoEditor.applyColor(new Rainbow()); // Rainbow is a color from the 3rd party library

            - We cannot modify the 3rd-party library code to make the color classed implement Color interface. Hence we solve for this by converting the interface of the 3rd party color classes to a different form, using the Adaper Pattern



    - SOLUTION 2 - ADAPTER PATTERN
        - So far, we can't use Rainbow because it doesn't implement Color, and we can't make it implement COlor because it's inside a 3rd party package:


            ______________________                ________________
            | VideoEditor        |--------------> | Color        |
            |____________________|                |______________|
            | applyColor(Color)  |                | app;y(Video) |
            |____________________|                |______________|
                                                        ^
                                                        |
                                                        |
                    ???                                 |
               _________________                ________________________
           ??? | Rainbow       | ???            | MidnightpurpleColor  |
               |_______________|                |______________________|
           ??? | update(video) | ???            | apply(video)         |
               |_______________|                |______________________|


        - SOLUTION:
            - We create a RainbowColor class that implements Color and is composed of the 3rd party Rainbow class. We can then call the apply() method in RainbowColor, and, inside it, call whatever methods we need to call from Rainbow to apply the filter. We adapt the class to a different form;

            ______________________                ________________
            | VideoEditor        |--------------> | Color        |
            |____________________|                |______________|
            | applyColor(Color)  |                | apply(Video) |
            |____________________|                |______________|
                                                        ^
                                                        |
                                                        |
                                                        |
               _________________                _________________
               | Rainbow       | <-----------<> | Rainbow       |
               |_______________|                |_______________|
               | update(video) |                | apply(video)  |   rainbow.update(video)
               |_______________|                |_______________|


            - RainbowColor is the adapter; it's converting the interface of the Rainbow("adaptee") class into a different form(Color)
        -


 */

public class Notes {

}
