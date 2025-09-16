package _04_DesignPatterns.Behavioral.Observer.good;

import java.util.ArrayList;
import java.util.List;

public class DataSource extends Subject {

    private List<Integer> values = new ArrayList<>();

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
        notifyObservers();
    }
}
