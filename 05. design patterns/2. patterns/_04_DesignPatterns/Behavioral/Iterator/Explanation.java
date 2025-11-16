package _04_DesignPatterns.Behavioral.Iterator;

/*

    - CODE EXPLANATION:

    - CHALLENGE:
        - We have a ShoppingList class which stores a list of items, we have a push() method to add items to the list, pop() method to remove the last item from the list and getList() method which returns the whole shopping list. The list is utelizing an ArrayList to store the items

            public class ShoppingList {

                private List<String> list = new ArrayList<>();

                public void push(String itemName) {
                    list.add(itemName);
                }

                public String pop() {
                    return list.remove(list.size() - 1);
                }

                public List<String> getList() {
                    return list;
                }
            }

        - How can we iterate over the ShoppingList object, without knowing the internal representation of the list?


    - SOLUTION 1:
        - Client class:
            - Let's model a client interaction with our ShoppingList
                - We are currently adding items to the list
                - We want to loop over each item in the shopping list and log each item

                        public class Main {
                            public static void main(String[] args) {

                                ShoppingList shoppingList = new ShoppingList();

                                shoppingList.push("Milk");
                                shoppingList.push("honey");
                                shoppingList.push("Tea");

                                for (int i = 0; i < shoppingList.getList().size(); i++) {
                                    System.out.println(shoppingList.getList().get(i));
                                }
                            }
                        }

                        
            - Issue:
                - Looks like we have a decent solution however changing the internal of the objects(ShoppinList) will affect it's consumers i.e our Client(Main class). i.e If we change the data structure(used to store the items) inside our shopping list from an ArrayList to a normal array our client code will break because we will still be using ArrayList methods in the client code which causes an error


        - ShoppingList class: DEMO purpose;
                public class ShoppingList {

                    private String[] list = new String[5];
                    int index = 0;

                    public void push(String itemName) {
                        list[index++] = itemName;
                    }

                    public String pop() {
                        if (index <= 0) {
                            return null;
                        }
                        return list[index--];
                    }

                    public String[] getList() {
                        return list;
                    }
                }


            - Now if we run the client code, it will cause an error because we are using List methods in the client code, but the internal representation of the list is now an array. Errors arising:
                - java: cannot find symbol
                - symbol:   method size()
                - location: class java.lang.String[]



    - SOLUTION 2: ITERATOR PATTERN
        - We can use the Iterator Pattern to ensure that changing the internals (list data structure) doesn't affect consumers. We can add some methods to ShoppingList to allow iteration

        - Iterator: Interface
            - First we create an Interface for the Iterator, it has 3 methods:

                    public interface Iterator {

                        void next();
                        boolean hasNext();
                        String current(); // returns the current item in the loop
                    }


            - current() method returns current items in the loop, this is great as we are working with String objects in our Shopping list [private List<String> list = new ArrayList<>()]. If we change to working with integer values or any other object, it would result to change in the return type of current() method. We can solve this by using Generics

                    public interface Iterator<T> {

                        void next();
                        boolean hasNext();
                        T current();
                    }


        - ShoppingList class:
            - The next thing is creating concrete iterator classes, we will create them as nested classes inside ShoppingList
                - Why Nested classes?
                    - Because these concrete classes are only concerned with iterating over ShoppingList, so it makes sense to nest them so that they can only be used to iterate over shoppping list and not be used in other classes throughout our codebase

            - We also make them invisible to all other classes by keeping them private

                    public class ShoppingList {

                        ...

                        private class ListIterator implements Iterator<String> {

                            private ShoppingList shoppingList;

                            private int index;

                            public ListIterator(ShoppingList shoppingList) {
                                this.shoppingList = shoppingList;
                            }

                            @Override
                            public void next() {
                                index++;
                            }

                            @Override
                            public boolean hasNext() {
                                return index < shoppingList.list.size();
                            }

                            @Override
                            public String current() {
                                return shoppingList.list.get(index);
                            }
                        }
                    }

                - We have;
                    - private ShoppingList shoppingList; because it's what we are looping over
                    - private int index; to keep track of the current position in the loop
                    - Constructor which takes in a ShoppingList object, so that we can access the list property of shopping list

                    - Methods;
                        - current() method to return the current item in the list based on indexes position
                        - hasNext() method to check if there is another item in the list by comparing the index with the size of the list
                        - next() method to increment the index to move to the next item in the list by one


            - One more thing we need to do in our ShoppingList class is to create a method that returns an instance of the concrete iterator class
                - It has a return type of Iterator which allows use of multiple concrete iterators
                - It returns new ListIterator and we pass in our current ShoppingList class

                    public class ShoppingList {

                        ...

                        public Iterator<String> createIterator() {
                            return new ListIterator(this);
                        }
                    }



        - Main class: Client 
            - Now we can use this method in our client code to get an iterator and loop over the ShoppingList without ever knowing it's internal representation
                public class Main {
                    public static void main(String[] args) {

                        ShoppingList shoppingList = new ShoppingList();

                        shoppingList.push("Milk");
                        shoppingList.push("honey");
                        shoppingList.push("Tea");

                        Iterator<String> list = shoppingList.createIterator();

                        while(list.hasNext()) {
                            String current = list.current();
                            System.out.println(current);
                            list.next();
                        }
                    }
                }


        - The advantage of this is that you can safely change the data structure used in ShoppingList without breaking the client code
            - For example if we change the internal representation of the list to an array, we just have to update the iterator methods to account for the new data structure

                    public class ShoppingList {

                        private String[] list = new String[5];
                        int index = 0;

                        public void push(String itemName) {
                            list[index++] = itemName;
                        }

                        public String pop() {
                            if (index <= 0) {
                                return null;
                            }
                            return list[index--];
                        }

                        public String[] getList() {
                            return list;
                        }

                        public Iterator<String> createIterator() {
                            return new ListIterator(this);
                        }

                        private class ListIterator implements Iterator<String> {

                            private ShoppingList shoppingList;

                            private int index;

                            public ListIterator(ShoppingList shoppingList) {
                                this.shoppingList = shoppingList;
                            }

                            @Override
                            public void next() {
                                index++;
                            }

                            @Override
                            public boolean hasNext() {
                                return index < shoppingList.index;

                            }

                            @Override
                            public String current() {
                                return shoppingList.list[index];
                            }
                        }
                    }

    - Observation:
        - Now if we run the client code, it will work perfectly fine because we have updated the iterator methods to account for the new data structure. This is because we are using the iterator methods to loop over the shopping list, and not directly accessing the list property of ShoppingList

 */

public class Explanation {

}
