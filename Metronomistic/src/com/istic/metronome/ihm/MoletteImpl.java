package com.istic.metronome.ihm;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import com.istic.metronome.command.Command;

public class MoletteImpl extends JSlider implements Molette {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int old_position;
	private Command cmdUpdateMolette;
	
	public void setCmdUpdateMolette(Command cmdUpdateMolette) {
		this.addChangeListener((ChangeListener) cmdUpdateMolette);
	}

	public int position() {
		return this.getValue();
	}

	@Override
	public void lireEtat() {
		if(this.position() != this.old_position) {
			this.old_position = this.position();
			this.cmdUpdateMolette.execute();
		}
	}

}
