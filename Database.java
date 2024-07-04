package casestudy3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Database {

	public static Connection databaseConnection()
	{

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1","root","firstbit");
				if(con!=null)
				{
					System.out.println("connection establish succesesfully");
					return con;
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
	}
}
