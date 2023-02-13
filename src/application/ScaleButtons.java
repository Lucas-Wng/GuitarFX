package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ScaleButtons extends Pane{
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
	private ToggleGroup noteGroup;
	private static Label currentNoteScale;
	public ScaleButtons() {
		String css = this.getClass().getResource("scale.css").toExternalForm();
		this.getStylesheets().add(css);
		currentNoteScale = new Label("");
		VBox noteScaleVBox = new VBox(3);
		noteScaleVBox.setId("rootVBox");
		HBox noteHBox = new HBox(12);
		noteHBox.setId("noteHBox");
		noteGroup = new ToggleGroup();
		ANote = new ToggleButton("A");
		ASharpNote = new ToggleButton("A#");
		BNote = new ToggleButton("B");
		CNote = new ToggleButton("C");
		CSharpNote = new ToggleButton("C#");
		DNote = new ToggleButton("D");
		DSharpNote = new ToggleButton("D#");
		ENote = new ToggleButton("E");
		FNote = new ToggleButton("F");
		FSharpNote = new ToggleButton("F#");
		GNote = new ToggleButton("G");
		GSharpNote = new ToggleButton("G#");
		
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
		    		ScaleFretboard.setCurrentNote(selectedNote.getText());
		    		ScaleFretboard.updateNotes();
		    	}
		     } 
		});
		
		noteHBox.getChildren().addAll(ANote, ASharpNote,BNote,CNote,CSharpNote,
				DNote,DSharpNote, ENote, FNote, FSharpNote, GNote, GSharpNote);
		
		ToggleGroup scaleGroup = new ToggleGroup();
		RadioButton major = new RadioButton("Major");
		RadioButton minor = new RadioButton("Minor");
		RadioButton minorPentatonic = new RadioButton("MinorPentatonic");
		RadioButton blues = new RadioButton("Blues");
		RadioButton dorian = new RadioButton("Dorian");
		RadioButton mixolydian = new RadioButton("Mixolydian");
		RadioButton lydian = new RadioButton("Lydian");
		RadioButton melodicMinor = new RadioButton("MelodicMinor");
		RadioButton harmonicMinor = new RadioButton("HarmonicMinor");
		RadioButton phrygian = new RadioButton("Phrygian");
		RadioButton locrian = new RadioButton("Locrian");
		RadioButton majorPentatonic = new RadioButton("MajorPentatonic");
		major.setToggleGroup(scaleGroup);
		minor.setToggleGroup(scaleGroup);
		minorPentatonic.setToggleGroup(scaleGroup);
		blues.setToggleGroup(scaleGroup);
		dorian.setToggleGroup(scaleGroup);
		mixolydian.setToggleGroup(scaleGroup);
		lydian.setToggleGroup(scaleGroup);
		melodicMinor.setToggleGroup(scaleGroup);
		harmonicMinor.setToggleGroup(scaleGroup);
		phrygian.setToggleGroup(scaleGroup);
		locrian.setToggleGroup(scaleGroup);
		majorPentatonic.setToggleGroup(scaleGroup);
		
		
		GridPane scaleGrid = new GridPane();
		scaleGrid.add(major, 0, 0);
		scaleGrid.add(minor, 1, 0);
		scaleGrid.add(minorPentatonic, 0, 1);
		scaleGrid.add(blues, 1, 1);
		scaleGrid.add(dorian, 2, 0);
		scaleGrid.add(mixolydian, 2, 1);
		scaleGrid.add(lydian, 2, 2);
		scaleGrid.add(melodicMinor, 3, 0);
		scaleGrid.add(harmonicMinor, 3, 1);
		scaleGrid.add(phrygian, 0, 2);
		scaleGrid.add(locrian, 3, 2);
		scaleGrid.add(majorPentatonic, 1, 2);
		
		scaleGrid.setHgap(20);
		scaleGrid.setVgap(20);
		
		noteScaleVBox.getChildren().addAll(currentNoteScale,noteHBox,scaleGrid);
		scaleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
		    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

		         if (scaleGroup.getSelectedToggle() != null) {
		        	 String selectedScaleButton = ((RadioButton)scaleGroup.getSelectedToggle()).getText();
		             //System.out.println(selectedScaleButton);
		             ScaleFretboard.setCurrentScale(selectedScaleButton);
		             ScaleFretboard.updateNotes();

		         }

		     } 
		});
	
		this.getChildren().add(noteScaleVBox);
	}
	public static Label getCurrentNoteScale() {
		return currentNoteScale;
	}
	public static void setCurrentNoteScaleText(String text) {
		ScaleButtons.currentNoteScale.setText(text);;
	}
	
}
