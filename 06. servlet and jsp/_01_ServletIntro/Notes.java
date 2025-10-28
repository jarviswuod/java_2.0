/*

    NOTES:
    - Java project has been setup and started successfully; from installing eclipse and tomcat and setting them up to work together
    - What we did is just over is creating a file called base.html with basic html content for testing purposes and did run the server. It all works good and perfect at URL: http://localhost:8080/_01_ServletIntro/base.html

        _01_ServletIntro/src/main/webapp/base.html
            <!DOCTYPE html>
            <html>
                <head>
                    <meta charset="UTF-8" />
                    <title>Random title test</title>
                </head>
                <body>
                    <p>This is Jarvis</p>
                </body>
            </html>



    - This is a static page with is just a request and a quick reponse back to the client. We want to create a dynamic page which will require processing to learn about servlet. In this case will be adding 2 numbers, process them and send back a response

        _01_ServletIntro/src/main/webapp/index.html
            <!DOCTYPE html>
            <html>
                <head>
                    <meta charset="UTF-8" />
                    <title>Random title test</title>
                </head>
                <body>
                    <form action="add">
                        Enter 1st number : <input type="text" name="num1" /> <br />
                        Enter 2nd number : <input type="text" name="num2" /> <br />

                        <input type="submit" />
                    </form>
                </body>
            </html>

    - With this setup we have a form UI that takes 2 numbers but causes an error when the submit button is clicked, reason is we have set an action as 'add' under the form but we really haven't set up the add servlet and functionality. the action is the url we will be using to precess the logic. 
    - With this a request is send successfully but an error follows up as we haven't setup a servlet to help match the action url 'add'. The url is initially  http://localhost:8080/_01_ServletIntro/base.html but then gets converted to http://localhost:8080/_01_ServletIntro/add?num1=&num2=
    - What this means is 'add' request is hitting the Tomcat server and processed leading to the error as we dont have any page for the add page, for this now we need a servlet

    - Next part is setting up a servlet

 */

public class Notes {
}
