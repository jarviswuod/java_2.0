/*

    NOTES:
    - Servlet Filter Practical:

    - A filter is a class which extends the Servlet Filter interface and is used to perform tasks like logging, authentication, data compression etc
    - You have 3 methods in a filter
        - init() : To indicate to a filter that it's being placed into service
        - doFilter() : Called everytime a request/response pair is passed through the chain due to a client request for a resource at the end of the chain
        - destroy() : To indicate to a filter that it is being taken out of service

    - Filters are avaible to intercept requests and responses in a web application

    - Filter Chaining:
        - Multiple filters can be configured to a single servlet
        - The order of filter execution is determined by the order in which they are defined in the web.xml file
        - The first filter defined in the web.xml file is the first filter to be executed
        - The filters are not aware of each other, they just pass the request and response to the next filter in the chain

    - FilterConfig
        - You can configure individual filters using the FilterConfig object same way we have ServletConfig object for servlets

 */

public class Notes_2 {
}
