package _04_DesignPatterns.Behavioral.Visitor;

/*

    - CODE EXPLANATION:

    - CHALLENGE:
        - Say that you are a developer for a marketing agency that has differenct types of clients:
            - Restautants
            - Law firms
            - Retailers

        - Your manager comes to you and says that they need the ability to send a specialised email with marketing tips for each  of the different clients; example:
            - Restaurants needs tips on how they can better market their food better but law firms don't
            - Law firms tips to improve their online reviews
            - Retailers tips to improve their product descriptions


    - SOLUTION 1: POLYMORPHISM
        - Client class
            - We have Client class, it's basicaly a parent/base class for different types of clients
            - We are storing the name and contact email for the client
            - We also have an abstract method sendEmail() which will be implemented by subclasses and customized according to their needs

                    public abstract class Client {

                        protected String name;
                        protected String email;

                        public Client(String name, String email) {
                            this.name = name;
                            this.email = email;
                        }

                        public abstract void sendEmail();
                    }

        - Concrete classes:
            - LawClient class:
                - We extend the Client class and introduce a consttuctor and implement SendEmail() method

                        public class LawClient extends Client {

                            public LawClient(String name, String email) {
                                super(name, email);
                            }

                            @Override
                            public void sendEmail() {
                                System.out.println("Sending law marketing tips to " + name + " at " + email);
                            }
                        }


            - RestaurantClient class:
            - RetailClient class:
                - Same concept as LawClient



        - Main class: Client class
            - We create a list of Clients
            - We then loop through each client sending them custom emails using the sendEmail() method

                    public class Main {
                        public static void main(String[] args) {

                            List<Client> clients = List.of(
                                    new LawClient("Debianhams", "team@deian.co.uk"),
                                    new RetailClient("John Lewis", "some@random.com"),
                                    new RestaurantClient("Pizza Hut", "safe@inpizza.com"));

                            for (Client client : clients) {
                                client.sendEmail();
                            }
                        }
                    }


        - Observation:
            - This solution works pefectly fine meeting our goal
            - Following our current design every time we wanted to add new functionality we have to open up abstract class adding these specific abstract methods and then implment the methods in to ClientConcrete classes. This breaks the OCP

            - We are also violating the SRP as clients are responsible for storing clients, sending emails and exporting clients as PDF's or XML



    - SOLUTION 2: VISITOR PATTERN:
        - To solve for the issue we are facing we need to extract the behavior outside client classes on which they operate on as Visitor pattern separates the algorithm/behaviours from the object they operate on

        - abstract Client class:
            - We have everything as before from the 2 fields of name and email, a constructor to pass them and a getter method for email
            - NOTE: No abstract method sendEmail() this time instead we will have accept() which takes in a Visitot object and the Visisot object is gonna contain the behavior that will operate of specific client object

                    public abstract class Client {

                        protected String name;
                        protected String email;

                        public Client(String name, String email) {
                            this.name = name;
                            this.email = email;
                        }

                        public String getEmail() {
                            return email;
                        }

                        public abstract void accept(Visitor visitor);
                    }


        - Visitor Interface:
            - In here, we will have 3 methods

                    public interface Visitor {

                        void visitLaw(LawClient lawClient);

                        void visitRestaurant(RestaurantClient restaurantClient);

                        void visitRetail(RetailClient retailClient);
                    }


        - Concrete classes:
            - RetailClient class:
                - Extend the Client abstract class then implement the accept() method
                - Under the accept() method we call visitRetail() method and then pass 'this' keyword  because the RetailVisitor will operate on the exact RetailClient object

                    public class RetailClient extends Client {

                        public RetailClient(String name, String email) {
                            super(name, email);
                        }

                        @Override
                        public void accept(Visitor visitor) {
                            visitor.visitRetail(this);
                        }
                    }


            - RestaurantClient class:
            - LawClient class:
                - Same concept applies as the RetailClient when it comes to accept() method where we call visitRestaurant() and visitLaw() respectively

                        @Override
                        public void accept(Visitor visitor) {
                            visitor.visitRestaurant(this);
                        }

                        @Override
                        public void accept(Visitor visitor) {
                            visitor.visitLaw(this);
                        }


        - ConcreteVisitor class for sending matching email for each specific type of client
            - EmailVisitor class:
                - It implements the Visitor interface 
                - This is where we implement the specific methods and we have the behavior is not separated from each of the clients objects
                - What we now do is to send custom emails

                        public class EmailVisitor implements Visitor {

                            @Override
                            public void visitLaw(LawClient client) {
                                System.out.println("Sending law marketing tips to " + client.name + " at " + client.email);
                            }

                            @Override
                            public void visitRestaurant(RestaurantClient client) {
                                System.out.println(
                                        "Sending Restaurant marketing tips to " + client.name + " at " + client.email);
                            }

                            @Override
                            public void visitRetail(RetailClient client) {
                                System.out.println("Sending retail marketing tips to " + client.name + " at " + client.email);
                            }
                        }



        - Main class: Client class;
            - As before we have a list of clients; RetailClient, RestaurantClient, LawClient
            - We then loop though across our clients not with the sendEmail() because the logic is no longer stored on the client objects themselves, we've separated the behaviour which is sendEmail() in this case from the objects in which they operate which are the unique specific client objects. We just call the accept() method instead and inside the accept method we pass in any type of visitor, in this case we will pass in the emailVisitor because we want to send an email to each of the clients

            - Running our programs, it works find with no issues

                    public class Main {

                        public static void main(String[] args) {

                            List<Client> clients = List.of(
                                    new LawClient("Debianhams", "team@deian.co.uk"),
                                    new RetailClient("John Lewis", "some@random.com"),
                                    new RestaurantClient("Pizza Hut", "safe@inpizzahut.co.ke"));

                            for (Client client : clients) {
                                client.accpet(new EmailVisitor());

                                // New
                                client.accpet(new PDFExportVistor());
                            }
                        }
                    }


            - This is a good solution as we can add any other features needed with just extending our code and we don't have to modify nothing
            - To add new functionality such as export as PDF we just create a new type of visitor

                    public class PDFExportVistor implements Visitor {

                        @Override
                        public void visitLaw(LawClient client) {
                            System.out.println("Sending law marketing tips to " + client.name + " at " + client.email);
                        }

                        @Override
                        public void visitRestaurant(RestaurantClient client) {
                            System.out.println("Exporting restaurant client " + client.name + " to PDF");
                        }

                        @Override
                        public void visitRetail(RetailClient client) {
                            System.out.println("Exporting retail client " + client.name + " to PDF");
                        }
                    }

 */

public class Explanation {

}
