package fileDao;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ElencoProprietariContratto implements ActionListener {

	
	
		private List list;
		
		public ElencoProprietariContratto(List list){
			this.list=list;
			
		}

		public void ElencPrCo() {
//			Scanner in= new Scanner(System.in);
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
			
			    String sql="select distinct p.Nome, p.Codicefiscale from Proprietario p, Contratto c where p.Codicefiscale = c.Codicefiscale ";
					
			   
			    
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
//					System.out.println(rs.getString("Nome")+", "+rs.getString("Microchip"));
					String contratto = rs.getString("Nome").concat(" ").concat(rs.getString("Codicefiscale"));
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
			ElencPrCo();
			
		}


}
