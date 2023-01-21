package application;

public class Chord extends NoteGroup{
	private String chordRoot;
	private String chordType;
	private String[] chordStructure;

	public Chord(String chordRoot, String chordType, int numOfNotes, Note[] notes, String[] chordStructure) {
		super(chordRoot+chordType, notes.length, notes);
		this.chordRoot = chordRoot;
		this.chordType = chordType;
		this.chordStructure = chordStructure;
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
	public boolean equals(Chord c) {
		Note[] chord1 = c.getNotes();
		return true;
	}
	public String toString() {
		return chordRoot+chordType;
	}
	
}
