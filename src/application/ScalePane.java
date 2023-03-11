package application;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ScalePane extends VBox{
	public ScalePane() {
		VBox fretButtons = new VBox(2);
		HBox fretSearch = new HBox(2);
		NavigationBar navBar = new NavigationBar();
		ScaleSearch search = new ScaleSearch();
		ScaleFretboard fretboard = new ScaleFretboard();
		ScaleButtons buttons = new ScaleButtons();
		fretButtons.getChildren().addAll(fretboard,buttons);
		fretSearch.getChildren().addAll(fretButtons,search);
		this.getChildren().addAll(navBar,fretSearch);
	}
}
