package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class FretboardButtons extends GridPane{
	public FretboardButtons() {
		this.setHgap(10);
	    this.setVgap(10);
	    Image resetImg = null;
	    Image soundImg = null;
		try {
			resetImg = new Image(new FileInputStream("data/resetButton.png"));
			soundImg = new Image(new FileInputStream("data/soundButton.png"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Button resetNotes = new Button();
		resetNotes.setPrefSize(60, 40);
		resetNotes.setGraphic(new ImageView(resetImg));
		Button switchEnharmonic = new Button("#⇔b");
		switchEnharmonic.setPrefSize(60, 40);
		Button soundButton = new Button();
		soundButton.setPrefSize(60, 40);
		soundButton.setGraphic(new ImageView(soundImg));
		Button button4 = new Button("Button 4");
		Button button5 = new Button("Button 5");
		Button button6 = new Button("Button 6");
		
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
		soundButton.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent event) {
		    	Fretboard.playFretboardNotes();
		    }

		});
		
		this.add(resetNotes, 0, 0, 1, 1);
		this.add(switchEnharmonic, 1, 0, 1, 1);
		this.add(soundButton, 2, 0, 1, 1);
		this.add(button4, 0, 1, 1, 1);
		this.add(button5, 1, 1, 1, 1);
		this.add(button6, 2, 1, 1, 1);
	}
}
