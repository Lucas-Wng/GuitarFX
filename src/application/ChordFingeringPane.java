package application;

import java.util.Arrays;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class ChordFingeringPane extends VBox{

	//chord write 
	public ChordFingeringPane() {
		VBox fretboardButton= new VBox(2);
		HBox fretSearch = new HBox(2);
		NavigationBar navBar = new NavigationBar();
//		System.out.println(Arrays.toString(ChordLibrary.list.get(1).getFingerPos()));
		ChordFingeringFretboard fretboard = new ChordFingeringFretboard();
		ChordFingeringButtons buttons = new ChordFingeringButtons();
		ChordFingeringSearch search = new ChordFingeringSearch();
		fretboardButton.getChildren().addAll(fretboard,buttons);
		fretSearch.getChildren().addAll(fretboardButton,search);
		this.getChildren().addAll(navBar,fretSearch);
	}
	
}
