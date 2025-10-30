/*

    NOTES:
    - ServletConfig & ServletContext:

    - We use these ServletConfig & ServletContext to get the intial values for a servlet or for the application. Say example you want to specify the file path or you want to specify a susername and password

    - Pratical implementation:
        - We have the web.xml file in which you can mention some intial parameters you might need and then you can use those parameters inside your code. Example blow we want to specify a name and phone brand someone had


            <context-param>
                <param-name>name</param-name>
                <param-value>Jarvis</param-value>
            </context-param>

            <context-param>
                <param-name>phone</param-name>
                <param-value>Samsung</param-value>
            </context-param>


        - The above are our initial values and we can use them by fecthing a special object of ServletContext(which is an interface). You just instantiate it using what Tomcat already provides us which is calling getServletContext() method[NOTE: The method is coming from HttpServlet]

        		ServletContext ctx = getServletContext();

        - Using this object we call getInitParameter() to get whatever initial value we have/had, all you need to do is to pass the param-name you specified in web.xml file

    		    String name = ctx.getInitParameter("name");


                    public class MyServlet extends HttpServlet {
                        public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

                            PrintWriter out = res.getWriter();

                            ServletContext ctx = getServletContext();
                            String name = ctx.getInitParameter("name");
                            out.println("name: " + name);

                        }
                    }

        - Normally we use file path, the location of your database maybe your username and password for that database. You can just pass them in here
        - We also have servlet config of which we can also intialize some values the same way as ServletContext the only difference is, in your application you might have several servlets(5-10 or 100) the servlet context will be shared by all the servlets, i.e if you intialize name the same name will be acccesible to all the servlets
        - If you want to have different configurations for different servelts you will be using servlet config instead of servlet context. You achieve this by adding the init-param tag inside your desired servlet tag you need it on. Everything else reamains the same interms of param-name and param-value tags

                    <servlet>
                        <servlet-name>qpr</servlet-name>
                        <servlet-class>_08_ServletConfigAndContext.MyServlet</servlet-class>

                        <init-param>
                            <param-name>innerName</param-name>
                            <param-value>Wuod</param-value>
                        </init-param>
                    </servlet>

                    <servlet-mapping>
                        <servlet-name>qpr</servlet-name>
                        <url-pattern>/home</url-pattern>
                    </servlet-mapping>

        - To use the context config above you first create an instance of ServletConfig and instanciate it to getServletConfig() method for which you will getInitParameter() method from just as in we did under servletcontext

                    public class MyServlet extends HttpServlet {
                        public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

                            PrintWriter out = res.getWriter();

                            ServletConfig cg = getServletConfig();
                            String innerName = cg.getInitParameter("innerName");
                            out.println("innerName: " + innerName);
                        }
                    }

        - If you have the same param-name in servletConfig as in servletContext with different values. The config value will be called

        - Summary:
            - For multipe servelts to share the same  value go for servlet context
            - If you have different values for different servlets gor for servlet config

 */

public class Notes {
}
