/*

    NOTES:
    - HttpServletRequest req & HttpServletResponse res:

    - The above 2 objects are applied on service(), doGet() and doPost() methods
    - Say we have a client machine and a server and a client wants to add 2 numbers. This means that we need to first send the request and then you have to pass those 2 values say 24 and 49.
    - How do you pass these 2 values?, maybe we dont just want the 2 values, how about we also want to know the client address, we also want to know which browser the client uses. TO send all these information you have to pass it in some format, we can put them in an object as we are using java programming lanuage.
    - Now this object is going from the client page to the server as your request object, request oobject is an object which will hold your values. Once the server got the request it has to send back a response. When you are sending a response at times we might wanna send some data inform of HTML we want o send a video, we want to send an image. You can send all that information in one particular object in a response object. i.e while sendint the data, we will be sending the response object, all the data a client needs. NOTE: YOur response can be in any format, a text, a html, video and whatnot of which you can always specify whatever format you want to go for
    - All the request and response objects are send and received by the help of HttpServletRequest and HttpServletResponse
    - NOTE:
        - We dont need to create an object of either objects [HttpServletRequest & HttpServletResponse] they are created for us by the help of Tomcat server
        - THe 2 objects are interfaces not a class but the implementation is done by TOmcat and object will be given by the Tomcat and for that reason if you want to run a web application you need a Tomcat server

 */

public class Notes {
}
