package PensioneGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import fileDao.CancellazioneContratto;
import fileDao.ElencoAnimaliContratto;
import fileDao.StipulaContratto;

import java.awt.Button;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PensioneFrame {

	private JFrame frame;
	private InsProprietario prop;
	private InsAnimale animale;
	private StContratto contratto;
	private CancAnimale cancA;
	private CancContratto cancC;
	private Lista l;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PensioneFrame window = new PensioneFrame();
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
	public PensioneFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 145, 228);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		Button inserisciProprietario = new Button("Inserisci Proprietario");
		inserisciProprietario.setActionCommand("Inserisci Proprietario");
		inserisciProprietario.addActionListener(new InsProprietario());
		panel.add(inserisciProprietario);
		
		Button inserisciAnimale = new Button("Inserisci Animale");
		inserisciAnimale.setActionCommand("Inserisci Animale");
		inserisciAnimale.addActionListener(new InsAnimale());
		panel.add(inserisciAnimale);
		
		Button stipulaContratto = new Button("Stipula Contratto");
		stipulaContratto.setActionCommand("Stipula Contratto");
		stipulaContratto.addActionListener(new StContratto());
		panel.add(stipulaContratto);
		
		
		Button mostraLista = new Button("Mostra Liste");
		mostraLista.setActionCommand("MostraLista");
		mostraLista.addActionListener(new Lista());
		panel.add(mostraLista);
		
		Button cancellaAnimale = new Button("Cancella Animale");
		cancellaAnimale.setActionCommand("Cancella Animale");
		cancellaAnimale.addActionListener(new CancAnimale());
		panel.add(cancellaAnimale);
		
		Button cancellaContratto = new Button("Cancella Contratto");
		cancellaContratto.setActionCommand("Cancella Contratto");
		cancellaContratto.addActionListener(new CancContratto());
		panel.add(cancellaContratto);
	
	}

}
