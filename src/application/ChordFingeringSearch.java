package application;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ChordFingeringSearch extends Pane{
	private TextField searchBar;
	private Button searchButton;
	private Button playArpeggioButton;
	private Button playChordButton;
	private ListView<String> listView;
	private List<String> chordList;
	public ChordFingeringSearch() {
		HBox nextPrevBox = new HBox(4);
		Button next = new Button(">");
		Button prev = new Button("<");
		searchBar = new TextField();
		searchButton = new Button("Search");
		playArpeggioButton = new Button("Play");
		playChordButton = new Button("Play");
		chordList = FretPosJSONReader.getChordTypeList();
		ObservableList<String> chordObservableList = FXCollections.observableArrayList(chordList);
		listView = new ListView<String>(chordObservableList);
		listView.setMaxSize(200, 160);
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
		    	ChordFingeringFretboard.playArpeggio(ChordFingeringFretboard.getCurrentNotes());
		    }

		});
		
		playChordButton.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent event) {
		    	ChordFingeringFretboard.playChord(ChordFingeringFretboard.getCurrentNotes());
		    }

		});
		
		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

		    	if(newValue!=null) {
		    		ChordFingeringFretboard.setCurrChordType(newValue);
		    		ChordFingeringFretboard.updateNotes();
		    	}
		    }
		});
		HBox searchHBox = new HBox(2);
		VBox searchVBox = new VBox(3);
		HBox buttonPlayHBox = new HBox(3);
		searchHBox.getChildren().addAll(searchBar, searchButton);
		nextPrevBox.getChildren().addAll(prev,next,playArpeggioButton,playChordButton);
		searchVBox.getChildren().addAll(searchHBox, listView, nextPrevBox);
		this.getChildren().addAll(searchVBox);
	}
	public void search(ActionEvent event) {
		listView.getItems().clear();
		listView.getItems().addAll(ScaleSearch.searchList(searchBar.getText(), chordList));
	}
	
}
