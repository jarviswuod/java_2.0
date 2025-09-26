package _04_DesignPatterns.Creational.Singleton;

/*

    - CODE EXPLANATION:

    - CHALLENGE:
        - Here's a user making a request to fetch some products. There are two classes - UserAuthentication and Products. Both require fetching things from the same db. Notice that we are not using the 'new' keyword to get the db object, we are using a method caled getInstance() that returns the exact db object throughout the application, ensuring that we always use a single db connection


    - SOLUTION 1:
        - AppSettings class:
            - Here we create Map list and each entry will have String key and Object as value -  This is where we will store our settings, each setting will have some key such as "app_name" and object of "Design Mastery"
            - We need to create a get() method for getting our values from our settings Map list
                - First we check is there is a setting with the key we feed into it, if it doesn't exist we will return null else we return the setting itself

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
            - To check if it's working correctly, we test it by logging a random setting key under the get() method

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
            - What is happening is that we are creating a instance of AppSettings under Main class and we also creating another instance under the Test class; these are 2 different instances we are having hence if we try to access a key (e.g "app_name") we created, we get null under Test class




    - SOLUTION 2: SINGLETON PATTERN;
        - We will use singleton pattern to solve this issue coz every time we need to use the AppSettings Object currently we are using the 'new' keyword and hence creating a new separate object

        - We will refactor our code to adhere to the singleton design pattern

        - AppSettings class:
            - First we create a private static field for holding a reference to the  instance - it's an instance of itself
            - Second part is to make the constructor private to ensure that isntance of app settings cannot be created outside of the class itself - this means that the class itself will be able to create and maintain a single instance of itself throughout the application globally
            - Next we create a method for creating a single isntance this(AppSettings) class and call the method getInstance() -  It's a static method
                - We do some checks, first we check if the instance field is null as the first time the method will be called the instance will be null, inside the if statement we create the new instance otherwise we jsut return the instance - the second time the getInstance is called instance will be set to an instance of AppSettings object

            - Everything else remains the same

                    public class AppSettings {

                        private static AppSettings instance;
                        private Map<String, Object> settings = new HashMap<>();

                        private AppSettings() {
                        }

                        public static AppSettings getInstance() {
                            if (instance == null) {
                                instance = new AppSettings();
                            }

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
            - Because we we using the 'new' keyword to previously to create an AppSettings object, we are currently having an error because AppSettings constructor is privateand unaccesible due to protection level within the class
                AppSettings appSettings = new AppSettings();

            - To create a settings object, we need to call AppSettings.getInstance() method as it returns an instance of AppSettings object and we can use it just as we did before i.e adding keys and values and then logging using get() to a keywe addedand know exist

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



        - Test class:
            - We are testing getting this instance ourside a different client inside our application
            - Over here too we will use AppSettings.getInstance() method to create our AppSettings object(we already created one inside Main)
            - It works peftectly

                    public class Test {
                        public static void run() {

                            AppSettings settings = AppSettings.getInstance();
                            System.out.println(settings.get("app_name"));
                        }
                    }


        - EXPLANATION:
            - Main class;;; under 'settings' field, we get an instance from AppSettings and AppSettings;;; getInstance() method creates a new instance of AppSettings and caches/stores this instance in 'instance' static field inside our AppSettings class. 'instance' field being static means the instance is stored on the class itself and not within the new object created elsewhere in the program

            - We now have a global instance of object for our AppSettings

 */

public class Explanation {

}
