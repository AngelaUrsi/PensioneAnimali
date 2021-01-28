package PensioneGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fileDao.ElencoAnimaliContratto;
import fileDao.ElencoProprietariContratto;
import fileDao.InserimentoAnimale;

import java.awt.BorderLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Lista implements ActionListener {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lista window = new Lista();
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
	public Lista() {
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 229, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		List list = new List();
		panel.add(list);
		
		JLabel lblVisualizzaAnimaliCon = new JLabel("Visualizza Animali con Contratto");
		panel.add(lblVisualizzaAnimaliCon);
		
		JButton btnVisualizzaA = new JButton("Visualizza A");
		btnVisualizzaA .addActionListener(new ElencoAnimaliContratto(list));
        panel.add(btnVisualizzaA);
        
        
		
		JLabel lblVisualizzaPersoneCon = new JLabel("Visualizza Persone con Contratto");
		panel.add(lblVisualizzaPersoneCon);
		
		
		JButton btnVisualizzaP = new JButton("Visualizza P");
		btnVisualizzaP.addActionListener(new ElencoProprietariContratto(list));
		panel.add(btnVisualizzaP);
		
		this.frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	initialize();
		
	}

}
