/*

    NOTES:
    - Servlet Filter Practical:

    - We have a normal Servlet which is basically taking some values from a form and printint them out on a page. It works great however, using filter knowledge we want to add a pluggable functionality of checking the form values and either allowing the end product to be seen or not bu displaying a completely different page

                    @WebServlet("/addAlien")
                    public class MyServlet extends HttpServlet {
                        protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

                            int aid = Integer.parseInt(req.getParameter("aid"));
                            String name = req.getParameter("aname");

                            PrintWriter out = res.getWriter();
                            out.println("Welcome " + name);
                        }
                    }

    - Below is the base structure of a filter
        - It's implementing an interface named Filter.
        - Inside the Filter we have a constructor, a destroy(), doFilter() and init() methods
        - init() Before using the filter if you wanna intialize the values. you can do it inside the inti() method. With the FilterConfig ability in every filter

        - destroy(): If you wanna destroy the Filter after it's initialization under init() and use under doFilter() under the destroy() method

        - doFilter is the same as doGet() and doPost() methods in servlet, you accept request and process values. The unique thing about it is that you have FilterChaining.
            - As we have the ability to use more that one filter. If you have several filters working on the same path/Servlet/request. By default when you run the application, it will run the first Filter. Once the filter has done it's own work it will call the second filter this is done chain.doFilter() method. If we are now operating on the last filter then we dont call the next filter instead at this point we call the servlet. i.e call the filters first then call the Servlet once done with filters


                    @WebFilter("/addAlien")
                    public class IdFilter implements Filter {

                        public IdFilter() { ... }

                        public void destroy() { ... }

                        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                                throws ServletException, IOException {

                                chain.doFilter(request, response);

                        }

                        public void init(FilterConfig fConfig) throws ServletException { ... }
                    }


    - Everything operates just the same way as it does operate on the Servlet when it comes to doFilter() method. In this case what we have is that when value processed is greater than 1, only then do we execute chain.doFilter() method. Meaning we call the next filter or servlet if this is the last filter avaiable. Otherwise we print "Invalid response" on screen

                public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                        throws ServletException, IOException {

                    int aid = Integer.parseInt(request.getParameter("aid"));
                    PrintWriter out = response.getWriter();

                    if (aid > 1)
                        chain.doFilter(request, response);
                    else
                        out.println("Invalid response");
                }

 */

public class Notes_3 {
}
