package com.istic.metronome.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Arrête le métronome
 */
public class CommandStop implements Command, ActionListener{
	
	private Controller ctl;
	
	public CommandStop(Controller ctl) {
		 this.ctl = ctl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		execute();
	}

	@Override
	public void execute() {
		this.ctl.stop();
		
	}

}