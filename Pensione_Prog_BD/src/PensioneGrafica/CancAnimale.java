package PensioneGrafica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import fileDao.CancellazioneAnimale;

public class CancAnimale implements ActionListener{

	private JFrame frame;
	private JTextField textMC;
	
	private JTextField textCF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancAnimale window = new CancAnimale();
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
	public CancAnimale() {
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 136, 190);
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
		
		JButton btnCancellaAnimale = new JButton("Cancella Animale");
		btnCancellaAnimale.addActionListener(new CancellazioneAnimale(textMC,  textCF));
		panel.add(btnCancellaAnimale);

		this.frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		initialize();
		
	}

}
