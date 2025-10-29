/*

    NOTES:
    - RequestDispatcher & sendRedirect Theory:

    - This is a theroy lecture of how to call a servlet from another servlet
    - Imagine we have a servlet s1 and another servlet s2

    - Inside the same website
        - We have a client who want to send a request to s1, normally we do that by creating a button on the page or you can submit form, what you configure it and click submit it will call s1, s1 will interm send back a response to client. DUring this process 2 objects comes into picture, request object and response object. Here a client will send a reqeust to s1/s1 will use a request object to fectch data from a client  and s1 response will send a response back to the client. for this scenario say we have request1 and response1 because we have s1
        - Imagine we have another situation where s1 should be calling another servlet s2 instead of s1 sending a response back to client its supposed to call a second servlet s2.
        - we can achieve this by the help of a special feature RequestDispatcher, we will name our dispatcher as rd,. using rd you can call s2 from s1. You just have to create an object of RequestDispatcher and mention a url name for s2. But this is not enough to make the whole thing work out for us, we also need to  forward the 2 object request and response.
            - NOTE:
                - You have to send the same 2 objects request1 and response1 so that if you want to mention a data to s2. Reason for this is if you want to send data to s2 say a variable 'x' ll you need to do is to add it in the request1 object so you cah access the data in s2 as well because the s2 will be using the same 2 objects anyways

        - Now if you want to send a response to the client, a response which will be send back to client will be the same response1. THis way even the client doesnot know where the response is coming from is it s1 or is it s2. To verify this the address bar URL is still from the same s1 servlet
        `- This works fine when you have the same webiste say jarviswuod.com i.e both s1 and s2 on the same website


    - Different websites:
        - If you have a scenario where you have 2 serverts from 2 ifferent dwebsites, say jarviwwuod and paypal
        - In this scenario, jarviswuod.come will send a request tos2 which is paypla, during this moment the client shoudl know that something is happening behind the scene. This mean the request to paypal should be made from/ by paypal. Say when you click a button that says donate inside jarviswuod.com website, jarviswuod.com wevsite will inform the broswer that "Hey you are getting redirected to paypal" which is a payment gateway
        - In this case you cannot use a RequestDispatcher object because in RequestDispatcher our client doesnot know you are getting redirected
        - In this case will be using a special method called a sendRedirect() which this approach the client actually knows that you are getting redirected to the next servlet
                - NOTE:
                    - In scenario 1[RequestDispatcher], s1 will call s2 but in the second scenario s1 will inform the browser that they are getting redirected to s2. this mean when a browser

        - Say we have s1 and s2 just our example, browser sends a request to s1 and s1 cannot call s2 directly, for this s1 will inform browser  to go to s2, in this case we have 2 different request objects, i.e to send a request to s1 and s2 to send another request s2 of which we will also get another response s2
            - Summary:
                - In sendRedirect() you bacially send 2 different requests while in dispatcher, we were using the same request object
                - This means if you want to send and maintain data between s1 and s2 in sendRedirect(),we have to use a concept of session management

 */

public class _02_Notes {
}
