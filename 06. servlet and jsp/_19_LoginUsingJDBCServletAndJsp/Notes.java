/*

    NOTES:
    - Login Using Servlet & JSP & JDBC Part 3:

    - Whenever we want to work with the database, there are several layers we need to work with hence need to create a separate class LoginDao. Though not mandatory, we should have this class in a different package

    - LoginDao class:
        - We will be using this class to interact with our database
        - Inside this class we have a method called check() which takes in a username and a password


                public class LoginDao {
                    public boolean check(String name, String password) {


                        return false;
                    }
                }


        - Inside this method is where we should write our logic and since we are working with database we need to follow the 7 JDBC steps

                public class LoginDao {

                    String url = "jdbc:mysql://localhost:3306/jsp";
                    String user = "root";
                    String pass = "yourpassword";
                    String sql = "Select * from users where name=? and password=?";

                    public boolean check(String name, String password) {

                        try {

                            Class.forName("com.mysql.cj.jdbc.Driver");

                            try (Connection con = DriverManager.getConnection(url, user, pass)) {

                                PreparedStatement st = con.prepareStatement(sql);
                                st.setString(1, name);
                                st.setString(2, password);

                                ResultSet rs = st.executeQuery();
                                if (rs.next())
                                    return true;
                                System.out.println("Connected successfully!");
                            }

                        } catch (ClassNotFoundException | SQLException e) {
                            e.printStackTrace();
                            System.out.println("Issue " + e.getMessage());
                        }
                        return false;
                    }
                }


    - Login class:
        - With LoginDao class done we modify our Login class by creating a LoginDao object and using it

            -  OLD:: ::
                    @WebServlet("/Login")
                    public class Login extends HttpServlet {

                        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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


            -  NEW:: ::
                    @WebServlet("/Login")
                    public class Login extends HttpServlet {

                        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                            String uname = request.getParameter("uname");
                            String pass = request.getParameter("password");

                            LoginDao dao = new LoginDao();

                            if (dao.check(uname, pass)) {

                                HttpSession session = request.getSession();
                                session.setAttribute("username", uname);

                                response.sendRedirect("welcome.jsp");
                            } else {
                                response.sendRedirect("login.jsp");
                            }
                        }
                    }

 */

public class Notes {
}
