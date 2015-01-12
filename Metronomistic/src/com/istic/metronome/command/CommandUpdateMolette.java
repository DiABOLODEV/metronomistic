package com.istic.metronome.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Changement de position de la molette du tempo
 */
public class CommandUpdateMolette implements Command, ChangeListener {
	
	private Controller ctl;

	/**
	 * Constructeur prenant en param�tre une r�f�rence vers le controlleur
	 * @param _ctl
	 * 		R�f�rence vers un objet de type IController
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
