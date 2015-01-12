package com.istic.metronome.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.istic.metronome.component.Materiel;

public class CommandLire implements Command, ActionListener {

	public void execute() {
		Materiel.getMolette().lireEtat();
		Materiel.getClavier().getBouton(1).lireEtat();
		Materiel.getClavier().getBouton(2).lireEtat();
		Materiel.getClavier().getBouton(3).lireEtat();
		Materiel.getClavier().getBouton(4).lireEtat();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



}


