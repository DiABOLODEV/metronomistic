package com.istic.metronome.main;

import java.awt.Color;

import com.istic.metronome.command.CommandDecMeasure;
import com.istic.metronome.command.CommandIncMeasure;
import com.istic.metronome.command.CommandMarkMeasure;
import com.istic.metronome.command.CommandMarkTime;
import com.istic.metronome.command.CommandRythme;
import com.istic.metronome.command.CommandStart;
import com.istic.metronome.command.CommandStop;
import com.istic.metronome.command.CommandUpdateMolette;
import com.istic.metronome.controller.Controller;
import com.istic.metronome.controller.ControllerImpl;
import com.istic.metronome.controller.Horloge;
import com.istic.metronome.controller.HorlogeImpl;
import com.istic.metronome.engine.Engine;
import com.istic.metronome.engine.EngineImpl;
import com.istic.metronome.ihm.EmetteurSonore;
import com.istic.metronome.ihm.EmetteurSonoreImpl;
import com.istic.metronome.ihm.IHM;
import com.istic.metronome.ihm.IHMImpl;
import com.istic.metronome.ihm.LEDImpl;
import com.istic.metronome.ihm.Molette;
import com.istic.metronome.ihm.MoletteImpl;



public class LauncherV1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Instanciation des objets
		Engine engine = new EngineImpl();
		IHM ihm = new IHMImpl();
		Horloge horloge = new HorlogeImpl();
		Controller controller = new ControllerImpl();
		EmetteurSonore emetteur = new EmetteurSonoreImpl("assets/tempo.wav");
		
		// Dependances de l'IHM
		Molette molette = new MoletteImpl();
		molette.setCmdUpdateMolette(new CommandUpdateMolette(controller));
		ihm.setMolette(molette);
		ihm.setLED(IHM.LED_ID.LED_1, new LEDImpl(Color.DARK_GRAY, Color.GREEN));
		ihm.setLED(IHM.LED_ID.LED_2, new LEDImpl(Color.DARK_GRAY, Color.ORANGE));
		ihm.setCmdStart(new CommandStart(controller));
		ihm.setCmdStop(new CommandStop(controller));
		ihm.setCmdIncMesure(new CommandIncMeasure(controller));
		ihm.setCmdDecMesure(new CommandDecMeasure(controller));
		ihm.setEmetteurSonore(emetteur);
		
		// Dependances du moteur
		engine.setCmdRythme(new CommandRythme(engine));
		engine.setCmdMarkTime(new CommandMarkTime(controller));
		engine.setCmdMarkMeasure(new CommandMarkMeasure(controller));
		engine.setHorloge(horloge);
		
		// Dependances du controleur
		controller.setEngine(engine);
		controller.setIHM(ihm);
		
		// Test
		System.out.println("Demarrage metronome");
		ihm.init();
	}

}
