package com.istic.metronome.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.istic.metronome.command.CommandDecMeasure;
import com.istic.metronome.command.CommandIncMeasure;
import com.istic.metronome.command.CommandLire;
import com.istic.metronome.command.CommandMarkMeasure;
import com.istic.metronome.command.CommandMarkTime;
import com.istic.metronome.command.CommandRythme;
import com.istic.metronome.command.CommandStart;
import com.istic.metronome.command.CommandStop;
import com.istic.metronome.command.CommandUpdateMolette;
import com.istic.metronome.component.Afficheur;
import com.istic.metronome.component.AfficheurImpl;
import com.istic.metronome.component.Bouton;
import com.istic.metronome.component.Clavier;
import com.istic.metronome.component.ClavierImpl;
import com.istic.metronome.component.Materiel;
import com.istic.metronome.controller.Controller;
import com.istic.metronome.controller.ControllerImpl;
import com.istic.metronome.controller.Horloge;
import com.istic.metronome.controller.HorlogeImpl;
import com.istic.metronome.engine.Engine;
import com.istic.metronome.engine.EngineImpl;
import com.istic.metronome.ihm.EmetteurSonore;
import com.istic.metronome.ihm.EmetteurSonoreImpl;
import com.istic.metronome.ihm.LEDImpl;
import com.istic.metronome.ihm.Molette;
import com.istic.metronome.ihm.MoletteImpl;


public class LauncherV2 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Instanciation des objets
		Engine engine = new EngineImpl();
		Afficheur afficheur = new AfficheurImpl();
		Horloge horloge = new HorlogeImpl();
		Controller controller = new ControllerImpl();
		Clavier clavier = new ClavierImpl();
		EmetteurSonore emetteur = new EmetteurSonoreImpl("assets/tempo.wav");
		Molette molette = new MoletteImpl();
		molette.setCmdUpdateMolette(new CommandUpdateMolette(controller));
		
		// Dependances du clavier
		Bouton btnStart = new Bouton();
		btnStart.setText("Start");
		btnStart.setNum(1);
		btnStart.setCmd(new CommandStart(controller));
		Bouton btnStop = new Bouton();
		btnStop.setText("Stop");
		btnStop.setNum(2);
		btnStop.setCmd(new CommandStop(controller));
		Bouton btnIncMesure = new Bouton();
		btnIncMesure.setText("Inc");
		btnIncMesure.setNum(3);
		btnIncMesure.setCmd(new CommandIncMeasure(controller));
		Bouton btnDecMesure = new Bouton();
		btnDecMesure.setText("Dec");
		btnDecMesure.setNum(4);
		btnDecMesure.setCmd(new CommandDecMeasure(controller));
		clavier.setBouton(1, btnStart);
		clavier.setBouton(2, btnStop);
		clavier.setBouton(3, btnIncMesure);
		clavier.setBouton(4, btnDecMesure);
		
		// Dependances de l'afficheur
		JLabel ecran = new JLabel();
		ecran.setFont(new Font("MONOSPACED", Font.PLAIN, 30));
		ecran.setOpaque(true);
		ecran.setBackground(Color.DARK_GRAY);
		ecran.setForeground(Color.GREEN);
		ecran.setHorizontalAlignment(JLabel.CENTER);
		((AfficheurImpl) afficheur).setEcran(ecran);
		afficheur.setLED(1, new LEDImpl(Color.DARK_GRAY, Color.GREEN));
		afficheur.setLED(2, new LEDImpl(Color.DARK_GRAY, Color.ORANGE));
		
		// Dependances du materiel
		Materiel.setHorloge(horloge);
		Materiel.setClavier(clavier);
		Materiel.setMolette(molette);
		Materiel.setEmetteurSonore(emetteur);
		Materiel.setAfficheur(afficheur);
		
		// Dependances du moteur
		engine.setCmdRythme(new CommandRythme(engine));
		engine.setCmdMarkTime(new CommandMarkTime(controller));
		engine.setCmdMarkMeasure(new CommandMarkMeasure(controller));
		engine.setHorloge(horloge);
		
		// Dependances du controleur
		controller.setEngine(engine);
		
		// Planification de la verification des actions effectuees sur le materiel
		horloge.activerPeriodiquement(new CommandLire(), 10);
		
		// ---------------------------
		// Creation de l'IHM de test
		// ---------------------------
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 4));
		
		panel.add((Component) molette);
		panel.add(ecran);
		panel.add((JLabel) afficheur.getLED(1));
		panel.add((JLabel) afficheur.getLED(2));
		
		panel.add(btnStart);
		panel.add(btnStop);
		panel.add(btnIncMesure);
		panel.add(btnDecMesure);
		
		// Creation et affichage de la fenetre contenant notre panneau
		JFrame fenetre = new JFrame("Metronome");
		fenetre.setContentPane(panel);
		fenetre.setSize(500, 150);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}

}
