package _03_Design.Behavior.Visitor;

import java.util.List;

/*

    NOTES:
    - Is a behavioral pattern that separates algorithms from objects they are acting on
    - Key players:
        - Visitor interface
        - Concrete Visitor
        - Component interface
        - Concrete Component

    - Example:
        - PDF and Send custom Emails

*/

public class _02_Visitor {
    public static void main(String[] args) {

        List<_02_Client> clients = List.of(
                new _02_Barber("Jarvis", "jarvis@qi.com"),
                new _02_Lawyer("Gym", "gym@dim.com"),
                new _02_Restaurant("Lakeside", "polepole@com.lm"));

        for (_02_Client client : clients) {
            // client.action(new _02_SendEmail());

            client.action(new _02_PDF());
        }
    }
}

abstract class _02_Client {

    private String name;
    private String email;

    public _02_Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract void action(_02_Visitor_ visitor);
}

class _02_Restaurant extends _02_Client {

    public _02_Restaurant(String name, String email) {
        super(name, email);
    }

    @Override
    public void action(_02_Visitor_ visitor) {
        visitor.visit(this);
    }
}

class _02_Lawyer extends _02_Client {

    public _02_Lawyer(String name, String email) {
        super(name, email);
    }

    @Override
    public void action(_02_Visitor_ visitor) {
        visitor.visit(this);
    }
}

class _02_Barber extends _02_Client {

    public _02_Barber(String name, String email) {
        super(name, email);
    }

    @Override
    public void action(_02_Visitor_ visitor) {
        visitor.visit(this);
    }
}

interface _02_Visitor_ {

    void visit(_02_Restaurant client);

    void visit(_02_Lawyer client);

    void visit(_02_Barber client);
}

class _02_SendEmail implements _02_Visitor_ {

    @Override
    public void visit(_02_Restaurant client) {
        System.out.println("Restaurant specifics inside " + client.getEmail());
    }

    @Override
    public void visit(_02_Lawyer client) {
        System.out.println("Lawyer specifics inside " + client.getEmail());
    }

    @Override
    public void visit(_02_Barber client) {
        System.out.println("Barber specifics inside " + client.getEmail());
    }
}

class _02_PDF implements _02_Visitor_ {

    @Override
    public void visit(_02_Restaurant client) {
        System.out.println("Restaurant " + client.getName() + " can send " + client.getEmail());
    }

    @Override
    public void visit(_02_Lawyer client) {
        System.out.println("Lawyer " + client.getName() + " can send " + client.getEmail());
    }

    @Override
    public void visit(_02_Barber client) {
        System.out.println("Barber " + client.getName() + " can send " + client.getEmail());
    }
}
