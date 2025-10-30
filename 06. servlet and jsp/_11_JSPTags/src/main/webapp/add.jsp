<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
	- JSP Tags:
		- Scriplet
		- Declaration
		- Directive
		- Expression
 -->

<%@ page  import="java.util.Scanner"%>
 <!--
 	- The above tag is a directive tag
 	- This tag is used to import a package
 -->
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP Tags</title>
	</head>

	<body bgcolor="blue">

		<%!
			int coef = 3;
			Scanner scanner = new Scanner(System.in);
		%>
		<!--
			- The above is a declaration tag
			- This code goes outside the service method of our servlet
		 -->

		<%
			out.println("This is a scriplet tag");
			out.println("We can have multiple scriplet tags");
		%>
		<!--
			- The above is a scriplet tag
			- Code inside this place gets printed inside our jsp page
			- NOTE: All scriplet tags codes go into the service method of our servlet
		 -->


		<p>My favorite Number is <% out.print(coef); %> </p>
		<p>My favorite Number is <%= coef %> </p>
		<!--
			- The above is an expression tag
			- It's a shortcut to printing something inside our jsp page
		-->

	</body>
</html>