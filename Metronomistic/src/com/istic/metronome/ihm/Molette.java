package com.istic.metronome.ihm;

import com.istic.metronome.command.Command;



/**
 * Definit les interactions possibles avec un objet de type Molette
 */
public interface Molette {
	
	/**
	 * Affecte la commande qui sera executee lorsque l'utilisateur manipulera la molette
	 * @param _cmdUpdateMolette
	 * 		Reference vers un objet de type Command
	 */
	public void setCmdUpdateMolette(Command cmdUpdateMolette);
	
	/**
	 * Retourne la position de la molette
	 * @return La position de la molette
	 */
	public int position();

	public void lireEtat();
}

