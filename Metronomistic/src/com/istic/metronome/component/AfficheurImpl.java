package com.istic.metronome.component;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;

import com.istic.metronome.ihm.LED;

/**
 * Controle les elements d'affichage du materiel
 */
public class AfficheurImpl implements Afficheur {

	private Map<Integer, LED> ledList;
	private JLabel ecran;
	
	public AfficheurImpl() {
		this.ledList = new HashMap<Integer, LED>();
	}
	
	public void allumerLED(int numLED) {
		this.ledList.get((Integer) numLED).allumer();
	}
	
	public void eteindreLED(int numLED) {
		this.ledList.get((Integer) numLED).eteindre();
	}
	
	public void afficherTempo(int tempo) {
		this.ecran.setText(String.valueOf(tempo));
	}
	
	public void setLED(int numLED, LED led) {
		this.ledList.put(numLED, led);
	}
	
	public LED getLED(int numLED) {
		return this.ledList.get((Integer) numLED);
	}
	/**
	 * Affecte un ecran a  l'afficheur
	 * @param ecran
	 * 		Reference vers un objet de type JLabel
	 */
	public void setEcran(JLabel ecran) {
		this.ecran = ecran;
	}
	/**
	 * Retourne une reference vers l'ecran utilise par l'Afficheur
	 * @return Une reference vers un objet de type JLabel
	 */
	public JLabel getEcran() {
		return this.ecran;
	}

}
