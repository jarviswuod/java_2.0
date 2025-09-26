package _04_DesignPatterns.Creational.FactoryMethod;

/*

    - CODE EXPLANATION:

    - CHALLENGE:
        - Say that we are developing a new Model-View-Controller backend framework, to rival the popular PHP framework, Laravel



    - SOLUTION 1:
        - MVCFramework:
            - This folder which is part of our framework that we are developing and the below are 3rd party code to our framework because we are going to download these ViewEngines interface and subclasses to our application as packages. This means we would not have access to the source code to these ViewEngines


            - ViewEngine interface:
                - We have an inteface with a single method render() which takes a fileName, which is going to be the file location of our template and Map that contains data that we wish to have pass to the template
                - This ViewEngine is going to render this template, it's going to pass it the data and turn it into a regular String of HTML and return that HTML so that it can be understood by a browser

                        public interface ViewEngine {

                            public String render(String fileName, Map<String, Object> data);
                        }



            - Concrete ViewEngine classes:
                - We have a couple of template engines;

                - BladeViewEngine class:
                    - It implements the ViewEngine interface and the render() method
                    - The render() method returns a simple String "View renderd from..."

                        public class BladeViewEngine implements ViewEngine {

                            @Override
                            public String render(String fileName, Map<String, Object> data) {
                                return "View rendered from " + fileName + " by Blade";
                            }
                        }


                - TwigViewEngine class:
                    - This is a different Templating Engine just as the BladeViewEngine class with the same implementations as it

                        public class TwigViewEngine implements ViewEngine {

                            @Override
                            public String render(String fileName, Map<String, Object> data) {
                                return "View rendered from " + fileName + " by Twig";
                            }
                        }



            - Controller class:
                - We are creating a base controller class to handle our requests made to our application
                - Here we have a class called render() which takes a fileName for the template we want to render and some data that will pass to is inform of a Map
                    - Inside this we first create a ViewEngine object that we want to use and we are going to use a BladeViewEngine
                    - Then we will actually use the ViewEngine instance to convert our template and pass it the data and convert it it into some regular HTML
                    - Finally we would render the HTML to the console

                - NOTE: This is part of our MVCFramework devs can use to create there own backend application or API's. This mean developers can extend the base controller class to create their own controllers to handle rewuests to their application e.g a controller that deals with order related requests

                        public class Controller {
                            public void render(String fileName, Map<String, Object> data) {

                                BladeViewEngine viewEngine = new BladeViewEngine();
                                String html = viewEngine.render(fileName, data);
                                System.out.println(html);
                            }
                        }



        - OrderController class:
            - NOTE: This is created outside our MVCFramework directory
            - It extends our MVCFramework's Contoller class
            - NOTE: Remember this could be some other developer not related to our MVCFramework creating there application, say an eCommerce app and they are using our MVC backend framework
            - In here what we do is to create a method called listOrders() 'orders' which is to basically simulate fetching some orders from  a database, i.e we have a Map with item names and their corresponding prices - note; this is simulating some fetching some sort of order data from a db
            - Below the orders we then call the render() method which we inherited from the controller which we pass the location of our template file and the orders as data that we want to populate our template file with  - we fetched orders(data) from the db simulation

            - We also have another method called getOrder() which takes in the Id and renders a single order item by ID -  we are also simulating the db

                    public class OrdersController extends Controller {
                        public void listOrders() {

                            Map<String, Object> orders = new HashMap<>();
                            orders.put("Red socks", "$12.98");
                            orders.put("Black socks", "$12.98");
                            orders.put("Pink T-shirt", "$29.00");

                            render("orders.blade.php", orders);
                        }

                        public void getOrder(int id) {

                            // Simulating getting single order by id from db
                            Map<String, Object> orders = new HashMap<>();
                            orders.put("Red socks", "$12.98");

                            render("order.blade.php", orders);
                        }
                    }



            NOTES:::
                - Our backend framework code where our base controller is stored will be downlaoded by developers as a 3rd party framework i.e developers will be downloading our MVCFramework folder as a package so they can use our framework to create their own applications and the OrderController was a example of what a developer might create using our framework where they basically extend our base Controller class
                - Developers wouldn't however be able to modify the code directly in this MVCFramework folder so this means if a developer wants to use a different ViewEngine or TemplateEngine then the solution we developed is poor because our Controller class is tightly coupled to the BladeViewEngine and cannot be changed by developers - in short devleopers have no way of swithching to a different ViewEngine i.e they cannot use TwigViewEngine to create their templates using the Twig templating language then we  have provided them with no way of switching



    - SOLUTION 2:
        - We are trying a different approach of allowing developers to pass a ViewEngine as an argument to the controller.render() method - currently we only have fileName and Map data want to pass

        - Controller class:
            - OLD::
                public class Controller {

                    public void render(String fileName, Map<String< Object> data) {
                        BladeViewEngine viewEngine =  new BladeViewEngine();
                        String html = viewEngine.render(fileName, data);
                        System.out.println(html);
                    }
                }

            - NEW::
                public class Controller {

                    public void render(String fileName, Map<String, Object> data, ViewEngine viewEngine) {

                        String html = viewEngine.render(fileName, data);
                        System.out.println(html);
                    }
                }



            - This allows developers to select the ViewEngine every time they can call base Control.render() method

        - OrdersController class;
            - If we come to our OrderController we can see an error because we have to pass the ViewEngine we want to use example new TwigEngine()

                        public class OrdersController extends Controller {
                            public void listOrders() {

                                Map<String, Object> orders = new HashMap<>();
                                orders.put("Red socks", "$12.98");
                                orders.put("Black socks", "$12.98");
                                orders.put("Pink T-shirt", "$29.00");

                                render("orders.blade.php", orders, new BladeViewEngine());
                            }

                            public void getOrder(int id) {

                                // Simulating getting single order by id from db
                                Map<String, Object> orders = new HashMap<>();
                                orders.put("Red socks", "$12.98");

                                render("order.blade.php", orders, new BladeViewEngine());
                            }
                        }



                NOTES:::
                    - This is a more flexible solution as it allows developers to choose the ViewEngine they wanna use
                    - However we developed another problem, we now have to pass the ViewEngine every time we call the render method and usually developers will always be using one ViewEngine for all of the templates in the application so it makes no sense to make a developer to keep passing the ViewEngine every time a render() method is called




    - SOLUTION 3: FACTORY METHOD PATTERN
        - We will refactor our code to follow the pattern
        - Controller class:
            - We remove the ViewEngine as parameter from the render method
            - We will then use a template method to create our ViewEngine, we'll call it createViewEngine() by default we return new BladeViewEngine()
            - NOTE:::
                - This is the same method that we call under render() method when we need a viewEngine instance

            - OLD::
                public void render(String fileName, Map<String< Object> data, ViewEngine viewEngine) {

                    String html = viewEngine.render(fileName, data);
                    System.out.println(html);
                }

            - NEW::
                public void render(String fileName, Map<String, Object> data) {

                    ViewEngine viewEngine = createViewEngine();
                    String html = viewEngine.render(fileName, data);
                    System.out.println(html);
                }

                protected ViewEngine createViewEngine() {

                    return new BladeViewEngine();
                }


        -TwigController class;
            - Now we create an alternative controller that the developer use to render html
            - Here we implement our Controller class and override the createViewEngine() template method
            - With this now, if a developer wants to switch to the TwigViewEngine they can extend the TwigController class rather than the base Controller class

                        public class TwigController extends Controller {

                            @Override
                            protected ViewEngine CreateViewEngine() {
                                return new TwigViewEngine();
                            }
                        }




        - OrderController class:
            - Over here we are having an error again because we no longer have 3 parameters inside the render() method hence we remove them and whenever we wanna use the Twig template language we can just extend the TwigController class instead of the default Controller which is having the BladeViewTemplate set as default - and when you shift to the TwigController and our render() method will use the Twig template language because this(Contoller;;; createViewEngine()) is a template meaning it can be oveeriden and once that happens it will affect the behavior of the render() method (Contoller;;; render()) because we are calling it inside render() method definition and it can return different types of engines depending on whether it's be overriden or not


            - OLD::
                render("order.blade.php", orders, new TwigViewTemplate());

            - NEW::
                render("order.blade.php", orders);


            - Switching Controller class:
                - public class OrdersController extends Controller {...}
                - public class OrdersController extends TwigController {...}


                        // public class OrdersController extends Controller {
                        public class OrdersController extends TwigController {

                            public void listOrders() {

                                Map<String, Object> orders = new HashMap<>();
                                orders.put("Red socks", "$12.98");
                                orders.put("Black socks", "$12.98");
                                orders.put("Pink T-shirt", "$29.00");

                                render("orders.blade.php", orders);
                            }

                            public void getOrder(int id) {

                                // Simulating getting single order by id from db
                                Map<String, Object> orders = new HashMap<>();
                                orders.put("Red socks", "$12.98");

                                render("order.blade.php", orders);
                            }
                        }



        - NOTE:::
            - createViewEngine() method is acting as our Factory method as it returns a new object and it can be a different type of object depending on if we oveeride it or not -  what we have done is to essentially deferred the creation of an object(the ViewEngine) to a subclass and in this case a subclass is TwigController coz it's a subclass of the base controler class
            - Another option would be to make the createViewEngine() an abstract method and force subclasses to implement it in our case we have made it just a regular method hence it can be overriden
                - If we decide to make it an abstract method then we'd need to create a blade controller that implements this createViewEngine() and returns a BladeViewEngine forcing developer to select either Blade or Twig Controller

 */

public class Explanation {

}
