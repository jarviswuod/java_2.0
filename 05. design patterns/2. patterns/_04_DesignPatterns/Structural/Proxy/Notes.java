package _04_DesignPatterns.Structural.Proxy;

/*

    NOTES:
    - The Proxy Pattern:
        - Is a structural design pattern that provides an object to control access to another object
        - It acts as an intermediary allowing you to add additional functionality or control to the original object without modifying it's code
        - They are commonly used for various aspects including caching, logging, lazy loading, access control, resources management and delaying object creation

              ______________        ______________        ______________
              | Client     |------->| Proxy      |------->| Target     |
              |____________|        |____________|        |____________|



    - CHALLENGE:
        - Let's say that we have an application that fetched a list of youtube videos from Youtube's API, and displays them in a list. In our application we are using the 3rd party youtube package to handle fetching youtube videos from the API, and then rendering the video on the screen with the video controls
        - The problem is that every time a request is made in our application, our server has to re-download the video from the YouTube API. This takes a long time especially if lots of requests are made to our application at once


    - SOLUTION 1
        - 


    - SOLUTION 2: PROXY PATTERN;
        - The problem with our first solution is that the YoutubeVideo class is from a third-party library, so we are unable to modify it's code. The solution is to use a proxy object

                                      Lazy Loading
              ______________        ______________        ____________________
              | VideoList  |------->| VideoProxy |------->| ThirdPartyVideo  |
              |____________|        |____________|        |__________________|



        - Our VideoList object will now talk to VideoProxy objects

              ______________                _________________
              | VideoList  |--------------> | Video         |
              |____________|                |_______________|
              | add(video) |                | render()      |
              |____________|                |_______________|
                                                    ^
                                                    |
                                          __________|_______________
                                          |                         |
                              ____________|_______           _______|______
                              | ThirdPartyVideo  |<--------<>| VideoProxy |
                              |__________________|           |____________|      if(video == null)
                              | render()         |           |  render()  |          video = new Video();
                              |__________________|           |____________|          video.render();



            - The above UML shows that our VideoProxy object will implement the third-party libraries Video interface, meaning that we can add these video proxy objects to our VideoList and VideoList won't care whether it's a ThirPartyVideo or a VideoProxy, as long as it's a Video

              ______________              _________________
              | Client     |------------> | Subject       |
              |____________|              |_______________|
              |            |              | request()     |
              |____________|              |_______________|
                                                  ^
                                                  |
                                        __________|_______________
                                        |                         |
                            ____________|_______           _______|______
                            | RealSubject      |<--------<>| Proxy      |
                            |__________________|           |____________|
                            | request()        |           |  request() |     realSubject.request()
                            |__________________|           |____________|

 */

public class Notes {

}
