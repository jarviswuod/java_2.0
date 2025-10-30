/*

    NOTES:
    - Cookie

        - Other than using HttpSession to send data between servlets under the sendRedirect, we can also use cookies
        - Whenever you send a request to the server and a server sends you a response. In that response object from the server we will have a cookie and then when you send a request to the SquareServlet you will send the same cookie again
        - In summary the cookie is coming from the servers response and is sent back to the server and sent back to the second servlet

        - Practical implementation os a cookie
            - Cookie is basically a class just like any other object we create a new Cookie setting a key and value with it

            		Cookie cookie = new Cookie("k", k + "");

            - Once we have the cookie object we just have to add it to the response object by calling the addCookie() method passing the cookie inside of it

            		res.addCookie(cookie);


                    public class AddServlet extends HttpServlet {

                        public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

                            int i = Integer.parseInt(req.getParameter("num1"));
                            int j = Integer.parseInt(req.getParameter("num2"));

                            int k = i + j;

                            Cookie cookie = new Cookie("k", k + "");
                            res.addCookie(cookie);

                            res.sendRedirect("square");
                        }
                    }

            - What we have now is addSevlet sending a respone back to teh client and then a client will sent the rame request to SquareServlet of which a cookie will be send too
            -  Over here we have getCookies() method and not a getCookie(). Client gives you all the cookies you might need all you need to do is to figure out which cookies you want to utelize


                    public class SquareServlet extends HttpServlet {
                        public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

                            int k = 0;

                            Cookie[] cookies = req.getCookies();

                            for (Cookie c : cookies) {

                                if (c.getName().equals("k"))
                                    k = Integer.parseInt(c.getValue());
                            }

                            k = k * k;

                            PrintWriter out = res.getWriter();
                            out.println("Result is " + k);

                        }
                    }

            - 

 */

public class Notes {
}
