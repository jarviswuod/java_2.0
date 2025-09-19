package _04_DesignPatterns.Behavioral.Observer.bad;

import java.util.ArrayList;
import java.util.List;

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

    public void addDependent(Object dependent) {
        dependents.add(dependent);
    }

    public void removeDependent(Object dependent) {
        dependents.remove(dependent);
    }
}
