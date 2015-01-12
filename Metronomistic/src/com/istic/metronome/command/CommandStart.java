package com.istic.metronome.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.istic.metronome.controller.Controller;
/**
 * D�marre le m�tronome
 */
public class CommandStart implements Command, ActionListener{
	
	private Controller ctl;
	
	public CommandStart(Controller ctl) {
		 this.ctl = ctl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		execute();
	}

	@Override
	public void execute() {
		this.ctl.start();
		
	}

}