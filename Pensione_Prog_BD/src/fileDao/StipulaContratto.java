package fileDao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

public class StipulaContratto implements ActionListener{

	
	private JTextField mc;
	private JTextField tipo;
    private JTextField cf;
    private JTextField box;
    private JTextField datain;
    private JTextField datafi;
	
	public StipulaContratto (JTextField mc, JTextField tipo, JTextField cf,JTextField box, JTextField datain, JTextField datafi){
       this.mc = mc;
       this.tipo = tipo;
       this.cf =cf;
       this.box=box;
       this.datain = datain;
       this.datafi = datafi;
	}

	public  void StipCon() throws ParseException {


//		Scanner in= new Scanner(System.in);
		Connection connect;
		Statement stmt;
		ResultSet rs,rsB;

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




			System.out.println("STIPULO CONTRATTO");



			//System.out.println("inserire id contratto");
			//String id=in.nextLine();
//			System.out.println("inserire il microchip dell'animale");
//			String mc=in.nextLine();
//			System.out.println("inserisci il tipo (cane, gatto, uccello, roditore, rettile)");
//			String tipo=in.nextLine();
//			System.out.println("inserire il codice fiscale del proprietario");
//			String cf=in.nextLine();
//			System.out.println("inserire il codice del box in cui l'animale verrà ospitato");
//			String box=in.nextLine();

//			System.out.println("inserire data inizio");
//			 datain=in.nextLine();
			
			String dataIn;
			
			dataIn = sdfsql.format(sdfjava.parse(datain.getText()));
			GregorianCalendar inizio = new GregorianCalendar();
			try{
				inizio.setTime(sdfsql.parse(dataIn));
			} catch (ParseException e){
				e.printStackTrace();
			}



//			System.out.println("inserire data fine");
//			String datafi=in.nextLine();
			
			String dataFi;
			
			dataFi = sdfsql.format(sdfjava.parse(datafi.getText()));
			GregorianCalendar fine = new GregorianCalendar();
			try{
				fine.setTime(sdfsql.parse(dataFi));
			}catch (ParseException e){
				e.printStackTrace();
			}

			long inizioMill = inizio.getTimeInMillis();
			long fineMill = fine.getTimeInMillis();

			long millinfi = fineMill - inizioMill; 

			long sommaMill= inizioMill+fineMill;

			long numgiorni = millinfi/86400000; 



			String sql2 = "select c.DataInizio,c.DataFine From animale a, contratto c where a.Microchip = c.Microchip and c.idBox = '" + box.getText() + "';";
			String sql1 = "select c.DataInizio,c.DataFine From  animale a, contratto c where a.Microchip = c.Microchip and c.Microchip = '" + mc.getText() + "';";
			String sql3 = "select PrezzoBase From Animale where Microchip = '"+mc.getText()+"';";
			
			rs= stmt.executeQuery(sql2);
			

			while(rs.next())
			{
				
				//Per ogni tupla ottenuta prendo le date e confronto se le date non si accavallano con le date del contratto
				//che voglio inserire

				String dataapp=rs.getString("DataInizio");
				dataapp = sdfjava.format(sdfsql.parse(dataapp));

				GregorianCalendar app = new GregorianCalendar();
				try{
					app.setTime(sdfjava.parse(dataapp));
				} catch (ParseException e){
					e.printStackTrace();
				}

				String dataappF=rs.getString("DataFine");
				dataappF = sdfjava.format(sdfsql.parse(dataappF));

				GregorianCalendar appF = new GregorianCalendar();
				try{
					appF.setTime(sdfjava.parse(dataappF));
				} catch (ParseException e){
					e.printStackTrace();
				}

				//Posso avere due casi in cui posso inserire il nuovo contratto e quattro no
				//Unendo queste due if tramite un OR e negando ottengo le 4 condizioni di scarto
				//Se accade una condizione di scarto non posso inserire e modifico il flag a false

				if(!((fine.before(app) && inizio.before(app) && inizio.before(fine)) || (inizio.after(appF) && fine.after(appF) && inizio.before(fine))))
				{
					System.out.print("Box Occupato!");
					return;
				}

			}

			rs= stmt.executeQuery(sql1);
			

			while(rs.next())
			{

				//Per ogni tupla ottenuta prendo le date e confronto se le date non si accavallano con le date del contratto
				//che voglio inserire

				String dataapp=rs.getString("DataInizio");
				dataapp = sdfjava.format(sdfsql.parse(dataapp));

				GregorianCalendar app = new GregorianCalendar();
				try{
					app.setTime(sdfjava.parse(dataapp));
				} catch (ParseException e){
					e.printStackTrace();
				}

				String dataappF=rs.getString("DataFine");
				dataappF = sdfjava.format(sdfsql.parse(dataappF));

				GregorianCalendar appF = new GregorianCalendar();
				try{
					appF.setTime(sdfjava.parse(dataappF));
				} catch (ParseException e){
					e.printStackTrace();
				}

				//Posso avere due casi in cui posso inserire il nuovo contratto e quattro no
				//Unendo queste due if tramite un OR e negando ottengo le 4 condizioni di scarto
				//Se accade una condizione di scarto non posso inserire e modifico e faccio return

				if(!((fine.before(app) && inizio.before(app) && inizio.before(fine)) || (inizio.after(appF) && fine.after(appF) && inizio.before(fine))))
				{
					System.out.print("Esiste gia' un contratto!");
					return;
				}

			}
			
			rs= stmt.executeQuery(sql3);
			double prez=0;
			
			while(rs.next()){
				
				prez = Double.parseDouble(rs.getString("PrezzoBase"));
				
			}
			
				prez = prez* numgiorni;

				String sql="insert into contratto"
						+"(idBox, Microchip, Tipo, CodiceFiscale, DataInizio, DataFine, NumeroGiorni, Prezzo)"
						+"values ("+"'"+box.getText()+"'"+", "+"'"+mc.getText()+"'"+","+"'"+tipo.getText()+"'"+", "+"'"+cf.getText()+"'"+","+"'"+dataIn+"'"+","+"'"+dataFi+"'"+","+"'"+numgiorni+"'"+","+"'"+prez+"'"+")";
				stmt.executeUpdate(sql);
				System.out.println("Inserimento completato !");
			

			JOptionPane.showMessageDialog(null, "Contratto stipulato");
			JOptionPane.showMessageDialog(null, "Il prezzo è di: "+prez+" €");
			
			


			stmt.close();
			connect.close();
			rs.close();
			
			


		}//END TRY
		catch(SQLException ex) 
		{
			System.err.println("SQLException: " + ex.getMessage());
		}




	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			StipCon();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
