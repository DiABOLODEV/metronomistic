package com.istic.metronome.ihm;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import com.istic.metronome.command.Command;



public class MoletteImpl extends JSlider implements Molette {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void setCmdUpdateMolette(Command cmdUpdateMolette) {
		this.addChangeListener((ChangeListener) cmdUpdateMolette);
	}

	public int position() {
		return this.getValue();
	}

}
