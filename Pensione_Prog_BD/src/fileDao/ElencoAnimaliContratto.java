package fileDao;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ElencoAnimaliContratto implements ActionListener {
	
	private List list;
	
	public ElencoAnimaliContratto(List list){
		this.list=list;
		
	}

	public void ElencAnCo() {
//		Scanner in= new Scanner(System.in);
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

			
			//System.out.println("ELENCO ANIMALI CON CONTRATTO");
		
		    String sql="select distinct a.Nome, a.Microchip from Animale a, Contratto c where a.Microchip = c.Microchip ";
				
		   
		    
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){

				String contratto = rs.getString("Nome").concat(" ").concat(rs.getString("Microchip"));
				list.add(" ");
				list.add(contratto);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		ElencAnCo();
		
	}


}
