package application;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ScalePane extends VBox{
	public ScalePane() {
		NavigationBar navBar = new NavigationBar();
		ScaleSearch search = new ScaleSearch();
		ScaleFretboard fretboard = new ScaleFretboard();
		
		HBox fretBoardHbox = new HBox(2);
		fretBoardHbox.getChildren().addAll(fretboard,search);
		this.getChildren().addAll(navBar,fretBoardHbox);
	}
}
