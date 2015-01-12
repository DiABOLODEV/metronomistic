package com.istic.metronome.controller;

import com.istic.metronome.engine.Engine;
import com.istic.metronome.ihm.IHM;


/**
 * Definit les interactions possibles avec le controlleur de l'application
 */
public interface Controller {

	/**
	 * Marque le temps de façon visuel et sonore en faisant flasher
	 * la LED prevue Ã  cet effet et en emettant un clic
	 */
	public void markTime();
	/**
	 * Marque la mesure de facon visuel et sonore en faisant flasher
	 * la LED prevue a  cet effet et en emettant un clic
	 */
	public void markMeasure();
	/**
	 * Ordonne au moteur de demarrer
	 */
	public void start();
	/**
	 * Ordonne au moteur de s'arreter
	 */
	public void stop();
	/**
	 * Incremente le nombre de temps par mesure contenu dans le moteur
	 */
	public void incMeasure();
	/**
	 * Decremente le nombre de temps par mesure contenu dans le moteur
	 */
	public void decMeasure();
	/**
	 * Recupere la valeur du tempo de la molette, la traite et met a  jour le tempo du moteur
	 */
	public void updateMolette();
	/**
	 * Retourne une reference vers l'objet utilise en tant qu'IHM
	 * @return Une reference vers un objet de type IHM
	 */
	public IHM getIHM();
	/**
	 * Affecte l'IHM utilisee par le controlleur
	 * @param ihm
	 * 		Reference vers un objet de type IHM
	 */
	public void setIHM(IHM ihm);
	/**
	 * Retourne une reference vers l'objet utilise en tant que moteur du metronome
	 * @return Une reference vers un objet de type Engine
	 */
	public Engine getEngine();
	/**
	 * Affecte le moteur utilise par le controlleur
	 * @param engine
	 * 		Reference vers un objet de type Engine
	 */
	public void setEngine(Engine engine);
}

