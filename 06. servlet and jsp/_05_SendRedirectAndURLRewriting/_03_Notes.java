/*

    NOTES:
    - sendRedirect | URL Rewriting:
        - In the last practical video we had implemented requestDispatcher
        - We have a page in which we are going to do is asking for 2 values. THe moment you hit on the  submit it will send a request to 'add' [action="add"] and when you send a request to add it will call the AddServlet as per what we have configured in the  pom.xml file and once you call it it will call the doGet() because we are sending a request. THen we are passing the the 2 values  via getParameter() method since they are right in the address bar url, once you get them you add them then you send the data in the request object so that when you fire the request/ send a request to the next servlet "square" by using RequestDispatcher you can just forward passing the request object plus the response object and using the request object on the second server

        - In the second servlet what we are doing is fetching from the value from the request object, we are storing in our variable and then we are performing an operation and printing it using the PrintWriter object


    - In this video we will be doing the same thing but using a different tool other than the RequestDispatcher, we'll be using the sendRedirect
        - How to call the second servlet using the sendRedirect(). Since we are not using the RequestDispatcher it's safe to remove the setAttribute() method on the request object and remove the RequestDispacher entirely
        - We can call the second servlet by simply calling the sendRedirect() method on the request object and passing in the url path of the targeted servlet "square"

                res.sendRedirect("square");


        - At this point when you do your testing everything works super great

        - Since the second servlet is working well, we now need to send data between the 2 servlets. To send data between the 2 servlets we rely on the primary concept that we are sending a request using on a 'get' method and for this type of method we use getParameter() for which the data is stored/send along the address bar url.
        - Keep in mind we are we need the value of 'k' to be sent from AddServlet to SquareServlet. To effectively send 'k' along the parameter we have to modify our sendRedirect() method parameter to;

                res.sendRedirect("square?k=" + k);


                public class AddServlet extends HttpServlet {
                    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

                        int i = Integer.parseInt(req.getParameter("num1"));
                        int j = Integer.parseInt(req.getParameter("num2"));

                        int k = i + j;

                        res.sendRedirect("square?k=" + k);

                    }
                }


        - Inside the SquareServlet all we have to do to get the value is to call the getPameter() method on the request object and continue with out operation as we did under RequestDispatcher's getAttribute() method

                public class SquareServlet extends HttpServlet {
                    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

                        int k = Integer.parseInt(req.getParameter("k"));
                        k = k * k;

                        PrintWriter out = res.getWriter();
                        out.println("Result is " + k);

                    }
                }



        - This is the first way in which you send a value from one servlet to another using the sendRedirect() method
                - This technique is called URL rewriting
                - We can also use;
                    - sessions
                    - cookies

 */

public class _03_Notes {
}
