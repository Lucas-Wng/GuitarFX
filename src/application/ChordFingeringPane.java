package application;


import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class ChordFingeringPane extends VBox{

	public ChordFingeringPane() {
		VBox fretboardButton= new VBox(2);
		HBox fretSearch = new HBox(2);
		NavigationBar navBar = new NavigationBar();
		ChordFingeringFretboard fretboard = new ChordFingeringFretboard();
		ChordFingeringButtons buttons = new ChordFingeringButtons();
		ChordFingeringSearch search = new ChordFingeringSearch();
		fretboardButton.getChildren().addAll(fretboard,buttons);
		fretSearch.getChildren().addAll(fretboardButton,search);
		this.getChildren().addAll(navBar,fretSearch);
	}
	
}
