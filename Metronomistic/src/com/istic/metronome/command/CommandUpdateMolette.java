package com.istic.metronome.command;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.istic.metronome.controller.Controller;

/**
 * Changement de position de la molette du tempo
 */
public class CommandUpdateMolette implements Command, ChangeListener {
	
	private Controller ctl;

	/**
	 * Constructeur prenant en paramètre une référence vers le controlleur
	 * @param ctl
	 * 		Référence vers un objet de type IController
	 */
	public CommandUpdateMolette(Controller ctl) {
		this.ctl = ctl;
	}
	
	public void execute() {
		this.ctl.updateMolette();
	}

	public void stateChanged(ChangeEvent arg0) {
		this.execute();
	}

}
