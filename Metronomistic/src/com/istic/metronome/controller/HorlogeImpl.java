package com.istic.metronome.controller;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Timer;

import com.istic.metronome.command.Command;


/**
 * Gere la planification des differentes commandes (Command) a  executer de façon periodique ou apres un certain delai.
 */
public class HorlogeImpl implements Horloge {
	
	private Map<Command, Timer> commandes;

	/**
	 * Constructeur
	 */
	public HorlogeImpl() {
		this.commandes = new HashMap<Command, Timer>();
	}
	
	public void activerApresDelai(Command cmd, float delay) { 
		Timer timer = new Timer((int) delay, (ActionListener) cmd);
		timer.setRepeats(false);
		timer.start();
		this.commandes.put(cmd, timer);
	}

	public void activerPeriodiquement(Command cmd, float periode) {
		if(this.commandes.containsKey(cmd)) {
			this.commandes.get(cmd).setDelay((int) periode);
		}
		else {
			Timer timer = new Timer((int) periode, (ActionListener) cmd);
			timer.setRepeats(true);
			timer.start();
			this.commandes.put(cmd, timer);
		}
	}

	public void desactiver(Command cmd) {
		this.commandes.get(cmd).stop();
		this.commandes.remove(cmd);
	}

}
