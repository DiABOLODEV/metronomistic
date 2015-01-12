package com.istic.metronome.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.istic.metronome.controller.Controller;
/**
 * Marque la mesure
 */
public class CommandMarkMeasure implements Command, ActionListener {
	private Controller ctl;

	public CommandMarkMeasure(Controller ctl) {
		this.ctl = ctl;
	}
	
	public void execute() {
		this.ctl.markMeasure();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		this.execute();
	}

}
