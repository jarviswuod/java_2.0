package _04_DesignPatterns.Creational.Singleton;

/*

    - CODE EXPLANATION:

    - CHALLENGE:
        - Here's a user making a request to fetch some products. There are two classes; UserAuthentication and Products. Both require fetching things from the same db
        - Notice:
            - We are not using the 'new' keyword to get the db object. We are using a method called getInstance() that returns the exact same db object throughout the application. This ensures that we always use a single db connection


    - SOLUTION 1:
        - AppSettings class:
            - Here we create Map list and each entry will have String key and Object as value
                - This is where we will store our settings, each setting will have some key such as "app_name" and object of "Design Mastery"
            - We need to create a get() method for getting our values from our settings Map list
                - First we check if there's a setting with the key we feed into it, if it doesn't exist we will return null else we return the setting itself

                        public class AppSettings {

                            private Map<String, String> settings = new HashMap<>();

                            public String get(String key) {
                                if (!settings.containsKey(key))
                                    return null;
                                return settings.get(key);
                            }

                            public void set(String key, String value) {
                                settings.put(key, value);
                            }
                        }


        - Main class: Client class;
            - First we create a new AppSettings object
            - Then we add a few settings to it
            - We test it by logging a random setting key under the get() method

                    public class Main {
                        public static void main(String[] args) {

                            AppSettings settings = new AppSettings();
                            settings.set("app_name", "Design Patterns Mastery");
                            settings.set("app_creator", "Danny");

                            System.out.println(settings.get("app_name"));
                            System.out.println();

                            Test.run();
                        }
                    }


        - Test class:
            - Next is testing the getting a settings objectS from a different client
            - We create a static run() method and inside it we create a AppSettings object then finally test the get() method with a key we know exist

                    public class Test {
                        public static void run() {

                            AppSettings settings = new AppSettings();
                            System.out.println(settings.get("app_name"));
                        }
                    }



        - Main class: Cliet class;
            - If we test it be calling run() method under Test class, it doesn't work. What we see instead is 'null' being returned

                    public class Main {
                        public static void main(String[] args) {

                            Test.run();
                            ...
                        }
                    }



        - OBSERVATION:
            -  We need to use single pattern to ensure a single instance of AppSettings is maintained throughout our aplication
            - What is happening is that we are created an instance of AppSettings under Main class and also created another instance under the Test class. These are 2 different instances we are having hence if we try to access a key (e.g "app_name") we created, we get null under Test class




    - SOLUTION 2: SINGLETON PATTERN;
        - Currently we are using the 'new' keyword and hence creating a new separate object
        - We will use singleton pattern to solve this issue coz every time we need to use the same AppSettings Object

        - We will refactor our code to adhere to the singleton design pattern

        - AppSettings class:
            - First we create a private static field for holding a reference to the instance (an instance of itself)
            - Second part is making the constructor private to ensure that instance of app settings cannot be created outside of the class itself
                - This means that the class itself will be able to create and maintain a single instance of itself throughout the application globally
            - Next, we create a static method for creating a single instance this(AppSettings) class and call the method getInstance()
                - We do some checks, first we check if the instance field is null as the first time the method will be called the instance will be null, inside the if statement we create the new instance otherwise we return the instance. The second time the getInstance() is called instance will be set to an instance of AppSettings object

            - Everything else remains the same

                    public class AppSettings {

                        private static AppSettings instance;
                        private Map<String, Object> settings = new HashMap<>();

                        private AppSettings() {
                        }

                        public static AppSettings getInstance() {
                            if (instance == null)
                                instance = new AppSettings();

                            return instance;
                        }

                        public Object get(String key) {
                            if (!settings.containsKey(key))
                                return null;
                            return settings.get(key);
                        }

                        public void set(String key, Object value) {
                            settings.put(key, value);
                        }
                    }



        - Main class: Client class;
            - Because we are using the 'new' keyword to previously create an AppSettings object. We are currently having an error because AppSettings constructor is private and unaccesible due to protection level within the class
                AppSettings appSettings = new AppSettings();

            - To create a settings object, we call AppSettings.getInstance() method as it returns an instance of AppSettings object and use it just as before i.e adding keys and values and then logging using get() method

                    public class Main {
                        public static void main(String[] args) {

                            AppSettings settings = AppSettings.getInstance();
                            settings.set("app_name", "Design Patterns Mastery **");
                            settings.set("app_creator", "Danny");

                            System.out.println(settings.get("app_name"));
                            System.out.println();

                            Test.run();
                        }
                    }


        - EXPLANATION:
            - Under 'settings' field we get an instance from AppSettings
            - getInstance() method creates a new instance of AppSettings and caches this instance in 'instance' static field inside our AppSettings class
            - 'instance' field being static means the instance is stored on the class itself and not within the new object created elsewhere in the program
            - We now have a global instance of object for our AppSettings



        - Test class:
            - We are testing get() method instance in a different client inside our application
            - Over here too we will use AppSettings.getInstance() method to create our AppSettings object(we already created one inside Main)
            - It works peftectly

                    public class Test {
                        public static void run() {

                            AppSettings settings = AppSettings.getInstance();
                            System.out.println(settings.get("app_name"));
                        }
                    }

 */

public class Explanation {

}
