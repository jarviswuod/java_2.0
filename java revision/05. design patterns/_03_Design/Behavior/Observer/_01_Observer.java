package _03_Design.Behavior.Observer;

import java.util.ArrayList;
import java.util.List;

/*

    NOTES:
    - Is a behavioral design pattern that introduces a one to many relationship, where one objects's internal state changes is communicated and reflected in other objects
    - Key players:
        - Publisher
        - Subscriber
        - Concrete subsribers

    - Example:
        - Barchart

*/

public class _01_Observer {
    public static void main(String[] args) {

        _Datasource datasource = new _Datasource();
        _BarChart barchart = new _BarChart(datasource);
        _BarChart2 barchart1 = new _BarChart2(datasource);

        datasource.add(barchart);
        datasource.add(barchart1);

        datasource.setValues(List.of(1, 2, 3));
        datasource.setValues(List.of(10, 20, 30));

        datasource.remove(barchart);
        datasource.setValues(List.of(11, 22, 33));
    }
}

class _Publisher {

    List<_Subscriber> subsribers = new ArrayList<>();

    public void add(_Subscriber subscriber) {
        subsribers.add(subscriber);
    }

    public void remove(_Subscriber subscriber) {
        subsribers.remove(subscriber);
    }

    public void notifyObs() {
        for (_Subscriber subscriber : subsribers) {
            subscriber.update();
        }
    }
}

class _Datasource extends _Publisher {

    private List<Integer> values = new ArrayList<>();

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
        notifyObs();
    }
}

interface _Subscriber {
    void update();
}

class _BarChart implements _Subscriber {

    private _Datasource datasource;

    public _BarChart(_Datasource datasource) {
        this.datasource = datasource;
    }

    @Override
    public void update() {
        System.out.println("Changes made freshed Barchat");
    }
}

class _BarChart2 implements _Subscriber {

    private _Datasource datasource;

    public _BarChart2(_Datasource datasource) {
        this.datasource = datasource;
    }

    @Override
    public void update() {

        int total = 0;

        for (int value : datasource.getValues()) {
            total += value;
        }
        System.out.println("Changes made " + total);
    }
}
