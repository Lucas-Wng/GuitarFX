package application;

public abstract class NoteGroup {
	private String name;
	private int numOfNotes;
	private Note[] notes;
	public NoteGroup(String name, int numOfNotes, Note[] notes) {
		this.name = name;
		this.numOfNotes = numOfNotes;
		this.notes = notes;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumOfNotes() {
		return numOfNotes;
	}
	public void setNumOfNotes(int numOfNotes) {
		this.numOfNotes = numOfNotes;
	}
	public Note[] getNotes() {
		return notes;
	}
	public void setNotes(Note[] notes) {
		this.notes = notes;
	}
	public String toString() {
		String s = "";
		s += name+" ";
		for(Note note:notes) {
			s += note.toString();
		}
		return s;
	}
}
	
