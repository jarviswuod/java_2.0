package _04_DesignPatterns.Structural.Bridge;

/*

    NOTES:
    - The Bridge Pattern:
        - Is a structural design pattern that separates a large class, or a set of related classes into two separate hierarchies so that they can be developed independently from each other


    - CHALLENGE:
        - Say that we have a remote controlling a radio. There are multiple different brands of radio, and there are different types of remotes;
                                                   __________________
                                                   | Remote         |   Abstract class
                                                   |________________|
                                                           ^
                    _______________________________________|___________________________________
                    |Abstract class             |Abstract class       |Abstract class         |
                    |                           |                     |                       |
            __________________          ________________     __________________     ________________
            | AdvancedRemote |          | MegaRemote   |     | LGRemote       |     | SonyRemote   |
            |________________|          |______________|     |________________|     |______________|
                    ^                           ^
                    |                           |
             _______|_____________________      |________________________________________
             |                           |                  |                           |
            _|________________     ______|_________     ____|_____________     _________|______
            | AdvancedLG     |     | AdvancedSony |     | MegaLG         |     | MegaRemote   |
            |________________|     |______________|     |________________|     |______________|


        - With this design every time we add a new brand, e.g Samsung, we'd have to create three new classes: SamsungRemote, AdvancedSamsungRemote and MegaSamsungRemote. And if we create a new type of remote e.g. RadioAndTVRemote, then we'd have to create a new class for every brand, so RadioAndTVLG, RadioAndTVSamsung. This is not maintainable



    - SOLUTION 2: BRIDGE PATTERN;
        - The reason we ended up with this structure is because our hierarachy is growing in 2-dimensions; the abstract dimension (remote type) and an implementation dimension (the brand/device)

        - To simplify this hierarchy, we can break it down into two separate hierarchies;

            __________________    Device "Bridge"                   ________________
            | RemoteControl  |<>--------------------------------->  | Device       |
            |________________|                                      |______________|
            | turnOn()       |  device.turnOn()                     | turnOn()     |
            |________________|                                      |______________|
                    ^                                                       ^
                    |                                                       |
                ____|_______________________                    ____________|________
                |                          |                    |                   |
              __|_______________   ________|________     _______|_________   _______|_________
              | AdvancedRemote |   | MegaRemote    |     | LG            |   | Sony          |
              |________________|   |_______________|     |_______________|   |_______________|
              |                |   |               |     |               |   |               |
              |________________|   |_______________|     |_______________|   |_______________|

        - Whenever we have a hierarchy growing in two separate dimensions, we need to split them in half and connect then using bridge
        - The two hierarchies can now grow independently from each other

 */

public class Notes {

}
