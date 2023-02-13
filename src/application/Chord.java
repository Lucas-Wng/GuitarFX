package application;

public class Chord extends NoteGroup{
	private String chordRoot;
	private String chordType;
	private String[] chordStructure;
	private int[] fingerPos;
	public Chord(String chordRoot, String chordType, int numOfNotes, Note[] notes, String[] chordStructure,int[] fingerPos) {
		super(chordRoot+chordType, notes.length, notes);
		this.chordRoot = chordRoot;
		this.chordType = chordType;
		this.chordStructure = chordStructure;
		this.setFingerPos(fingerPos);
	}

	public String getChordRoot() {
		return chordRoot;
	}

	public void setChordRoot(String chordRoot) {
		this.chordRoot = chordRoot;
	}

	public String getChordType() {
		return chordType;
	}

	public void setChordType(String chordType) {
		this.chordType = chordType;
	}

	public String[] getChordStructure() {
		return chordStructure;
	}

	public void setChordStructure(String[] chordStructure) {
		this.chordStructure = chordStructure;
	}
	
	public String toString() {
		return chordRoot+chordType;
	}

	public int[] getFingerPos() {
		return fingerPos;
	}

	public void setFingerPos(int[] fingerPos) {
		this.fingerPos = fingerPos;
	}
	
}
