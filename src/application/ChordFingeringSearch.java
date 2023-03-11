package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ChordFingeringSearch extends Pane{
	private TextField searchBar;
	private Button searchButton;
	private Button playArpeggioButton;
	private Button playChordButton;
	private Button writeChord;
	private Button clearFile;
	private ListView<String> listView;
	private List<String> chordList;
	public ChordFingeringSearch() {
		String css = this.getClass().getResource("chordLibraryButtons.css").toExternalForm();
		this.getStylesheets().add(css);
		
	    Image soundImg = null;
		try {
			soundImg = new Image(new FileInputStream("resources/images/soundButton.png"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GridPane buttonGrid = new GridPane();
		Button next = new Button("  >\nNext");
		Button prev = new Button("     <\nPrevious");
		searchBar = new TextField();
		searchBar.setMaxWidth(150);
		searchButton = new Button("Search");
		playArpeggioButton = new Button("Arpeggio", new ImageView(soundImg));
		playArpeggioButton.setContentDisplay(ContentDisplay.TOP);
		playChordButton = new Button("Chord", new ImageView(soundImg));
		playChordButton.setContentDisplay(ContentDisplay.TOP);
		writeChord = new Button("Write Chord");
		clearFile = new Button("Clear File");
		prev.setId("gridButton");
		next.setId("gridButton");
		playArpeggioButton.setId("gridButton");
		playChordButton.setId("gridButton");
		writeChord.setId("gridButton");
		clearFile.setId("gridButton");
		
		buttonGrid.add(prev, 0, 0, 1, 1);
		buttonGrid.add(next, 1, 0, 1, 1);
		buttonGrid.add(playArpeggioButton, 0, 1, 1, 1);
		buttonGrid.add(playChordButton, 1, 1, 1, 1);
		buttonGrid.add(writeChord, 0, 2, 1, 1);
		buttonGrid.add(clearFile, 1, 2, 1, 1);
		buttonGrid.setHgap(10);
		buttonGrid.setVgap(10);
		chordList = FretPosJSONReader.getChordTypeList();
		ObservableList<String> chordObservableList = FXCollections.observableArrayList(chordList);
		listView = new ListView<String>(chordObservableList);
		listView.setMaxSize(210, 300);
		searchBar = new TextField();
		searchButton.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent event) {
		    	search(event);
		    }

		});
		
		next.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent event) {
		    	ChordFingeringFretboard.nextVariation();
		    }

		});
		prev.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent event) {
		    	ChordFingeringFretboard.prevVariation();
		    }

		});
		playArpeggioButton.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent event) {
		    	if(ChordFingeringFretboard.getCurrChordNote()!=null&&ChordFingeringFretboard.getCurrChordType()!=null&&ChordFingeringFretboard.getCurrentNotes()!=null) {
		    		ChordFingeringFretboard.playArpeggio(ChordFingeringFretboard.getCurrentNotes());
		    	}
		    }

		});
		
		playChordButton.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent event) {
		    	if(ChordFingeringFretboard.getCurrChordNote()!=null&&ChordFingeringFretboard.getCurrChordType()!=null&&ChordFingeringFretboard.getCurrentNotes()!=null) {
		    		ChordFingeringFretboard.playChord(ChordFingeringFretboard.getCurrentNotes());
		    	}
		    }

		});
		
		writeChord.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent event) {
		    	if(ChordFingeringFretboard.getCurrChordNote()!=null&&ChordFingeringFretboard.getCurrChordType()!=null&&ChordFingeringFretboard.getCurrentNotes()!=null) {
		    		ChordFingeringFileWriter.writeChord(ChordFingeringFretboard.getCurrChordNote()+ChordFingeringFretboard.getCurrChordType(), ChordFingeringFretboard.getCurrentNotes());
		    	}
		    	
		    }

		});
		
		clearFile.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent event) {
		    	ChordFingeringFileWriter.clearFile();
		    }

		});
		
		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

		    	if(newValue!=null) {
		    		ChordFingeringFretboard.setCurrChordType(newValue);
		    		ChordFingeringFretboard.updateNotes();
		    		ChordFingeringButtons.updateText();
		    		ChordFingeringButtons.clearSelection();
		    	}
		    }
		});
		HBox searchHBox = new HBox(2);
		VBox searchVBox = new VBox(3);
		searchHBox.getChildren().addAll(searchBar, searchButton);
		
		searchVBox.getChildren().addAll(searchHBox, listView, buttonGrid);
		this.getChildren().addAll(searchVBox);
	}
	public void search(ActionEvent event) {
		listView.getItems().clear();
		listView.getItems().addAll(ScaleSearch.searchList(searchBar.getText(), chordList));
	}
	
	
}
