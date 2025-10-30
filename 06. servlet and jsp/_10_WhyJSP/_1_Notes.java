/*

    NOTES:
    - Why JSP(Java Server Pages) ?

    - In servlet we write HTML inside java while in JSP we write java inside html pages


    - Servlet:

            @WebServlet("/add")
            public class AddServlet extends HttpServlet {
                public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

                    int i = Integer.parseInt(req.getParameter("num1"));
                    int j = Integer.parseInt(req.getParameter("num2"));

                    int k = i + j;

                    PrintWriter out = res.getWriter();
                    out.println("<html><body bgcolor='cyan'>");
                    out.println("Result is " + k);
                    out.println("</body></html>");

                }
            }



    - Practical implementation:
        - We create add.jsp just someone can create any other file inside eclipse. Once it's created it comes up preloaded i.e it comes with html template already
        - What we have to do is to now add java code to add the 2 numbers inside the jsp file and display the output

                <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
                <!DOCTYPE html>
                <html>
                    <head>
                    <meta charset="UTF-8" />
                    <title>Why JSP</title>
                    </head>
                    <body bgcolor="blue">

                        <%

                            int i = Integer.parseInt(request.getParameter("num1"));
                            int j = Integer.parseInt(request.getParameter("num2"));
                            int k = i + j;
                            out.println("Result is " + k);

                        %>

                    </body>
                </html>

        - We separate html and java by adding java inside the tags <% %>

        - To ensure the code is working we will actually call the add.jsp file instead of 'add' the servlet. This is done insde the action attibute of index.html(Where the execution starts). No need for annotations

                <form action="add.jsp" method="get">
                    Enter 1st number : <input type="text" name="num1" /><br />
                    Enter 2nd number : <input type="text" name="num2" /><br />

                    <input type="submit" />
                </form>


        - Observation:
            - With these changes, we have everything working perfectly as the bg color changes
            - Something worth noting is the address bar url change [[ http://localhost:8080/_10_WhyJSP/add.jsp?num1=23&num2=3 ]] from the original [[ http://localhost:8080/_10_WhyJSP/index.html ]]
            - NOTE:
                -  add.jsp is inside the address url

 */

public class _1_Notes {
}
