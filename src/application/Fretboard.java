package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Fretboard extends Pane {
	private static String[] userNotes;
	private static ToggleGroup highE;
	private static ToggleGroup A;
	private static ToggleGroup D;
	private static ToggleGroup G;
	private static ToggleGroup B;
	private static ToggleGroup lowE;
	private static ArrayList<ToggleButton> highEList;
	private static ArrayList<ToggleButton> AList;
	private static ArrayList<ToggleButton> DList;
	private static ArrayList<ToggleButton> GList;
	private static ArrayList<ToggleButton> BList;
	private static ArrayList<ToggleButton> lowEList;
	private static ImageView wholeViewhighE;
	private static ImageView sharphighE;
	private static ImageView wholeViewA;
	private static ImageView sharpA;
	private static ImageView wholeViewD;
	private static ImageView sharpD;
	private static ImageView wholeViewG;
	private static ImageView sharpG;
	private static ImageView wholeViewB;
	private static ImageView sharpB;
	private static ImageView wholeViewlowE;
	private static ImageView sharplowE;
	private static FlowPane possibleChordsLabel;
	final private static String[] noteSequenceSharp = { "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G",
			"G#" };
	final private static String[] noteSequenceFlat = { "A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G",
			"Ab" };
	private static MidiPlayer midiplayer;
	private static ArrayList<String> possibleChordsList;

	public Fretboard() {
		String css = this.getClass().getResource("fretboard.css").toExternalForm();
		this.getStylesheets().add(css);
		this.setPrefHeight(650);
		this.setPrefWidth(850);
		midiplayer = new MidiPlayer();
		createFretboard();
	}

	public void createFretboard() {
		Rectangle chordNameRect = new Rectangle(50, 330, 500, 200);
		chordNameRect.setId("chordNameRect");
		possibleChordsLabel = new FlowPane();
		possibleChordsLabel.setHgap(5);
		possibleChordsLabel.setVgap(5);
		possibleChordsLabel.relocate(50, 330);
		possibleChordsLabel.setPrefWrapLength(500);
		possibleChordsLabel.setId("flowPane");
		userNotes = new String[6];
		possibleChordsList = new ArrayList<String>();
		Label possibleChords = new Label("");
		Label possibleChordsHeading = new Label("Possible Chords");
		Rectangle staffRectangle = new Rectangle(600, 330, 170, 200);
		staffRectangle.setId("staffRectangle");
		this.getChildren().add(staffRectangle);
		Image trebleclef = null;
		Image wholeNote = null;
		Image sharpSymbol = null;
		try {
			trebleclef = new Image(new FileInputStream("resources/images/trebleclef.png"), 130, 100, false, false);
			wholeNote = new Image(new FileInputStream("resources/images/wholeNote.png"), 23, 17, false, false);
			sharpSymbol = new Image(new FileInputStream("resources/images/sharpSymbol.png"), 15, 16, false, false);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageView trebleView = new ImageView(trebleclef);

		trebleView.setX(625);
		trebleView.setY(355);
		this.getChildren().add(trebleView);

		possibleChords.relocate(50, 330);
		possibleChords.setId("possibleChordsCss");
		possibleChordsHeading.relocate(50, 250);
		possibleChordsHeading.setId("possibleChordsLabel");
		ChordLibrary chordlibrary = new ChordLibrary();
		for (int i = 0; i < 6; i++) {
			Line line1 = new Line(50, 20 + (i * 40), 800.0, 20 + (i * 40));
			line1.setId("stringline" + (i + 1));
			this.getChildren().add(line1);
		}
		Line lineNut = new Line(50.0, 20.0, 50.0, 220);
		lineNut.setId("lineNut");
		this.getChildren().add(lineNut);
		for (int i = 1; i <= 15; i++) {
			Line line1 = new Line(50 + i * 50.0, 20.0, 50 + i * 50.0, 220);
			line1.setId("lineFret");
			this.getChildren().add(line1);
		}
		Label num0 = new Label("0");
		num0.relocate(24, 230);
		num0.setId("fretNum");
		this.getChildren().add(num0);
		for (int i = 1; i <= 9; i++) {
			Label num = new Label(i + "");
			num.relocate(i * 50 + 17, 230);
			num.setId("fretNum");
			this.getChildren().add(num);
		}
		for (int i = 10; i <= 15; i++) {
			Label num = new Label(i + "");
			num.relocate(i * 50.0 + 16, 230);
			num.setId("fretNum");
			this.getChildren().add(num);
		}

		Circle circle3 = new Circle(175, 120, 10);
		Circle circle5 = new Circle(275, 120, 10);
		Circle circle7 = new Circle(375, 120, 10);
		Circle circle9 = new Circle(475, 120, 10);
		Circle circle12A = new Circle(625, 80, 10);
		Circle circle12B = new Circle(625, 160, 10);
		Circle circle15 = new Circle(775, 120, 10);
		circle3.setId("noteCircle");
		circle5.setId("noteCircle");
		circle7.setId("noteCircle");
		circle9.setId("noteCircle");
		circle12A.setId("noteCircle");
		circle12B.setId("noteCircle");
		circle15.setId("noteCircle");

		highE = new ToggleGroup();

		ToggleButton highE0 = new ToggleButton("E");
		ToggleButton highE1 = new ToggleButton("F");
		ToggleButton highE2 = new ToggleButton("F#");
		ToggleButton highE3 = new ToggleButton("G");
		ToggleButton highE4 = new ToggleButton("G#");
		ToggleButton highE5 = new ToggleButton("A");
		ToggleButton highE6 = new ToggleButton("A#");
		ToggleButton highE7 = new ToggleButton("B");
		ToggleButton highE8 = new ToggleButton("C");
		ToggleButton highE9 = new ToggleButton("C#");
		ToggleButton highE10 = new ToggleButton("D");
		ToggleButton highE11 = new ToggleButton("D#");
		ToggleButton highE12 = new ToggleButton("E");
		ToggleButton highE13 = new ToggleButton("F");
		ToggleButton highE14 = new ToggleButton("F#");
		ToggleButton highE15 = new ToggleButton("G");

		highE0.setToggleGroup(highE);
		highE1.setToggleGroup(highE);
		highE2.setToggleGroup(highE);
		highE3.setToggleGroup(highE);
		highE4.setToggleGroup(highE);
		highE5.setToggleGroup(highE);
		highE6.setToggleGroup(highE);
		highE7.setToggleGroup(highE);
		highE8.setToggleGroup(highE);
		highE9.setToggleGroup(highE);
		highE10.setToggleGroup(highE);
		highE11.setToggleGroup(highE);
		highE12.setToggleGroup(highE);
		highE13.setToggleGroup(highE);
		highE14.setToggleGroup(highE);
		highE15.setToggleGroup(highE);

		highEList = new ArrayList<ToggleButton>();
		highEList.add(highE0);
		highEList.add(highE1);
		highEList.add(highE2);
		highEList.add(highE3);
		highEList.add(highE4);
		highEList.add(highE5);
		highEList.add(highE6);
		highEList.add(highE7);
		highEList.add(highE8);
		highEList.add(highE9);
		highEList.add(highE10);
		highEList.add(highE11);
		highEList.add(highE12);
		highEList.add(highE13);
		highEList.add(highE14);
		highEList.add(highE15);

		highE0.setUserData(new Note("E", 64, 3));
		highE1.setUserData(new Note("F", 65, 3));
		highE2.setUserData(new Note("F#", 66, 3));
		highE3.setUserData(new Note("G", 67, 3));
		highE4.setUserData(new Note("G#", 68, 3));
		highE5.setUserData(new Note("A", 69, 3));
		highE6.setUserData(new Note("A#", 70, 3));
		highE7.setUserData(new Note("B", 71, 3));
		highE8.setUserData(new Note("C", 72, 4));
		highE9.setUserData(new Note("C#", 73, 4));
		highE10.setUserData(new Note("D", 74, 4));
		highE11.setUserData(new Note("D#", 75, 4));
		highE12.setUserData(new Note("E", 76, 4));
		highE13.setUserData(new Note("F", 77, 4));
		highE14.setUserData(new Note("F#", 78, 4));
		highE15.setUserData(new Note("G", 79, 4));

		highE0.setLayoutX(5);
		highE0.setLayoutY(5);
		highE1.setLayoutX(55);
		highE1.setLayoutY(5);
		highE2.setLayoutX(105);
		highE2.setLayoutY(5);
		highE3.setLayoutX(155);
		highE3.setLayoutY(5);
		highE4.setLayoutX(205);
		highE4.setLayoutY(5);
		highE5.setLayoutX(255);
		highE5.setLayoutY(5);
		highE6.setLayoutX(305);
		highE6.setLayoutY(5);
		highE7.setLayoutX(355);
		highE7.setLayoutY(5);
		highE8.setLayoutX(405);
		highE8.setLayoutY(5);
		highE9.setLayoutX(455);
		highE9.setLayoutY(5);
		highE10.setLayoutX(505);
		highE10.setLayoutY(5);
		highE11.setLayoutX(555);
		highE11.setLayoutY(5);
		highE12.setLayoutX(605);
		highE12.setLayoutY(5);
		highE13.setLayoutX(655);
		highE13.setLayoutY(5);
		highE14.setLayoutX(705);
		highE14.setLayoutY(5);
		highE15.setLayoutX(755);
		highE15.setLayoutY(5);

		wholeViewhighE = new ImageView(wholeNote);
		wholeViewhighE.setVisible(false);
		wholeViewhighE.setX(700);
		this.getChildren().add(wholeViewhighE);

		sharphighE = new ImageView(sharpSymbol);
		sharphighE.setVisible(false);
		sharphighE.setX(685);
		this.getChildren().add(sharphighE);

		highE.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
				ToggleButton selectedNote = (ToggleButton) highE.getSelectedToggle();
				sharphighE.setVisible(false);
				wholeViewhighE.setVisible(false);
				if (selectedNote != null) {
					String stringNote = ((Note) selectedNote.getUserData()).getName();
					userNotes[5] = stringNote;
					wholeViewhighE.setY(getStaffNotePos(stringNote));
					wholeViewhighE.setVisible(true);
					if (stringNote.length() != 1) {
						sharphighE.setY(getStaffNotePos(stringNote));
						sharphighE.setVisible(true);
					}
				} else {
					userNotes[5] = null;
				}

				possibleChordsList = chordlibrary.findChord(userNotes);
				Piano.updatePiano(userNotes);
				updateLabel();
			}

		});

		B = new ToggleGroup();
		ToggleButton B0 = new ToggleButton("B");
		ToggleButton B1 = new ToggleButton("C");
		ToggleButton B2 = new ToggleButton("C#");
		ToggleButton B3 = new ToggleButton("D");
		ToggleButton B4 = new ToggleButton("D#");
		ToggleButton B5 = new ToggleButton("E");
		ToggleButton B6 = new ToggleButton("F");
		ToggleButton B7 = new ToggleButton("F#");
		ToggleButton B8 = new ToggleButton("G");
		ToggleButton B9 = new ToggleButton("G#");
		ToggleButton B10 = new ToggleButton("A");
		ToggleButton B11 = new ToggleButton("A#");
		ToggleButton B12 = new ToggleButton("B");
		ToggleButton B13 = new ToggleButton("C");
		ToggleButton B14 = new ToggleButton("C#");
		ToggleButton B15 = new ToggleButton("D");

		B0.setToggleGroup(B);
		B1.setToggleGroup(B);
		B2.setToggleGroup(B);
		B3.setToggleGroup(B);
		B4.setToggleGroup(B);
		B5.setToggleGroup(B);
		B6.setToggleGroup(B);
		B7.setToggleGroup(B);
		B8.setToggleGroup(B);
		B9.setToggleGroup(B);
		B10.setToggleGroup(B);
		B11.setToggleGroup(B);
		B12.setToggleGroup(B);
		B13.setToggleGroup(B);
		B14.setToggleGroup(B);
		B15.setToggleGroup(B);

		BList = new ArrayList<ToggleButton>();
		BList.add(B0);
		BList.add(B1);
		BList.add(B2);
		BList.add(B3);
		BList.add(B4);
		BList.add(B5);
		BList.add(B6);
		BList.add(B7);
		BList.add(B8);
		BList.add(B9);
		BList.add(B10);
		BList.add(B11);
		BList.add(B12);
		BList.add(B13);
		BList.add(B14);
		BList.add(B15);

		B0.setUserData(new Note("B", 59, 2));
		B1.setUserData(new Note("C", 60, 3));
		B2.setUserData(new Note("C#", 61, 3));
		B3.setUserData(new Note("D", 62, 3));
		B4.setUserData(new Note("D#", 63, 3));
		B5.setUserData(new Note("E", 64, 3));
		B6.setUserData(new Note("F", 65, 3));
		B7.setUserData(new Note("F#", 66, 3));
		B8.setUserData(new Note("G", 67, 3));
		B9.setUserData(new Note("G#", 68, 3));
		B10.setUserData(new Note("A", 69, 3));
		B11.setUserData(new Note("A#", 70, 3));
		B12.setUserData(new Note("B", 71, 3));
		B13.setUserData(new Note("C", 72, 4));
		B14.setUserData(new Note("C#", 73, 4));
		B15.setUserData(new Note("D", 74, 4));

		B0.setLayoutX(5);
		B0.setLayoutY(45);
		B1.setLayoutX(55);
		B1.setLayoutY(45);
		B2.setLayoutX(105);
		B2.setLayoutY(45);
		B3.setLayoutX(155);
		B3.setLayoutY(45);
		B4.setLayoutX(205);
		B4.setLayoutY(45);
		B5.setLayoutX(255);
		B5.setLayoutY(45);
		B6.setLayoutX(305);
		B6.setLayoutY(45);
		B7.setLayoutX(355);
		B7.setLayoutY(45);
		B8.setLayoutX(405);
		B8.setLayoutY(45);
		B9.setLayoutX(455);
		B9.setLayoutY(45);
		B10.setLayoutX(505);
		B10.setLayoutY(45);
		B11.setLayoutX(555);
		B11.setLayoutY(45);
		B12.setLayoutX(605);
		B12.setLayoutY(45);
		B13.setLayoutX(655);
		B13.setLayoutY(45);
		B14.setLayoutX(705);
		B14.setLayoutY(45);
		B15.setLayoutX(755);
		B15.setLayoutY(45);

		wholeViewB = new ImageView(wholeNote);
		wholeViewB.setVisible(false);
		wholeViewB.setX(700);
		this.getChildren().add(wholeViewB);

		sharpB = new ImageView(sharpSymbol);
		sharpB.setVisible(false);
		sharpB.setX(685);
		this.getChildren().add(sharpB);

		B.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
				ToggleButton selectedNote = (ToggleButton) B.getSelectedToggle();
				sharpB.setVisible(false);
				wholeViewB.setVisible(false);
				if (selectedNote != null) {
					String stringNote = ((Note) selectedNote.getUserData()).getName();
					userNotes[4] = stringNote;
					wholeViewB.setY(getStaffNotePos(stringNote));
					wholeViewB.setVisible(true);
					if (stringNote.length() != 1) {
						sharpB.setY(getStaffNotePos(stringNote));
						sharpB.setVisible(true);
					}
				} else {
					userNotes[4] = null;
				}

				possibleChordsList = chordlibrary.findChord(userNotes);
				Piano.updatePiano(userNotes);
				updateLabel();

			}

		});

		G = new ToggleGroup();
		ToggleButton G0 = new ToggleButton("G");
		ToggleButton G1 = new ToggleButton("G#");
		ToggleButton G2 = new ToggleButton("A");
		ToggleButton G3 = new ToggleButton("A#");
		ToggleButton G4 = new ToggleButton("B");
		ToggleButton G5 = new ToggleButton("C");
		ToggleButton G6 = new ToggleButton("C#");
		ToggleButton G7 = new ToggleButton("D");
		ToggleButton G8 = new ToggleButton("D#");
		ToggleButton G9 = new ToggleButton("E");
		ToggleButton G10 = new ToggleButton("F");
		ToggleButton G11 = new ToggleButton("F#");
		ToggleButton G12 = new ToggleButton("G");
		ToggleButton G13 = new ToggleButton("G#");
		ToggleButton G14 = new ToggleButton("A");
		ToggleButton G15 = new ToggleButton("A#");

		G0.setToggleGroup(G);
		G1.setToggleGroup(G);
		G2.setToggleGroup(G);
		G3.setToggleGroup(G);
		G4.setToggleGroup(G);
		G5.setToggleGroup(G);
		G6.setToggleGroup(G);
		G7.setToggleGroup(G);
		G8.setToggleGroup(G);
		G9.setToggleGroup(G);
		G10.setToggleGroup(G);
		G11.setToggleGroup(G);
		G12.setToggleGroup(G);
		G13.setToggleGroup(G);
		G14.setToggleGroup(G);
		G15.setToggleGroup(G);

		G0.setUserData(new Note("G", 55, 2));
		G1.setUserData(new Note("G#", 56, 2));
		G2.setUserData(new Note("A", 57, 2));
		G3.setUserData(new Note("A#", 58, 2));
		G4.setUserData(new Note("B", 59, 2));
		G5.setUserData(new Note("C", 60, 3));
		G6.setUserData(new Note("C#", 61, 3));
		G7.setUserData(new Note("D", 62, 3));
		G8.setUserData(new Note("D#", 63, 3));
		G9.setUserData(new Note("E", 64, 3));
		G10.setUserData(new Note("F", 65, 3));
		G11.setUserData(new Note("F#", 66, 3));
		G12.setUserData(new Note("G", 67, 3));
		G13.setUserData(new Note("G#", 68, 3));
		G14.setUserData(new Note("A", 69, 3));
		G15.setUserData(new Note("A#", 70, 3));

		GList = new ArrayList<ToggleButton>();
		GList.add(G0);
		GList.add(G1);
		GList.add(G2);
		GList.add(G3);
		GList.add(G4);
		GList.add(G5);
		GList.add(G6);
		GList.add(G7);
		GList.add(G8);
		GList.add(G9);
		GList.add(G10);
		GList.add(G11);
		GList.add(G12);
		GList.add(G13);
		GList.add(G14);
		GList.add(G15);

		G0.setLayoutX(5);
		G0.setLayoutY(85);
		G1.setLayoutX(55);
		G1.setLayoutY(85);
		G2.setLayoutX(105);
		G2.setLayoutY(85);
		G3.setLayoutX(155);
		G3.setLayoutY(85);
		G4.setLayoutX(205);
		G4.setLayoutY(85);
		G5.setLayoutX(255);
		G5.setLayoutY(85);
		G6.setLayoutX(305);
		G6.setLayoutY(85);
		G7.setLayoutX(355);
		G7.setLayoutY(85);
		G8.setLayoutX(405);
		G8.setLayoutY(85);
		G9.setLayoutX(455);
		G9.setLayoutY(85);
		G10.setLayoutX(505);
		G10.setLayoutY(85);
		G11.setLayoutX(555);
		G11.setLayoutY(85);
		G12.setLayoutX(605);
		G12.setLayoutY(85);
		G13.setLayoutX(655);
		G13.setLayoutY(85);
		G14.setLayoutX(705);
		G14.setLayoutY(85);
		G15.setLayoutX(755);
		G15.setLayoutY(85);

		wholeViewG = new ImageView(wholeNote);
		wholeViewG.setVisible(false);
		wholeViewG.setX(700);
		this.getChildren().add(wholeViewG);

		sharpG = new ImageView(sharpSymbol);
		sharpG.setVisible(false);
		sharpG.setX(685);
		this.getChildren().add(sharpG);

		G.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
				ToggleButton selectedNote = (ToggleButton) G.getSelectedToggle();
				sharpG.setVisible(false);
				wholeViewG.setVisible(false);
				if (selectedNote != null) {
					String stringNote = ((Note) selectedNote.getUserData()).getName();
					userNotes[3] = stringNote;
					wholeViewG.setY(getStaffNotePos(stringNote));
					wholeViewG.setVisible(true);
					if (stringNote.length() != 1) {
						sharpG.setY(getStaffNotePos(stringNote));
						sharpG.setVisible(true);
					}
				} else {
					userNotes[3] = null;
				}

				possibleChordsList = chordlibrary.findChord(userNotes);
				Piano.updatePiano(userNotes);
				updateLabel();
			}

		});

		D = new ToggleGroup();
		ToggleButton D0 = new ToggleButton("D");
		ToggleButton D1 = new ToggleButton("D#");
		ToggleButton D2 = new ToggleButton("E");
		ToggleButton D3 = new ToggleButton("F");
		ToggleButton D4 = new ToggleButton("F#");
		ToggleButton D5 = new ToggleButton("G");
		ToggleButton D6 = new ToggleButton("G#");
		ToggleButton D7 = new ToggleButton("A");
		ToggleButton D8 = new ToggleButton("A#");
		ToggleButton D9 = new ToggleButton("B");
		ToggleButton D10 = new ToggleButton("C");
		ToggleButton D11 = new ToggleButton("C#");
		ToggleButton D12 = new ToggleButton("D");
		ToggleButton D13 = new ToggleButton("D#");
		ToggleButton D14 = new ToggleButton("E");
		ToggleButton D15 = new ToggleButton("F");

		D0.setToggleGroup(D);
		D1.setToggleGroup(D);
		D2.setToggleGroup(D);
		D3.setToggleGroup(D);
		D4.setToggleGroup(D);
		D5.setToggleGroup(D);
		D6.setToggleGroup(D);
		D7.setToggleGroup(D);
		D8.setToggleGroup(D);
		D9.setToggleGroup(D);
		D10.setToggleGroup(D);
		D11.setToggleGroup(D);
		D12.setToggleGroup(D);
		D13.setToggleGroup(D);
		D14.setToggleGroup(D);
		D15.setToggleGroup(D);

		D0.setUserData(new Note("D", 50, 2));
		D1.setUserData(new Note("D#", 51, 2));
		D2.setUserData(new Note("E", 52, 2));
		D3.setUserData(new Note("F", 53, 2));
		D4.setUserData(new Note("F#", 54, 2));
		D5.setUserData(new Note("G", 55, 2));
		D6.setUserData(new Note("G#", 56, 2));
		D7.setUserData(new Note("A", 57, 2));
		D8.setUserData(new Note("A#", 58, 2));
		D9.setUserData(new Note("B", 59, 2));
		D10.setUserData(new Note("C", 60, 3));
		D11.setUserData(new Note("C#", 61, 3));
		D12.setUserData(new Note("D", 62, 3));
		D13.setUserData(new Note("D#", 63, 3));
		D14.setUserData(new Note("E", 64, 3));
		D15.setUserData(new Note("F", 65, 3));

		DList = new ArrayList<ToggleButton>();
		DList.add(D0);
		DList.add(D1);
		DList.add(D2);
		DList.add(D3);
		DList.add(D4);
		DList.add(D5);
		DList.add(D6);
		DList.add(D7);
		DList.add(D8);
		DList.add(D9);
		DList.add(D10);
		DList.add(D11);
		DList.add(D12);
		DList.add(D13);
		DList.add(D14);
		DList.add(D15);

		D0.setLayoutX(5);
		D0.setLayoutY(125);
		D1.setLayoutX(55);
		D1.setLayoutY(125);
		D2.setLayoutX(105);
		D2.setLayoutY(125);
		D3.setLayoutX(155);
		D3.setLayoutY(125);
		D4.setLayoutX(205);
		D4.setLayoutY(125);
		D5.setLayoutX(255);
		D5.setLayoutY(125);
		D6.setLayoutX(305);
		D6.setLayoutY(125);
		D7.setLayoutX(355);
		D7.setLayoutY(125);
		D8.setLayoutX(405);
		D8.setLayoutY(125);
		D9.setLayoutX(455);
		D9.setLayoutY(125);
		D10.setLayoutX(505);
		D10.setLayoutY(125);
		D11.setLayoutX(555);
		D11.setLayoutY(125);
		D12.setLayoutX(605);
		D12.setLayoutY(125);
		D13.setLayoutX(655);
		D13.setLayoutY(125);
		D14.setLayoutX(705);
		D14.setLayoutY(125);
		D15.setLayoutX(755);
		D15.setLayoutY(125);

		wholeViewD = new ImageView(wholeNote);
		wholeViewD.setVisible(false);
		wholeViewD.setX(700);
		this.getChildren().add(wholeViewD);

		sharpD = new ImageView(sharpSymbol);
		sharpD.setVisible(false);
		sharpD.setX(685);
		this.getChildren().add(sharpD);

		D.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
				ToggleButton selectedNote = (ToggleButton) D.getSelectedToggle();
				sharpD.setVisible(false);
				wholeViewD.setVisible(false);
				if (selectedNote != null) {
					String stringNote = ((Note) selectedNote.getUserData()).getName();
					userNotes[2] = stringNote;
					wholeViewD.setY(getStaffNotePos(stringNote));
					wholeViewD.setVisible(true);
					if (stringNote.length() != 1) {
						sharpD.setY(getStaffNotePos(stringNote));
						sharpD.setVisible(true);
					}
				} else {
					userNotes[2] = null;
				}

				possibleChordsList = chordlibrary.findChord(userNotes);
				Piano.updatePiano(userNotes);
				updateLabel();
			}

		});

		A = new ToggleGroup();
		ToggleButton A0 = new ToggleButton("A");
		ToggleButton A1 = new ToggleButton("A#");
		ToggleButton A2 = new ToggleButton("B");
		ToggleButton A3 = new ToggleButton("C");
		ToggleButton A4 = new ToggleButton("C#");
		ToggleButton A5 = new ToggleButton("D");
		ToggleButton A6 = new ToggleButton("D#");
		ToggleButton A7 = new ToggleButton("E");
		ToggleButton A8 = new ToggleButton("F");
		ToggleButton A9 = new ToggleButton("F#");
		ToggleButton A10 = new ToggleButton("G");
		ToggleButton A11 = new ToggleButton("G#");
		ToggleButton A12 = new ToggleButton("A");
		ToggleButton A13 = new ToggleButton("A#");
		ToggleButton A14 = new ToggleButton("B");
		ToggleButton A15 = new ToggleButton("C");

		A0.setToggleGroup(A);
		A1.setToggleGroup(A);
		A2.setToggleGroup(A);
		A3.setToggleGroup(A);
		A4.setToggleGroup(A);
		A5.setToggleGroup(A);
		A6.setToggleGroup(A);
		A7.setToggleGroup(A);
		A8.setToggleGroup(A);
		A9.setToggleGroup(A);
		A10.setToggleGroup(A);
		A11.setToggleGroup(A);
		A12.setToggleGroup(A);
		A13.setToggleGroup(A);
		A14.setToggleGroup(A);
		A15.setToggleGroup(A);

		A0.setUserData(new Note("A", 45, 1));
		A1.setUserData(new Note("A#", 46, 1));
		A2.setUserData(new Note("B", 47, 1));
		A3.setUserData(new Note("C", 48, 2));
		A4.setUserData(new Note("C#", 49, 2));
		A5.setUserData(new Note("D", 50, 2));
		A6.setUserData(new Note("D#", 51, 2));
		A7.setUserData(new Note("E", 52, 2));
		A8.setUserData(new Note("F", 53, 2));
		A9.setUserData(new Note("F#", 54, 2));
		A10.setUserData(new Note("G", 55, 2));
		A11.setUserData(new Note("G#", 56, 2));
		A12.setUserData(new Note("A", 57, 2));
		A13.setUserData(new Note("A#", 58, 2));
		A14.setUserData(new Note("B", 59, 2));
		A15.setUserData(new Note("C", 60, 3));

		AList = new ArrayList<ToggleButton>();
		AList.add(A0);
		AList.add(A1);
		AList.add(A2);
		AList.add(A3);
		AList.add(A4);
		AList.add(A5);
		AList.add(A6);
		AList.add(A7);
		AList.add(A8);
		AList.add(A9);
		AList.add(A10);
		AList.add(A11);
		AList.add(A12);
		AList.add(A13);
		AList.add(A14);
		AList.add(A15);

		A0.setLayoutX(5);
		A0.setLayoutY(165);
		A1.setLayoutX(55);
		A1.setLayoutY(165);
		A2.setLayoutX(105);
		A2.setLayoutY(165);
		A3.setLayoutX(155);
		A3.setLayoutY(165);
		A4.setLayoutX(205);
		A4.setLayoutY(165);
		A5.setLayoutX(255);
		A5.setLayoutY(165);
		A6.setLayoutX(305);
		A6.setLayoutY(165);
		A7.setLayoutX(355);
		A7.setLayoutY(165);
		A8.setLayoutX(405);
		A8.setLayoutY(165);
		A9.setLayoutX(455);
		A9.setLayoutY(165);
		A10.setLayoutX(505);
		A10.setLayoutY(165);
		A11.setLayoutX(555);
		A11.setLayoutY(165);
		A12.setLayoutX(605);
		A12.setLayoutY(165);
		A13.setLayoutX(655);
		A13.setLayoutY(165);
		A14.setLayoutX(705);
		A14.setLayoutY(165);
		A15.setLayoutX(755);
		A15.setLayoutY(165);

		wholeViewA = new ImageView(wholeNote);
		wholeViewA.setVisible(false);
		wholeViewA.setX(700);
		this.getChildren().add(wholeViewA);

		sharpA = new ImageView(sharpSymbol);
		sharpA.setVisible(false);
		sharpA.setX(685);
		this.getChildren().add(sharpA);

		A.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
				ToggleButton selectedNote = (ToggleButton) A.getSelectedToggle();
				sharpA.setVisible(false);
				wholeViewA.setVisible(false);
				if (selectedNote != null) {
					String stringNote = ((Note) selectedNote.getUserData()).getName();
					userNotes[1] = stringNote;
					wholeViewA.setY(getStaffNotePos(stringNote));
					wholeViewA.setVisible(true);
					if (stringNote.length() != 1) {
						sharpA.setY(getStaffNotePos(stringNote));
						sharpA.setVisible(true);
					}
				} else {
					userNotes[1] = null;
				}

				possibleChordsList = chordlibrary.findChord(userNotes);
				Piano.updatePiano(userNotes);
				updateLabel();
			}

		});

		lowE = new ToggleGroup();
		ToggleButton lowE0 = new ToggleButton("E");
		ToggleButton lowE1 = new ToggleButton("F");
		ToggleButton lowE2 = new ToggleButton("F#");
		ToggleButton lowE3 = new ToggleButton("G");
		ToggleButton lowE4 = new ToggleButton("G#");
		ToggleButton lowE5 = new ToggleButton("A");
		ToggleButton lowE6 = new ToggleButton("A#");
		ToggleButton lowE7 = new ToggleButton("B");
		ToggleButton lowE8 = new ToggleButton("C");
		ToggleButton lowE9 = new ToggleButton("C#");
		ToggleButton lowE10 = new ToggleButton("D");
		ToggleButton lowE11 = new ToggleButton("D#");
		ToggleButton lowE12 = new ToggleButton("E");
		ToggleButton lowE13 = new ToggleButton("F");
		ToggleButton lowE14 = new ToggleButton("F#");
		ToggleButton lowE15 = new ToggleButton("G");

		lowE0.setToggleGroup(lowE);
		lowE1.setToggleGroup(lowE);
		lowE2.setToggleGroup(lowE);
		lowE3.setToggleGroup(lowE);
		lowE4.setToggleGroup(lowE);
		lowE5.setToggleGroup(lowE);
		lowE6.setToggleGroup(lowE);
		lowE7.setToggleGroup(lowE);
		lowE8.setToggleGroup(lowE);
		lowE9.setToggleGroup(lowE);
		lowE10.setToggleGroup(lowE);
		lowE11.setToggleGroup(lowE);
		lowE12.setToggleGroup(lowE);
		lowE13.setToggleGroup(lowE);
		lowE14.setToggleGroup(lowE);
		lowE15.setToggleGroup(lowE);

		lowE0.setUserData(new Note("E", 40, 1));
		lowE1.setUserData(new Note("F", 41, 1));
		lowE2.setUserData(new Note("F#", 42, 1));
		lowE3.setUserData(new Note("G", 43, 1));
		lowE4.setUserData(new Note("G#", 44, 1));
		lowE5.setUserData(new Note("A", 45, 1));
		lowE6.setUserData(new Note("A#", 46, 1));
		lowE7.setUserData(new Note("B", 47, 1));
		lowE8.setUserData(new Note("C", 48, 2));
		lowE9.setUserData(new Note("C#", 49, 2));
		lowE10.setUserData(new Note("D", 50, 2));
		lowE11.setUserData(new Note("D#", 51, 2));
		lowE12.setUserData(new Note("E", 52, 2));
		lowE13.setUserData(new Note("F", 53, 2));
		lowE14.setUserData(new Note("F#", 54, 2));
		lowE15.setUserData(new Note("G", 55, 2));

		lowEList = new ArrayList<ToggleButton>();
		lowEList.add(lowE0);
		lowEList.add(lowE1);
		lowEList.add(lowE2);
		lowEList.add(lowE3);
		lowEList.add(lowE4);
		lowEList.add(lowE5);
		lowEList.add(lowE6);
		lowEList.add(lowE7);
		lowEList.add(lowE8);
		lowEList.add(lowE9);
		lowEList.add(lowE10);
		lowEList.add(lowE11);
		lowEList.add(lowE12);
		lowEList.add(lowE13);
		lowEList.add(lowE14);
		lowEList.add(lowE15);

		lowE0.setLayoutX(5);
		lowE0.setLayoutY(205);
		lowE1.setLayoutX(55);
		lowE1.setLayoutY(205);
		lowE2.setLayoutX(105);
		lowE2.setLayoutY(205);
		lowE3.setLayoutX(155);
		lowE3.setLayoutY(205);
		lowE4.setLayoutX(205);
		lowE4.setLayoutY(205);
		lowE5.setLayoutX(255);
		lowE5.setLayoutY(205);
		lowE6.setLayoutX(305);
		lowE6.setLayoutY(205);
		lowE7.setLayoutX(355);
		lowE7.setLayoutY(205);
		lowE8.setLayoutX(405);
		lowE8.setLayoutY(205);
		lowE9.setLayoutX(455);
		lowE9.setLayoutY(205);
		lowE10.setLayoutX(505);
		lowE10.setLayoutY(205);
		lowE11.setLayoutX(555);
		lowE11.setLayoutY(205);
		lowE12.setLayoutX(605);
		lowE12.setLayoutY(205);
		lowE13.setLayoutX(655);
		lowE13.setLayoutY(205);
		lowE14.setLayoutX(705);
		lowE14.setLayoutY(205);
		lowE15.setLayoutX(755);
		lowE15.setLayoutY(205);

		wholeViewlowE = new ImageView(wholeNote);
		wholeViewlowE.setVisible(false);
		wholeViewlowE.setX(700);
		this.getChildren().add(wholeViewlowE);

		sharplowE = new ImageView(sharpSymbol);
		sharplowE.setVisible(false);
		sharplowE.setX(685);
		this.getChildren().add(sharplowE);

		lowE.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
				ToggleButton selectedNote = (ToggleButton) lowE.getSelectedToggle();
				sharplowE.setVisible(false);
				wholeViewlowE.setVisible(false);
				if (selectedNote != null) {
					String stringNote = ((Note) selectedNote.getUserData()).getName();
					userNotes[0] = stringNote;
					wholeViewlowE.setY(getStaffNotePos(stringNote));
					wholeViewlowE.setVisible(true);
					if (stringNote.length() != 1) {
						sharplowE.setY(getStaffNotePos(stringNote));
						sharplowE.setVisible(true);
					}
				} else {
					userNotes[0] = null;
				}

				possibleChordsList = chordlibrary.findChord(userNotes);
				Piano.updatePiano(userNotes);
				updateLabel();
			}

		});

		this.getChildren().addAll(circle3, circle5, circle7, circle9, circle12A, circle12B, circle15, highE0, highE1,
				highE2, highE3, highE4, highE5, highE6, highE7, highE8, highE9, highE10, highE11, highE12, highE13,
				highE14, highE15, B0, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, G0, G1, G2, G3,
				G4, G5, G6, G7, G8, G9, G10, G11, G12, G13, G14, G15, D0, D1, D2, D3, D4, D5, D6, D7, D8, D9, D10, D11,
				D12, D13, D14, D15, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, lowE0, lowE1,
				lowE2, lowE3, lowE4, lowE5, lowE6, lowE7, lowE8, lowE9, lowE10, lowE11, lowE12, lowE13, lowE14, lowE15,
				chordNameRect, possibleChordsLabel, possibleChordsHeading);

	}

	public static void updateLabel() {
		possibleChordsLabel.getChildren().clear();
		possibleChordsList = (ArrayList<String>) possibleChordsList.stream().distinct().collect(Collectors.toList());
		for (String chordName : possibleChordsList) {
			Label chordLabel = new Label(chordName);
			chordLabel.setId("possibleChordsCss");
			possibleChordsLabel.getChildren().add(chordLabel);
		}

	}

	public void addNode(Node item) {
		this.getChildren().add(item);
	}

	public void removeNode(Node item) {
		this.getChildren().remove(item);
	}

	public static void switchAccidental() {
		highE.getToggles().stream().map((toggle) -> (ToggleButton) toggle).forEach((button) -> {
			button.setText(getOppositeAccidental(button.getText()));
		});
		A.getToggles().stream().map((toggle) -> (ToggleButton) toggle).forEach((button) -> {
			button.setText(getOppositeAccidental(button.getText()));
		});
		B.getToggles().stream().map((toggle) -> (ToggleButton) toggle).forEach((button) -> {
			button.setText(getOppositeAccidental(button.getText()));
		});
		D.getToggles().stream().map((toggle) -> (ToggleButton) toggle).forEach((button) -> {
			button.setText(getOppositeAccidental(button.getText()));
		});
		G.getToggles().stream().map((toggle) -> (ToggleButton) toggle).forEach((button) -> {
			button.setText(getOppositeAccidental(button.getText()));
		});
		lowE.getToggles().stream().map((toggle) -> (ToggleButton) toggle).forEach((button) -> {
			button.setText(getOppositeAccidental(button.getText()));
		});

	}

	public static String getOppositeAccidental(String name) {
		if (name.length() != 1) {
			int notePos = 0;
			if (name.charAt(1) == '#') {
				for (int i = 0; i < 12; i++) {
					if (noteSequenceSharp[i].equals(name)) {
						notePos = i;
					}
				}

				return noteSequenceFlat[notePos];
			}
			if (name.charAt(1) == 'b') {
				for (int i = 0; i < 12; i++) {
					if (noteSequenceFlat[i].equals(name)) {
						notePos = i;
					}
				}

				return noteSequenceSharp[notePos];
			}
		}
		return name;
	}

	public static void playArpeggioFretboardNotes() {
		if (lowE.getSelectedToggle() != null) {
			midiplayer.playNote(((Note) (lowE.getSelectedToggle().getUserData())).getMidiNoteNumber());
			try {
				Thread.sleep(600); // wait time in milliseconds to control duration
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (A.getSelectedToggle() != null) {
			midiplayer.playNote(((Note) (A.getSelectedToggle().getUserData())).getMidiNoteNumber());
			try {
				Thread.sleep(600); // wait time in milliseconds to control duration
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (D.getSelectedToggle() != null) {
			midiplayer.playNote(((Note) (D.getSelectedToggle().getUserData())).getMidiNoteNumber());
			try {
				Thread.sleep(600); // wait time in milliseconds to control duration
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (G.getSelectedToggle() != null) {
			midiplayer.playNote(((Note) (G.getSelectedToggle().getUserData())).getMidiNoteNumber());
			try {
				Thread.sleep(600); // wait time in milliseconds to control duration
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (B.getSelectedToggle() != null) {
			midiplayer.playNote(((Note) (B.getSelectedToggle().getUserData())).getMidiNoteNumber());
			try {
				Thread.sleep(600); // wait time in milliseconds to control duration
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (highE.getSelectedToggle() != null) {
			midiplayer.playNote(((Note) (highE.getSelectedToggle().getUserData())).getMidiNoteNumber());
			try {
				Thread.sleep(600); // wait time in milliseconds to control duration
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(1000); // wait time in milliseconds to control duration
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		midiplayer.stopSound();
	}

	public static void playChordFretboardNotes() {
		if (lowE.getSelectedToggle() != null) {
			midiplayer.playNote(((Note) (lowE.getSelectedToggle().getUserData())).getMidiNoteNumber());
		}
		if (A.getSelectedToggle() != null) {
			midiplayer.playNote(((Note) (A.getSelectedToggle().getUserData())).getMidiNoteNumber());
		}
		if (D.getSelectedToggle() != null) {
			midiplayer.playNote(((Note) (D.getSelectedToggle().getUserData())).getMidiNoteNumber());
		}
		if (G.getSelectedToggle() != null) {
			midiplayer.playNote(((Note) (G.getSelectedToggle().getUserData())).getMidiNoteNumber());
		}
		if (B.getSelectedToggle() != null) {
			midiplayer.playNote(((Note) (B.getSelectedToggle().getUserData())).getMidiNoteNumber());
		}
		if (highE.getSelectedToggle() != null) {
			midiplayer.playNote(((Note) (highE.getSelectedToggle().getUserData())).getMidiNoteNumber());
		}
		try {
			Thread.sleep(3000); // wait time in milliseconds to control duration
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		midiplayer.stopSound();
	}

	public static void randomNotes() {

	}

	public static void clearSelection() {
		highE.selectToggle(null);
		A.selectToggle(null);
		B.selectToggle(null);
		G.selectToggle(null);
		D.selectToggle(null);
		lowE.selectToggle(null);
		wholeViewhighE.setVisible(false);
		sharphighE.setVisible(false);
		wholeViewA.setVisible(false);
		sharpA.setVisible(false);
		wholeViewD.setVisible(false);
		sharpD.setVisible(false);
		wholeViewG.setVisible(false);
		sharpG.setVisible(false);
		wholeViewB.setVisible(false);
		sharpB.setVisible(false);
		wholeViewlowE.setVisible(false);
		sharplowE.setVisible(false);
	}

	public static double getStaffNotePos(String note) {
		if (note.equals("A")) {
			return 345;
		}
		if (note.equals("A#")) {
			return 345;
		}
		if (note.equals("B")) {
			return 390;
		}
		if (note.equals("C")) {
			return 440;
		}
		if (note.equals("C#")) {
			return 440;
		}
		if (note.equals("D")) {
			return 373;
		}
		if (note.equals("D#")) {
			return 373;
		}
		if (note.equals("E")) {
			return 424;
		}
		if (note.equals("F")) {
			return 357;
		}
		if (note.equals("F#")) {
			return 357;
		}
		if (note.equals("G")) {
			return 408;
		}
		if (note.equals("G#")) {
			return 408;
		}
		return 0;
	}

	public static void writeChord() {
		int[] fingering = new int[6];
		for (int i = 0; i < 6; i++) {
			fingering[i] = -1;
		}
		for (int i = 0; i < 15; i++) {
			if (highEList.get(i).isSelected()) {
				fingering[5] = i;
			}
			if (BList.get(i).isSelected()) {
				fingering[4] = i;
			}
			if (GList.get(i).isSelected()) {
				fingering[3] = i;
			}
			if (DList.get(i).isSelected()) {
				fingering[2] = i;
			}
			if (AList.get(i).isSelected()) {
				fingering[1] = i;
			}
			if (lowEList.get(i).isSelected()) {
				fingering[0] = i;
			}

		}
		ChordFingeringFileWriter.writeChord(possibleChordsList.get(0), fingering);
	}

}
