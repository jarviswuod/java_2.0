package _04_DesignPatterns.Behavioral.Visitor;

/*

    NOTES:
    - SOLUTUION 1: POLYMORPHISM
        - Client class
            - We have Client class, it's basically a parent/base class for different types of clients
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

        - COncrete classes:
            - LawClient class:
                - we extend the Client class and introduce a consttuctor

                        public class LawClient extends Client {

                            public LawClient(String name, String email) {
                                super(name, email);
                            }

                            @Override
                            public void sendEmail() {
                                System.out.println("Sending law marketing tips to " + name + " at " + email);
                            }
                        }


            - RestrantClient class:
            - RetailClient class:
                - same concept as LawClient



        - Main class: client class
            -  We create a list of Clients
            - We then loop through each client sending them custom emails using the sendeMail() method

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
            - THis solution workd pefectly fine meeting our goal
            - FOllowing our current design every time we wanted to add new funtionality we have to open up abstract class addign thes specific abstract methos and them implments the methods in to client concrete classes. This breaks the open close prinviple  and we risk breaking tested working code

            - We are also violating the single Responsiblity principle as clients are responsible for stroing clients into sending emaila sna exporting clients as PDF's orXML



    - SOLUTION 2: VISITOR PATTERN:
        - TO solve for the issue we are facin we need to extract the behavior outside client classes on which they operate as VIsitor pattern separetes the algorith/behaviours from the object they operate on

        - abstract CLient class:
            - We ahve everythins as before from the 2 fields of name and email, a constructor to pass them and a getter methos for email
            - NOTE: NO abstract method sendEmail() this time instead we will have accept() which takes in a Visitot object and the visisot object is gonna contain the behavior that will operate of specific client object

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
            - In here we will have 3 methods

                    public interface Visitor {

                        void visitLaw(LawClient lawClient);

                        void visitRestaurant(RestaurantClient restaurantClient);

                        void visitRetail(RetailClient retailClient);
                    }


        - Concrete classes:
            - RetailClient class:
                - Extend the CLient abstract class then implement the accept() methos
                - Under the accept() method we call visitRetail() method and then pass 'this' keyword as  because the retail Vistor will operate on the excact RetailClient object

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
                - Same concept applies as the RetailCLient when it comes to accept() method where we call visitRestaurant() and visitLaw() respectively

                        @Override
                        public void accept(Visitor visitor) {
                            visitor.visitRestaurant(this);
                        }

                        @Override
                        public void accept(Visitor visitor) {
                            visitor.visitLaw(this);
                        }


        - concrete visitor class for sending matching email for each specific type of client
            - EmailVisitor class:
                - It implements the Visitor interface 
                - This is where we implement the specific methods  and we have the behavior is not separated form each of the cleitns objects
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

        - Mail class: Client class:
            - As before we have a list of clients; retailClient, RestaurantClient, LawClient
            - We then loop though across our clients not with the sendEmail() because the logic is nolonger stored on the client objects themselves, we've separed teh behaviour which is sendEmail() in this case from the objects in which they operate which are the unique specific client objects. We just call the accept() method instead and inside the accept method we pass in  any type of visitor, in this case we will pass in the emailVisitor becasue we want to send an email to each of the clients

            - RUnning our programs works find with no issues

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


            - This is a good solutionas we can add any other features needed with just extendin our code and we dont have to modify nothing.
            - To add new fucntionality such as export as PDF we just create a new type of visitor

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
