package _03_SOLID.S;

/*

    NOTES:
    - A class should have one reason to change, meaning that it should have only one responsibility or purpose
    - This principle encourages you to create classes that are more focused and perform one single well-defined task rather than multiple tasks
    - By breaking up classes into smaller more focused units, it makes code easy to understand, maintain and test

    - BAD CODE EXPLAINED:
        - We have 2 fields username and email then we have a method called register that registers a user to our platform;
        Over here we will be having our register user logic like fecthing the user from the D by their email, if they already exist we could redirect them to the login page, saving them to the DB. Once that's all done we can send the user an email notification
            public class User {

                private String username;
                private String email;

                public void register() {
                    // Register user logic ...

                    // Send email
                    EmailSender emailSender = new EmailSender();

                    emailSender.sendEmail(email, "Welcome to our plaform");
                }
            }
                
        - We are creating an EmailSender class for sending an email notification, over here we have a sendEmail() method which takes email and message as params
            public class EmailSender {
                public void sendEmail(String email, String message) {
                    System.out.println("Sending email to " + email + ": " + message);
                }
            }
        - We use the sendEmail() method to send an email successfully after successfuly registering a user

        - ISSUE:
            - In this example the User class is violating the Single respoinsibility principle because it makes all user data, email, username, passowrd, etc then it also contains the logid for registering user. The class it has more than one reason to change, it has 2 reasons to change;
                1. We can make modifications to our User data management, i.e add more fields such as firstName, Lastname, age, hobby, etc

                2. Another reason to modify the class is if we need to change the logic for registering a user, example, we may choose to fetch the user from the DB by email instead of username

        

    - GOOD CODE EXPLAINED:
        - We create a separate class UserService and over here we will put all the business logic/ methods related to a user, i.e log In a user, Updating a user, registering a user
        - We need access to user data hence  we pass User to the register() method
            public class UserService {

                public void register(User user) {
                        // Register user logic ...

                        // Send email
                        EmailSender emailSender = new EmailSender();

                        emailSender.sendEmail(user.getEmail(), "Welcome to our plaform");
                    }
                }
            }
            
        - With this clear separation, now the User class  has one purpose of representing the User data and the UserService class now handles user registration or User business logic

 */

public class Notes {

}
