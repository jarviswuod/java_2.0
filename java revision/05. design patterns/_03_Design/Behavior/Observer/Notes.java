package _03_Design.Behavior.Observer;

// import java.util.ArrayList;
// import java.util.List;

/*

    NOTES:
    - Is a behavioral pattern that defines a relationship between one class and several classes. Changes in that class is communicated and passed to the other classes

    - Key players:
        - Publisher:
            - Is a class that has reference to other objects and sends a communication when there is a change

        - Susbcriber:
            - Is a class that provides what other classes should implement in response to publishers communication

        - Concrete Susbcribers:
            - Is a class that implements a subcriber interface and receives communication from publisher


    // FIRST ATTEMPT::: ::: ::: :::

                    public class Notes {
                        public static void main(String[] args) {

                            Publisher publisher = new Publisher();

                            Sheet sheet = new Sheet(publisher);
                            Barchart barchart = new Barchart(publisher);

                            publisher.addToList(sheet);
                            publisher.addToList(barchart);

                            publisher.setIntList(List.of(21, 8));

                            publisher.removeToList(sheet);
                            publisher.setIntList(List.of(2, 8));

                            System.out.println();

                            publisher.setIntList(List.of(3, 8));

                        }
                    }

                    class Publisher {

                        private List<Integer> intList = new ArrayList<>();
                        private List<Subscriber> list = new ArrayList<>();

                        public void setIntList(List<Integer> intList) {
                            this.intList = intList;
                            notifySub();
                        }

                        public List<Integer> getIntList() {
                            return intList;

                        }

                        public void addToList(Subscriber subscriber) {
                            list.add(subscriber);
                        }

                        public void removeToList(Subscriber subscriber) {
                            list.remove(subscriber);
                        }

                        public void notifySub() {
                            for (Subscriber subscriber : list) {
                                subscriber.action();
                            }
                        }
                    }

                    abstract class Subscriber {

                        public abstract void action();
                    }

                    class Sheet extends Subscriber {

                        private Publisher publisher;

                        public Sheet(Publisher publisher) {
                            this.publisher = publisher;
                        }

                        @Override
                        public void action() {
                            System.out.println("Updated based on recent value updates");
                        }
                    }

                    class Barchart extends Subscriber {

                        private Publisher publisher;
                        private int total;

                        public int getTotal() {
                            return total;
                        }

                        public Barchart(Publisher publisher) {
                            this.publisher = publisher;
                        }

                        @Override
                        public void action() {
                            total = 0;
                            for (int int_ : publisher.getIntList()) {
                                total += int_;
                            }
                            System.out.println("Updated total to : " + total);
                        }
                    }


                
    // SECOND ATTEMPT::: ::: ::: :::
    - Observer pattern is a behavioral pattern that defines a one to many relationship. Modification in one class is automatically communicated and reflected in the other classes

    - 3 key players:
        - Publisher:
            - Is a class that contains reference to other classes and communicates to other classes when a change happens in it. It has a notify, attach and detach methods to help in communication

        - Subscriber:
            - Is a class that provides an skeleton for the concrete classes to implement changes that communicated by publisher

        - Concrete subscriber:
            - Is a class that receives communication from publisher and implements subscriber class

                public class Notes {
                    public static void main(String[] args) {

                        Datasource datasource = new Datasource();

                        Sheet sheet = new Sheet(datasource);
                        BarChart barChart = new BarChart(datasource);

                        datasource.addObs(barChart);
                        datasource.addObs(sheet);

                        datasource.setIntList(List.of(21, 34, 56));
                        System.out.println();
                        datasource.setIntList(List.of(21, 2));

                    }
                }

                class Publisher {

                    private List<Observer> observers = new ArrayList<>();

                    public List<Observer> getObservers() {
                        return observers;
                    }

                    public void setObservers(List<Observer> observers) {
                        this.observers = observers;
                    }

                    public void addObs(Observer observer) {
                        observers.add(observer);
                    }

                    public void removeObs(Observer observer) {
                        observers.remove(observer);
                    }

                    public void notifyObs() {
                        for (Observer observer : observers) {
                            observer.update();
                        }
                    }
                }

                class Datasource extends Publisher {

                    private List<Integer> intList = new ArrayList<>();

                    public List<Integer> getIntList() {
                        return intList;
                    }

                    public void setIntList(List<Integer> intList) {
                        this.intList = intList;
                        notifyObs();
                    }
                }

                interface Observer {

                    void update();
                }

                class Sheet implements Observer {
                    private Datasource datasource;
                    int total = 0;

                    public int getTotal() {
                        return total;
                    }

                    public Sheet(Datasource datasource) {
                        this.datasource = datasource;
                    }

                    @Override
                    public void update() {
                        total = 0;
                        for (int integer : datasource.getIntList()) {
                            total += integer;
                        }
                        System.out.println("Here with you'll loosers Sheet : " + total);
                    }
                }

                class BarChart implements Observer {
                    private Datasource datasource;

                    public BarChart(Datasource datasource) {
                        this.datasource = datasource;
                    }

                    @Override
                    public void update() {
                        datasource.hashCode();
                        System.out.println("Here with you'll loosers BarChart");
                    }
                }

 */

public class Notes {
}