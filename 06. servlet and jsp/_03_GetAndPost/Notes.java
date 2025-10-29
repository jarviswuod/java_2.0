/*

    NOTES:
    - GET & POST Method:

    - HyperText Transfer Protocol (HTTP):
        - This protocal has several 5 methods to work with
            - Get
            - Post
            - Put
            - Delete
            - Options

        - We don't always use most of them and use
            - Post request to send request to the server
            - Get request to receive requests to the server

        - NOTE:
            - By default we always use Get request
            - Whenever we use a get request the data goes under the address bar [[ http://localhost:8080/_03_GetAndPost/add?num1=23&num2=14 ]]

                    [Default]       <form action="add"></>
                    [GET]           <form action="add" method="get"></>
                    [POST]          <form action="add" method="post"></>

            - When you use a post instead the data does not get passed through the address bar and we won't be using the address bar to send data as we do in get   [[ http://localhost:8080/_03_GetAndPost/add ]]
                - We get the same answer but the urls is as clean, no query String


    - Inside our AddServlet we can decide to only deal with a post request leaving our get request. HttpServlet actually gives us that ability by providing us with 2 extra methods on top of service() method. These are doGet() and doPost() methods
    - By changing service() to doPost() method what we are implying is that we are only dealing with post request
    - Same is tru when you working with doGet() method
    - The benefit of only using one method is that you escape the risk of SQL-injection
    - What's is happening behind the scene when submit button is clicked:
        - If you send a post request under the form method="" form it will go to the web.xml and look for the 'add' url of which our Tomcat internally has a serice method since we are extending the HttpServlet(requests always go to the service() method where now a do get or post method will be called, only that it's running behind the scene)


                public class AddServlet extends HttpServlet {
                    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

                        int i = Integer.parseInt(req.getParameter("num1"));
                        int j = Integer.parseInt(req.getParameter("num2"));

                        int k = i + j;
                        System.out.println("Result is " + k);

                        PrintWriter out = res.getWriter();
                        out.println("Result is " + k);

                    }
                }

 */

public class Notes {
}
