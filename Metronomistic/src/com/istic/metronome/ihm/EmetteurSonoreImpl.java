package com.istic.metronome.ihm;


import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;

/**
 * Se charge de lire un fichier son de type Wav
 */
public class EmetteurSonoreImpl implements EmetteurSonore {

	private URL wav;

	/**
	 * Constructeur prenant en parametre le chemin du fichier Wav a  lire
	 * @param _wav : chemin du fichier son a lire
	 */ 
	public EmetteurSonoreImpl(String _wav) {
		this.wav = getClass().getResource("/"+_wav);
	}
	
	@Override
	public void emettreClic() {
		JouerWav clic = new JouerWav(this.wav);
		clic.start();
	}
	
	/**
	 * Classe interne a l'EmetteurSonore se chargeant de lire un fichier son Wav
	 */
	class JouerWav extends Thread {
		private URL wav;
		public JouerWav(URL _wav) {
			this.wav = _wav;
		}
		public void run() {
			try {
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.wav);
				AudioFormat format = audioInputStream.getFormat();
				Info info = new Info(SourceDataLine.class, format);
				SourceDataLine source = (SourceDataLine)AudioSystem.getLine(info);
				source.open(format);
				source.start();
				int read = 0;
				byte[] audioData = new byte[16384];
				
				while(read > -1) {
					read = audioInputStream.read(audioData, 0 , audioData.length);
					if(read >= 0)
						source.write(audioData, 0, read);
				}
				
				source.drain();
				source.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		}
	}

}