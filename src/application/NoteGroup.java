package application;

public abstract class NoteGroup {
	private String name;
	private int numOfNotes;
	private String[] notes;
	public NoteGroup(String name, int numOfNotes, String[] notes) {
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
	public String[] getNotes() {
		return notes;
	}
	public void setNotes(String[] notes) {
		this.notes = notes;
	}
}
	
