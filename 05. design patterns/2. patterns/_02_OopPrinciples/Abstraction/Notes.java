package _02_OopPrinciples.Abstraction;

/*

    NOTES:
    - Abstraction;
        - Is an OOP principle used to reduce the complexity by hiding unnecessary details of a class to a user of that class. Example
            - When pressing a button a TV remote, you don't have to worry about all the interaction with the internal circuit board of the remote


    - BAD CODE EXPLANATION:
        - This is a simple class example without abstraction; we have a load of public methods to any user of the EmailService class

            public class EmailService {

                public void sendEmail() {...}
                public void connect() {...}
                public void authenticate() {...}
                public void disconnect() {...}

            }

        - With this example, if we want to send an email, we have to; Create an EmailService object instance, Connect to the email server, Authenticate that it's us, Send the email message we wanted then, remember to Disconnect from the email server connection

            public class Main {
                public static void main(String[] args) {

                    EmailService emailService = new EmailService();
                    emailService.connect();
                    emailService.authenticate();
                    emailService.sendEmail();
                    emailService.disconnect();

                }
            }

        - ISSUE:
            - The issue with this solution is that all the users have to follow all the steps in a specific order and incase another method is added to the class then all the users of the class have to update their codes as well

        - SOLUTION:
            - A better solution is to make the methods private and only expose one method to the users of the class



    - GOOD CODE EXPLANATION:
        - Over here we make all the methods private except the sendEmail() method. This makes it easy to make method call as we only have a single method to interact with

                public class EmailService {

                    public void sendEmail() {
                        connect();
                        authenticate();
                        System.out.println("Sending email...");
                        disconnect();
                    }
                    ...
                }

        - With this, users of the EmailService class don't have to worry about the internal implementations details involved in sending an email
                public class Main {
                    public static void main(String[] args) {

                        EmailService emailService = new EmailService();
                        emailService.sendEmail();
                    }
                }

        - You don't have to worry about adding multiple methods, you can safely add a method, make it private and call it too under sendEmail(). This reduces chances of introducing bugs inside a working software solution


    - NOTE:
        - Make all methods private except one that you want to expose to the client then call all the methods inside the public method exposed

 */

public class Notes {
}
