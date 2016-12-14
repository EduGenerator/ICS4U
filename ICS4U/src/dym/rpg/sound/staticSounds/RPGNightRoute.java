package dym.rpg.sound.staticSounds;

import java.io.File;

import dym.rpg.sound.Sound;

public class RPGNightRoute extends Sound {

	public RPGNightRoute() {
		super("res"+File.separator+"sound"+File.separator+"main_theme.wav");
		this.getClip().setLoopPoints(50, 3000000);
	}

}
