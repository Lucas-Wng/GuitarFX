package application;

import java.util.Arrays;

import javafx.scene.layout.VBox;


public class ChordFingeringPane extends VBox{

	//chord write 
	public ChordFingeringPane() {
		NavigationBar navBar = new NavigationBar();
		System.out.println(Arrays.toString(ChordLibrary.list.get(1).getFingerPos()));
		ChordFingeringFretboard fretboard = new ChordFingeringFretboard();
		this.getChildren().addAll(navBar,fretboard);
	}
	
}