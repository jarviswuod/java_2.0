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
    - Memento design pattern is a behavioral pattern that captures and externalizes the internal state of an object, this happens without affecting the encapsulation

    - 3 Key players:
        - Originator:
            - Is a class whose internal state should be captured and stored

        - Memento:
            - Is a class that captures and stores the internal structure of the Originator

        - CareTaker:
            - Is a class that stores and redo's the memento


                public class Note {
                    public static void main(String[] args) {

                        Originator blog = new Originator("", "");
                        CareTaker history = new CareTaker(blog);

                        history.save();

                        blog.setDetails("Jarvis is my name");

                        history.save();
                        blog.setTitle("Changed title for the 3rd time");

                        history.save();
                        System.out.println(blog.getTitle());
                        System.out.println(blog.getDetails());
                        System.out.println();

                        blog.setDetails("My name");
                        history.save();

                        System.out.println(blog.getTitle());
                        System.out.println(blog.getDetails());
                        System.out.println();

                        blog.setTitle("Title for the 3rd time");
                        history.save();

                        System.out.println(blog.getTitle());
                        System.out.println(blog.getDetails());
                        System.out.println();

                        history.undo();
                        System.out.println(blog.getTitle());
                        System.out.println(blog.getDetails());
                        System.out.println();

                        history.undo();
                        System.out.println(blog.getTitle());
                        System.out.println(blog.getDetails());
                        System.out.println();

                        history.undo();
                        System.out.println(blog.getTitle());
                        System.out.println(blog.getDetails());
                        System.out.println();

                        history.undo();
                        System.out.println(blog.getTitle());
                        System.out.println(blog.getDetails());
                        System.out.println();
                    }
                }

                class Originator {
                    private String title;
                    private String details;

                    public Originator(String title, String details) {
                        this.title = title;
                        this.details = details;
                    }

                    public Memento capture() {
                        return new Memento(title, details);
                    }

                    public void undo(Memento memento) {
                        title = memento.getTitle();
                        details = memento.getDetails();
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDetails() {
                        return details;
                    }

                    public void setDetails(String details) {
                        this.details = details;
                    }

                    @Override
                    public String toString() {
                        return "Originator [title=" + title + ", details=" + details + "]";
                    }
                }

                class Memento {
                    private String title;
                    private String details;
                    private Instant createdAt;

                    public Memento(String title, String details) {
                        this.setTitle(title);
                        this.setDetails(details);
                        createdAt = Instant.now();
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDetails() {
                        return details;
                    }

                    public void setDetails(String details) {
                        this.details = details;
                    }

                    public Instant getCreatedAt() {
                        return createdAt;
                    }

                    @Override
                    public String toString() {
                        return "Memento [title=" + title + ", details=" + details + ", createdAt=" + createdAt + "]";
                    }
                }

                class CareTaker {

                    private Stack<Memento> mementos = new Stack<>();
                    private Originator originator;

                    public CareTaker(Originator originator) {
                        this.originator = originator;
                    }

                    public void save() {
                        mementos.push(originator.capture());
                    }

                    public void undo() {
                        if (mementos.isEmpty())
                            return;

                        originator.undo(mementos.pop());
                    }

                    public void showHistory() {
                        for (Memento memento : mementos) {
                            System.out.println(memento.toString());
                        }
                    }
                }


 */

public class Notes {
}