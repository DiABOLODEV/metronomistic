package com.istic.metronome.ihm;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.istic.metronome.command.Command;



/**
 * Gere les differents composants de l'IHM (boutons, LED...) et les actions effectuees par l'utilisateur.
 */
public class IHMImpl implements IHM {

	private Command cmdStart, cmdStop, cmdIncMesure, cmdDecMesure;
	private Map<LED_ID, LED> ledList;
	private EmetteurSonore emetteur;
	private Molette molette;
	private JFrame fenetre;
	private JLabel afficheur;
	
	/**
	 * Constructeur
	 */
	public IHMImpl() {
		this.ledList = new HashMap<LED_ID, LED>();
	}
	
	/**
	 * Initialise les differents composants de l'IHM (boutons, LED),
	 * et affecte les differentes commandes utilisateurs aux boutons.
	 */
	public void init() {
		// Creation du panneau accueillant les composants de notre interface
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 4));
		
		panel.add((Component) molette);
		this.afficheur = new JLabel();
		this.afficheur.setFont(new Font("MONOSPACED", Font.PLAIN, 30));
		this.afficheur.setOpaque(true);
		this.afficheur.setBackground(Color.DARK_GRAY);
		this.afficheur.setForeground(Color.GREEN);
		this.afficheur.setHorizontalAlignment(JLabel.CENTER);
		panel.add(this.afficheur);
		
		panel.add((JLabel) this.ledList.get(LED_ID.LED_1));
		panel.add((JLabel) this.ledList.get(LED_ID.LED_2));
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener((ActionListener) this.cmdStart);
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener((ActionListener) this.cmdStop);
		JButton btnDecMesure = new JButton("Dec");
		btnDecMesure.addActionListener((ActionListener) this.cmdDecMesure);
		JButton btnIncMesure = new JButton("Inc");
		btnIncMesure.addActionListener((ActionListener) this.cmdIncMesure);
		
		panel.add(btnStart);
		panel.add(btnStop);
		panel.add(btnIncMesure);
		panel.add(btnDecMesure);
		
		// Creation et affichage de la fenetre contenant notre panneau
		this.fenetre = new JFrame("Metronome");
		this.fenetre.setContentPane(panel);
		this.fenetre.setSize(500, 150);
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.fenetre.setResizable(false);
		this.fenetre.setVisible(true);
	}

	public void allumerLED(LED_ID numLED) {
		this.ledList.get(numLED).allumer();
	}
	
	public void eteindreLED(LED_ID numLED) {
		this.ledList.get(numLED).eteindre();
	}

	public void emettreClic() {
		this.emetteur.emettreClic();
	}
	
	public Molette getMolette() {
		return this.molette;
	}
	
	public void afficherTempo(String val) {
		this.afficheur.setText(val);
	}

	public void setCmdStart(Command cmd) {
		this.cmdStart = cmd;
	}
	
	public void setCmdStop(Command cmd) {
		this.cmdStop = cmd;
	}

	public void setCmdIncMesure(Command cmd) {
		this.cmdIncMesure = cmd;
	}
	
	public void setCmdDecMesure(Command cmd) {
		this.cmdDecMesure = cmd;
	}

	public void setEmetteurSonore(EmetteurSonore emetteur) {
		this.emetteur = emetteur;
	}

	public void setLED(LED_ID id, LED led) {
		this.ledList.put(id, led);
	}
	
	public void setMolette(Molette molette) {
		this.molette = molette;
	}

}
