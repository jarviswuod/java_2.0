<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Exception Handling In JSP</title>
  </head>
  <body>
	<%
		try {
	
			int i = 9 / 0;
		} catch (Exception e) {
			out.println("Oops!!! Cannot divide by zero");
		}
	%>
  </body>
</html>
