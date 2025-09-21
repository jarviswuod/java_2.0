package _04_DesignPatterns.Behavioral.Observer;

/*

    - CODE EXPLANATION:

    - CHALLENGE:
        - We have an excel doc with 2 spreadsheets
            - Spreedsheet 1:
                - In one spreedsheet we have a data source which is a list of city(on the left column) with number_of_dogs in that city(on the right column)
                - We also have a bar chart with dogs on the y-axis and the city name on the x-axis

            - On spreedsheet 2:
                - Here we have a sum, basically one of the cell is summing up the total number_of_dogs to get the total number of dogs in all the cities


    - SOLUTION 1:
        - Sheet2 class:
            - It has 2 fields for storing total sum
            - It also has a getter which returns the total and a method for calculating total calculateTotal() which takes in a List and will;

                    public class Sheet2 {

                        private int total;

                        public int getTotal() {
                            return total;
                        }

                        public int calculateTotal(List<Integer> values) {
                            int sum = 0;

                            for (Integer value : values) {
                                sum += value;
                            }
                            System.out.println("Total : " + sum);
                            return sum;
                        }
                    }


        - BarChart class:
            - Here we have a single method called render() which takes in a list of values from the DataSource and then just logs some information for simplicity

                    public class BarChart {

                        public void render(List<Integer> values) {
                            System.out.println("Rendering Barchart with new values");
                        }
                    }


            - In a typical app we could be pass in a proper object with keys and values with City and NumberOfDogs, we are keeping it all simple



        - DataSource class:
            - Finally we create a DataSource class which stores a List of the dependent objects essentially, The Observers, that rely on the DataSource so that when the values in the DataSource are changed then DataSource can up date those dependent objects
            - We have a list of values Dogs in the cities typically
            - We also have a list of dependent objects for our Observer objects type, we call it dependents,,, We'll pass in any objects of either BarChart or Sheet2 that needs to be updated when the DataSource values change
            - We also need a getter for the values so that the other object can get the values. Then we need a setter method which takes in a List of Integers or whatnot

                    public class DataSource {

                        private List<Integer> values = new ArrayList<>();
                        private List<Object> dependents = new ArrayList<>();

                        public List<Integer> getValues() {
                            return values;
                        }

                        public void setValues(List<Integer> values) {
                            this.values = values;
                        }
                    }


            - Under the setter method whenever we updae the values we also need to notify the dependents object list (BarChart and Sheet2) so they can render themselves in the new values and recalculate the total if needed. Typically we loop through our dependent objects

                public class DataSource {

                    private List<Integer> values = new ArrayList<>();
                    private List<Object> dependents = new ArrayList<>();

                    public List<Integer> getValues() {
                        return values;
                    }

                    public void setValues(List<Integer> values) {
                        this.values = values;

                        for (Object object : dependents) {
                            if (object instanceof Sheet2) {
                                ((Sheet2) object).calculateTotal(values);
                            } else if (object instanceof BarChart) {
                                ((BarChart) object).render(values);
                            }
                        }
                    }

                    ...
                }

                - AI RECOMMENDATION:
                    - object.getClass() == Sheet2.class → checks if the object’s class is exactly Sheet2 (no subclasses)
                    - object instanceof Sheet2 → true if the object is Sheet2 or any subclass of Sheet2

                    - instanceof is preferred because:
                        - It’s clearer, more readable, and idiomatic in Java
                        - It supports polymorphism (works with subclasses)
                        - Avoids unnecessary object creation (new Sheet2().getClass() is wasteful)


            - We also need a way of adding dependents to our DataSource so we can control which objects are going to observe the DataSource for that we create addDependent() and removeDependent() methods

                public class DataSource {

                    public void addDependent(Object dependent) {
                        dependents.add(dependent);
                    }

                    public void removeDependent(Object dependent) {
                        dependents.remove(dependent);
                    }

                    ...
                }


        - Main class: Client class
            - We create a new DataSource object
            - Also create Sheet2 and BarChart observers

            - We know need to add the objects (Datasource and BarChart) observers
                    public class Main {
                        public static void main(String[] args) {

                            DataSource datasource = new DataSource();

                            Sheet2 sheet2 = new Sheet2();
                            BarChart barChart = new BarChart();

                            ...
                        }
                    }


            - Then we can set some values in the DataSource. It all works prefectly

                public class Main {
                    public static void main(String[] args) {

                        datasource.setValues(List.of(5, 4, 1, 10));
                        datasource.setValues(List.of(5, 2, 3, 4, 5));

                        ...
                    }
                }


        - Observations:
            - The solution works well but we are violation some SOLID principles
                - SRP coz DataSource class has 2 responsibilities; sorting managing data storage and managing the dependent observer objects too, hence 2 reasons to change
                - OCP coz every time we want to add a new observer object we have to modify DataSource and then update the conditionals too. This is because we are programming to concrete classes rather than to generic interface


    - Observer Pattern UML: PULL STYLE: 
        - Observer interface:
            - First we create an observer interface with a single method update()
                public interface Observer {

                    void update();
                }


        - Concrete observers:
            - BarChart class
                - It implements the Observer interface and sorts Datasource reference passing it to the constructor whenever we create a new BarChart

                - This is a solution compared to our previous way of passing the Datasource class into the render() method


                    public class BarChart implements Observer {

                        private DataSource dataSource;

                        public BarChart(DataSource dataSource) {
                            this.dataSource = dataSource;
                        }

                        @Override
                        public void update() {
                            System.out.println("Rendering Barchart with new values");
                        }
                    }


            - Sheet2 class:
                - Same case to BarChart, store reference to Datasouce and then pass it into other constructor and then call in the calculateTotal() method passing DataSource values

                    public class Sheet2 implements Observer {

                        private int total;
                        private DataSource dataSource;

                        public Sheet2(DataSource dataSource) {
                            this.dataSource = dataSource;
                        }

                        public int getTotal() {
                            return total;
                        }

                        @Override
                        public void update() {
                            total = calculateTotal(dataSource.getValues());
                        }

                        public int calculateTotal(List<Integer> values) {
                            int sum = 0;

                            for (Integer value : values) {
                                sum += value;
                            }
                            System.out.println("Total : " + sum);
                            return sum;
                        }
                    }


            - Subject class:
                - This is the class that manages the Observers
                - First we need a field to keep the list of Observer objects
                - Then we need to pass in our 3 methods for managing observers, i.e adding, removing, and notifying observers.
                - We notify observers in our DataSource list that our source object has changed
                    - NOTE: we loop in the Obervers object list and call the update() method

                        public class Subject {

                            private List<Observer> observers = new ArrayList<>();

                            public void addObserver(Observer observer) {
                                observers.add(observer);
                            }

                            public void removeObserver(Observer observer) {
                                observers.remove(observer);
                            }

                            public void notifyObservers() {
                                for (Observer observer : observers) {
                                    observer.update();
                                }
                            }
                        }


            - DataSource class:
                - We are refactoring our DataSource class,
                - First we are not longer managing our observers over here hence we can remove dependents list
                    - private List<Object> dependents = new ArrayList<>();

                - We clean up our setValues() method
                    - OLD::
                        public void setValues(List<Integer> values) {
                            this.values = values;

                            for (Object object : dependents) {
                                if (object instanceof Sheet2) {
                                    ((Sheet2) object).calculateTotal(values);
                                } else if (object instanceof BarChart) {
                                    ((BarChart) object).render(values);
                                }
                            }
                        }


                    - NEW::
                        public void setValues(List<Integer> values) {
                            this.values = values;

                            for (Object object : dependents) {
                                if (object instanceof Sheet2) {
                                    ((Sheet2) object).calculateTotal(values);
                                } else if (object instanceof BarChart) {
                                    ((BarChart) object).render(values);
                                }
                            }
                        }


            - Main class: Client class;
                - First we create an instances of DataSource
                - Then we create a list of observers, Sheet2 and BarChart, passing DataSource into the object
                        public class Main {
                            public static void main(String[] args) {

                                DataSource datasource = new DataSource();

                                Sheet2 sheet2 = new Sheet2(datasource);
                                BarChart barChart = new BarChart(datasource);

                                ...
                            }
                        }


                - Then we add our observers into the DataSource object
                        public class Main {
                            public static void main(String[] args) {

                                datasource.addObserver(barChart);
                                datasource.addObserver(sheet2);

                                ...
                            }
                        }


                - Now if we set values in the DataSource it should then notify our observer object and cause them to be update
                        public class Main {
                            public static void main(String[] args) {

                                datasource.setValues(List.of(5, 4, 1, 10));
                                datasource.setValues(List.of(5, 2, 3, 4, 5));

                                ...
                            }
                        }

            - Observation:
                - Our code all works perfectly

 */

public class Explanation {

}
