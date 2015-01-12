package com.istic.metronome.engine;

import com.istic.metronome.command.Command;
import com.istic.metronome.controller.Horloge;

/**
 * Gere le rythme du metronome (tempo, nombre de temps par mesure...)
 */
public class EngineImpl implements Engine {
	
	private int tempo; // Nombre de battements par minute
	private int nbTimeByMeasure, nbTimeByMeasureCount; // Nombre de temps par mesure
	private boolean isWorking;
	private Command cmdRythme;
	private Command cmdMarkTime;
	private Command cmdMarkMeasure;
	private Horloge horloge;
	private int countTimes = 0;


	/**
	 * Constructeur
	 */
	public EngineImpl() {
		this.tempo = 135;
		this.nbTimeByMeasure = 4;
		this.nbTimeByMeasureCount = 4;
		this.isWorking = false;
	}
	
	public int getNbTimeByMeasure() {
		return this.nbTimeByMeasure;
	}
	
	public void setNbTimeByMeasure(int _nbTimeByMeasure) {
		if(_nbTimeByMeasure >= 2 && _nbTimeByMeasure <= 7) {
			if(isWorking) {
				this.nbTimeByMeasure = _nbTimeByMeasure;
			}
			else this.nbTimeByMeasure = _nbTimeByMeasure;
		}
	}

	public int getTempo() {
		return this.tempo;
	}
	
	public boolean isWorking() {
		return this.isWorking;
	}
	
	public Horloge getHorloge() {
		return this.horloge;
	}
	
	public void setTempo(int _tempo) {
		if(_tempo >= 30 && _tempo <= 240){
			this.tempo = _tempo;
			if(isWorking){
				long periode = 60000 / this.getTempo();
				this.horloge.activerPeriodiquement(cmdRythme, (float) periode);	
			}
		}
	}
	
	public void isWorking(boolean _isworking) {
		this.isWorking = _isworking;
		if(_isworking) {
			// Lancement du rythme du metronome
			this.horloge.activerPeriodiquement(this.cmdRythme, 60000 / this.getTempo());
		}
		else {
			// Arret du rythme
			this.horloge.desactiver(this.cmdRythme);
			this.countTimes = 0;
		}
	}
	
	public void setHorloge(Horloge horloge) {
		this.horloge = horloge;
	}
	
	public void setCmdRythme(Command cmdRythme) {
		this.cmdRythme = cmdRythme;
	}

	public void setCmdMarkTime(Command cmdMarkTime) {
		this.cmdMarkTime = cmdMarkTime;
	}
	
	public void setCmdMarkMeasure(Command cmdMarkMeasure) {
		this.cmdMarkMeasure = cmdMarkMeasure;
	}

	public void rythme() {
		if(this.countTimes < (this.nbTimeByMeasureCount-1)) {
			this.cmdMarkTime.execute();
			this.countTimes++;
		}
		else {
			this.cmdMarkMeasure.execute();
			this.countTimes = 0;
			this.nbTimeByMeasureCount = this.nbTimeByMeasure;
		}
	}

}
