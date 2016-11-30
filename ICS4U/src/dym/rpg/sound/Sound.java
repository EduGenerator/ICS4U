package dym.rpg.sound;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	AudioInputStream stream;
	Clip clip;
	public Sound(String file) {
		try {
			stream = AudioSystem.getAudioInputStream(new File(file));
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
			return;
		}
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {e.printStackTrace();return;}
		try {
			clip.open(stream);
		} catch (LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
		
	}
	public void play() {
		clip.stop();
		clip.setMicrosecondPosition(0L);
		clip.start();
	}
	public void close() {
		try {
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		stream = null;
		clip = null;
	}
	public AudioInputStream getStream() {
		return this.stream;
	}
	public Clip getClip() {
		return clip;
	}
}
