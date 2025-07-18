import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _08_SortingCustomObjects {

    public static void main(String[] args) {

        // Sorting Custom Objects
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(10, "Jarvis", 30, 4000));
        employees.add(new Employee(20, "Mary", 39, 3345));
        employees.add(new Employee(30, "Eunice", 23, 9890));
        employees.add(new Employee(40, "Wuod", 29, 1200));

        // Collections.sort(employees, new MySort_1()); // descending order with salary
        // Collections.sort(employees, new MySort_2()); // ascending order with salary

        // Collections.sort(employees, (arg0, arg1) -> (arg1.getAge() - arg0.getAge()));
        // descending order with age

        // Collections.sort(employees, (arg0, arg1) -> (arg0.getAge() - arg1.getAge()));
        // ascending order with age

        // Collections.sort(employees, (arg0, arg1) ->
        // (arg0.getName().compareTo(arg1.getName())));
        // // asscending order with name

        Collections.sort(employees, (arg0, arg1) -> (arg1.getName().compareTo(arg0.getName())));
        // descending order with name

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

class MySort_1 implements Comparator<Employee> {

    @Override
    public int compare(Employee arg0, Employee arg1) {
        return (int) (arg1.getSalary() - arg0.getSalary());
    }
}

class MySort_2 implements Comparator<Employee> {

    @Override
    public int compare(Employee arg0, Employee arg1) {
        return (int) (arg0.getSalary() - arg1.getSalary());
    }
}

class Employee {
    private int id;
    private String name;
    private int age;
    private long salary;

    public Employee(int id, String name, int age, long salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employees [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
    }
}