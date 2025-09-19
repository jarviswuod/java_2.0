package _04_DesignPatterns.Behavioral.Observer;

/*

    NOTES:
    - Observer Pattern:
        - It involves an object know as the sbuject, maintainin a list of its dependent objcers calles observers and notifying them automatically of any state changes


    - Situation:
        - We have an excel doc with 2 spreadsheets
        - Spreedsheet 1:
            - In one spreedsheet we have a datat source which is a list of city(on the left column) with number of dogs in that city(on the right column)
            - We also have a bar chart with dogs on the y-axis and the city name on the x-axis

        - On spreedsheet 2:
            - Here we have a sum, basiclly one of the cell is summing up the total number of dogs to get the total number of dogs in all the cities
    

    - SOLUTION 1:
        - observers we have under the data source is the barChart and Sheet2 (the one that sums up the number of dogs) all from the datasource
        - we also have the values of the data soruce and the setters and getters for the datasource
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
            - TIght coupling to concrete observers means that we need considitonals to check the objcer type before updating

            - SRP is violated: Datasource has twi reponsilities, storing data and managing dependent, observer objects
            - OCP: Every time we create a new Observer, we have to modify DataScource, This is because we are programming to concrete objects rather than to a generic interface


        - HOW TO SOLVE FOR THEM:
            - TO solve the SRP violatin, we could create a separate class for managing the dependt observer objects
            - To solve teh OCP violation, we can ensure that all observers objects(SHeet, BarChart) implement a common interface to that thy provide consistent methods allowing us to use polymorphism in DataSource


    - SOLUTION 2: Observer Pattern

                ______________________            _____________
                | Subject            |            | Observer  |
                |____________________|<>--------->|___________|
                | addObserver(obj):  |            | update()  |
                | rmvObserver(obj):  |            |___________|
                | notifyObserver():  |                   ^
                | getValues():       |                   |
                | setValues():       |                   |
                |____________________|            _______|____________
                            ^                     |                   |
                            |             ________|______     ________|______
                            |             |  Sheet2     |     |  BarChart   |
                            |             |_____________|     |_____________|
                            |             |  update()   |     |  update()   |
                            <>            |_____________|     |_____________|
                    _________________
                    | DataSource    |
                    |_______________|
                    | values:       |
                    |_______________|
                    | getValues():  |
                    | setValues():  |
                    |_______________|


        - Above Sheet2 and BarChat implement a common interface, so DataSOurce can now talk to that one interface and not multiple concrete classes. We've also created a Subject class to provide the methods for managing observers

        - This follows the Open-closed SOLID principle as we can extend out application by adding new observer classes without havint to modigy DataSource

        - setValues(values) will loop through all of its observers and call update() on each. This is polymorhism bevahior, a different update() methos wil be callsed depending on the observer but DataScource doesnot need to know what the specific concrete observers are. Each concrete implementation figures our how to update themselves



    - Observer Pattern UML:
        - The Observer Pattern is AKA the pub and subscriber pattern: the subject (publisher) publishes changes in it's state and the subscribers(observers) subscriber to those events

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
                           |                   |__________________|-|
                ___________________            | update()         | |-|
                | ConcreteSubject |            |__________________| | |
                |_________________|              |__________________| |
                |                 |                |__________________|
                |_________________|



    - Communucation Styles:
        - PUSH STYLE:
            - Above, the observers get notified of a change, but they dont know what has changes One solution it to add a parameter to the observer update() method. This is know as a 'push' style of communication as the Subject pushes the changes to the observers

                NOTES:
                    - Value is "published" to observer

                ____________________            ______________
                | Subject          |            | Observer   |
                |__________________|<>--------->|____________|
                |                  |            | update()   |
                |__________________|            |____________|
                           ^                          ^
                           |                          |
                           |                          |
                           |                          |
                ____________________            ____________________
                | ConcreteSubject  |            | ConcreteObserver |
                |__________________|            |__________________|
                |                  |            | update()         |
                |__________________|            |__________________|

            - For flexiliblty 'value' could be any 'Object' or generic type

            - The push style has the advantage that the Concrete observer doesn't depend on (has no knowledge or 'coupling' to) the concrete subject

            - Problem: What if each observer needs a different set of values? This is where we could use a Pull style of communuication, where the obserer stores a reference to the concrete subject then whenever it is notified of a change, it pulls, or queries, the data it needs from the concrete subject


        - PULL STYLE:
            - NOTES:
                - Value is 'pulled' from concrete subject

                ___________________            _____________
                | Subject         |            | Observer  |
                |_________________|<>--------->|___________|
                |                 |            | update()  |
                |_________________|            |___________|
                           ^                         ^
                           |                         |
                           |                         |
                           |                         |
                ___________________            ____________________
                | ConcreteSubject |            | ConcreteObserver |
                |_________________|<---------<>|__________________|
                | getValue()      |            |                  |
                |_________________|            |__________________|


            - The concrete observer stores a reference to the concrete subject. We give concrete subject a getValue() method, so a concrete observer can get the data it needs. This gives more fleibility; however, we have coupling between the concrete classes. But this is not a bad type of coupling. 
            - A bad coupling would be between COncreteSubject and ConcreteObserver, because these observers could change in the future which may introduce more observers - and COncreteSUbject would have to keep reference to them all. We dont wanto to change our concrete subject class( DataSource in our example) every time there is a new observer

            - NOTE:
                - In reality , we never have zero coupling in cosftware. WHat matters is the direction of the relationship

            - With Pull style commincation, we pass the conrete subject(dataSOurce ) to the observer objects- just like we did when implmeneting the Observer pattern for our DataSrouce with the BarChat and Sheet2 observers


 */

public class Notes {

}
