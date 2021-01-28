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

public class InserimentoProprietario implements ActionListener{
	
	private JTextField cf;
	private JTextField nome;
	private JTextField cognome;
	private JTextField indirizzo;
	private JTextField numerocell;

	public InserimentoProprietario(JTextField cf, JTextField nome, JTextField cognome, JTextField indirizzo, JTextField numerocell){
		this.cf=cf;
		this.nome=nome;
		this.cognome=cognome;
		this.indirizzo= indirizzo;
		this.numerocell=numerocell;
	}
	
	public void insP(){
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
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/pensione2", "root", "sintex");
			stmt = connect.createStatement();
			
			
			String sql="insert into Proprietario"
					+"(CodiceFiscale, Nome, Cognome, Indirizzo, NumeroCell)"
					+"values ("+"'"+cf.getText()+"'"+", "+"'"+nome.getText()+"'"+", "+"'"+cognome.getText()+"'"+","+"'"+indirizzo.getText()+"'"+","+"'"+numerocell.getText()+"'"+")";
			
			stmt.executeUpdate(sql);
			
			
			
			stmt.close();
			connect.close();
			System.out.println("Inserimento completato !");
			
			JOptionPane.showMessageDialog(null, "Inserimento Proprietario completato");
			
			}
		catch(SQLException ex) 
		{
			System.err.println("SQLException: " + ex.getMessage());
		}
			
 }

	@Override
	public void actionPerformed(ActionEvent e) {
		insP();
		
	}

	}


