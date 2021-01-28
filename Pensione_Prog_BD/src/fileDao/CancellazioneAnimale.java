package fileDao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class CancellazioneAnimale implements ActionListener{
	
	private static JTextField textMC;
	
	private static JTextField textCF;
	
	public CancellazioneAnimale(JTextField textMC,  JTextField textCF ){
		
		this.textMC=textMC;
		
		this.textCF=textCF;
		
	}

	public static void insA() {
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

			
			System.out.println("CANCELLO ANIMALE");

			
			String sql1="delete from Contratto"
					+" where Microchip="+"'"+textMC.getText()+"'"+" and CodiceFiscale="+"'"+textCF.getText()+"'"+"";
				
		
			String sql="delete from Animale"
					+" where Microchip="+"'"+textMC.getText()+"'"+" and CodiceFiscale="+"'"+textCF.getText()+"'"+"";
				

			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql);
		
			
			stmt.close();
			connect.close();
			
			System.out.println("Cancellazione completata !");
			
			JOptionPane.showMessageDialog(null, "Cancellazione Animale completato");
			
			
			
			}
		catch(SQLException ex) 
		{
			System.err.println("SQLException: " + ex.getMessage());
		}
			
 

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		insA();
		
	}
	



}
