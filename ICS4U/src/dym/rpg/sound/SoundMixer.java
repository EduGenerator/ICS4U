package dym.rpg.sound;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.SourceDataLine;

public class SoundMixer {
	public static Clip music;
	public static Mixer mixer;
	public static AudioFormat format;
	public static SourceDataLine soundFX;
	public static void init() {
		mixer = AudioSystem.getMixer(AudioSystem.getMixerInfo()[0]);
		format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
		try {
			soundFX = (SourceDataLine)AudioSystem.getLine(new DataLine.Info(SourceDataLine.class,format));
			soundFX.open();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	@Deprecated
	public static void playSound(Sound s) {
		s.play();
	}
	public static void playMusic(Sound s) {
		if (music!=null) {
			music.stop();
			music.setMicrosecondPosition(0L);
		}
		music = s.getClip();
		music.start();
		music.loop(Clip.LOOP_CONTINUOUSLY);
	}
}
