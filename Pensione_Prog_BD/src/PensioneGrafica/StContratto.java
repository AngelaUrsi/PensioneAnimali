package PensioneGrafica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fileDao.StipulaContratto;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Scrollbar;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

public class StContratto implements ActionListener {

	private JFrame frame;
	private JTextField textMC;
	private JTextField textTipo;
	private JTextField textCF;
	private JTextField textBox;
	private JTextField textDataIn;
	private JTextField textDataFi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StContratto window = new StContratto();
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
	public StContratto() {
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 140, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblMicrochip = new JLabel("Microchip");
		panel.add(lblMicrochip);
		
		textMC = new JTextField();
		panel.add(textMC);
		textMC.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo...");
		panel.add(lblTipo);
		
		textTipo = new JTextField();
		panel.add(textTipo);
		textTipo.setColumns(10);
		
		JLabel lblCodiceFiscale = new JLabel("Codice Fiscale");
		panel.add(lblCodiceFiscale);
		
		textCF = new JTextField();
		panel.add(textCF);
		textCF.setColumns(10);
		
		JLabel lblBox = new JLabel("Box...");
		panel.add(lblBox);
		
		textBox = new JTextField();
		panel.add(textBox);
		textBox.setColumns(10);
		
		JLabel lblDataInizio = new JLabel("Data Inizio");
		panel.add(lblDataInizio);
		
		textDataIn = new JTextField();
		panel.add(textDataIn);
		textDataIn.setColumns(10);
		
		JLabel lblDataFine = new JLabel("Data Fine");
		panel.add(lblDataFine);
		
		textDataFi = new JTextField();
		panel.add(textDataFi);
		textDataFi.setColumns(10);
		
		JButton btnStipulaContratto = new JButton("Stipula Contratto");
		btnStipulaContratto.addActionListener(new StipulaContratto(textMC, textTipo, textCF, textBox, textDataIn, textDataFi));
		panel.add(btnStipulaContratto);
		
		
		this.frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		initialize();
		
	}

}
