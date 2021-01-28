package fileDao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CancellazioneContratto implements ActionListener {
	private JTextField textMC;
	
	private JTextField textCF;
	private JTextField textDataIn;
	
	public CancellazioneContratto(JTextField textMC, JTextField textCF, JTextField textDataIn){
		
		this.textMC=textMC;
		
		this.textCF=textCF;
		this.textDataIn=textDataIn;
		
	}

	public void cancC() throws ParseException {
//		Scanner in= new Scanner(System.in);
		Connection connect;
		Statement stmt;
		
		SimpleDateFormat sdfjava = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdfsql = new SimpleDateFormat("yyyy-MM-dd");
		
		
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

			
			System.out.println("CANCELLO CONTRATTO");

			String dataI;
			dataI = sdfsql.format(sdfjava.parse(textDataIn.getText()));
			GregorianCalendar inizio = new GregorianCalendar();
			try{
			inizio.setTime(sdfsql.parse(dataI));
			} catch (ParseException e){
				e.printStackTrace();
			}
			
			String sql1="delete from Contratto"
					+" where Microchip="+"'"+textMC.getText()+"'"+" and CodiceFiscale="+"'"+textCF.getText()+"'"+"and DataInizio="+"'"+dataI+"'"+"";
		
				

			stmt.executeUpdate(sql1);
			
		
			
			
			stmt.close();
			connect.close();
			System.out.println("Cancellazione completata !");
			
			JOptionPane.showMessageDialog(null, "Cancellazione Contratto completata");
			}
		catch(SQLException ex) 
		{
			System.err.println("SQLException: " + ex.getMessage());
		}
			
 

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			cancC();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	}

