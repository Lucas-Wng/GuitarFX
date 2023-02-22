package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class ChordFingeringSearch extends Pane{
	public ChordFingeringSearch() {
		HBox nextPrevBox = new HBox(2);
		Button next = new Button(">");
		Button prev = new Button("<");
		next.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent event) {
		    	ChordFingeringFretboard.nextVariation();
		    }

		});
		prev.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent event) {
		    	ChordFingeringFretboard.prevVariation();
		    }

		});
		nextPrevBox.getChildren().addAll(prev,next);
		this.getChildren().addAll(nextPrevBox);
	}
}
