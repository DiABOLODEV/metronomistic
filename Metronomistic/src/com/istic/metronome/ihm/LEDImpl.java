package com.istic.metronome.ihm;

import java.awt.Color;
import javax.swing.JLabel;

public class LEDImpl extends JLabel implements LED {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color off, on;
	/**
	 * Prend deux couleurs en parametre, une couleur lorsque la LED est eteinte, et une couleur lorsque la LED est allumee
	 * @param off
	 * @param on
	 */
	public LEDImpl(Color off, Color on) {
		this.off = off;
		this.on = on;
		this.setOpaque(true);
		this.setBackground(this.off);
	}

	public void allumer() {
		this.setBackground(this.on);
	}

	public void eteindre() {
		this.setBackground(this.off);
	}

}
