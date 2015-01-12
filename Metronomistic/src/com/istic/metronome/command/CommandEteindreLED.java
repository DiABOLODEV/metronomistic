package com.istic.metronome.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.istic.metronome.component.Materiel;



/**
 * Éteint une LED
 */
public class CommandEteindreLED implements Command, ActionListener {
	private int numLED;

	public CommandEteindreLED(int numLED) {
		this.numLED = numLED;
	}


	@Override
	public void execute() {
		Materiel.getAfficheur().eteindreLED(this.numLED);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.execute();
	}

}
