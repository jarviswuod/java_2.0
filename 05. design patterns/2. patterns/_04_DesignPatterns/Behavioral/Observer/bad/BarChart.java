package _04_DesignPatterns.Behavioral.Observer.bad;

import java.util.List;
import java.util.Map;

public class BarChart {

    public void render(List<Integer> values) {
        System.out.println("Rendering Barchart with new values");
    }

    public void render1(Map<City, Dog> values) {
        System.out.println("Rendering Barchart with new values");
    }
}

class City {
}

class Dog {
}