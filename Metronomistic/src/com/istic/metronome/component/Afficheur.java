package com.istic.metronome.component;

import com.istic.metronome.ihm.LED;

/**
 * Definit les interactions possibles pour afficher les informations du metronome
 */
public interface Afficheur {
	/**
	 * Allume la LED dont l'identifiant est passe en parametre
	 * @param numLED
	 * 		Identifiant de la LED Ã  allumer
	 */
	public void allumerLED(int numLED);
	/**
	 * eteint la LED dont l'identifiant est passe en parametre
	 * @param numLED
	 * 		Identifiant de la LED Ã  eteindre
	 */
	public void eteindreLED(int numLED);
	/**
	 * Met a  jour l'affichage du tempo
	 * @param tempo
	 * 		Valeur du tempo
	 */
	public void afficherTempo(int tempo);
	
	/**
	 * Affecte une LED a  un identifiant (allant de 1 a  2)
	 * @param numLED
	 * 		Identifiant de la LED
	 * @param led
	 * 		Reference vers un objet de type ILED
	 */
	public void setLED(int numLED, LED led);
	/**
	 * Retourne une reference vers la LED dont l'identifiant est passe en parametre
	 * @param numLED
	 * 		Identifiant de la LED
	 * @return Une reference vers un objet de type ILED
	 */
	public LED getLED(int numLED);
}

