package _04_DesignPatterns.Behavioral.Observer;

/*

    NOTES:

    - SOLUTION 1:
        - Sheet2 class:
            - it has 2 fields for storing total
            - It also has a getter which returns the total and a method for calculating total calculateTOtal() which takes in a list of integers and will
                - It tracks the sum in int called sum
                -  loop through each value adding it to the sumvaraible and then returning that sum

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
            - here we have a single method called render() which takes in a list of values from the data srouce and then just logg some imformation for simplicity
                    public class BarChart {

                        public void render(List<Integer> values) {
                            System.out.println("Rendering Barchart with new values");
                        }
                    }
                    
            - In a typical app we could be pass in a proper object with keys and values with City and NumberOfDogs, we are keeping it all simple



        - DataSource class:
            - FInally we create a data srouce class which stores a list of the dependt objects essentially(The Observers) that rely on the data source so that when thy values in teh data soruce are changed the data soruce can up date those dependt objects

            - We have a list of values Dogs in the cities typically
            - we also have a list of dependt objects or our Observer objects type, we call it dependents,,, we will pass in any objects of either BarChart or Sheet2 that needs to be updated when the data srouce values have changed
            - We also need a getter for thevalues so that the other objects can get the values
                            - THen we need a setter method which takes in a list of Integers or whatnot 
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

            - Under the setter method whenever we updae the values we also need to notify the dependents objset list (BarChart and Sheet2) so they can render themselves in the new values and recalculate the total if needed... TYpically we loop throug our dependent objects


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

                AI RECOMMENDATION:
                    - object.getClass() == Sheet2.class → checks if the object’s class is exactly Sheet2 (no subclasses)
                    - object instanceof Sheet2 → true if the object is Sheet2 or any subclass of Sheet2

                    - instanceof is preferred because:
                        - It’s clearer, more readable, and idiomatic in Java
                        - It supports polymorphism (works with subclasses)
                        - Avoids unnecessary object creation (new Sheet2().getClass() is wasteful)

            - We also need a way of adding dependts to our data source so we can control which objcers are going to observe the data source for that we create addDepndent() and removeDependent() methods
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
            - We create ta new datarouce object
            - also create Sheet2 and BarChart objservers 

            - We know need to add the objects (Datasource and BarChart) observers
                public class Main {
                    public static void main(String[] args) {

                        DataSource datasource = new DataSource();

                        Sheet2 sheet2 = new Sheet2();
                        BarChart barChart = new BarChart();

                        ...
                    }
                }

            - THen we can set some values in teh data sorce
                - It all workd prefectly
                public class Main {
                    public static void main(String[] args) {

                        datasource.setValues(List.of(5, 4, 1, 10));
                        datasource.setValues(List.of(5, 2, 3, 4, 5));

                        ...
                    }
                }

        - Observations:
            - THe solutions works well but we are violation some SOLID principles
                - SRP cos DataSource class has 2 responsibilities ; sotring data/managing data storage then it's also  manadgint the depdents observer objects, hence 2 reasons to change
                - O/C principe,,  coz every time we want to add a new observer object we ahve to modify  datasoruce and then update the conditionals too
                    - This is becasue we are programming to concrete classes rather than to generic interface


    - Observer Pattern UML:
        - PULL STYLE:
            - Observer interface:
                - First we create an observer interface with a single methos update()
                    public interface Observer {

                        void update();
                    }

            - COncrete observers
                - BarChart class;
                    - It implements the Observer interface and sotres Datasource reference passing it to the constructor whwenever we create a new BarChart

                    - THis is a soluion compared to our previous way of passing the Datasource class into the render() method


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

                - Sheet2 class
                    - Same case to BarChart, store reference to  Datasouce and then pass it int othe constructor and then call in the CalculateTOtal() method passing datasrouce values

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

                - SUbject class: 
                    - THis is class that manages the Observers
                    - Frist we need a field to keep the list or Observer objects 
                    - then we need to pass in our 3 methods for managing observers, i.e adding observers, removing obsers and notifying all observers in the list that our source object has changed
                        - NOTE: we loop in teh Obervers object list and call the update() method
                        

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



                - Datasource class:
                    - We are refactoring our DataSrouce class,
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
                    - FIrst we create instnaces of DataSource()
                    - THen we need to create a list of observers
                        - SHeet2 and BarChart passing Datasource into the object

                            public class Main {
                                public static void main(String[] args) {

                                    DataSource datasource = new DataSource();

                                    Sheet2 sheet2 = new Sheet2(datasource);
                                    BarChart barChart = new BarChart(datasource);

                                    ...
                                }
                            }

                    - THen we add our observers into the datasource object

                            public class Main {
                                public static void main(String[] args) {

                                    datasource.addObserver(barChart);
                                    datasource.addObserver(sheet2);

                                    ...
                                }
                            }


                    - Now if we set values in the datasource it should then notify  our observer object and cause them to be updated

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
