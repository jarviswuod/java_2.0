package _04_DesignPatterns.Behavioral.Strategy;

/*

    NOTES:
    - The Strategy Pattern is used to pass different algorithms, or behaviours, to an object

    - Example;
        - Let's consider an application tha stores videos. Before storing a video, the video needs to be compressed using a specific compression algorithm, such as MOV or MP4, then, if necessary, apply an overlay to the video, such as black and white or blur

        - GOOD SOLUTION:
            - The UML below show that when we create a VideoStorage object, we pass it the concrete compressor and overlay objects that we want it to use. This is polymophism: VideoStroage can accpet many different forms of Compressor and Overlay objects. VideoStorage is composed of Compressor and Overlay objects. And there are multiple concrete compressor and overlay implementations that extend Compressor and Filter respectively

                ________________            _______________
                | VideoStorage |            | Compressor  |
                |______________|<>--------->|_____________|
                | compressor   |            | compress(): |
                | overlay()    |            |_____________|
                |______________|                   ^
                | store():     |                   |
                |______________|                   |
                                            _________________
                                            | CompressorMP4 |
                                            |_______________|-|
                                            | - context     | |-|
                                            |_______________| | |
                                            | + doThis():   | | |
                                            | + doThat():   | | |
                                            |_______________| | |
                                              |_______________| |
                                                |_______________|
 

                ________________            _________________
                | VideoStorage |            |  Overlay      |
                |______________|<>--------->|_______________|
                | compressor   |            |  compress():  |
                | overlay()    |            |_______________|
                |______________|                   ^
                | store():     |                   |
                |______________|                   |
                                            _________________
                                            |  OverlayBlur  |
                                            |_______________|-|
                                            |  - context    | |-|
                                            |_______________| | |
                                            |  + doThis():  | | |
                                            |  + doThat():  | | |
                                            |_______________| | |
                                              |_______________| |
                                                |_______________|

    - This is the Strategy Pattern. Here's how it looks, with it's abstract class names, in GoF;

                ___________________            __________________
                |  Context        |            | Strategy       |
                |_________________|<>--------->|________________|
                |  - strategy     |            | execute(data): |
                |_________________|            |________________|
                | + setStrategy() |                   ^
                | + doSomething() |                   |
                |_________________|                   |
                                              _____________________
                                              |  ConcreteStrategy |
                                              |___________________|-|
                                              |  + execute(data): | |-|
                                              |___________________| | |
                                                |___________________| |
                                                  |___________________|


        - Difference between Strategy and State:
            - The two patterns are similar in practice, and the difference between them varies depending on who you ask. SOme popular choices are:
                - States store a reference to the contenxt objects that contains them. Strategies do not.
                - States are allowed to replace themselves (i.e; to change the state of the context object to something else) while Statergies are not
                - Strategies only handle a single, specific task, while States provide the underlaying implmentation for everything (or most) the content object does
            
    - When to use:
        - When you have a class with a large number of conditional statements that switch between variants of same the algorithm. The algorithm logic can be can be extracted into separate classes that implement the same interface. The context object then delegates the work to these classes, instead of implementing all the algorithms itself

    - Pros and Cons:
        + Satisfies open/closed principle: can add new strategies without modifying the context
        + Can swap algorithms used inside an object at runtime

        - Clients have to be aware of the different algorithms and select the appropriate one
        - If you only have a few algorithms that rarely change, then using the Stratergy Pattern may be over-engineering



 */

public class Notes {

}
