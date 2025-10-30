<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <!-- 
    	Builtin Object (can be used in Scriplet and Expression)
    		- request(HTTPServletRequest)
    		- response(HTTPServletResponse)
    		- pageContext(PageContext)
    		- out (JspWriter) ~ PrintWriter object
    		- session (HttpSession)
    		- application (ServletContext)
    		- config (ServletConfig)
    	
     -->
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Implicit Object In JSP</title>
	</head>
	<body>
	
		<%
			request.getParameter("name");
		
			pageContext.setAttribute("name","Wuod",PageContext.SESSION_SCOPE);
			
				// Request scope
				// Session scope
				// By default it's page Scope

			
			config.getInitParameter("name");
			
		%>
	
	</body>
</html>