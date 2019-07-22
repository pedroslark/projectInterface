package dal;
import java.sql.*;

import javax.swing.JOptionPane;

public class DbConnect {

	public static Connection dbconnect() throws ClassNotFoundException {
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project_management","postgres","pv159753");
			JOptionPane.showMessageDialog(null, "DB Connected!");
			return con;
		}
		
		catch (SQLException error) {
			
			JOptionPane.showMessageDialog(null, error);
			
			return null;
		}
	}
}
