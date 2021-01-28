package fileDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PersoneNoConData {


	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		Connection connect;
		Statement stmt;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			} 
		catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
			}
		try 
		{
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/pensione2", "root", "root");
			stmt = connect.createStatement();

			System.out.println("PERSONE CHE NON HANNO STIPULATO CONTRATTI NEL 2018");
		    

			 String sql1 = "select distinct c.CodiceFiscale From  animale a, contratto c where a.CodiceFiscale= c.CodiceFiscale and not( DataInizio >= '2018-01-01' and DataInizio <='2018-12-31') ;";
				 
				ResultSet rs = stmt.executeQuery(sql1);
				
				while(rs.next()){
					System.out.println("codice fiscale "+rs.getString("Codicefiscale"));
				}
				
			
			
			stmt.close();
			connect.close();
			rs.close();
	
			}
		catch(SQLException ex) 
		{
			System.err.println("SQLException: " + ex.getMessage());
		}
			
 }


}