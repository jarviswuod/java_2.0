/*

    NOTES:
    - HttpSession
        - In the previous video we used url rewriting to send data between 2 servlets by the help of sendRedirect
        - The challenge of using url rewriting is that, it's quite difficult to send multiple values with it or you want to send same value in multiple servlets. It becomes hard to manage the entire thingy
        - We overcome this challenge by using session. Whenever you go to a web application, it will try to maintain a session for you and that will done by Tomcat
        - Since a session is always throughout your website servlets. you can easly add your data for it to help supply it in different servlets you might want throughout a servlets. A session value comes in super handy

        - For practical implementation
            - Since a session object is provided by Tomcat server and you just have to get a hold of it. All you need to do is call the setSession() method on the reqeust and instantiate a HttpSession which is an interface

                		HttpSession session = req.getSession();

            - Once we have a session we can set an attribute from it and use the value through out the servlets as long as we dont remove or delete the session object

                        session.setAttribute("k", k);


                        public class AddServlet extends HttpServlet {

                            public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

                                int i = Integer.parseInt(req.getParameter("num1"));
                                int j = Integer.parseInt(req.getParameter("num2"));

                                int k = i + j;

                                HttpSession session = req.getSession();
                                session.setAttribute("k", k);

                                res.sendRedirect("square");

                            }
                        }


            - We access the value by calling the getAttribute() method

            		int k = (int) session.getAttribute("k");


                        public class SquareServlet extends HttpServlet {

                            public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

                                HttpSession session = req.getSession();

                                int k = (int) session.getAttribute("k");
                                k = k * k;

                                PrintWriter out = res.getWriter();
                                out.println("Result is " + k);

                            }
                        }


            - The attribute/value will be available throghout the session as long as we dont delete/remove it 

                        session.removeAttribute("k");

 */

public class Notes {
}
