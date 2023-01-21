package application;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Fretboard extends Pane {
	String[] userNotes;
	static ToggleGroup highE;
	static ToggleGroup A;
	static ToggleGroup D;
	static ToggleGroup G;
	static ToggleGroup B;
	static ToggleGroup lowE;
	final private static String[] noteSequenceSharp = {"A","A#","B","C","C#","D","D#","E","F","F#","G","G#"};
	final private static String[] noteSequenceFlat = {"A","Bb","B","C","Db","D","Eb","E","F","Gb","G","Ab"};
	static MidiPlayer midiplayer;
	
	public Fretboard() {
		String css = this.getClass().getResource("fretboard.css").toExternalForm();
		this.getStylesheets().add(css);
		this.setPrefHeight(600);
		this.setPrefWidth(850);
		midiplayer = new MidiPlayer();
		createFretboard();
	}
	public void createFretboard() {
		userNotes = new String[6];
		Label possibleChords = new Label("");
		Label possibleChordsHeading = new Label("Possible Chords");
		possibleChords.relocate(300, 300);
		possibleChords.setId("possibleChordsCss");
		possibleChordsHeading.relocate(50, 250);
		possibleChordsHeading.setId("possibleChordsCss");
		ChordLibrary chordlibrary = new ChordLibrary();
		for(int i=0;i<6;i++) {
			Line line1 = new Line(50, 20+(i*40), 800.0, 20+(i*40));
			line1.setId("stringline"+(i+1));
			this.getChildren().add(line1);
		}
		Line lineNut = new Line(50.0, 20.0, 50.0, 220);
		lineNut.setId("lineNut");
		this.getChildren().add(lineNut);
		for(int i=1;i<=15;i++) {
			Line line1 = new Line(50+i*50.0, 20.0, 50+i*50.0, 220);
			line1.setId("lineFret");
			this.getChildren().add(line1);
		}
		Label num0 = new Label("0");
		num0.relocate(24, 230);
		num0.setId("fretNum");
		this.getChildren().add(num0);
		for(int i=1;i<=9;i++) {
			Label num = new Label(i+"");
			num.relocate(i*50+17, 230);
			num.setId("fretNum");
			this.getChildren().add(num);
		}
		for(int i=10;i<=15;i++) {
			Label num = new Label(i+"");
			num.relocate(i*50.0+16, 230);
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
        
        highE0.setUserData(new Note("E",64,3));
        highE1.setUserData(new Note("F",65,3));
        highE2.setUserData(new Note("F#",66,3));
        highE3.setUserData(new Note("G",67,3));
        highE4.setUserData(new Note("G#",68,3));
        highE5.setUserData(new Note("A",69,3));
        highE6.setUserData(new Note("A#",70,3));
        highE7.setUserData(new Note("B",71,3));
        highE8.setUserData(new Note("C",72,4));
        highE9.setUserData(new Note("C#",73,4));
        highE10.setUserData(new Note("D",74,4));
        highE11.setUserData(new Note("D#",75,4));
        highE12.setUserData(new Note("E",76,4));
        highE13.setUserData(new Note("F",77,4));
        highE14.setUserData(new Note("F#",78,4));
        highE15.setUserData(new Note("G",79,4));
        
//        System.out.println();
//        ((Note)highE2.getUserData()).setName(((Note)highE2.getUserData()).switchAccidental());
//        System.out.println(((Note) (highE2.getUserData())).getName());
        
        
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
        

        highE.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
				ToggleButton selectedNote = (ToggleButton) highE.getSelectedToggle();
				if(selectedNote!=null) {
					userNotes[5] = ((Note)selectedNote.getUserData()).getName();
				}
				else {
					userNotes[5] = null;
				}
//				System.out.println(Arrays.toString(userNotes));
//				System.out.println(chordlibrary.findChord(userNotes));
				possibleChords.setText(chordlibrary.findChord(userNotes));
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
        
        B0.setUserData(new Note("B",59,2));
        B1.setUserData(new Note("C",60,3));
        B2.setUserData(new Note("C#",61,3));
        B3.setUserData(new Note("D",62,3));
        B4.setUserData(new Note("D#",63,3));
        B5.setUserData(new Note("E",64,3));
        B6.setUserData(new Note("F",65,3));
        B7.setUserData(new Note("F#",66,3));
        B8.setUserData(new Note("G",67,3));
        B9.setUserData(new Note("G#",68,3));
        B10.setUserData(new Note("A",69,3));
        B11.setUserData(new Note("A#",70,3));
        B12.setUserData(new Note("B",71,3));
        B13.setUserData(new Note("C",72,4));
        B14.setUserData(new Note("C#",73,4));
        B15.setUserData(new Note("D",74,4));
        
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
        

        B.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
				ToggleButton selectedNote = (ToggleButton) B.getSelectedToggle();
				if(selectedNote!=null) {
					userNotes[4] = ((Note)selectedNote.getUserData()).getName();
				}
				else {
					userNotes[4] = null;
				}
//				System.out.println(Arrays.toString(userNotes));
//				System.out.println(chordlibrary.findChord(userNotes));
				possibleChords.setText(chordlibrary.findChord(userNotes));
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
        
        G0.setUserData(new Note("G",55,2));
        G1.setUserData(new Note("G#",56,2));
        G2.setUserData(new Note("A",57,2));
        G3.setUserData(new Note("A#",58,2));
        G4.setUserData(new Note("B",59,2));
        G5.setUserData(new Note("C",60,3));
        G6.setUserData(new Note("C#",61,3));
        G7.setUserData(new Note("D",62,3));
        G8.setUserData(new Note("D#",63,3));
        G9.setUserData(new Note("E",64,3));
        G10.setUserData(new Note("F",65,3));
        G11.setUserData(new Note("F#",66,3));
        G12.setUserData(new Note("G",67,3));
        G13.setUserData(new Note("G#",68,3));
        G14.setUserData(new Note("A",69,3));
        G15.setUserData(new Note("A#",70,3));
        
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
        

        G.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
				ToggleButton selectedNote = (ToggleButton) G.getSelectedToggle();
				if(selectedNote!=null) {
					userNotes[3] = ((Note)selectedNote.getUserData()).getName();
				}
				else {
					userNotes[3] = null;
				}
//				System.out.println(Arrays.toString(userNotes));
//				System.out.println(chordlibrary.findChord(userNotes));
				possibleChords.setText(chordlibrary.findChord(userNotes));
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
        
        D0.setUserData(new Note("D",50,2));
        D1.setUserData(new Note("D#",51,2));
        D2.setUserData(new Note("E",52,2));
        D3.setUserData(new Note("F",53,2));
        D4.setUserData(new Note("F#",54,2));
        D5.setUserData(new Note("G",55,2));
        D6.setUserData(new Note("G#",56,2));
        D7.setUserData(new Note("A",57,2));
        D8.setUserData(new Note("A#",58,2));
        D9.setUserData(new Note("B",59,2));
        D10.setUserData(new Note("C",60,3));
        D11.setUserData(new Note("C#",61,3));
        D12.setUserData(new Note("D",62,3));
        D13.setUserData(new Note("D#",63,3));
        D14.setUserData(new Note("E",64,3));
        D15.setUserData(new Note("F",65,3));
        
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
        

        D.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
				ToggleButton selectedNote = (ToggleButton) D.getSelectedToggle();
				if(selectedNote!=null) {
					userNotes[2] = ((Note)selectedNote.getUserData()).getName();
				}
				else {
					userNotes[2] = null;
				}
//				System.out.println(Arrays.toString(userNotes));
//				System.out.println(chordlibrary.findChord(userNotes));
				possibleChords.setText(chordlibrary.findChord(userNotes));
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
        
        A0.setUserData(new Note("A",45,1));
        A1.setUserData(new Note("A#",46,1));
        A2.setUserData(new Note("B",47,1));
        A3.setUserData(new Note("C",48,2));
        A4.setUserData(new Note("C#",49,2));
        A5.setUserData(new Note("D",50,2));
        A6.setUserData(new Note("D#",51,2));
        A7.setUserData(new Note("E",52,2));
        A8.setUserData(new Note("F",53,2));
        A9.setUserData(new Note("F#",54,2));
        A10.setUserData(new Note("G",55,2));
        A11.setUserData(new Note("G#",56,2));
        A12.setUserData(new Note("A",57,2));
        A13.setUserData(new Note("A#",58,2));
        A14.setUserData(new Note("B",59,2));
        A15.setUserData(new Note("C",60,3));
        
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
        

        A.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
				ToggleButton selectedNote = (ToggleButton) A.getSelectedToggle();
				if(selectedNote!=null) {
					userNotes[1] = ((Note)selectedNote.getUserData()).getName();
				}
				else {
					userNotes[1] = null;
				}
//				System.out.println(Arrays.toString(userNotes));
//				System.out.println(chordlibrary.findChord(userNotes));
				possibleChords.setText(chordlibrary.findChord(userNotes));
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
        
        lowE0.setUserData(new Note("E",40,1));
        lowE1.setUserData(new Note("F",41,1));
        lowE2.setUserData(new Note("F#",42,1));
        lowE3.setUserData(new Note("G",43,1));
        lowE4.setUserData(new Note("G#",44,1));
        lowE5.setUserData(new Note("A",45,1));
        lowE6.setUserData(new Note("A#",46,1));
        lowE7.setUserData(new Note("B",47,1));
        lowE8.setUserData(new Note("C",48,2));
        lowE9.setUserData(new Note("C#",49,2));
        lowE10.setUserData(new Note("D",50,2));
        lowE11.setUserData(new Note("D#",51,2));
        lowE12.setUserData(new Note("E",52,2));
        lowE13.setUserData(new Note("F",53,2));
        lowE14.setUserData(new Note("F#",54,2));
        lowE15.setUserData(new Note("G",55,2));
        
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
        

        lowE.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
				ToggleButton selectedNote = (ToggleButton) lowE.getSelectedToggle();
				if(selectedNote!=null) {
					userNotes[0] = ((Note)selectedNote.getUserData()).getName();
				}
				else {
					userNotes[0] = null;
				}
//				System.out.println(Arrays.toString(userNotes));
//				System.out.println(chordlibrary.findChord(userNotes));
				possibleChords.setText(chordlibrary.findChord(userNotes));
			}
        	
        });
        
        this.getChildren().addAll(circle3, circle5, circle7, circle9, circle12A, circle12B, circle15,
        						highE0,highE1,highE2,highE3,highE4,highE5,highE6,highE7,highE8,highE9,highE10,highE11,highE12,highE13,highE14,highE15,
        						B0,B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,
        						G0,G1,G2,G3,G4,G5,G6,G7,G8,G9,G10,G11,G12,G13,G14,G15,
        						D0,D1,D2,D3,D4,D5,D6,D7,D8,D9,D10,D11,D12,D13,D14,D15,
        						A0,A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14,A15,
        						lowE0,lowE1,lowE2,lowE3,lowE4,lowE5,lowE6,lowE7,lowE8,lowE9,lowE10,lowE11,lowE12,lowE13,lowE14,lowE15,
        						possibleChords, possibleChordsHeading);
  

	}
	public void addNode(Node item) {
		this.getChildren().add(item);
	}
	public void removeNode(Node item) {
		this.getChildren().remove(item);
	}
	public static void switchAccidental() {
		highE.getToggles().stream().map((toggle) -> (ToggleButton)toggle).forEach((button) -> {
		    button.setText(getOppositeAccidental(button.getText()));
		});
		A.getToggles().stream().map((toggle) -> (ToggleButton)toggle).forEach((button) -> {
		    button.setText(getOppositeAccidental(button.getText()));
		});
		B.getToggles().stream().map((toggle) -> (ToggleButton)toggle).forEach((button) -> {
		    button.setText(getOppositeAccidental(button.getText()));
		});
		D.getToggles().stream().map((toggle) -> (ToggleButton)toggle).forEach((button) -> {
		    button.setText(getOppositeAccidental(button.getText()));
		});
		G.getToggles().stream().map((toggle) -> (ToggleButton)toggle).forEach((button) -> {
		    button.setText(getOppositeAccidental(button.getText()));
		});
		lowE.getToggles().stream().map((toggle) -> (ToggleButton)toggle).forEach((button) -> {
		    button.setText(getOppositeAccidental(button.getText()));
		});
		
		
	}
	public static String getOppositeAccidental(String name) {
		if(name.length()!=1) {
			int notePos = 0;
			if(name.charAt(1)=='#') {
				for(int i=0;i<12;i++) {
					if(noteSequenceSharp[i].equals(name)) {
						notePos = i;
					}
				}
				
				return noteSequenceFlat[notePos];
			}
			if(name.charAt(1)=='b') {
				for(int i=0;i<12;i++) {
					if(noteSequenceFlat[i].equals(name)) {
						notePos = i;
					}
				}

				return noteSequenceSharp[notePos];
			}
		}
		return name;
	}
	public static void playFretboardNotes() {
		if(lowE.getSelectedToggle()!=null) {
			midiplayer.playNote(((Note)(lowE.getSelectedToggle().getUserData())).getMidiNoteNumber());
			try { Thread.sleep(600); // wait time in milliseconds to control duration
	        } catch( InterruptedException e ) {
	            e.printStackTrace();
	        }
		}
		if(A.getSelectedToggle()!=null) {
			midiplayer.playNote(((Note)(A.getSelectedToggle().getUserData())).getMidiNoteNumber());
			try { Thread.sleep(600); // wait time in milliseconds to control duration
	        } catch( InterruptedException e ) {
	            e.printStackTrace();
	        }
		}
		if(D.getSelectedToggle()!=null) {
			midiplayer.playNote(((Note)(D.getSelectedToggle().getUserData())).getMidiNoteNumber());
			try { Thread.sleep(600); // wait time in milliseconds to control duration
	        } catch( InterruptedException e ) {
	            e.printStackTrace();
	        }
		}
		if(G.getSelectedToggle()!=null) {
			midiplayer.playNote(((Note)(G.getSelectedToggle().getUserData())).getMidiNoteNumber());
			try { Thread.sleep(600); // wait time in milliseconds to control duration
	        } catch( InterruptedException e ) {
	            e.printStackTrace();
	        }
		}
		if(B.getSelectedToggle()!=null) {
			midiplayer.playNote(((Note)(B.getSelectedToggle().getUserData())).getMidiNoteNumber());
			try { Thread.sleep(600); // wait time in milliseconds to control duration
	        } catch( InterruptedException e ) {
	            e.printStackTrace();
	        }
		}
		if(highE.getSelectedToggle()!=null) {
			midiplayer.playNote(((Note)(highE.getSelectedToggle().getUserData())).getMidiNoteNumber());
			try { Thread.sleep(600); // wait time in milliseconds to control duration
	        } catch( InterruptedException e ) {
	            e.printStackTrace();
	        }
		}
		try { Thread.sleep(1000); // wait time in milliseconds to control duration
        } catch( InterruptedException e ) {
            e.printStackTrace();
        }
		midiplayer.stopSound();
	}
	public static void clearSelection() {
		highE.selectToggle(null);
		A.selectToggle(null);
		B.selectToggle(null);
		G.selectToggle(null);
		D.selectToggle(null);
		lowE.selectToggle(null);
	}
	public static void moveSelectionUp() {
		
	}
	
}
