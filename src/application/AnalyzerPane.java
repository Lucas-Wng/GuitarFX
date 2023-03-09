package application;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AnalyzerPane extends VBox{
	public AnalyzerPane() {
		NavigationBar navBar = new NavigationBar();
		Fretboard fretboard = new Fretboard();
		Piano piano = new Piano();
		FretboardButtons fretboardButtons = new FretboardButtons();
		HBox fretBoardHbox = new HBox(2);
		VBox buttonPiano = new VBox(2);
		buttonPiano.setSpacing(163);
		buttonPiano.getChildren().addAll(fretboardButtons,piano);
		fretBoardHbox.getChildren().addAll(fretboard,buttonPiano);
		this.getChildren().addAll(navBar,fretBoardHbox);
	}
}
