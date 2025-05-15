package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class UserModel {

	
	private ArrayList<User> users = new ArrayList<User>();
	
	public UserModel() {
		
	}
	
	public ArrayList<User> get()
	{
		
		String query = "select * from users";
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				
				Integer empId = rs.getInt(1);
				String firstName = rs.getString(2);
				String email = rs.getString(3); 
				String role = rs.getString(4); 
				String phone = rs.getString(5);
				
				users.add(new User(empId,firstName,email,role,phone,null,null));
				
				
				
				
			}
			rs.close();
			
			return users; 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		
		
		
		return users; 
		
	}

}