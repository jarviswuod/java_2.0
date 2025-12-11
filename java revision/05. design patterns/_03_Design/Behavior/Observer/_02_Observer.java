package _03_Design.Behavior.Observer;

import java.util.ArrayList;
import java.util.List;

/*

    NOTES:
    - Is a behavioral pattern that defines a one to many relationship between objects where changes in one object is directly reflected in other objects
    - Key players:
        - Publisher
        - Subscriber interface
        - Concrete Subscriber

    - Example:
        - SpreadSheet and BarChart

*/

public class _02_Observer {
    public static void main(String[] args) {

        _02_Chart chart = new _02_Chart(List.of(12, 34, 1, 9));

        chart.add(new _02_BarChart(chart));
        chart.add(new _02_CleanNums(chart));

        chart.notifyAllsubs();

        System.out.println();
        chart.setIntegers(List.of(1, 3, 2, 8));

    }
}

class _02_Publisher {

    private List<_02_Subsriber> subsribers = new ArrayList<>();

    public void add(_02_Subsriber sub) {
        subsribers.add(sub);
    }

    public void remove(_02_Subsriber sub) {
        subsribers.remove(sub);
    }

    public void notifyAllsubs() {

        for (_02_Subsriber sub : subsribers) {
            sub.change();
        }
    }
}

class _02_Chart extends _02_Publisher {

    private List<Integer> integers;

    public _02_Chart(List<Integer> integers) {
        this.integers = integers;
    }

    public void setIntegers(List<Integer> integers) {
        this.integers = integers;
        notifyAllsubs();
    }

    public List<Integer> getIntegers() {
        return integers;
    }
}

interface _02_Subsriber {

    void change();
}

class _02_BarChart implements _02_Subsriber {

    private _02_Chart chart;

    public _02_BarChart(_02_Chart chart) {
        this.chart = chart;
    }

    @Override
    public void change() {
        System.out.println("Changes happened here due to change");
    }
}

class _02_CleanNums implements _02_Subsriber {

    private _02_Chart chart;

    public _02_CleanNums(_02_Chart chart) {
        this.chart = chart;
    }

    @Override
    public void change() {
        int total = 0;

        for (int value : chart.getIntegers()) {
            total += value;
        }

        System.out.println("Changes happened " + total);
    }
}