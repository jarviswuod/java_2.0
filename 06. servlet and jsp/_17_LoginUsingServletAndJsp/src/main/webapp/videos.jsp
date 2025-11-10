<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Videos: Login Using Servlet And Jsp</title>
  </head>
  <body>

	<%
		
		if(session.getAttribute("username")==null){
			response.sendRedirect("login.jsp");
		}
		
	%>

	<iframe width="560" height="315"
		src="https://www.youtube.com/embed/W2zhRgi69Z0?si=IJvnQlXlp9H36DbC"
		title="YouTube video player" frameborder="0"
		allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
		referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

  </body>
</html>
