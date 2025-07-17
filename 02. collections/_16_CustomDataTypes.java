import java.util.HashMap;
import java.util.Map;

public class _16_CustomDataTypes {
    public static void main(String[] args) {

        // Creating a custom object in a HashMap
        Map<Integer, Employee> employeeMap = new HashMap<>();
        employeeMap.put(1, new Employee("John", "Doe", 50000));
        employeeMap.put(2, new Employee("Jane", "Smith", 60000));
        employeeMap.put(3, new Employee("Alice", "Johnson", 70000));

        // iterating over the map
        employeeMap.forEach((id, employee) -> {
            System.out.println("ID: " + id + ", Employee: " + employee);
        });

        // displaying the map values
        System.out.println("Employee Map: " + employeeMap.values());

    }
}

class Employee {
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(String firstName, String lastName, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + "]";
    }

}