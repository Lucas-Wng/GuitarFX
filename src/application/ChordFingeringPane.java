package application;

import java.util.Arrays;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class ChordFingeringPane extends VBox{

	//chord write 
	public ChordFingeringPane() {
		HBox fretboardSearchBox = new HBox(2);
		NavigationBar navBar = new NavigationBar();
//		System.out.println(Arrays.toString(ChordLibrary.list.get(1).getFingerPos()));
		ChordFingeringFretboard fretboard = new ChordFingeringFretboard();
		ChordFingeringButtons buttons = new ChordFingeringButtons();
		ChordFingeringFileWriter fileWriter = new ChordFingeringFileWriter(); 
		ChordFingeringFileWriter.writeChord(2);
		ChordFingeringSearch search = new ChordFingeringSearch();
		fretboardSearchBox.getChildren().addAll(fretboard,search);
		this.getChildren().addAll(navBar,fretboardSearchBox,buttons);
	}
	
}
