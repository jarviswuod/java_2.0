package _03_Design.Behavior.Memento;

/*

    NOTES:
    // FIRST ATTEMPT::: ::: ::: :::

    - Is a behavioral pattern that captures and extenalizes internal state of an object without without affecting it's encapsulation

    - 3 key players:
        - Originator:
            - Is a class whose internal state needs to be captured and stored

        - Memento:
            - Is a class which captures and stores Originator states

        - Caretaker:
            - Is a class which stores and redo's mementos


            class Originator {
                private String title;
                private String detail;

                public Originator(String title, String detail) {
                    this.title = title;
                    this.detail = detail;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public void setDetail(String detail) {
                    this.detail = detail;
                }

                public String getTitle() {
                    return title;
                }

                public String getDetail() {
                    return detail;
                }
            }

            class Memento {
                private String title;
                private String detail;
                private Originator originator;

                public String getTitle() {
                    return title;
                }

                public String getDetail() {
                    return detail;
                }

                public Originator capture() {
                    return new Originator(title, detail);
                }

                public void undo(Originator last) {
                    originator.setTitle(last.getTitle());
                    originator.setDetail(last.getDetail());
                }
            }

            class Caretaker {

                Stack<Originator> list = new Stack<>();
                private Originator originator;
                private Memento memento;

                public Caretaker(Originator originator) {
                    this.originator = originator;
                }

                public void backup() {

                    list.push(memento.capture());
                }

                public void undo() {

                    memento.undo(list.pop());
                }
            }

    // SECOND ATTEMPT::: ::: ::: :::
    - Observer pattern:
        - Is a behavior pattern that captures and externalizes the internal state of an object without affecting it's encapsulation

    - 3 key players:
        - Originator:
            - 

        - Memento:
            - 

        - CareTaker:
            - 

 */

public class Notes {
}

class Originator {
}

class Memento {
}

class CareTaker {
}
