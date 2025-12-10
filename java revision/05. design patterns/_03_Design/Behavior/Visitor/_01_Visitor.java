package _03_Design.Behavior.Visitor;

import java.util.List;

/*

    NOTES:
    - Is a behavioral pattern that lets you separates algorithms from objects they are operating on
    - Key players:
        - Visitor interface
        - Concrete Visitor
        - Component interface
        - Concrete Component

    - Example:
        - PDF export and EmailMarketing

*/

public class _01_Visitor {
    public static void main(String[] args) {

        List<_Client> clients = List.of(
                new _LaywerClient("Jarvis", "jarvis@wuod.com"),
                new _BarberClient("Barbar", "shop@bar.com"),
                new _RestaurantClient("Restaurant", "kilimall@ema.com"));

        for (_Client client : clients) {
            // client.accept(new _MarketingEmail());

            client.accept(new _PDFEmail());
        }
    }
}

abstract class _Client {

    private String name;
    private String email;

    public _Client(String name, String email) {
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

    public abstract void accept(_Visitor visitor);
}

class _RestaurantClient extends _Client {

    public _RestaurantClient(String name, String email) {
        super(name, email);
    }

    @Override
    public void accept(_Visitor visitor) {
        visitor.visit(this);
    }
}

class _LaywerClient extends _Client {

    public _LaywerClient(String name, String email) {
        super(name, email);
    }

    @Override
    public void accept(_Visitor visitor) {
        visitor.visit(this);
    }
}

class _BarberClient extends _Client {

    public _BarberClient(String name, String email) {
        super(name, email);
    }

    @Override
    public void accept(_Visitor visitor) {
        visitor.visit(this);
    }
}

interface _Visitor {

    void visit(_RestaurantClient element);

    void visit(_LaywerClient element);

    void visit(_BarberClient element);
}

class _MarketingEmail implements _Visitor {

    @Override
    public void visit(_RestaurantClient restaurantClient) {
        System.out.println("Sending mail to " + restaurantClient.getEmail());
    }

    @Override
    public void visit(_LaywerClient laywerClient) {
        System.out.println("Sending mail to " + laywerClient.getEmail());
    }

    @Override
    public void visit(_BarberClient barberClient) {
        System.out.println("Sending mail to " + barberClient.getEmail());
    }
}

class _PDFEmail implements _Visitor {

    @Override
    public void visit(_RestaurantClient restaurantClient) {
        System.out.println("Sending PDF " + restaurantClient.getName());
    }

    @Override
    public void visit(_LaywerClient laywerClient) {
        System.out.println("Sending PDF " + laywerClient.getName());
    }

    @Override
    public void visit(_BarberClient barberClient) {
        System.out.println("Sending PDF " + barberClient.getName());
    }
}
