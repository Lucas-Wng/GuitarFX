package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ScaleSearch extends Pane{
	private TextField searchBar;
	private Button searchButton;
	private ListView<String> listView;
	private ScaleLibrary scaleLibrary;
	private List<String> scaleNames;
	private MidiPlayer midiplayer;
	private Button playScaleButton;
	final private static String[] noteSequence = { "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G",
	"G#" };
	final private static int[] midiNoteSequence = {57,59,59,60,61,62,63,64,65,66,67,68};
	

	public ScaleSearch() {
		midiplayer = new MidiPlayer();
		HBox searchHBox = new HBox(2);
		VBox searchVBox = new VBox(3);
		scaleLibrary = new ScaleLibrary();

		// System.out.println(Arrays.deepToString(scaleNames.toArray()));
		scaleNames = new ArrayList<String>(ScaleLibrary.getScaleMap().keySet());
		ObservableList<String> scaleObservableList = FXCollections.observableArrayList(scaleNames);
		listView = new ListView<String>(scaleObservableList);
		listView.setMaxSize(200, 160);
		searchBar = new TextField();
		searchButton = new Button("Search");
		playScaleButton = new Button("Play");
		searchButton.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent event) {
		    	search(event);
		    }

		});
		
		
		
		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		        //System.out.println(newValue);
		    	if(newValue!=null) {
		    		ScaleFretboard.setCurrentScale(newValue);
		    		ScaleFretboard.updateNotes();
		    	}
		    }
		});
		
		playScaleButton.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent event) {
		    	if(ScaleFretboard.getCurrentScale()!=null) {
		    		//System.out.println(scaleLibrary.getScaleMap().keySet());
		    		int[] intervals = ScaleLibrary.getScaleMap().get(ScaleFretboard.getCurrentScale());
		    		//System.out.println(Arrays.toString(intervals));
		    		String currentNote = ScaleFretboard.getCurrentNote();
		    		int midinote = -1;
		    		for(int i=0;i<noteSequence.length;i++) {
		    			if(noteSequence[i].equals(currentNote)) {
		    				midinote = i;
		    				break;
		    			}
		    		}
		    		
		    		for(int i=0;i<intervals.length;i++) {
		    			midiplayer.playNote(midiNoteSequence[midinote]+intervals[i]);
		    			try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    			midiplayer.stopSound();
		    		}
		    		midiplayer.playNote(midiNoteSequence[midinote]+12);
		    		try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		midiplayer.stopSound();
		    	}
		    }

		});
		
		searchHBox.getChildren().addAll(searchBar, searchButton);
		searchVBox.getChildren().addAll(searchHBox, listView,playScaleButton);
		this.getChildren().addAll(searchVBox);
	}


	public void search(ActionEvent event) {
		listView.getItems().clear();
		listView.getItems().addAll(searchList(searchBar.getText(), scaleNames));
	}

	private List<String> searchList(String searchWords, List<String> listOfStrings) {

		List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));

		return listOfStrings.stream().filter(input -> {
			return searchWordsArray.stream().allMatch(word -> input.toLowerCase().contains(word.toLowerCase()));
		}).collect(Collectors.toList());
	}
	public List<String> quickSort(){
		return null;
		
	}
	public String binarySearch() {
		return null;
		
	}
	
}
