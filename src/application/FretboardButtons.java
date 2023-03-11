package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class FretboardButtons extends GridPane {
	public FretboardButtons() {
		this.setHgap(10);
		this.setVgap(10);
		Image resetImg = null;
		Image soundImg = null;
		try {
			resetImg = new Image(new FileInputStream("resources/images/resetButton.png"));
			soundImg = new Image(new FileInputStream("resources/images/soundButton.png"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Button resetNotes = new Button("Reset", new ImageView(resetImg));
		resetNotes.setContentDisplay(ContentDisplay.TOP);
		resetNotes.setPrefSize(80, 80);
		Button switchEnharmonic = new Button("#⇔b");
		switchEnharmonic.wrapTextProperty().setValue(true);
		switchEnharmonic.setPrefSize(80, 80);
		Button arpeggioSoundButton = new Button("Arpeggio", new ImageView(soundImg));
		arpeggioSoundButton.setPrefSize(80, 80);
		arpeggioSoundButton.setContentDisplay(ContentDisplay.TOP);
		Button chordSoundButton = new Button("Chord", new ImageView(soundImg));
		chordSoundButton.setPrefSize(80, 80);
		chordSoundButton.setContentDisplay(ContentDisplay.TOP);
		Button clearTxtButton = new Button("Clear File");
		Button writeButton = new Button("Write");
		clearTxtButton.setPrefSize(80, 80);
		writeButton.setPrefSize(80, 80);

		resetNotes.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Fretboard.clearSelection();
			}

		});
		switchEnharmonic.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Fretboard.switchAccidental();
			}

		});
		arpeggioSoundButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Fretboard.playArpeggioFretboardNotes();
			}

		});

		chordSoundButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Fretboard.playChordFretboardNotes();
			}

		});
		clearTxtButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ChordFingeringFileWriter.clearFile();
			}

		});

		writeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Fretboard.writeChord();
			}

		});

		this.add(resetNotes, 0, 0, 1, 1);
		this.add(switchEnharmonic, 1, 0, 1, 1);
		this.add(arpeggioSoundButton, 2, 0, 1, 1);
		this.add(writeButton, 0, 1, 1, 1);
		this.add(clearTxtButton, 1, 1, 1, 1);
		this.add(chordSoundButton, 2, 1, 1, 1);
	}
}
