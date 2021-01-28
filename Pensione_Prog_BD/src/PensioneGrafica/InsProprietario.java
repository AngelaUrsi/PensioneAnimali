package PensioneGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

import fileDao.InserimentoProprietario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsProprietario implements ActionListener{
	
	
	private JFrame frame;
	private JTextField textCF;
	private JTextField textNome;
	private JTextField textCognome;
	private JTextField textIndirizzo;
	private JTextField textNumCell;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsProprietario window = new InsProprietario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InsProprietario() {
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 136, 322);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblCodiceFiscale = new JLabel("Codice Fiscale");
		lblCodiceFiscale.setForeground(Color.BLACK);
		panel.add(lblCodiceFiscale);
		
		textCF = new JTextField();
		panel.add(textCF);
		textCF.setColumns(10);
		
		
		JLabel lblNome = new JLabel("Nome");
		panel.add(lblNome);
		
		textNome = new JTextField();
		panel.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblCognome = new JLabel("Cognome");
		panel.add(lblCognome);
		
		textCognome = new JTextField();
		panel.add(textCognome);
		textCognome.setColumns(10);
		
		JLabel lblIndirizzo = new JLabel("Indirizzo");
		panel.add(lblIndirizzo);
		
		textIndirizzo = new JTextField();
		panel.add(textIndirizzo);
		textIndirizzo.setColumns(10);
		
		JLabel lblNumeroCell = new JLabel("Numero Cell");
		panel.add(lblNumeroCell);
		
		textNumCell = new JTextField();
		panel.add(textNumCell);
		textNumCell.setColumns(10);
		
		JButton btnInserisciProprietario = new JButton("Inserisci Proprietario");
		btnInserisciProprietario.addActionListener(new InserimentoProprietario(textCF, textNome, textCognome, textIndirizzo, textNumCell));
		panel.add(btnInserisciProprietario);
		
		this.frame.setVisible(true);

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		initialize();	
	}

}
