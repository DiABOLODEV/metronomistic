package com.istic.metronome.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Incrémente la mesure
 */
public class CommandIncMeasure implements Command, ActionListener{

	private Controller ctl;

	public CommandIncMeasure(Controller ctl) {
		this.ctl = ctl;
	}
	@Override
	public void execute() {
		this.ctl.incMeasure();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.execute();
	}

}
