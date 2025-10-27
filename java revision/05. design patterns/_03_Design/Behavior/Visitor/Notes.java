package _03_Design.Behavior.Visitor;

/*

    NOTES:
    - Encourages an object separation from it's method impelementation

    - 4 Parts needed:
        - Visitor interface: contains methods to be implemented
        - VisitorConcrete: This is concrete implementation of methods
        - Element interface: This defined the accept
        - Concrete Element: Real implementation connection between method/visitor and element/object



        // FIRST ATTEMPT:: ::
                interface Visitor { // Contains the methods
                    void firstMethod(Element element);
                }

                interface Element { // Contains the classes to implement Visitor methods
                    void accept(Visitor visitor);
                }

                class ConcreteVisitor implements Visitor {

                    @Override
                    public void firstMethod(Element element) {

                    }
                }

                class ConcreteElement implements Element {

                    @Override
                    public void accept(Visitor visitor) {

                    }
                }


    - Element can be either an interface or an abstract class with fields and methods to be overriden

    - 4 things to keep in mind
        - First thingy  : Element interface/ abstract class:
            - Is the base class that's needed for concrete classes to implement
            - Contains all fields and methods needed to be overriden
            - The only difference here it that we only have the accept() methods inplace of the methods
            - Everything else is just a normal super/base class to sub-classes

        - Second thingy
            - These are basically the subclasses of the Element
            - Can have as many as possible subclasses as long as they all implement the Interface/abstract class plus they also intake the accept a Visitor  slot, untaking only the Visitor visitor
            - THis is done at the accpet level

        - Third thingy  : Visitor interface:
            - This is the interface that all visitors will implement
            - It has a list of methods that are to be implemented by various Concrete classes, say sendEmail() method Class
            - This means all the methods inside the class will be for specific class methods
            - 

        - Fourth thingy
            - It implements the Visitor interface with had methods for every class to override/implement
            - This is concrete Visitor class



            // SECOND ATTEMPT:: ::
            abstract class Element {

                protected String name;
                protected String email;

                public Element(String name, String email) {
                    this.name = name;
                    this.email = email;
                }

                public abstract void accept(Visitor visitor);
            }

            class Element1 extends Element {

                public Element1(String name, String email) {
                    super(name, email);
                }

                @Override
                public void accept(Visitor visitor) {
                    visitor.sendEmailEl1(this);
                }
            }

            class Element2 extends Element {

                public Element2(String name, String email) {
                    super(name, email);
                }

                @Override
                public void accept(Visitor visitor) {
                    visitor.sendEmailEl2(this);
                }
            }

            class Element3 extends Element {

                public Element3(String name, String email) {
                    super(name, email);
                }

                @Override
                public void accept(Visitor visitor) {
                    visitor.sendEmailEl3(this);
                }
            }

            interface Visitor {

                void sendEmailEl1(Element1 element1);

                void sendEmailEl2(Element2 element2);

                void sendEmailEl3(Element3 element3);

            }

            class VisitorSendEmail implements Visitor {

                @Override
                public void sendEmailEl1(Element1 element1) {
                    System.out.println("Anything Element1");
                }

                @Override
                public void sendEmailEl2(Element2 element2) {
                    System.out.println("Anything Element2");
                }

                @Override
                public void sendEmailEl3(Element3 element3) {
                    System.out.println("Anything Element3");
                }
            }


        - NOTES:
            - 'this' keyword plays an important role in this setupish thing

            - Match up first idea with second idea:
                - 4 classes/participants:
                    - Element abstract class:
                        - Normal super class/ can be abstract class or an interface
                        - It has normal fields/ constructor(if need be), and only one method accept(), which takes in Visitor interface[third part]

                    - Element concrete class:
                        - These implement the Element abstract class with each being unique as a subclass
                        - They override the accept() method while passing in 'this' keyword
                        - Something funny/ to keep in mind is that the accept visitor methods are not yet created at this point, quite crippy

                    - Visitor interface:
                        - This is the methods interface; i.e it's used / applied as a method creator or superclass method object
                        - It has the same method with only a slightly different name to match up the unique names(client concrete classes)
                        - The methods take in concrete element classes as parameter

                    - Visitor concrete class:
                        - This class all the several methods needed by all the subclasses of the Element superclass
                        - The methods in here implement the visitor abstraction of the classes and a sysout is likey to be used for testing purposes

            // THIRD ATTEMPT::: ::: ::: :::
            public class Notes {
                public static void main(String[] args) {

                    List<Element> list = List.of(
                            new Element1("Jarvis", "randome@gmail.com"),
                            new Element2("Wuod", "wuod@jariv.ck"),
                            new Element3("randy", "orton@gabby"));

                    for (Element element : list) {
                        element.accept(new SendEmail());
                    }
                }
            }

            abstract class Element {

                protected String name;
                protected String email;

                public Element(String name, String email) {
                    this.name = name;
                    this.email = email;
                }

                public String getEmail() {
                    return email;
                }

                public String getName() {
                    return name;
                }

                public abstract void accept(Visitor visitor);

            }

            class Element1 extends Element {

                public Element1(String name, String email) {
                    super(name, email);
                }

                @Override
                public void accept(Visitor visitor) {
                    visitor.visitSendEl1(this);
                }
            }

            class Element2 extends Element {

                public Element2(String name, String email) {
                    super(name, email);
                }

                @Override
                public void accept(Visitor visitor) {
                    visitor.visitSendEl2(this);
                }
            }

            class Element3 extends Element {

                public Element3(String name, String email) {
                    super(name, email);
                }

                @Override
                public void accept(Visitor visitor) {
                    visitor.visitSendEl3(this);
                }
            }

            interface Visitor {

                void visitSendEl1(Element1 element1);

                void visitSendEl3(Element3 element3);

                void visitSendEl2(Element2 element2);
            }

            class SendEmail implements Visitor {

                @Override
                public void visitSendEl1(Element1 element1) {
                    System.out.println("visit Send" + element1.getEmail() + " " + element1.getName());
                }

                @Override
                public void visitSendEl2(Element2 element2) {
                    System.out.println("visit Send" + element2.getEmail() + " " + element2.getName());
                }

                @Override
                public void visitSendEl3(Element3 element3) {
                    System.out.println("visit Send" + element3.getEmail() + " " + element3.getName());
                }
            }


        - Visitor design pattern:
            - Definition:
                - Is a behavioral pattern that separares the object implementation from the object itself

                - Separates algorithms from object structure

                - It has four main key players
                    - Element interface/ abstract class:
                        - Normal super class with fields, constructor and accept() method inplace of normal method
                        - accept() takes in Visitor object as a parameter


                    - Element Concrete classes:
                        - Is the subclass of Element super class
                        - The accept() method implements what's inside the visitor interface(not implemented at the moment), quite crippy
                        - Example; visit.visitSendEl1(this);
                        - 'this' keyword is used to refer to the current object
                        - Concrete Element classes


                    - Visitor interface:
                        - Is an interface that contains all the unique methods that should be implemented by the concrete Visitor class
                        - The methods take in concrete Element class as parameter
                        - Basically is a super method class(as method name or method as class name, idk which is which)

                    - Visitor concrete classes:
                        - This is the implementation of superclass Visitor class
                        - Does basic implementation of the methods to the correponding Concrete Element class
                        - THe class name is mostly feeling like the method in a normal polymorphism setup only that it implements the method across multiple concrete element classes



        FOURTH ATTEMPT::: ::: ::: :::
            - 

 */

public class Notes {
}