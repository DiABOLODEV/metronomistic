package com.istic.metronome.component;

import java.util.HashMap;
import java.util.Map;


public class ClavierImpl implements Clavier {

	private Map<Integer, Boolean> boutons_etats;
	private Map<Integer, Bouton> boutons;
	
	public ClavierImpl() {
		this.boutons_etats = new HashMap<Integer, Boolean>();
		this.boutons = new HashMap<Integer, Bouton>();
	}
	
	public boolean touchePressee(int i) {
		if(this.boutons_etats.get((Integer) i)) {
			this.touchePressee((Integer) i, false);
			return true;
		}
		return false;
	}
	
	public void touchePressee(int i, boolean b) {
		this.boutons_etats.put(i, b);
	}
	
	public void setBouton(int i, Bouton bouton) {
		this.boutons.put((Integer) i, bouton);
		this.boutons_etats.put((Integer) i, false);
	}
	
	public Bouton getBouton(int i) {
		return this.boutons.get((Integer) i);
	}

}
