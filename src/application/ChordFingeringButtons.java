package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ChordFingeringButtons extends Pane{
	private ToggleButton ANote;
	private ToggleButton ASharpNote;
	private ToggleButton BNote;
	private ToggleButton CNote;
	private ToggleButton CSharpNote;
	private ToggleButton DNote;
	private ToggleButton DSharpNote;
	private ToggleButton ENote;
	private ToggleButton FNote;
	private ToggleButton FSharpNote;
	private ToggleButton GNote;
	private ToggleButton GSharpNote;
	private static Label currentNoteChord;
	private static ToggleGroup chordGroup;
	private ToggleGroup noteGroup;
	public ChordFingeringButtons() {
		String css = this.getClass().getResource("scale.css").toExternalForm();
		this.getStylesheets().add(css);
		currentNoteChord = new Label("");
		currentNoteChord.setId("noteScaleLabel");
		VBox noteChordVBox = new VBox(3);
		noteChordVBox.setId("rootVBox");
		HBox noteHBox = new HBox(12);
		noteHBox.setId("noteHBox");
		noteGroup = new ToggleGroup();
		ANote = new ToggleButton("A");
		ANote.setUserData("A");
		ASharpNote = new ToggleButton("A#");
		ASharpNote.setUserData("Bb");
		BNote = new ToggleButton("B");
		BNote.setUserData("B");
		CNote = new ToggleButton("C");
		CNote.setUserData("C");
		CSharpNote = new ToggleButton("C#");
		CSharpNote.setUserData("Csharp");
		DNote = new ToggleButton("D");
		DNote.setUserData("D");
		DSharpNote = new ToggleButton("D#");
		DSharpNote.setUserData("Eb");
		ENote = new ToggleButton("E");
		ENote.setUserData("E");
		FNote = new ToggleButton("F");
		FNote.setUserData("F");
		FSharpNote = new ToggleButton("F#");
		FSharpNote.setUserData("Fsharp");
		GNote = new ToggleButton("G");
		GNote.setUserData("G");
		GSharpNote = new ToggleButton("G#");
		GSharpNote.setUserData("Ab");
		
		ANote.setToggleGroup(noteGroup);
		ASharpNote.setToggleGroup(noteGroup);
		BNote.setToggleGroup(noteGroup);
		CNote.setToggleGroup(noteGroup);
		CSharpNote.setToggleGroup(noteGroup);
		DNote.setToggleGroup(noteGroup);
		DSharpNote.setToggleGroup(noteGroup);
		ENote.setToggleGroup(noteGroup);
		FNote.setToggleGroup(noteGroup);
		FSharpNote.setToggleGroup(noteGroup);
		GNote.setToggleGroup(noteGroup);
		GSharpNote.setToggleGroup(noteGroup);
		
		noteGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
		    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
		    	ToggleButton selectedNote = (ToggleButton) noteGroup.getSelectedToggle();
		    	if(selectedNote!=null) {

		    		ChordFingeringFretboard.setCurrChordNote((String) selectedNote.getUserData());
		    		ChordFingeringFretboard.updateNotes();
		    	}
		     } 
		});
		
		noteHBox.getChildren().addAll(ANote, ASharpNote,BNote,CNote,CSharpNote,
				DNote,DSharpNote, ENote, FNote, FSharpNote, GNote, GSharpNote);
		
		chordGroup = new ToggleGroup();
		RadioButton major = new RadioButton("Major");
		major.setUserData("major");
		RadioButton minor = new RadioButton("Minor");
		minor.setUserData("minor");
		RadioButton major7 = new RadioButton("Major 7");
		major7.setUserData("maj7");
		RadioButton minor7 = new RadioButton("Minor 7");
		minor7.setUserData("m7");
		RadioButton dom7 = new RadioButton("Dominant 7");
		dom7.setUserData("7");
		RadioButton dim = new RadioButton("Diminished");
		dim.setUserData("dim");
		RadioButton aug = new RadioButton("Augmented");
		aug.setUserData("aug");
		RadioButton major9 = new RadioButton("Major 9");
		major9.setUserData("maj9");
		RadioButton dom9 = new RadioButton("Dominant 9");
		dom9.setUserData("9");
		RadioButton dim7 = new RadioButton("Diminished 7");
		dim7.setUserData("dim7");
		RadioButton m9 = new RadioButton("Minor 9");
		m9.setUserData("m9");
		RadioButton sixth = new RadioButton("Sixth");
		sixth.setUserData("6");
		major.setToggleGroup(chordGroup);
		minor.setToggleGroup(chordGroup);
		major7.setToggleGroup(chordGroup);
		minor7.setToggleGroup(chordGroup);
		dom7.setToggleGroup(chordGroup);
		dim.setToggleGroup(chordGroup);
		aug.setToggleGroup(chordGroup);
		major9.setToggleGroup(chordGroup);
		dom9.setToggleGroup(chordGroup);
		dim7.setToggleGroup(chordGroup);
		m9.setToggleGroup(chordGroup);
		sixth.setToggleGroup(chordGroup);
		
		
		GridPane scaleGrid = new GridPane();
		scaleGrid.add(major, 0, 0);
		scaleGrid.add(minor, 1, 0);
		scaleGrid.add(major7, 0, 1);
		scaleGrid.add(minor7, 1, 1);
		scaleGrid.add(dom7, 2, 0);
		scaleGrid.add(dim, 2, 1);
		scaleGrid.add(aug, 2, 2);
		scaleGrid.add(major9, 3, 0);
		scaleGrid.add(dom9, 3, 1);
		scaleGrid.add(dim7, 0, 2);
		scaleGrid.add(m9, 3, 2);
		scaleGrid.add(sixth, 1, 2);
		
		scaleGrid.setHgap(20);
		scaleGrid.setVgap(20);
		
		noteChordVBox.getChildren().addAll(currentNoteChord,noteHBox,scaleGrid);
		chordGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
		    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

		         if (chordGroup.getSelectedToggle() != null) {
		        	 String selectedScaleButton = (String) ((RadioButton)chordGroup.getSelectedToggle()).getUserData();
		        	 ChordFingeringFretboard.setCurrChordType(selectedScaleButton);
		        	 ChordFingeringFretboard.updateNotes();
		         }

		     } 
		});
		
		this.getChildren().add(noteChordVBox);
	}
}
