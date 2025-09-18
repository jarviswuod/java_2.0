package _04_DesignPatterns.Behavioral.Strategy;

/*

    NOTES:
    - Strategy Pattern:
      - Used to pass different algorithms, or behaviours, to an object


    - CHALLENGE:
        - Let's consider an application that stores videos. Before storing a video, the video needs to be compressed using a specific compression algorithm, such as MOV or MP4, then, if necessary, apply an overlay of say black and white or blur to the video


    - BAD SOLUTION: Conditional If else;
        - We handle the issue by creating a VideoStorage class with if/else statement checking for enums both for Compressors and Overlays available



    - GOOD SOLUTION: Strategy Pattern
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



    - STRATEGY PATTERN UML: From GoF book:

                _________________            __________________
                | Context       |            | Strategy       |
                |_______________|<>--------->|________________|
                | strategy      |            | execute(data): |
                |_______________|            |________________|
                | setStrategy() |                   ^
                | doSomething() |                   |
                |_______________|                   |
                                              _____________________
                                              |  ConcreteStrategy |
                                              |___________________|-|
                                              |  + execute(data): | |-|
                                              |___________________| | |
                                                |___________________| |
                                                  |___________________|


    - Difference between Strategy and State:
        - The two patterns are similar in practice, and the difference between them varies depending on who you ask. Some popular choices are:
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
