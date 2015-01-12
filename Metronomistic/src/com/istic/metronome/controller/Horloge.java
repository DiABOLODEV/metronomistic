package com.istic.metronome.controller;

import com.istic.metronome.command.Command;



/**
 * Definit les interactions possibles avec un objet de type IHorloge
 */
public interface Horloge {
	
	/**
	 * Planifie l'execution periodique d'une commande
	 * @param cmd
	 * 		Reference vers un objet de type Command
	 * @param periode
	 * 		Delai en millisecondes entre chaque activation
	 */
	public void activerPeriodiquement(Command cmd, float periode);
	
	/**
	 * Planifie l'execution d'une commande apres un certain delai
	 * @param cmd
	 * 		Reference vers un objet de type ICmd
	 * @param _delay
	 * 		Delai en millisecondes avant l'execution de la commande
	 */
	public void activerApresDelai(Command cmd, float delay);
	
	/**
	 * Desactive une commande qui a ete prealablement planifiee
	 * @param cmd
	 * 		Reference vers un objet de type ICmd
	 */
	public void desactiver(Command cmd);
}
