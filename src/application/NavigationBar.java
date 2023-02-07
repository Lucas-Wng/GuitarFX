package application;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;


public class NavigationBar extends HBox {


	public NavigationBar() {
		Button btn1 = new Button("Chord Analyzer");
		Button btn2 = new Button("Scale Library");
		Button btn3 = new Button("Button 3");

		btn1.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent event) {
		    	SceneController.activate("analyzer");
		    }

		});
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent event) {
		    	SceneController.activate("scales");
		    }

		});
		
		this.getChildren().addAll(btn1, btn2, btn3);
	}


}
