package com.istic.metronome.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.istic.metronome.command.Command;


/**
 * Simule le bouton du materiel
 */
public class Bouton extends JButton implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int num;
	private Command cmd;
	
	public Bouton() {
		this.addActionListener(this);
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	public void setCmd(Command cmd) {
		this.cmd = cmd;
	}
	
	public void lireEtat() {
		if(Materiel.getClavier().touchePressee(this.num))
			this.cmd.execute();
	}
	
	public void actionPerformed(ActionEvent e) {
		Materiel.getClavier().touchePressee(this.num, true);
	}
}
