package application;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;


public class NavigationBar extends HBox {


	public NavigationBar() {
		Button analyzerButton = new Button("Chord Analyzer");
		Button scaleButton = new Button("Scale Library");
		Button chordLibraryButton = new Button("Chord Library");

		analyzerButton.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent event) {
		    	SceneController.activate("analyzer");
		    }

		});
		
		scaleButton.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent event) {
		    	SceneController.activate("scales");
		    }

		});
		
		chordLibraryButton.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent event) {
		    	SceneController.activate("chord library");
		    }

		});
		this.getChildren().addAll(chordLibraryButton, analyzerButton, scaleButton);
	}


}
