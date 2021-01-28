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

public class InserimentoAnimale implements ActionListener{
	
	private JTextField mc;
	private JTextField tipo;
	private JTextField nome;
	private JTextField razza;
	private JTextField eta;
	private JTextField prezzobase;
	private JTextField cf;
	
	
	public InserimentoAnimale(JTextField mc, JTextField tipo, JTextField nome, JTextField razza, JTextField eta, JTextField prezzobase, JTextField cf){
		
		this.mc=mc;
		this.tipo=tipo;
		this.nome=nome;
		this.razza=razza;
		this.eta=eta;
		this.prezzobase=prezzobase;
		this.cf=cf;
	}

	public  void InsA() {
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


			
			
			
			String sql="insert into Animale"
					+"(Microchip, Tipo,Nome,Razza,Età, PrezzoBase,CodiceFiscale)"
					+"values ("+"'"+mc.getText()+"'"+", "+"'"+tipo.getText()+"'"+", "+"'"+nome.getText()+"'"+","+"'"+razza.getText()+"'"+","+"'"+eta.getText()+"'"+","+"'"+prezzobase.getText()+"'"+","+"'"+cf.getText()+"'"+")";
			
			stmt.executeUpdate(sql);
			
			
			
			stmt.close();
			connect.close();
			System.out.println("Inserimento completato !");
			
			JOptionPane.showMessageDialog(null, "Inserimento Animale completato");

			}
		catch(SQLException ex) 
		{
			System.err.println("SQLException: " + ex.getMessage());
		}
			
 }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		InsA();
		
	}
}
