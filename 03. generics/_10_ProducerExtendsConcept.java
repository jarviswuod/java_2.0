import java.util.List;

public class _10_ProducerExtendsConcept {
    public static void main(String[] args) {
        List<Student> listOfStudents = List.of(new Student(), new Student());
        List<Employee> listOfEmployees = List.of(new Employee(), new Employee());

        sendEmail(listOfEmployees);
        System.out.println();
        sendEmail(listOfStudents);

    }

    public static void sendEmail(List<? extends Customer> customerList) {
        for (Customer customer : customerList) {
            customer.sendEmail();
        }
    }
}

class Customer {
    public void sendEmail() {
        System.out.println("Sending email");
    }
}

class Student extends Customer {
}

class Employee extends Customer {
}