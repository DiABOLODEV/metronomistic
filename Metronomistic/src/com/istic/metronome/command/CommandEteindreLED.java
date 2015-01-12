package com.istic.metronome.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.istic.metronome.ihm.IHM;


/**
 * Éteint une LED
 */
public class CommandEteindreLED implements Command, ActionListener {
	
	private IHM ihm;
	private IHM.LED_ID numLED;
	
	public CommandEteindreLED(IHM _ihm, IHM.LED_ID _numLED) {
		this.ihm = _ihm;
		this.numLED = _numLED;
	}

	@Override
	public void execute() {
		this.ihm.eteindreLED(this.numLED);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.execute();
	}

}
