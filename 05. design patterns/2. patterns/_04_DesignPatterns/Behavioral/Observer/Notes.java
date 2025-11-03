package _04_DesignPatterns.Behavioral.Observer;

/*

    NOTES:
    - Observer Pattern:
        - It involves an object know as the subject that maintains a list of it's dependent object called observers, and notifying them automatically of any state changes


    - CHALLENGE:
        - We have an excel doc with 2 spreadsheets
            - Spreedsheet 1:
                - In one spreedsheet we have a data source which is a list of city(on the left column) with number_of_dogs in that city(on the right column)
                - We also have a bar chart with dogs on the y-axis and the city name on the x-axis

            - Spreedsheet 2:
                - Here we have a sum, basically one of the cell is summing up the total number_of_dogs to get the total number of dogs in all the cities



    - SOLUTION 1:
        - Observers we have under the Datasource is the BarChart and Sheet2 (the one that sums up the number of dogs) all from the Datasource
        - We also have the values of the Datasource plus setters and getters for the values
                _________________             _____________
                | Datasource    |             | Sheet2    |
                |_______________|<>---------->|___________|
                | observers:    |             |           |
                | values:       |             |___________|
                |_______________|
                | getValues():  |             _____________
                | setValues():  |<>---------->| BarChart  |
                |_______________|             |___________|
                                              |           |
                                              |___________|


        - PROBLEM:
            - Tight coupling to concrete observers; this means that we need conditonals to check the object type before updating

            - SRP is violated: Datasource has two reponsilities;
                - Storing data and
                - Managing dependent observer objects

            - OCP: Every time we create a new Observer we have to modify DataScource. This is because we are programming to concrete objects rather than to a generic interface


        - HOW TO SOLVE FOR THEM:
            - To solve the SRP violation, we could create a separate class for managing the dependent observer objects
            - To solve the OCP violation, we can ensure that all observers objects(Sheet, BarChart) implement a common interface to that they provide consistent methods allowing us to use polymorphism in Datasource



    - SOLUTION 2: Observer Pattern;

                ______________________            _____________
                | Subject            |            | Observer  |
                |____________________|<>--------->|___________|
                | addObserver(obj):  |            | update()  |
                | rmvObserver(obj):  |            |___________|
                | notifyObserver():  |                   ^
                | getValues():       |                   |
                | setValues():       |                   |
                |____________________|            _______|_________
                          ^                       |               |
                          |               ________|______ ________|______
                          |               |  Sheet2     | |  BarChart   |
                          |               |_____________| |_____________|
                          |               |  update()   | |  update()   |
                          <>              |_____________| |_____________|
                  _________________
                  | DataSource    |
                  |_______________|
                  | values:       |
                  |_______________|
                  | getValues():  |
                  | setValues():  |
                  |_______________|


        - Above Sheet2 and BarChat implement a common interface, so Datasource can now talk to that one interface and not multiple concrete classes. We've also created a Subject class to provide the methods for managing observers

        - This follows the OCP as we can extend out application by adding new observer classes without having to modify Datasource

        - setValues(values) will loop through all of it's observers and call update() on each. This is polymorphic bevahior, a different update() method will be called depending on the observer but Datasource doesnot need to know what the specific concrete observers are. Each concrete implementation figures out how to update themselves



    - OBSERVER PATTERN UML: From GoF book:
        - The Observer Pattern is AKA the publisher and subscriber pattern: The Subject(publisher) publishes change in it's state and the subscribers(observers) subscriber to those events

                ___________________            ______________
                | Subject         |            | Observer   |
                |_________________|<>--------->|____________|
                | attach(obj):    |            | update()   |
                | detatch(obj):   |            |____________|
                | notify():       |                   ^
                |_________________|                   |
                           ^                          |
                           |                   ____________________
                           |                   | ConcreteObserver |
                ___________________            |__________________|-|
                | ConcreteSubject |            | update()         | |-|
                |_________________|            |__________________| | |
                |                 |              |__________________| |
                |_________________|                |__________________|



        - Communication Styles: PUSH STYLE;
            - Here, the observers get notified of a change, but they don't know what has changed. One solution it to add a parameter to the observer update() method. This is know as a 'push' style of communication as the Subject pushes the changes to the observers

                NOTES:
                    - Value is "published" to observer
                    - For flexiliblty 'value' could be any 'Object' or generic type

                ____________________            ______________
                | Subject          |            | Observer   |
                |__________________|<>--------->|____________|
                |                  |            | update()   |
                |__________________|            |____________|
                        ^                          ^
                        |                          |
                        |                          |
                ____________________            ____________________
                | ConcreteSubject  |            | ConcreteObserver |
                |__________________|            |__________________|
                |                  |            | update()         |
                |__________________|            |__________________|


            - The push style has the advantage that the Concrete observer doesn't depend on (has no knowledge or 'coupling' to) the concrete subject


            - Problem:
                - What if each observer needs a different set of values? This is where we could use a Pull style of commununication, where the observer stores a reference to the concrete subject then whenever it is notified of a change, it pulls, or queries, the data it needs from the concrete subject



        - Communication Styles: PULL STYLE;
            - NOTES:
                - Value is 'pulled' from concrete subject

                ___________________            _____________
                | Subject         |            | Observer  |
                |_________________|<>--------->|___________|
                |                 |            | update()  |
                |_________________|            |___________|
                        ^                           ^
                        |                           |
                        |                           |
                ___________________            ____________________
                | ConcreteSubject |            | ConcreteObserver |
                |_________________|<---------<>|__________________|
                | getValue()      |            |                  |
                |_________________|            |__________________|


            - The concrete observer stores a reference to the concrete subject. We give concrete subject a getValue() method, so a concrete observer can get the data it needs. This gives more fleibility; however, we have coupling between the concrete classes. But this is not a bad type of coupling
            - A bad coupling would be between ConcreteSubject and ConcreteObserver, because these observers could change in the future which may introduce more observers - and ConcreteSubject would have to keep reference to them all. We don't want to change our concrete subject class(DataSource in our example) every time there is a new observer

                - NOTE:
                    - In reality, we never have zero coupling in software. What matters is the direction of the relationship

            - With Pull style communication, we pass the concrete subject(dataSource) to the observer objects - just like we did when implemeneting the Observer pattern for our DataSouce with the BarChart and Sheet2 observers

 */

public class Notes {

}
