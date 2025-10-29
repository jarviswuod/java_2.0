/*

    NOTES:
    - RequestDispatcher | Calling a Servlet from Servlet

    - First we ensure we are only using doGet and only sending a 'get' request 
    - Hypothetically if you have 2 servlets, 1 is a addition servlet, the second is a square servlet, we can decide to call one servlet from the other servlet
    - Currently we are calling a servlet from a page

    - To call a servlet from another servlet we should create one more servlet called SquareServlet
    - For this method too we'll use a doGet() method to send a method too

            public class SquareServlet extends HttpServlet {
                public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

                    PrintWriter out = res.getWriter();
                    out.println("Hello to square");

                }
            }


    - To connect the 2 servlets we have 2 options;
        1. Request Dispatcher
        2. Redirect
        
        NOTE:
            - In our case we will be using a request dispatcher

    - To use a request dispatcher between the 2 servlet we need to create a Requestdispatcher object from a getRequestDispatcher() method mentioning the url of the 
    - We also have to forward the 2 objects, the request and response

                public class AddServlet extends HttpServlet {

                    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

                        int i = Integer.parseInt(req.getParameter("num1"));
                        int j = Integer.parseInt(req.getParameter("num2"));

                        int k = i + j;
                        k *= k;
                        req.setAttribute("k", k);

                        RequestDispatcher rd = req.getRequestDispatcher("square");
                        rd.forward(req, res);

                    }
                }

    - This still won't work for our case, reason being if you want to call any servlet you have to ensure that in the web.xml file we mention the specific servlet mapping hence need to create servlet and servlet-mapping tags for SquareServlet inside our web.xml file

                <servlet>
                    <servlet-name>qpr</servlet-name>
                    <servlet-class>_04_RequestDispatcher.SquareServlet</servlet-class>
                </servlet>
                
                <servlet-mapping>
                    <servlet-name>qpr</servlet-name>
                    <url-pattern>/square</url-pattern>
                </servlet-mapping>


    - With this set up everything works great for us, and "Hello to square" is printed on the screen with a change in the address bar url  [[ http://localhost:8080/_04_RequestDispatcher//add?num1=23&num2=14 ]]
    - Explanation:
        - If you click on submit under index.html form in [[ http://localhost:8080/_04_RequestDispatcher/index.html ]] address bar it will call the AddServlet, from AddServlet we are dispatching the request to 'square' but we don't know what 'square' is and for that reason we check the web.xml file where we find that we have to call the SquareServletch which prints "Hello to square" on screen

    - The thing is however we dont want to print anything on screen we want to also send some data to SquareServlet. For that we can do some session management staff
    - If you want to send some data from one server to the other or maybe you want to  share data between different servlets we use a concept of session management
    - Since we are forwarding a request and a response objects from one servelt to the other i.e AddServlet to SquareServlet and she same 2 forwarded objects from AddServlet are the same exact ones used inside the SquareServlet. We can put in some data in the request object, keep in mind we are already forwarding the request and response object anyways,w e could just insert some data to push. TO accomplish this we will use setAttribute() which contains a key and a value parameter. this makes it easy to refer to inside the squareServlet

            public class AddServlet extends HttpServlet {
                public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

                    int i = Integer.parseInt(req.getParameter("num1"));
                    int j = Integer.parseInt(req.getParameter("num2"));

                    int k = i + j;
                    req.setAttribute("k", k);

                    RequestDispatcher rd = req.getRequestDispatcher("square");
                    rd.forward(req, res);

                }
            }


    - We need now to access the data we send along the forwarded objects, over here inside the SquareRequest we just need to call the getAtribute() method mentioning whatever data we want from the forwarded items and do whatever we want to do with it

            public class SquareServlet extends HttpServlet {

                public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

                    int k = (int) req.getAttribute("k");
                    k = k * k;

                    PrintWriter out = res.getWriter();
                    out.println("Result is " + k);

                }
            }

    - We can accomplish the same task we have over here using the redirect

 */

public class Notes {
}
