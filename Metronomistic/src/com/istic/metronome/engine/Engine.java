package com.istic.metronome.engine;

import com.istic.metronome.command.Command;
import com.istic.metronome.controller.Horloge;

/**
 * Definit les interactions possibles avec un objet de type Engine
 */
public interface Engine {

	/**
	 * Retourne la valeur du tempo
	 * @return La valeur du tempo actuel du moteur (comprise entre 30 et 240) 
	 */
	public int getTempo();
	/**
	 * Met a  jour le tempo du moteur 
	 * @param t
	 * 		La nouvelle valeur du tempo qui doit etre comprise entre 30 et 240
	 */
	public void setTempo(int t);
	
	/**
	 * Retourne le nombre de temps necessaires pour marquer la mesure
	 * @return le nombre de temps fixes pour marquer la mesure (comprise entre 2 et 7)
	 */
	public int getNbTimeByMeasure();
	/**
	 * Met a  jour le nombre de temps necessaire pour marquer la mesure 
	 * @param i
	 * 		La nouvelle valeur du nombre de temps par mesure qui doit etre comprise entre 2 et 7.
	 */
	public void setNbTimeByMeasure(int i);
	
	/**
	 * Indique l'etat de fonctionnement du moteur (demarre ou Ã  l'arret)
	 * @return Vrai si le moteur est en fonctionnement, Faux sinon.
	 */
	public boolean isWorking();
	/**
	 * Demarre ou arrete le moteur
	 * @param b
	 * 		Vrai pour demarrer le moteur, Faux pour l'arreter
	 */
	public void isWorking(boolean b);
	/**
	 * Methode appelee Ã  chaque temps par la commande de rythme.
	 * Marque le temps et la mesure (si besoin) en faisant appel au Controller
	 */
	public void rythme();
	
	/**
	 * Retourne l'horloge affectee au moteur
	 * @return Une reference vers un objet de type Horloge
	 */
	public Horloge getHorloge();
	/**
	 * Affecte une horloge au moteur
	 * @param horloge
	 * 		Objet de type Horloge
	 */
	public void setHorloge(Horloge horloge);
	/**
	 * Affecte la commande qui sera appelee periodiquement par l'horloge pour s'occuper du rythme general du metronome
	 * @param cmdRythme
	 */
	public void setCmdRythme(Command cmdRythme);
	/**
	 * Affecte la commande qui sera appelee pour marquer le temps
	 * @param cmdMarkTime
	 */
	public void setCmdMarkTime(Command cmdMarkTime);
	/**
	 * Affecte la commande qui sera appelee pour marquer la mesure
	 * @param cmdMarkMeasure
	 */
	public void setCmdMarkMeasure(Command cmdMarkMeasure);
}

