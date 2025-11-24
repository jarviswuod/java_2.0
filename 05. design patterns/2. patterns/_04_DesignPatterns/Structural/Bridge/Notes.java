package _04_DesignPatterns.Structural.Bridge;

/*

    NOTES:
    - The Bridge Pattern:
        - Is a structural design pattern that separates abstraction from implementation allowing them to evolve independently
        - It decouples an abstractions interface from it's implementation allowing changes in one without affecting the other


    - CHALLENGE:
        - Say that we have a remote controlling a radio. There are multiple different brands of radio with different types of remotes:
                                                 __________________
                                                 |     Remote     | Abstract class
                                                 |________________|
                                                         ^
                        _________________________________|__________________________________
                        | Abstract class      | Abstract class        | Abstract class     |
                        |                     |                       |                    |
                __________________      _____________          ________________     ________________
                | AdvancedRemote |      | LGRemote  |          | MegaRemote   |     | SonyRemote   |
                |________________|      |___________|          |______________|     |______________|
                        ^                                             ^
                        |                                             |
                  ______|___________                          ________|________
                  |                |                          |               |  
            ______|_______   ______|_________             ____|_____   _______|______
            | AdvancedLG |   | AdvancedSony |             | MegaLG |   | MegaRemote |
            |____________|   |______________|             |________|   |____________|


        - With this design every time we add a new brand e.g Samsung we'd have to create three new classes SamsungRemote, AdvancedSamsungRemote and MegaSamsungRemote. And if we create a new type of remote e.g. RadioAndTVRemote then we'd have to create a new class for every brand RadioAndTVLG and RadioAndTVSamsung. This is not maintainable



    - SOLUTION 2: BRIDGE PATTERN;
        - The reason we ended up with this structure is because our hierarachy is growing in 2-dimensions i.e the abstract dimension (remote type) and an implementation dimension (the brand/device)

        - To simplify this hierarchy, we can break it down into two separate hierarchies:

                      __________________    Device "Bridge"        ________________
                      | RemoteControl  |<>-----------------------> | Device       |
                      |________________|                           |______________|
                      | turnOn()       |  device.turnOn()          | turnOn()     |
                      |________________|                           |______________|
                              ^                                           ^
                              |                                           |
                     _________|_____________                    __________|__________
                     |                     |                    |                   |
              _______|__________   ________|________     _______|_________   _______|_________
              | AdvancedRemote |   | MegaRemote    |     | LG            |   | Sony          |
              |________________|   |_______________|     |_______________|   |_______________|
              |                |   |               |     |               |   |               |
              |________________|   |_______________|     |_______________|   |_______________|

        - Whenever we have a hierarchy growing in two separate dimensions, we need to split them in half and connect then using bridge
        - The two hierarchies can now grow independently from each other

 */

public class Notes {

}
