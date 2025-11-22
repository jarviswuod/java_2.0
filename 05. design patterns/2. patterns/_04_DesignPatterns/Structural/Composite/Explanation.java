package _04_DesignPatterns.Structural.Composite;

/*

    CODE EXPLANATION:

    - CHALLENGE:
        - Let's say that we get Amazon deliveries of a large packages containing multiple items and it's needed of us to find the total price of items within any package. How would we solve for it?



    - SOLUTION 1: Array Loop;
        - Creating an array of boxes and items, then loop through them recursively to find total price of the package


        - Item classes:
            - These are basic classes with a price field on them

            - Keyboard class:
                    public class Keyboard {

                        public double price = 40.00;
                    }


            - Mouse class:
                    public class Mouse {

                        public double price = 18.00;
                    }


            - Microphone class:
                    public class Microphone {

                        public double price = 29.99;
                    }



        - Box class:
            - We have a List field taking in any object we pass to it
            - We have add() method for adding objects to the List field
            - We have calculateTotalPrice() method with a totalPrice field set to zero. It loops through items within the List checking the type of object the item is. Cast the item to a relevant "Item" Object then accesses it's price. If the item is a Box we cast the item to a Box object calling calculateTotalPrice() method recursively. Finally, we return the totalPrice of the items

            - ISSUE & OBSERVATION:
                - This method is not efficient as we have to check the type of the object and then cast the object to that type to able to access that objct's fields
                - The more items we add the more bloated this method will grow plus it's violating the OCP


                    public class Box {

                        private List<Object> items = new ArrayList<>();

                        public void add(Object item) {
                            items.add(item);
                        }

                        public double calculateTotalPrice() {

                            double totalPrice = 0;

                            for (Object item : items) {
                                if (item instanceof Keyboard) {
                                    totalPrice += ((Keyboard) item).price;
                                } else if (item instanceof Mouse) {
                                    totalPrice += ((Mouse) item).price;
                                } else if (item instanceof Microphone) {
                                    totalPrice += ((Microphone) item).price;
                                } else if (item instanceof Box) {
                                    totalPrice += ((Box) item).calculateTotalPrice(); // calls calculateTotalPrice() recursively
                                }
                            }

                            return totalPrice;
                        }
                    }



        - Main class: Client class;

                public class Main {
                    public static void main(String[] args) {

                        // The big package to deliver, containing box1 and box2
                        Box packageBox = new Box();

                        // box1 contains a microphone
                        Box box1 = new Box();
                        box1.add(new Microphone());
                        
                        // box2 contains box3 and box4
                        Box box2 = new Box();
                        
                        // box3 contains a mouse
                        Box box3 = new Box();
                        box3.add(new Mouse());
                        
                        // box4 contains a keyboard
                        Box box4 = new Box();
                        box4.add(new Keyboard());

                        box2.add(box3);
                        box2.add(box4);

                        packageBox.add(box1);
                        packageBox.add(box2);

                        System.out.println("Total price of package : " + packageBox.calculateTotalPrice());
                    }
                }


                        
    - SOLUTION 2 COMPOSITE PATTERN:
        - Item interface:
            - First we create an interface called Item having a single method getPrice() which returns a double
                    public interface Item {

                        double getPrice();
                    }


        - Concrete classes:
            - Keyboard class:
                - Each class implements Item interface and overrides the getPrice() method
                - Each class has a field to store it's price and it's returned inside the getPrice() method

                        public class Keyboard implements Item {

                            public double price = 40.00;

                            @Override
                            public double getPrice() {
                                return price;
                            }
                        }

            - Mouse class:
            - Microphone class:
                - Same concept applies to all other classes



        - Box class:
            - This class not only implements the Item interface but also stores a group of items
            - It has a field for storing a List of items 'items'
            - It also has add() method for adding items to the List
            - We then implement the getPrice() looping through the items List summing it to the "totalPrice" variable by calling .getPrice() method on the item. i.e item.getPrice(). Since all items are implementing the Item interface we nolonger need to check the type of item object. We simply treat them as items because we using polymorphism which takes many forms

                    public class Box implements Item {

                        private List<Item> items = new ArrayList<>();

                        public void add(Item item) {
                            items.add(item);
                        }

                        public double getPrice() {

                            double totalPrice = 0;
                            for (Item item : items) {
                                totalPrice += item.getPrice();
                            }
                            return totalPrice;
                        }
                    }



        - Main class: Client class;
            - The same code as we had previously (In the bad code)

        - OBSERVATION:
            - There is no change in how the client uses the solution as compraed to before(Bad VS good) and biggest changes is in the way we calculate the price using the getPrice() method since we treat all the items in the box the same way as they implement Item interface hence no conditionals to check each type of item which satisfies the OCP

 */

public class Explanation {

}