package _01_soliddesignpattern.openclosed;

/*

    NOTES:
    - Whatever happened here is creating of a new interface called Operation and this inteface has perform() method which takes 2 numbers
    - This operation will be implemented by any concrete class we want, AddOperation and SubtractOperation. So we override the perform method we had and we either add, substract based on the class we have
    - If we now see the Calculate class, things are simple as we define a method 'calculateNumber' that takes 2 numbers and operation interface we defined to do whatever operation we call. THe operation is based and then operation.perform methos is called, whenever we will be passing the addOperation, addition will happnen, whenever we pass the pass the dubstraction, substraction will happen and if we want to introduce a new operation like division or multiplication, we can just implenent the Operation class we created and override the perform method then write a custom logic we want
    - This way we are not allowing to modify the existing method, instead we extend the fuctionalities
    - THis is how we should always this about this principle should act in our projects as well

 */

public class GoodCalculator {
    public int calculateNumber(int number1, int number2, Operation operation) {
        return operation.perform(number1, number2);
    }
}
