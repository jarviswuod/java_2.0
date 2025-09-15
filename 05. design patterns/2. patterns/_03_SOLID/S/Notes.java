package _03_SOLID.S;

/*

    NOTES:
    - Single Responsibility Principle:
        - States that a class should have one reason to change, meaning that it should have only one responsibility or purpose
        - This principle encourages you to create classes that are more focused and perform one single well-defined task rather than multiple tasks
        - By breaking up classes into smaller more focused units, it makes code easy to understand, maintain and test


    - BAD CODE EXPLAINED:
        - We have 2 fields **username** and **email** then we have a method called register() that registers a user to our platform;
        - Under the register() method is registration logic like;
            - Fetching the user from the DB by their email
            - If they already exist we could redirect them to the login page
            - Saving registered users to the DB

            # Once that's all done we can send the user an email notification;

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
                
        - We are creating an EmailSender class for sending an email notification, over here we have a sendEmail() method which takes *email* and *message* as params

                public class EmailSender {

                    public void sendEmail(String email, String message) {
                        System.out.println("Sending email to " + email + ": " + message);
                    }
                }

        - We use the sendEmail() method to send an email successfully after successfuly user registration

        - ISSUE:
            - In this example the User class is violating the Single responsibility principle because it manages user data; email, username, password. Then it also contains user registration logic
            - For this has, the User class has more than one reason to change (It 2 reasons to change)
                1. We can make modifications to our User data management, i.e add more fields such as firstName, lastName, age, hobby
                2. Another reason to modify the class is if we need to change the logic for registering a user. Example; we may choose to fetch user from the DB by email instead of username


        - SOLUTION:
            - We solve for this issue by introducing a new class UserService, which holds all the business logic related to a User



    - GOOD CODE EXPLAINED:
        - We have a separate class UserService which holds all the business logic related to a user, i.e 
            - User registration
            - User sign up
            - User details update

        - We need access to user data hence we pass User to the register() method

                public class UserService {

                    public void register(User user) {
                            // Register user logic ...

                            // Send email
                            EmailSender emailSender = new EmailSender();

                            emailSender.sendEmail(user.getEmail(), "Welcome to our plaform");
                        }
                    }
                }

        - With this clear separation, now the User class has ONLY ONE purpose, representing User data while UserService class handles User business logic like user registration, it might as well contain login() and update() methods for the User

 */

public class Notes {

}
