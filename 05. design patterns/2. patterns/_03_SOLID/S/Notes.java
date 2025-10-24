package _03_SOLID.S;

/*

    NOTES:
    - Single Responsibility Principle:
        - It states that a class should have one reason to change, meaning that it should have only one responsibility or purpose
        - This principle encourages you to create classes that are more focused and perform one single well-defined task rather than multiple tasks
        - By breaking up classes into smaller more focused units, it makes code easy to understand, maintain and test


    - BAD CODE EXPLAINED:
        - EmailSender class:
            - We are creating an EmailSender class for sending an email notification, over here we have a sendEmail() method which takes *email* and *message* as params
            - We can use the sendEmail() method say to send an email after successfull user registration

                    public class EmailSender {

                        public void sendEmail(String email, String message) {
                            System.out.println("Sending email to " + email + ": " + message);
                        }
                    }



       - User class:
            - We have 2 fields **username** and **email** then we have a method called register() that registers a user to our platform;
            - Under the register() method is registration logic i,e;
                - Fetching the user from the DB by their email
                - If they already exist we could redirect them to the login page
                - Saving registered users to the DB

            - Once that's all done we can send the user an email notification;

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


        - ISSUE:
            - In this example the User class is violating the Single responsibility principle because it's managing user data; email, username, password. It's also containing the user registration logic
            - For this reason, the User class has more than one reason to change;
                1. Modifications can be made to our User data management, i.e add more fields as firstName, lastName, age, hobby
                2. Another reason to modify the class is if we need to change the logic for registering a user. i.e We may choose to fetch user from the DB by email instead of username


        - SOLUTION:
            - We solve for this issue by introducing UserService class. It will hold all the business logic related to a User



    - GOOD CODE EXPLAINED:
        - UserService class:
            - We have a separate class UserService which holds all the business logic related to a user, i.e 
                - User registration
                - User sign-in
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

        - With this separation;
            - User class has only ONE purpose, representing User data
            - UserService class handles User business logic such as user registration, and might as well contain login() and update() methods for the User

 */

public class Notes {

}
