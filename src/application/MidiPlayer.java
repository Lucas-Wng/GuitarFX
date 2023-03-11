package application;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class MidiPlayer {
	private Synthesizer synth;
	private static MidiChannel channel;

	public MidiPlayer() {
		try {
			synth = MidiSystem.getSynthesizer();
			synth.open();
		} catch (MidiUnavailableException ex) {
			ex.printStackTrace();
		}
		channel = synth.getChannels()[0];

		channel.programChange(26);
	}

	public static void playNote(int value) {
		channel.noteOn(value, 75);
	}

	public static void stopSound() {
		channel.allNotesOff();
	}
}
