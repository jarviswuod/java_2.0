/*

    NOTES:
    - In the previous video we created a web project in eclipse then created one page, index.html which is takes 2 values and want to sum them. The moment you clisk submit we want to call "add" the purpose of having the 'add' is just to add the 2 numbers of which we will use a server side technology to sum the values up, in this case we will use servlet in java

    - We create a servlet by creating a normal class and then we extend the HttpServlet, once you extend the HttpServlet you are done, you class becomes a servlet
    - The next thing is when we click on the submit button on our form we will call 'add' and we expect that when we call 'add' we will be calling our AddServlet, it wouldn't be happening automatically

    - If our class AddServlet is working, if you want to perform any operations you need methods (from core java). This makes it that we have to use a method over here too and we will be using a service() method because a servlet is a server componenet which basically provides a service.
        - NOTE:
            - You can't use any other method name as a service() is a method that belongs to a servlet lifecycle

    - Inside the service() method we want to accept a request from the user and want to perform some task. Servlet makes it easy for us as we have 2 kinds of object we have to pass inside our serice();
        1. HttpServletRequest and
        2. HttpServiceResponse

        - NOTE: for this object you dont have to create them by yourself as they will be created by Tomcat, you just need to make a reference of it
        - Using the HttpServletRequest you can fetch data from the client and using the HttpServletResponse object you can send response to the client

    - A user is sending in 2 values in form of parameters, what we need to do is to get the parameters using the HttpServletRequest object. The values comes in as string and we expect an integer hence the need to cast them. Once we get the values we do a simple addition and print it to test if everything is working correctly

            public class AddServlet extends HttpServlet {

                public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {

                    int i = Integer.parseInt(req.getParameter("num1"));
                    int j = Integer.parseInt(req.getParameter("num2"));

                    int k = i + j;
                    System.out.println("Result is " + k);
                }
            }

    - When we run the aplication, we have a form UI which once we fill in our details and click submit, we get an error """ HTTP Status 404 – Not Found """. One thing we should observe howerver is the address bar [[ http://localhost:8080/_02_CreateServletAndWebXML/add?num1=23&num2=14 ]] We are sending an add request that is perfect and also passing the values, i.e we passing the values of num1 and num2 in the address bar[[ ?num1=23&num2=14 ]]. This is called a query string
    - Query string is a part where you can send your data from a client to a server

    - We get an error whenever we press the submit button, yet we alreay have the servlet. THe last missing thing we need to do to ensure our problem has no errors is to connect our 'add' action to our AddServlet class, we achieve this using the deployment descriptor/web.xml file. Over here we want to configure our servlet i.e whenever a user requests for 'add' we should call AddServlet in turn. We use two tags servlet tag and servlet-mapping tag each tag has two tags again


            <display-name>_02_CreateServletAndWebXML</display-name>

            <servlet>
                <servlet-name>abc</servlet-name>
                <servlet-class>_02_CreateServletAndWebXML.AddServlet</servlet-class>
            </servlet>

            <servlet-mapping>
                <servlet-name>abc</servlet-name>
                <url-pattern>/add</url-pattern>
            </servlet-mapping>

        - We have servlet-name tag appearing twice, this is because in our program we might have multiple servlets to avoid confusion if we have lots of servlets, hence we link them with the same name

    - With this we no longer get an error when we click the submit button and when we look at our console we get "Result is 37" meaning everything is working good. We now want to display our result instead of having a blank screen upon submission. To print on page we use a getWriter() method on the response which is sent back from our AddServlet class.
    - getWriter() returns an object of a PrintWriter 

            public class AddServlet extends HttpServlet {
                public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {

                    ...
                
                    PrintWriter out = res.getWriter();
                    out.println("Result is " + k);
                }
            }


    - With this our result gets displayed back on screen instead of the console



    - In summary:
        - we have created a simple AddsServlet class in any package you want, you just have to extend the HttpServlet class inwhich you just have to define a service() method and can't go for another name
        - The service takes in 2 objects HttpServiceResponse and HttpServiceRequest  and then you need to fecth and add our 2 values and finally print back to our user

 */

public class Notes {
}
