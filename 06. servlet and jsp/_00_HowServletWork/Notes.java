/*

    NOTES:
    1. Introduction to Servlet:
        - We will be learning on how servlets work
        Imagine we have a client machine and a server, A client sends a request to the server expecting a page, (you could ask for anything). This page can be a static page and it can also be a dynamic page. static means it's already made, while dynamic means it will be built at runtime

        - A client sends a static request to the server and on your server you already have a file(prebuilt) that file goes to the client and you are done( You have a request and a response). Now, imagine a situation where you asking for a page that is different from which it will be built at runtime. A client will send a request to the server, the server says hold on I dont have any page  with this link, so you have to make the page, you have to build the page. For that this request goes to a particular helper application on the server. This helper application is also called "Web Container". Inside this web container you will be having servlets, a servlet is basically a java file which takes in a request from the client on the internet and it can process that request it can then provide you with a response inform of html page. This means, the servlet will take your request, it will fetch your values, it will process the information and it will send a HTML page

        - Once again, from the client side, a request goes to a server, on the server side since it's a dymanic request it will go to your web container(Apache Tomcat, GlassFish, Jboss, WebSphere) In your Tomcat the request needed is for a particular page say abc.html but we dont have any page yet called abc.html so you have to build that page. this makes the request go to the servlet. A servlet will be having s java name example, when you create java class to add 2 numbers, the name will be addservlet, this means when a request for abc.html the page that's getting called is your servlet.

        - WHat happens here is that inside your container, you have a special file called a 'Deployment descriptor(web.xml)' for which you mention for which request which servlet will be called

        - When a client sends a request the request goes to the server, the server think this is a dynamic page let's send the request to a web container. a web container will check which request is mapped by this servlet which is doen by the help of web.xml file.

        - Inside a web.xml file we have 2 tags, servlet tag and servlet-mapping tag. In the servlet tag you have to metion the class name and in the servlet-mapping tag you have to mention the URL pattern i.e for this URL you have to call that classname, servlet.

        - We create a servlet as a normal class which extends HttpServlet as we want servlet features. This is because the HttpServlet will provide you all the features that you might need i.e take request from the server,  processing the request and sending back a response. The response will be inform of HTML. YOu can send the response in Json format, normal string, XML format or the HTML format. Now that HTML response format is a dynamic HTML page that goes to your client machine in format of response object

        - We have the alternative of using web.xml which is using annotations. We can use annotations on your servlets so you dont have to use web.xml file. Example ; @WebServlet("/abc.html")

        - Recap:
            - We have a client machine request goes to server, from the server your request goes to your web container. web container uses a file  web.xml to detect which servlet to call and that servlet will process the information and it will send the response to the client machine

 */

public class Notes {
}
