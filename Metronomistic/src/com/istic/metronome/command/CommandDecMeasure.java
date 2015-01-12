package com.istic.metronome.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * D�cr�mente la mesure
 */
public class CommandDecMeasure implements Command, ActionListener{

	private Controller ctl;

	public CommandDecMeasure(Controller ctl) {
		this.ctl = ctl;
	}
	@Override
	public void execute() {
		this.ctl.decMeasure();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.execute();
	}

}
