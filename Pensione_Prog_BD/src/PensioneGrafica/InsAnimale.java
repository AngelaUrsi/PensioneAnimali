package PensioneGrafica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fileDao.InserimentoAnimale;

import javax.swing.JButton;
import java.awt.Color;

public class InsAnimale implements ActionListener{

	private JFrame frame;
	private JTextField textMicro;
	private JTextField textTipo;
	private JTextField textNome;
	private JTextField textRazza;
	private JTextField textEta;
	private JTextField textCFP;
	private JTextField textPrzz;

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsAnimale window = new InsAnimale();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public InsAnimale() {
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 136, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Microchip");
		panel.add(lblNewLabel);
		
		textMicro = new JTextField();
		panel.add(textMicro);
		textMicro.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo...");
		panel.add(lblTipo);
		
		textTipo = new JTextField();
		panel.add(textTipo);
		textTipo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		panel.add(lblNome);
		
		textNome = new JTextField();
		panel.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblRazza = new JLabel("Razza");
		panel.add(lblRazza);
		
		textRazza = new JTextField();
		panel.add(textRazza);
		textRazza.setColumns(10);
		
		JLabel lblEt = new JLabel("Et\u00E0....");
		panel.add(lblEt);
		
		textEta = new JTextField();
		panel.add(textEta);
		textEta.setColumns(10);
		
		JLabel lblprzz = new JLabel("Prezzo Base");
		panel.add(lblprzz);
		
		textPrzz = new JTextField();
		panel.add(textPrzz);
		textPrzz.setColumns(10);
		
		JLabel lblCfproprietario = new JLabel("CF_Proprietario");
		panel.add(lblCfproprietario);
		
		textCFP = new JTextField();
		panel.add(textCFP);
		textCFP.setColumns(10);
		
		JButton btnInserisciAnimale = new JButton("Inserisci Animale");
		btnInserisciAnimale.addActionListener(new InserimentoAnimale(textMicro, textTipo, textNome, textRazza, textEta, textPrzz, textCFP));
		btnInserisciAnimale.setForeground(Color.BLACK);
		panel.add(btnInserisciAnimale);
		
		this.frame.setVisible(true);
		
		
		
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		initialize();
		
	}

}
