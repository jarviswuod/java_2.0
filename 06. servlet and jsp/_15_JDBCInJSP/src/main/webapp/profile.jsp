<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>

<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC In JSP</title>
</head>
<body>

	101 <br>
	Jarvis <br>
	88 <br>

	<%

		String url="jdbc.mysql://localhost:3306/jarvis";
		String user = "root";
		String pass = "yourpassword";

		String sql = "select * from student where rollno=103";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection(url, user, pass);
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(sql);
		rs.next();
		
	%>
	
	Rollno: <%= rs.getString(1) %>
	Name: <%= rs.getString(2) %>
	Marks: <%= rs.getString(3) %>

</body>
</html>