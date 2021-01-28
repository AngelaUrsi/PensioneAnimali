package PensioneGrafica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fileDao.CancellazioneAnimale;
import fileDao.CancellazioneContratto;

import javax.swing.JButton;

public class CancContratto implements ActionListener{

	private JFrame frame;
	private JTextField textMC;
	private JTextField textTipo;
	private JTextField textCF;
	private JTextField textDataIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancContratto window = new CancContratto();
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
	public CancContratto() {
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 143, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblMC = new JLabel("Microchip");
		panel.add(lblMC);
		
		textMC = new JTextField();
		panel.add(textMC);
		textMC.setColumns(10);
		
		
		
		JLabel lblCF = new JLabel("Codice Fiscale");
		panel.add(lblCF);
		
		textCF = new JTextField();
		panel.add(textCF);
		textCF.setColumns(10);
		
		JLabel lblDatainizio = new JLabel("Data Inizio");
		panel.add(lblDatainizio);
		
		textDataIn = new JTextField();
		panel.add(textDataIn);
		textDataIn.setColumns(10);
		
		JButton btnCancellaContratto = new JButton("Cancella Contratto");
		btnCancellaContratto.addActionListener(new CancellazioneContratto(textMC, textCF, textDataIn));
		panel.add(btnCancellaContratto);
		
		this.frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		initialize();
		
	}

}
