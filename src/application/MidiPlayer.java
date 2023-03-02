package application;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class MidiPlayer {
    private Synthesizer synth;
    private static MidiChannel channel;

    // Sets the maxValue to the biggest value of the array
    public MidiPlayer() {
        try {
            synth = MidiSystem.getSynthesizer();
            synth.open();
        } catch (MidiUnavailableException ex) {
            ex.printStackTrace();
        }
        channel = synth.getChannels()[0];
        //https://math.hws.edu/eck/cs124/f17/lab8/lab8-files/midi/SimpleSynth.java
        channel.programChange(26);
    }

    public static void playNote(int value) {
        channel.noteOn(value, 75);
//        try { Thread.sleep(600); // wait time in milliseconds to control duration
//        } catch( InterruptedException e ) {
//            e.printStackTrace();
//        }
//        channel.noteOff(value);
    }
    public static void stopSound() {
    	channel.allNotesOff();
    }
}
