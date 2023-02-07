package application;

public class Scale extends NoteGroup{

	private int[] intervals;

	public Scale(String scaleNote, String scaleType, int numOfNotes, Note[] notes, int[] intervals) {
		super(scaleNote+scaleType, numOfNotes, notes);
		this.intervals = intervals;
	}
	
}
