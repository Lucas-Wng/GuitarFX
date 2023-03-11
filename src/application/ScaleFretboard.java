package application;

import java.util.ArrayList;
import java.util.Map;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class ScaleFretboard extends Pane{
	private static Map<String, int[]> scaleMap;
	private static ArrayList<RadioButton> buttonList;
	final private static String[] noteSequence = { "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G",
	"G#" };
	private static String currentNote;
	private static String currentScale;
	public ScaleFretboard() {
		buttonList = new ArrayList<RadioButton>();
		scaleMap = ScaleLibrary.getScaleMap();
		currentNote = null;
		currentScale = null;
		String css = this.getClass().getResource("fretboard.css").toExternalForm();
		this.getStylesheets().add(css);
		this.setPrefHeight(300);
		this.setPrefWidth(850);
		createFretboard();
	}
	
	public void createFretboard() {
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

		RadioButton highE0 = new RadioButton("E");
		RadioButton highE1 = new RadioButton("F");
		RadioButton highE2 = new RadioButton("F#");
		RadioButton highE3 = new RadioButton("G");
		RadioButton highE4 = new RadioButton("G#");
		RadioButton highE5 = new RadioButton("A");
		RadioButton highE6 = new RadioButton("A#");
		RadioButton highE7 = new RadioButton("B");
		RadioButton highE8 = new RadioButton("C");
		RadioButton highE9 = new RadioButton("C#");
		RadioButton highE10 = new RadioButton("D");
		RadioButton highE11 = new RadioButton("D#");
		RadioButton highE12 = new RadioButton("E");
		RadioButton highE13 = new RadioButton("F");
		RadioButton highE14 = new RadioButton("F#");
		RadioButton highE15 = new RadioButton("G");

		

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


		RadioButton B0 = new RadioButton("B");
		RadioButton B1 = new RadioButton("C");
		RadioButton B2 = new RadioButton("C#");
		RadioButton B3 = new RadioButton("D");
		RadioButton B4 = new RadioButton("D#");
		RadioButton B5 = new RadioButton("E");
		RadioButton B6 = new RadioButton("F");
		RadioButton B7 = new RadioButton("F#");
		RadioButton B8 = new RadioButton("G");
		RadioButton B9 = new RadioButton("G#");
		RadioButton B10 = new RadioButton("A");
		RadioButton B11 = new RadioButton("A#");
		RadioButton B12 = new RadioButton("B");
		RadioButton B13 = new RadioButton("C");
		RadioButton B14 = new RadioButton("C#");
		RadioButton B15 = new RadioButton("D");


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

	
	
		RadioButton G0 = new RadioButton("G");
		RadioButton G1 = new RadioButton("G#");
		RadioButton G2 = new RadioButton("A");
		RadioButton G3 = new RadioButton("A#");
		RadioButton G4 = new RadioButton("B");
		RadioButton G5 = new RadioButton("C");
		RadioButton G6 = new RadioButton("C#");
		RadioButton G7 = new RadioButton("D");
		RadioButton G8 = new RadioButton("D#");
		RadioButton G9 = new RadioButton("E");
		RadioButton G10 = new RadioButton("F");
		RadioButton G11 = new RadioButton("F#");
		RadioButton G12 = new RadioButton("G");
		RadioButton G13 = new RadioButton("G#");
		RadioButton G14 = new RadioButton("A");
		RadioButton G15 = new RadioButton("A#");



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

		

	
		RadioButton D0 = new RadioButton("D");
		RadioButton D1 = new RadioButton("D#");
		RadioButton D2 = new RadioButton("E");
		RadioButton D3 = new RadioButton("F");
		RadioButton D4 = new RadioButton("F#");
		RadioButton D5 = new RadioButton("G");
		RadioButton D6 = new RadioButton("G#");
		RadioButton D7 = new RadioButton("A");
		RadioButton D8 = new RadioButton("A#");
		RadioButton D9 = new RadioButton("B");
		RadioButton D10 = new RadioButton("C");
		RadioButton D11 = new RadioButton("C#");
		RadioButton D12 = new RadioButton("D");
		RadioButton D13 = new RadioButton("D#");
		RadioButton D14 = new RadioButton("E");
		RadioButton D15 = new RadioButton("F");



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

	

		RadioButton A0 = new RadioButton("A");
		RadioButton A1 = new RadioButton("A#");
		RadioButton A2 = new RadioButton("B");
		RadioButton A3 = new RadioButton("C");
		RadioButton A4 = new RadioButton("C#");
		RadioButton A5 = new RadioButton("D");
		RadioButton A6 = new RadioButton("D#");
		RadioButton A7 = new RadioButton("E");
		RadioButton A8 = new RadioButton("F");
		RadioButton A9 = new RadioButton("F#");
		RadioButton A10 = new RadioButton("G");
		RadioButton A11 = new RadioButton("G#");
		RadioButton A12 = new RadioButton("A");
		RadioButton A13 = new RadioButton("A#");
		RadioButton A14 = new RadioButton("B");
		RadioButton A15 = new RadioButton("C");


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

	

		RadioButton lowE0 = new RadioButton("E");
		RadioButton lowE1 = new RadioButton("F");
		RadioButton lowE2 = new RadioButton("F#");
		RadioButton lowE3 = new RadioButton("G");
		RadioButton lowE4 = new RadioButton("G#");
		RadioButton lowE5 = new RadioButton("A");
		RadioButton lowE6 = new RadioButton("A#");
		RadioButton lowE7 = new RadioButton("B");
		RadioButton lowE8 = new RadioButton("C");
		RadioButton lowE9 = new RadioButton("C#");
		RadioButton lowE10 = new RadioButton("D");
		RadioButton lowE11 = new RadioButton("D#");
		RadioButton lowE12 = new RadioButton("E");
		RadioButton lowE13 = new RadioButton("F");
		RadioButton lowE14 = new RadioButton("F#");
		RadioButton lowE15 = new RadioButton("G");

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
		
		buttonList.add(highE0);
		buttonList.add(highE1);
		buttonList.add(highE2);
		buttonList.add(highE3);
		buttonList.add(highE4);
		buttonList.add(highE5);
		buttonList.add(highE6);
		buttonList.add(highE7);
		buttonList.add(highE8);
		buttonList.add(highE9);
		buttonList.add(highE10);
		buttonList.add(highE11);
		buttonList.add(highE12);
		buttonList.add(highE13);
		buttonList.add(highE14);
		buttonList.add(highE15);
		buttonList.add(B0);
		buttonList.add(B1);
		buttonList.add(B2);
		buttonList.add(B3);
		buttonList.add(B4);
		buttonList.add(B5);
		buttonList.add(B6);
		buttonList.add(B7);
		buttonList.add(B8);
		buttonList.add(B9);
		buttonList.add(B10);
		buttonList.add(B11);
		buttonList.add(B12);
		buttonList.add(B13);
		buttonList.add(B14);
		buttonList.add(B15);
		buttonList.add(G0);
		buttonList.add(G1);
		buttonList.add(G2);
		buttonList.add(G3);
		buttonList.add(G4);
		buttonList.add(G5);
		buttonList.add(G6);
		buttonList.add(G7);
		buttonList.add(G8);
		buttonList.add(G9);
		buttonList.add(G10);
		buttonList.add(G11);
		buttonList.add(G12);
		buttonList.add(G13);
		buttonList.add(G14);
		buttonList.add(G15);
		buttonList.add(D0);
		buttonList.add(D1);
		buttonList.add(D2);
		buttonList.add(D3);
		buttonList.add(D4);
		buttonList.add(D5);
		buttonList.add(D6);
		buttonList.add(D7);
		buttonList.add(D8);
		buttonList.add(D9);
		buttonList.add(D10);
		buttonList.add(D11);
		buttonList.add(D12);
		buttonList.add(D13);
		buttonList.add(D14);
		buttonList.add(D15);
		buttonList.add(A0);
		buttonList.add(A1);
		buttonList.add(A2);
		buttonList.add(A3);
		buttonList.add(A4);
		buttonList.add(A5);
		buttonList.add(A6);
		buttonList.add(A7);
		buttonList.add(A8);
		buttonList.add(A9);
		buttonList.add(A10);
		buttonList.add(A11);
		buttonList.add(A12);
		buttonList.add(A13);
		buttonList.add(A14);
		buttonList.add(A15);
		buttonList.add(lowE0);
		buttonList.add(lowE1);
		buttonList.add(lowE2);
		buttonList.add(lowE3);
		buttonList.add(lowE4);
		buttonList.add(lowE5);
		buttonList.add(lowE6);
		buttonList.add(lowE7);
		buttonList.add(lowE8);
		buttonList.add(lowE9);
		buttonList.add(lowE10);
		buttonList.add(lowE11);
		buttonList.add(lowE12);
		buttonList.add(lowE13);
		buttonList.add(lowE14);
		buttonList.add(lowE15);
		disableNotes();
		
		this.getChildren().addAll(circle3, circle5, circle7, circle9, circle12A, circle12B, circle15, highE0, highE1,
				highE2, highE3, highE4, highE5, highE6, highE7, highE8, highE9, highE10, highE11, highE12, highE13,
				highE14, highE15, B0, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, G0, G1, G2, G3,
				G4, G5, G6, G7, G8, G9, G10, G11, G12, G13, G14, G15, D0, D1, D2, D3, D4, D5, D6, D7, D8, D9, D10, D11,
				D12, D13, D14, D15, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, lowE0, lowE1,
				lowE2, lowE3, lowE4, lowE5, lowE6, lowE7, lowE8, lowE9, lowE10, lowE11, lowE12, lowE13, lowE14, lowE15
				);

	}
	public static void disableNotes() {
		for(RadioButton noteButton:buttonList) {
			noteButton.setDisable(true);
		}
	}
	public static void updateNotes() { 
		for(int i=0;i<buttonList.size();i++) {
			buttonList.get(i).setSelected(false);
		}
		disableNotes();
		if(currentScale!=null&&currentNote!=null) {
			ScaleButtons.setCurrentNoteScaleText(currentNote+currentScale);
			int[] intervals = scaleMap.get(currentScale);
			if(intervals!=null) {
				Note[] scaleNotes = generateScales(currentNote,intervals);
				for(int i=0;i<buttonList.size();i++) {
					Note buttonNote = (Note) buttonList.get(i).getUserData();
					for(Note note:scaleNotes) {
						if(note.equals(buttonNote)) {
							buttonList.get(i).setDisable(false);
							buttonList.get(i).fire();
						}
					}
				}
			}
		}
		
	}
	public static Note[] generateScales(String note, int[] intervals) {
		Note[] notes = new Note[intervals.length];
		int rootPos = -1;
		for(int i=0;i<noteSequence.length;i++) {
			if(noteSequence[i].equals(note)) {
				rootPos = i;
				break;
			}
		}
		for(int i=0;i<intervals.length;i++) {
			notes[i] = new Note(noteSequence[(rootPos + intervals[i])%12],0,0);
		}
		
		return notes;
	}
	public static String getCurrentNote() {
		return currentNote;
	}

	public static void setCurrentNote(String currentNote) {
		ScaleFretboard.currentNote = currentNote;
	}

	public static String getCurrentScale() {
		return currentScale;
	}

	public static void setCurrentScale(String currentScale) {
		ScaleFretboard.currentScale = currentScale;
	}
}
