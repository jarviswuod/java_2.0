/*

    NOTES:
    - Login Using Servlet & JSP Practical part 1:

    - login.jsp: page;
        - We have a login page form where you fill in username and password and the moment you click on the submit button it will take you to Login Servlet
            <body>
                <form action="Login">
                Enter username: <input type="text" name="uname" /><br />
                Enter password: <input type="password" name="password" /><br />
                <input type="submit" value="Login" />
                </form>
            </body>

    - Login class: Servlet;
        - This servlet is used to verify loggedin credentials
        - If your username is right  it will take you to welcome.jsp page otherwise it will take you back to login.jsp page
        - Before to going to welcome.jsp it will set up the "username" attribute as "username"

            @WebServlet("/Login")
            public class Login extends HttpServlet {

                public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                    String uname = request.getParameter("uname");
                    String pass = request.getParameter("password");

                    if (uname.equals("jarvis") && pass.equals("jarvis")) {

                        HttpSession session = request.getSession();
                        session.setAttribute("username", uname);

                        response.sendRedirect("welcome.jsp");
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                }
            }

    - welcome.jsp: page;
        - Here username is printed on screen the same username set under Login Servlet but before that it checkes if you are logged in(checking if attribute is set). If not logged in it will take you to login.jsp
        - Otherwise it will display you username and also a login out button and a link to videos. Once you click on videos link you are redirected to videos.jsp page
        - Altenatively one can click on the Logout button which will take you to Logout Servlet

            <body>

                <%
                    if (session.getAttribute("username") == null) {
                        response.sendRedirect("login.jsp");
                    }
                %>

                Welcome home ${username} ...

                <a href="videos.jsp">Videos here</a>

                <form action="Logout">
                <input type="submit" value="Logout" />
                </form>
            </body>

    - Logout class: Servlet;
        - Here we remove the initially set username attribute then redirect you to login.jsp page

            @WebServlet("/Logout")
            public class Logout extends HttpServlet {

                public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                    HttpSession session = request.getSession();
                    session.removeAttribute("username");
                    session.invalidate();

                    response.sendRedirect("login.jsp");
                }
            }


    - videos.jsp: page;
        - Here is a list of videos someone can watch after checking if one is logged in. If not logged in it will take you to login.jsp

            <body>

                <%
                    
                    if(session.getAttribute("username")==null){
                        response.sendRedirect("login.jsp");
                    }
                    
                %>

                <iframe width="560" height="315"
                    src="https://www.youtube.com/embed/W2zhRgi69Z0?si=IJvnQlXlp9H36DbC"
                    title="YouTube video player" frameborder="0"
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                    referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

            </body>


    - about.jsp: page;
        - This is the only page someone can visit freely without logging in

        <body>
            This is Jarvis From JarvisWuod.com...
        </body>

 */

public class Notes {
}
