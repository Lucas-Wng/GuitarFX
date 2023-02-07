package application;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AnalyzerPane extends VBox{
	public AnalyzerPane() {
		NavigationBar navBar = new NavigationBar();
		Fretboard fretboard = new Fretboard();
		FretboardButtons fretboardButtons = new FretboardButtons();
		Button btn3 = new Button("Button 3");
		HBox fretBoardHbox = new HBox(2);
		fretBoardHbox.getChildren().addAll(fretboard,fretboardButtons);
		this.getChildren().addAll(navBar,fretBoardHbox,btn3);
	}
}
