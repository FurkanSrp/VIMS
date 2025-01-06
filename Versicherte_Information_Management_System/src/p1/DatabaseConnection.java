package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/insurance_management"; // Şema adını buraya yaz.
	private static final String USER = "root"; // MySQL kullanıcı adın.
	private static final String PASSWORD = "0000"; // MySQL şifren.

	public static Connection getConnection() {
		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Erfolgreich mit der Datenbank verbunden!");
			return connection;
		} catch (SQLException e) {
			System.out.println("Verbindungsfehler: " + e.getMessage());
			return null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getConnection(); // Bağlantıyı test etmek için çağırıyoruz.
		
		

	}

}
