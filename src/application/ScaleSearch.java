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

	public ScaleSearch() {
		HBox searchHBox = new HBox(2);
		VBox searchVBox = new VBox(2);
		scaleLibrary = new ScaleLibrary();

		// System.out.println(Arrays.deepToString(scaleNames.toArray()));
		scaleNames = new ArrayList<>(scaleLibrary.getScaleMap().keySet());
		ObservableList<String> scaleObservableList = FXCollections.observableArrayList(scaleNames);
		listView = new ListView<String>(scaleObservableList);
		listView.setMaxSize(200, 160);
		searchBar = new TextField();
		searchButton = new Button("Search");
		
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
		    		ScaleFretboard.updateNotes(newValue);
		    	}
		    }
		});
		
		searchHBox.getChildren().addAll(searchBar, searchButton);
		searchVBox.getChildren().addAll(searchHBox, listView);
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
	
}
