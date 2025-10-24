package _19_LoginUsingJDBCServletAndJspDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

	String url = "jdbc:mysql://localhost:3306/jsp";
	String user = "root";
	String pass = "yourpassword";
	String sql = "Select * from users where name=? and password=?";

	public boolean check(String name, String password) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection con = DriverManager.getConnection(url, user, pass)) {

				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, name);
				st.setString(2, password);

				ResultSet rs = st.executeQuery();
				if (rs.next())
					return true;
				System.out.println("Connected successfully!");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Issue " + e.getMessage());
		}
		return false;
	}
}
