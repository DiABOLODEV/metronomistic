package com.istic.metronome.controller;



import com.istic.metronome.command.Command;
import com.istic.metronome.command.CommandEteindreLED;
import com.istic.metronome.component.Materiel;
import com.istic.metronome.engine.Engine;
import com.istic.metronome.ihm.IHM;




/**
 * Controlleur de l'application permettant la jonction entre l'interface utilisateur (IHM) et le moteur du metronome (Engine)
 */
public class ControllerImpl implements Controller {

	private Engine engine;

	public void markMeasure() {
		Materiel.getAfficheur().allumerLED(2);
		Materiel.getEmetteurSonore().emettreClic();
		Command cmd = new CommandEteindreLED(2);
		this.engine.getHorloge().activerApresDelai(cmd, 50);
	}

	public void markTime() {
		Materiel.getAfficheur().allumerLED(1);
		Materiel.getEmetteurSonore().emettreClic();
		Command cmd = new CommandEteindreLED(1);
		this.engine.getHorloge().activerApresDelai(cmd, 50);
	}

	public void start() {
		if(!this.engine.isWorking()) {
			this.engine.isWorking(true);
			Materiel.getAfficheur().afficherTempo(this.engine.getTempo());
		}
	}

	public void stop() {
		if(this.engine.isWorking()) {
			this.engine.isWorking(false);
		}
	}

	public void decMeasure() {
		this.engine.setNbTimeByMeasure(this.engine.getNbTimeByMeasure() - 1);
	}

	public void incMeasure() {
		this.engine.setNbTimeByMeasure(this.engine.getNbTimeByMeasure() + 1);
	}

	public void updateMolette() {
		int valeur = Materiel.getMolette().position() * 210 / 100 + 30;
		this.engine.setTempo(valeur);
		Materiel.getAfficheur().afficherTempo(valeur);
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public IHM getIHM() {
		return null;
	}

	public void setIHM(IHM ihm) {
		//
	}

}

