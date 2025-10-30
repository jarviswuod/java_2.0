/*

    NOTES:
    - Implicit Object in JSP

    - In Servlets if you want to any objects like request, responce objects, those objects will be created by Tomcat but still we have to refer them example in service() method we mention HttpServletRequest and HttpServletResponse, and if you want to print something you have to create an object of PrintWriter and then finally if you want to instanciate session you have to say HttpSession then session. Inshort we are still responsible to create the references

    - In Java Server Pages, we have lots of features, example writing java code inside of html. Jsp also gives some objects to use below are the 7 objects;(can be used in Scriplet and Expression)
    		- request(HTTPServletRequest)
    		- response(HTTPServletResponse)
    		- pageContext(PageContext)
    		- out (JspWriter) ~ PrintWriter object
    		- session (HttpSession)
    		- application (ServletContext)
    		- config (ServletConfig)

    - The good thing is that you don't have to instanciate the objects jsp provides them to you as compared to in servlet
            // Servlet
            public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

                int i = Integer.parseInt(req.getParameter("num1"));

                PrintWriter out = res.getWriter();
                out.println("Result is " + k);
            }



            // Jsp
            <%
		    	request.getParameter("name");
		    	config.getInitParameter("name");
            %>

    - Note: pageContext is an object of PageContext using which you can set a value or you can get a value so that you can use the value later(Done by the help of setAttribute() method)

            pageContext.setAttribute("name","Wuod");

    - By default the scope of the value is within the same page but we can up either make the value accessible in the entire page, session or request
			pageContext.setAttribute("name","Wuod", PageContext.SESSION_SCOPE);
			
				- Request scope
				- Session scope
				- By default it's page Scope

        - NOTE:
            - Request scope means, the current page and the next page(page you are requesting)

 */

public class Notes {
}
