package com.istic.metronome.ihm;

import com.istic.metronome.command.Command;

/**
 * Definit les interactions possibles avec un objet de type IHM
 */
public interface IHM {
	
	/**
	 * Initialise l'IHM
	 */
	public void init();
	/**
	 * Identifiants des LED utilisees par l'IHM, au nombre de deux.
	 */
	public enum LED_ID {LED_1, LED_2}
	/**
	 * Allume la LED dont l'identifiant est passe en parametre
	 * @param numLED
	 * 		Identifiant de la LED (de type LED_ID)
	 */
	public void allumerLED(LED_ID numLED);
	/**
	 * eteint la LED dont l'identifiant est passe en parametre
	 * @param numLED
	 * 		Identifiant de la LED (de type LED_ID)
	 */
	public void eteindreLED(LED_ID numLED);
	/**
	 * Methode appelee a  chaque marquage du tempo pour emettre un son
	 */
	public void emettreClic();
	/**
	 * Retourne la molette
	 * @return Une reference vers un objet de type Molette
	 */
	public Molette getMolette();
	/**
	 * Met a  jour la valeur du tempo affichee
	 * @param val
	 */
	public void afficherTempo(String val);
	/**
	 * Affecte la commande qui sera appelee lors de l'appuie sur le bouton de demarrage
	 * @param cmd
	 * 		Reference vers la commande de demarrage
	 */
	public void setCmdStart(Command cmd);
	/**
	 * Affecte la commande qui sera appelee lors de l'appuie sur le bouton d'arret
	 * @param cmd
	 * 		Reference vers la commande d'arret
	 */
	public void setCmdStop(Command cmd);
	/**
	 * Affecte la commande qui sera appelee lors de l'appuie sur le bouton 
	 * d'incrementation du nombre de temps dans une mesure
	 * @param cmd
	 * 		Reference vers la commande d'incrementation du nombre de temps dans une mesure
	 */
	public void setCmdIncMesure(Command cmd);
	/**
	 * Affecte la commande qui sera appelee lors de l'appuie sur le bouton 
	 * de decrementation du nombre de temps dans une mesure
	 * @param cmd
	 * 		Reference vers la commande de decrementation du nombre de temps dans une mesure
	 */
	public void setCmdDecMesure(Command cmd);
	/**
	 * Affecte l'emetteur sonore qui sera utilise lors de l'appel a  la methode emettreClic()
	 * @param emetteur
	 */
	public void setEmetteurSonore(EmetteurSonore emetteur);
	/**
	 * Affecte une LED avec l'identifiant correspondant (au nombre de deux, definit par l'enumeration LED_ID)
	 * @param id
	 * 		Identifiant de la LED (de type LED_ID)
	 * @param led
	 * 		Reference vers l'objet LED
	 */
	public void setMolette(Molette molette);

	public void setLED(LED_ID id, LED led);
}

