package com.istic.metronome.command;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.istic.metronome.engine.Engine;
/**
 * Marque le temps
 */
public class CommandRythme implements Command, ActionListener {

	private Engine engine;
	
	public CommandRythme(Engine engine) {
		this.engine = engine;
	}
	
	@Override
	public void execute() {
		this.engine.rythme();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.execute();
	}

}
