package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	String bd= "deltamanage";
	public String url="jdbc:mysql://localhost:3306/"+bd;
	public String usr="root";
	public String pwd="";
	public Connection conn = null;
	
	public DatabaseConnection() {
		try {
			//chargement du driver
			String driverName ="com.mysql.cj.jdbc.Driver";
			
			Class.forName(driverName);
			System.out.println("Driver Charge ... ok!");
			
			//connexion
			conn = DriverManager.getConnection(url,usr,pwd);
			System.out.println("Connexion ..ok!!!!");
		}catch(SQLException ex) {
			ex.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Echec de connection");
		}
		
		
	}
	public  Connection getConnection() {
        return conn;
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection closed successfully.");
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

	public static void main(String[] args) {
		
	}
}
