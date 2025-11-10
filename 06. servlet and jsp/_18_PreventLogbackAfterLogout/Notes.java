/*


    NOTES:
    - Login Using Servlet & JSP Practical part 2:

    - We should always use post request whenever we are sending something to the server and get request whenever we need something from the server. For this reason we change our servlet method from doGet() to doPost()
            @WebServlet("/Login")
            public class Login extends HttpServlet {

                public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                ...
                }
            }


    - Inside the form too we change from the default get() method to post method
            <form action="Login" method="post">
                Enter username: <input type="text" name="uname" /><br />
                Enter password: <input type="password" name="password" /><br />
                <input type="submit" value="Login" />
            </form>


    - The most important thing to keep in mind is after logging out we need to not be able to access any resource that needed logging in. This is currently possible a very big seurity vulnerability
    - Http protocals provides a lot of features example; session, cookies and cache
        - Cache is what makes your web experience more faster as we do maintain the cache
            - In our website when we log out and press the back button we are able to access the page as it is cached by the browser. We want to terminate the cache ability within the browser

                    <body>
                        <%

                            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
                            response.setHeader("Pragma", "no-cache"); // HTTP 1.0
                            response.setHeader("Expires", "0"); // Proxies

                            if (session.getAttribute("username") == null) {
                                response.sendRedirect("login.jsp");
                            }
                        %>

                        ...
                    </body>

        - We do add this code on top of every page that needs to be secured

        - NB:
            - Session objects are browser specific. This means the moment you change your browser a new new object will be needed for it. Whenever you do any form of verification you are doing withing the same specific browser object

 */

public class Notes {
}
