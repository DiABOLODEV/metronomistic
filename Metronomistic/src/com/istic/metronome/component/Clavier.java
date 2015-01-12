package com.istic.metronome.component;

/**
 * Definit les interactions possibles avec le clavier du metronome
 */
public interface Clavier {

	/**
	 * Indique si le bouton dont l'identifiant est passe en parametre est enfonce ou relache.
	 * 
	 * @param i
	 * 		L'identifiant du bouton. Le num 1 est Start, le 2 est Stop, le 3 est Inc et le 4 est Dec.
	 * @return Vrai si le bouton i est enfonce, False s'il est relache.
	 */
	public boolean touchePressee(int i);
	/**
	 * Renseigne l'etat (enfonce ou relache) d'un bouton dont l'identifiant est passe en parametre
	 * @param i
	 * 		L'identifiant du bouton. Le num 1 est Start, le 2 est Stop, le 3 est Inc et le 4 est Dec.
	 * @param b
	 * 		etat du bouton sous forme booleenne (True : Enfonce, False : Relâche)
	 */
	public void touchePressee(int i, boolean b);
	/**
	 * Affecte un bouton à un identifiant (allant de 1 a 4)
	 * @param i
	 * 		Identifiant du bouton
	 * @param bouton
	 * 		Reference vers un objet de type Bouton
	 */
	public void setBouton(int i, Bouton bouton);
	/**
	 * Retourne une reference vers le bouton dont l'identifiant est passe en parametre
	 * @param i
	 * 		Identifiant du bouton
	 * @return Une reference vers un objet de type Bouton
	 */
	public Bouton getBouton(int i);
}

