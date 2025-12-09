package _03_Design.Behavior.Visitor;

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

    }
}

abstract class _Element {

    private String name;
    private String email;

    public _Element(String name, String email) {
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

interface _Visitor {

    void visit(_Element element);
}