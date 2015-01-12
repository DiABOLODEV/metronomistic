package com.istic.metronome.component;

import com.istic.metronome.controller.Horloge;
import com.istic.metronome.ihm.EmetteurSonore;
import com.istic.metronome.ihm.Molette;
/**
 * Permet d'acceder au materiel de l'application
 *
 */
public class Materiel {
	private static Horloge horloge;
	private static Clavier clavier;
	private static Molette molette;
	private static Afficheur afficheur;
	private static EmetteurSonore emetteurSonore;
	public static Horloge getHorloge() {
		return horloge;
	}
	public static void setHorloge(Horloge horloge) {
		Materiel.horloge = horloge;
	}
	public static Clavier getClavier() {
		return clavier;
	}
	public static void setClavier(Clavier clavier) {
		Materiel.clavier = clavier;
	}
	public static Molette getMolette() {
		return molette;
	}
	public static void setMolette(Molette molette) {
		Materiel.molette = molette;
	}
	public static Afficheur getAfficheur() {
		return afficheur;
	}
	public static void setAfficheur(Afficheur afficheur) {
		Materiel.afficheur = afficheur;
	}
	public static EmetteurSonore getEmetteurSonore() {
		return emetteurSonore;
	}
	public static void setEmetteurSonore(EmetteurSonore emetteurSonore) {
		Materiel.emetteurSonore = emetteurSonore;
	}
	
	

}
