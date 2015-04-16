package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private Connection con;
	private static DatabaseConnection instance;
	
	private DatabaseConnection() {
		String user = "root";
		String pwd = ""
				+ "";
		String url = "jdbc:mysql://localhost:3306/celestra_database";
	
		try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException err) {}//do nothing 

        try {
            con = DriverManager.getConnection(url, user, pwd);
        } catch(SQLException err) {
        	con = null;
            System.out.println(err.getMessage());
        } //do nothing      
	}
	
	public static DatabaseConnection getInstance() {
		if(instance == null)
			instance = new DatabaseConnection();
		return instance;
	}
	
	public Connection getConnection() {
		return con;
	}
}
