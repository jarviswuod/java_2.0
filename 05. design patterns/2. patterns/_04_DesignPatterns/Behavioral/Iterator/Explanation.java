package _04_DesignPatterns.Behavioral.Iterator;

/*

    NOTES:

    - CHALLENGE:
        - We can use the Iterator Pattern to ensure that changing the internals i.e, changing the list data structure doesn't affect consumers. We can add some methods to ShoppingList to allow iterating over a shopping list object, without knowing it's internals representation:

    - We have a ShoppingList class which stores a list of items, we have a push method to add items to the list, and a pop method to remove the last item from the list. and we ahve a getList() method which returns the whole shopping list. list The list is stored as an array internally

            public class ShoppingList {

                private List<String> list = new ArrayList<>();
                // private int[] list = new int[5];

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

    - CLient:
        - Lets model a client interaction with our ShoppingList
            - We are currently adding items to the list

                public class Main {
                    public static void main(String[] args) {

                    ShoppingList shoppingList = new ShoppingList();

                    shoppingList.push("Milk");
                    shoppingList.push("honey");
                    shoppingList.push("Tea");

                    ...
                    }
                }
                
            - We want to loop over each item in the shopping list and log each item
                    public class Main {
                        public static void main(String[] args) {

                            ShoppingList shoppingList = new ShoppingList();

                            shoppingList.push("Milk");
                            ...

                            for (int i = 0; i < shoppingList.getList().size(); i++) {
                                System.out.println(shoppingList.getList().get(i));
                            }
                        }
                    }
                    
                - Issue:
                    - Looks like we ahve a deent solution however as changing the internal of the objects(ShoppinList) will affect it's consumers i.e our client(in thi case main method).
                    - That is if we change the data strcuture(used to store the items) inside our shopping list from List to a normal array, then our client code will break because we are using List methods in the client code. It actaully causes an error because

                            public class ShoppingList {

                                // private List<String> list = new ArrayList<>();
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

                    - Now if we run the client code, it will cause an error because we are using List methods in the client code, but the internal representation of the list is now an array. Error:
                        - java: cannot find symbol
                        - symbol:   method size()
                        - location: class java.lang.String[]



    - SOLUTION: SHOPINGLIST USING THE ITERATOR PATTERN
        - We can use the Iterator Pattern to ensure that changing the internals i.e, changing the list data structure doesn't affect consumers. We can add some methods to ShoppingList to allow iterating without knowing it's internals representation

        - Iterator: Interface
            - First we create an Interface fot the Iterator, it has 3 methods:

                    public interface Iterator {

                        void next();
                        boolean hasNext();
                        String current(); // returns the current item in the loop
                    }

            - THe current method returns the current item in the loop, this is great because we are working with Strings in our shopping list, but if we were working with integers or any other object, we would have to change the return type of current() method. We can solve this by using Generics

                    public interface Iterator<T> {

                        void next();
                        boolean hasNext();
                        T current();
                    }


        - ShoppingList class:
            - THe next thing is to create our concrete iterator classes, we will create them as nested classes inside ShoppingList for simplicity
            - Why Nested classes?
                - Because these concrete classes are only concerned with iterating over ShoppingList, so it makes sense to nest them so that they can only be used to iterate over shoppping list  and not be used in other classes thorughout our codebase
                - FOr this reason we are also keeping them private, making tit invisible to all other classes

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

                - COde explanation
                    - We have  private ShoppingList shoppingList; becasue it's what we are looping over
                    - We have private int index; to keep track of the current position in the loop
                    - We have a constructor which takes in a ShoppingList object, so that we can access the list property of shopping list

                    - The current() method returns the current item in the list based on the psition of index
                    - The hasNext() method checks if there is another item in the list by comparing the index with the size of the list
                    - The next() method increments the index to move to the next item in the list by one

            - One more thing we need to do in our SHoppingList class is to create a method that returns an instance of the concrete iterator class
                - It has a return Type or Iterator which allows us to use multiple different types of concrete iterators and our client is not going to breat . It returns new ListItatoer and we pass in our current CLass SHoppingList

                    public class ShoppingList {

                        ...

                        public Iterator<String> createIterator() {
                            return new ListIterator(this);
                        }
                    }

        - Main class: CLient 
            - Now we can use this method in our client code to get an iterator and loop over the shopping list without knowing it's internal representation

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

            - THe advantage ot this is that you can safely change the data structure used in ShoppingList without breaking the client code
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

            - Now if we run the client code, it will work perfectly fine because we have updated the iterator methods to account for the new data structure
            - THis is because we are using the iterator methods to loop over the shopping list, and not directly accessing the list property of shopping list

 */

public class Explanation {

}
