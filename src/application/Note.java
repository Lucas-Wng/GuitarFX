package application;
//update
public class Note {
	private char name;
	private double pitch;
	private int octave;
	public Note(char name, double pitch, int octave) {
		this.name = name;
		this.pitch = pitch;
		this.octave = octave;
	}
	public char getName() {
		return name;
	}
	public void setName(char name) {
		this.name = name;
	}
	public double getPitch() {
		return pitch;
	}
	public void setPitch(double pitch) {
		this.pitch = pitch;
	}
	public int getOctave() {
		return octave;
	}
	public void setOctave(int octave) {
		this.octave = octave;
	}
}
