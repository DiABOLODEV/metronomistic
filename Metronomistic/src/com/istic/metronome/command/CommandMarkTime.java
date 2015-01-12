package com.istic.metronome.command;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.istic.metronome.controller.Controller;


/**
 * Marque le temps 
 */
public class CommandMarkTime implements Command, ActionListener {
	
	private Controller ctl;

	/**
	 * Constructeur prenant en paramètre une référence vers le controlleur
	 * @param _ctl
	 * 		Référence vers un objet de type IController
	 */
	public CommandMarkTime(Controller ctl) {
		this.ctl = ctl;
	}
	
	public void execute() {
		this.ctl.markTime();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		this.execute();
	}

}
