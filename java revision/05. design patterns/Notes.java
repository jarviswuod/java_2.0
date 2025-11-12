/*

    CODE:


            import java.util.List;

            public class _04_Notes {
                public static void main(String[] args) {

                    List<Element> elements = List.of(
                            new Restaurant("Javis Wuod", "jarvis@gmail.com"),
                            new Mints("Mints Mc", "mins@deack.com"),
                            new Court("Court Bin", "court@des.com"),
                            new Random("Random", "random@ram.com"));
                    for (Element element : elements) {
                        // element.accept(new CustomEmail());

                        element.accept(new ExportPDF());
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

                public abstract void accept(Visitor visitor);

            }

            class Restaurant extends Element {

                public Restaurant(String name, String email) {
                    super(name, email);
                }

                @Override
                public void accept(Visitor visitor) {
                    visitor.visitor(this);
                }
            }

            class Mints extends Element {

                public Mints(String name, String email) {
                    super(name, email);
                }

                @Override
                public void accept(Visitor visitor) {
                    visitor.visitor(this);
                }
            }

            class Court extends Element {

                public Court(String name, String email) {
                    super(name, email);
                }

                @Override
                public void accept(Visitor visitor) {
                    visitor.visitor(this);
                }
            }

            class Random extends Element {

                public Random(String name, String email) {
                    super(name, email);
                }

                @Override
                public void accept(Visitor visitor) {
                    visitor.visitor(this);
                }
            }

            interface Visitor {

                void visitor(Court court);

                void visitor(Restaurant restaurant);

                void visitor(Random random);

                void visitor(Mints mints);
            }

            class CustomEmail implements Visitor {

                @Override
                public void visitor(Court court) {
                    System.out.println("Sending email to : " + court.getEmail() + " right now");
                }

                @Override
                public void visitor(Restaurant restaurant) {
                    System.out.println("Sending email to : " + restaurant.getEmail() + " right now");
                }

                @Override
                public void visitor(Random random) {
                    System.out.println("Sending email to : " + random.getEmail() + " right now");
                }

                @Override
                public void visitor(Mints mints) {
                    System.out.println("Sending email to : " + mints.getEmail() + " right now");
                }
            }

            class ExportPDF implements Visitor {

                @Override
                public void visitor(Court court) {
                    System.out.println("Name: " + court.name);
                }

                @Override
                public void visitor(Restaurant restaurant) {
                    System.out.println("Name: " + restaurant.name);
                }

                @Override
                public void visitor(Random random) {
                    System.out.println("Name: " + random.name);
                }

                @Override
                public void visitor(Mints mints) {
                    System.out.println("Name: " + mints.name);
                }
            }



        - TEMPLATE METHOD
            - Template method

            public class Notes {
                public static void main(String[] args) {
                    Vender vender = new Vender(new Tea());
                    vender.makeBeverage();

                    System.out.println();

                    vender.setBeverage(new Coffee());
                    vender.makeBeverage();

                    System.out.println();

                    vender.setBeverage(new Camomile());
                    vender.makeBeverage();
                }
            }

            class Vender {

                Beverage beverage;

                public Vender(Beverage beverage) {
                    this.beverage = beverage;
                }

                public void setBeverage(Beverage beverage) {
                    this.beverage = beverage;
                }

                public void makeBeverage() {
                    beverage.makeBeverage();
                }

            }

            abstract class Beverage {

                protected void boilwater() {
                    System.out.println("Boiling water");
                }

                protected void waterToCup() {
                    System.out.println("Pour water to cup");
                }

                protected abstract void brew();

                protected void addCondiments() {
                }

                public void makeBeverage() {
                    boilwater();
                    waterToCup();
                    brew();
                    addCondiments();
                }
            }

            class Tea extends Beverage {

                @Override
                public void brew() {
                    System.out.println("Brew for 4 mins");
                }

                @Override
                public void addCondiments() {
                    System.out.println("Adding tea leaves to tea");
                }
            }

            class Coffee extends Beverage {

                @Override
                public void brew() {
                    System.out.println("Brew for 5 mins");
                }

                @Override
                public void addCondiments() {
                    System.out.println("Adding cream to coffee");
                }
            }

            class Camomile extends Beverage {

                @Override
                public void brew() {
                    System.out.println("Brew for 3 mins");
                }
            }


            - Strategy method


                public class Notes {
                    public static void main(String[] args) {

                        BeverageMaker beverageMaker = new BeverageMaker(new Camomile());
                        beverageMaker.makeBeverage();
                        System.out.println();

                        beverageMaker.setBeverage(new Coffee());
                        beverageMaker.makeBeverage();
                        System.out.println();

                        beverageMaker.setBeverage(new Tea());
                        beverageMaker.makeBeverage();

                    }
                }

                class BeverageMaker {

                    Beverage beverage;

                    public BeverageMaker(Beverage beverage) {
                        this.beverage = beverage;
                    }

                    public void setBeverage(Beverage beverage) {
                        this.beverage = beverage;
                    }

                    public void makeBeverage() {
                        boilwater();
                        pourWaterToCup();
                        beverage.makeBeverage();
                    }

                    private void boilwater() {
                        System.out.println("Boil water for 5 minutes");
                    }

                    private void pourWaterToCup() {
                        System.out.println("Pour water to cup");
                    }

                }

                interface Beverage {

                    void makeBeverage();
                }

                class Coffee implements Beverage {

                    @Override
                    public void makeBeverage() {
                        brew();
                        addCondiments();
                    }

                    private void brew() {
                        System.out.println("Brew for 5 minutes");
                    }

                    private void addCondiments() {
                        System.out.println("Add cream to coffee");
                    }
                }

                class Tea implements Beverage {

                    @Override
                    public void makeBeverage() {
                        brew();
                        addCondiments();
                    }

                    private void brew() {
                        System.out.println("Brew for 4 minutes");
                    }

                    private void addCondiments() {
                        System.out.println("Add tea leaves to tea");
                    }
                }

                class Camomile implements Beverage {

                    @Override
                    public void makeBeverage() {
                        brew();
                    }

                    private void brew() {
                        System.out.println("Brew for 5 minutes");
                    }
                }

        - Stratergy pattern:

                public class Notes {
                    public static void main(String[] args) {

                        VideoStorage videoStorage = new VideoStorage(new Mp4(), new BlackAndWhite());
                        videoStorage.store("here/path/to/file");

                        videoStorage.setColor(new Blur());
                        videoStorage.setFormat(new Mp3());
                        videoStorage.store("here/path/to/file");

                    }
                }

                class VideoStorage {

                    Format format;
                    Color color;

                    public VideoStorage(Format format, Color color) {
                        this.format = format;
                        this.color = color;
                    }

                    public Format getFormat() {
                        return format;
                    }

                    public void setFormat(Format format) {
                        this.format = format;
                    }

                    public Color getColor() {
                        return color;
                    }

                    public void setColor(Color color) {
                        this.color = color;
                    }

                    public void store(String path) {
                        format.compress();
                        color.swap();
                        System.out.println("Video saved in " + color.getClass() + " " + format.getClass() + "to path " + path);
                    }

                }

                interface Format {

                    void compress();
                }

                interface Color {

                    void swap();
                }

                class BlackAndWhite implements Color {

                    @Override
                    public void swap() {
                        System.out.println("Color changed to Black and white");
                    }
                }

                class Blur implements Color {

                    @Override
                    public void swap() {
                        System.out.println("Video changed to blur");
                    }
                }

                class Mp4 implements Format {

                    @Override
                    public void compress() {
                        System.out.println("Format compressd to MP4");
                    }
                }

                class Mp3 implements Format {

                    @Override
                    public void compress() {
                        System.out.println("Format compressd to MP3");
                    }
                }


        - State pattern:


    NOTES:
    - Behavioral design pattern:
        - Visitor pattern:
            - Is a behavioral pattern that separated an algorithm from a class/object that acts on it
            - 4 key players:
                - visitor
                - concrete visitor
                - element
                - concrete element

            - Example:
                - Sending custom email
                - Exporting something in an pdf format



        - Template Method pattern:
            - Is a behavioral pattern where a super class defines an algorithm's skeleton while the specific implementations of the algo is done in the sub class level
            - 2 key players:
                - super class
                - sub classes

            - Example:
                - Coffee Vending machine

            - 2 ways:
                - Strategy
                - Template



        - Strategy pattern:
            - Is a behavioral pattern in which an algorithm of the same family can be changed and implemented at runtime
            - 3 key players:
                - context
                - strategy
                - concrete strategy

            - Example:
                - Video Storage



        - State pattern:
            - Is a behavioral pattern that changes an algorithms behaviour as the internal state changes
            - 3 Key players:
                - context
                - state
                - concrete state

            - Example:
                - 



        - Observer pattern:
            - Is a behavioral pattern that defines a one to many relationship between objects. Changes in one object is communicated and reflected on the other objects
            - 4 key players:
                - 
                - 
                - 
                - 

            - Example:
                - 



        - Memento pattern:
            - Is a behavioural pattern where internal structure of an object is captures and exported without compromising the encapsulation
            - 3 key players:
                - originator
                - memento
                - caretaker

            - Example:
                - Online editor



        - Mediator pattern:
            - Is a behavioral pattern 
            - 4 key players:
                - 
                - 
                - 
                - 
 
            - Example:
                - 

 */

public class Notes {
    public static void main(String[] args) {

    }
}
