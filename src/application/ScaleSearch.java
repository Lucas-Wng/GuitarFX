package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ScaleSearch extends Pane {
	private TextField searchBar;
	private Button searchButton;
	private ListView<String> listView;
	private ScaleLibrary scaleLibrary;
	private List<String> scaleNames;
	private Button playScaleButton;
	private Button clearButton;
	final private static String[] noteSequence = { "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#" };
	final private static int[] midiNoteSequence = { 57, 59, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68 };

	public ScaleSearch() {
		HBox searchHBox = new HBox(2);
		VBox searchVBox = new VBox(3);
		Image soundImg = null;
		try {
			soundImg = new Image(new FileInputStream("resources/images/soundButton.png"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scaleLibrary = new ScaleLibrary();
		scaleNames = new ArrayList<String>(ScaleLibrary.getScaleMap().keySet());
		ObservableList<String> scaleObservableList = FXCollections.observableArrayList(scaleNames);
		listView = new ListView<String>(scaleObservableList);
		listView.setMaxSize(210, 300);
		searchBar = new TextField();
		searchBar.setPrefWidth(150);
		searchButton = new Button("Search");
		playScaleButton = new Button("Play",new ImageView(soundImg));
		playScaleButton.setContentDisplay(ContentDisplay.TOP);
		clearButton = new Button("Clear");
		clearButton.setPrefSize(100, 80);
		playScaleButton.setPrefSize(100, 80);
		searchButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				search(event);
			}

		});

		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (newValue != null) {
					ScaleFretboard.setCurrentScale(newValue);
					ScaleFretboard.updateNotes();
					ScaleButtons.clearScaleGroup();
				}
			}
		});

		playScaleButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (ScaleFretboard.getCurrentScale() != null) {
					int[] intervals = ScaleLibrary.getScaleMap().get(ScaleFretboard.getCurrentScale());
					playIntervalsSound(intervals);

				}
			}

		});
		clearButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ScaleFretboard.setCurrentNote(null);
				ScaleFretboard.setCurrentScale(null);
				ScaleFretboard.updateNotes();
				ScaleButtons.clearNoteGroup();
				ScaleButtons.clearScaleGroup();
			}

		});

		searchHBox.getChildren().addAll(searchBar, searchButton);
		HBox buttonHBox = new HBox(2);
		buttonHBox.setSpacing(10);
		buttonHBox.getChildren().addAll(playScaleButton,clearButton);
		searchVBox.getChildren().addAll(searchHBox, listView, buttonHBox);
		this.getChildren().addAll(searchVBox);
	}

	public static void playIntervalsSound(int[] intervals) {
		if (ScaleFretboard.getCurrentNote() != null && ScaleFretboard.getCurrentScale() != null) {
			String currentNote = ScaleFretboard.getCurrentNote();
			int midinote = -1;
			for (int i = 0; i < noteSequence.length; i++) {
				if (noteSequence[i].equals(currentNote)) {
					midinote = i;
					break;
				}
			}

			for (int i = 0; i < intervals.length; i++) {
				MidiPlayer.playNote(midiNoteSequence[midinote] + intervals[i]);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				MidiPlayer.stopSound();
			}
			MidiPlayer.playNote(midiNoteSequence[midinote] + 12);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MidiPlayer.stopSound();
		}
	}

	public void search(ActionEvent event) {
		listView.getItems().clear();
		listView.getItems().addAll(searchList(searchBar.getText(), scaleNames));
	}

	public static List<String> searchList(String searchWords, List<String> listOfStrings) {
		Map<String, Integer> wordsMap = new HashMap<String, Integer>();
		for (String listWord : listOfStrings) {
			int similarity = levenshteinDistance(listWord.toLowerCase(), searchWords.toLowerCase());
			if (similarity <= 5) {
				wordsMap.put(listWord, similarity);
			}
		}
		return insertionSortHashMap(wordsMap);

	}

	public static List<String> insertionSortHashMap(Map<String, Integer> wordsMap) {
		List<Map.Entry<String, Integer>> wordsMapList = new ArrayList<>(wordsMap.entrySet());
		for (int i = 1; i < wordsMapList.size(); i++) {
			Map.Entry<String, Integer> current = wordsMapList.get(i);
			int j = i - 1;
			while (j >= 0 && wordsMapList.get(j).getValue() > current.getValue()) {
				wordsMapList.set(j + 1, wordsMapList.get(j));
				j--;
			}
			wordsMapList.set(j + 1, current);
		}
		List<String> searchStringList = new ArrayList<String>();
		for (Entry<String, Integer> search : wordsMapList) {
			searchStringList.add(search.getKey());
		}
		return searchStringList;
	}

	public static int levenshteinDistance(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= n; j++) {
			dp[0][j] = j;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				int substitutionCost;
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					substitutionCost = 0;
				} else {
					substitutionCost = 1;
				}
				dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + substitutionCost);
			}
		}

		return dp[m][n];
	}

}
