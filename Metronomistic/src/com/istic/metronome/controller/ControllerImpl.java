package com.istic.metronome.controller;

import com.istic.metronome.engine.Engine;
import com.istic.metronome.ihm.IHM;
import com.istic.metronome.ihm.IHM.LED_ID;

/**
 * Controlleur de l'application permettant la jonction entre l'interface utilisateur (IHM) et le moteur du metronome (Engine)
 */
public class ControllerImpl implements Controller {
	
	private Engine engine;
	private IHM ihm;

	public void markMeasure() {
		this.ihm.allumerLED(LED_ID.LED_2);
		this.ihm.emettreClic();
		Command cmd = new CommandEteindreLED(this.ihm, LED_ID.LED_2);
		this.engine.getHorloge().activerApresDelai(cmd, 50);
	}

	public void markTime() {
		this.ihm.allumerLED(LED_ID.LED_1);
		this.ihm.emettreClic();
		Command cmd = new CommandEteindreLED(this.ihm, LED_ID.LED_1);
		this.engine.getHorloge().activerApresDelai(cmd, 50);
	}

	public void start() {
		if(!this.engine.isWorking()) {
			this.engine.isWorking(true);
			this.ihm.afficherTempo(Integer.toString(this.engine.getTempo()));
		}
	}

	public void stop() {
		if(this.engine.isWorking()) {
			this.engine.isWorking(false);
			this.ihm.afficherTempo("");
		}
	}
	
	public void decMeasure() {
		this.engine.setNbTimeByMeasure(this.engine.getNbTimeByMeasure() - 1);
	}

	public void incMeasure() {
		this.engine.setNbTimeByMeasure(this.engine.getNbTimeByMeasure() + 1);
	}
	
	public void updateMolette() {
		int valeur = this.ihm.getMolette().position() * 210 / 100 + 30;
		this.engine.setTempo(valeur);
		this.ihm.afficherTempo(Integer.toString(valeur));
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public IHM getIHM() {
		return ihm;
	}

	public void setIHM(IHM ihm) {
		this.ihm = ihm;
	}

}

