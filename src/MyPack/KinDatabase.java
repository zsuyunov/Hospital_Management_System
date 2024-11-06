package MyPack;

import java.sql.Connection;
import java.sql.DriverManager;

public class KinDatabase {

	public static Connection databaseConn() {
		try {
			Class.forName("org.sqlite.JDBC");
			
			Connection connect = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\HP\\Kin-User-db.db");
			System.out.println("Database connection established successfully");
			return connect;
		} catch (Exception e) {
			System.out.print("connected");
			e.printStackTrace();
			System.out.println("Database is not connected");
			
			return null;
		}
	}
}
