/*

    NOTES:

    - Servlet Annotation Configuration:
        - We want to configure our servlets with the help of annotations.
        - Currently we have a page called index.html which is asking for 2 values and the moment you click on the submit button  it will send add request and then you send an add request it will call the AddServlet. THe question comes how does Tomcat nows we are in need of AddServlet when we call add request i.e which servlet to call on which request.
        - For this issue we have web.xml file to help for it, here you mention a url with it's correponding servlet. Example;
                <servlet>
                    <servlet-name>abc</servlet-name>
                    <servlet-class>_09_ServletConfigurationAnnotation.AddServlet</servlet-class>
                </servlet>

                <servlet-mapping>
                    <servlet-name>abc</servlet-name>
                    <url-pattern>/add</url-pattern>
                </servlet-mapping>

        - In the example above, whenever you send a request for add, you will call AddServlet 

        - One doesnot have to only work with web.xml and one can work with annotations too
        - To use annotations, on top of your AddServlet you can call WebServlet() method inside of which you have to mention which url you will have to call the servlet

                    @WebServlet("/add")
                    @WebServlet("/square")



                @WebServlet("/add")
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

 */

public class Notes {
}
