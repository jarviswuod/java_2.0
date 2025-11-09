/*

    NOTES:
    - Exception Handling in JSP:

    - When we work with servlets, it's easy to handle errors because we can just use a try and catch block for it
    - In servlets it's a bit different;
        1. Unchecked Exception:
            This causes an error and terminates the program throwing the exepction 
                - HTTP Status 500 - An error occured processing JSP page

                <!DOCTYPE html>
                <html>

                    <%
                            int i = 9 / 0;
                    %>

                    ...

                </html>

        2. Checked Exception:
            Unchecked exception causes the program to stop and we dont want the program to terminate. This leads to the introduction of a try catch block(Checked Excpetion)

                <!DOCTYPE html>
                <html>

                    <%
                        try {

                            int i = 9 / 0;
                        } catch (Exception e) {
                            out.println("Oops!!! Cannot divide by zero");
                        }
                    %>

                    ...

                </html>

            - With this it's not stopping the execution and throwing the exception, it's basically showing the error
            - This works perfectly, but in a web world if you get an error you should have a proper navigation. For this we have to create a separate page dedicated to only showing/displaying the error

                i. First when an error occurs we need to render it in a different page, hence we refer to that page incase of any error. In our case we will name it "error.jsp". Sample

                        errorPage="error.jsp"


                        <%@ page language="java" contentType="text/html; charset=UTF-8"
                        pageEncoding="UTF-8" errorPage="error.jsp" %>
                        <html>

                            <%

                                int i = 9 / 0;

                            %>

                        </html>


                ii. Second is we create the error.jsp page. In that new page, we use an implicit tag * <%= exception %> * on it to indicate that it's authorised to display an error. And finally this page should know that it is an error page which is achieved by using an attribute * isErrorPage="true" *. You can just decide to print the error message by using implicit object

                        <%= exception.getMessage() %>



                        <%@ page language="java" contentType="text/html; charset=UTF-8"
                        pageEncoding="UTF-8" isErrorPage="true"%>
                        <!DOCTYPE html>
                        <html>

                            <body bgcolor="red">
                                Error: <%= exception.getMessage() %>
                                <!-- <%= exception %> -->
                            </body>

                        </html>

 */

public class Notes {

}
