package application;


import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Piano extends Pane{
	private static Rectangle C;
	private static Rectangle D;
	private static Rectangle E;
	private static Rectangle F;
	private static Rectangle G;
	private static Rectangle A;
	private static Rectangle B;
	private static Rectangle Csharp;
	private static Rectangle Dsharp;
	private static Rectangle Fsharp;
	private static Rectangle Gsharp;
	private static Rectangle Asharp;
	private static ArrayList<Rectangle> noteList;
	public Piano() {
		String css = this.getClass().getResource("piano.css").toExternalForm();
		this.getStylesheets().add(css);
		noteList = new ArrayList<Rectangle>();
		C = new Rectangle(0,0, 35, 200);
		D = new Rectangle(35,0, 35, 200);
		E = new Rectangle(70,0, 35, 200);
		F = new Rectangle(105,0, 35, 200);
		G = new Rectangle(140,0, 35, 200);
		A = new Rectangle(175,0, 35, 200);
		B = new Rectangle(210,0, 35, 200);
		C.setUserData("C");
		D.setUserData("D");
		E.setUserData("E");
		F.setUserData("F");
		G.setUserData("G");
		A.setUserData("A");
		B.setUserData("B");
		Csharp = new Rectangle(25,0,20,130);
		Dsharp = new Rectangle(60,0,20,130);
		Fsharp = new Rectangle(130,0,20,130);
		Gsharp = new Rectangle(165,0,20,130);
		Asharp = new Rectangle(200,0,20,130);
		
		Csharp.setUserData("C#");
		Dsharp.setUserData("D#");
		Fsharp.setUserData("F#");
		Gsharp.setUserData("G#");
		Asharp.setUserData("A#");

		
		C.setId("whiteKey");
		D.setId("whiteKey");
		E.setId("whiteKey");
		F.setId("whiteKey");
		G.setId("whiteKey");
		A.setId("whiteKey");
		B.setId("whiteKey");
		C.setFill(Color.WHITE);
		D.setFill(Color.WHITE);
		E.setFill(Color.WHITE);
		F.setFill(Color.WHITE);
		G.setFill(Color.WHITE);
		A.setFill(Color.WHITE);
		B.setFill(Color.WHITE);
		
		C.setStroke(Color.BLACK);
		D.setStroke(Color.BLACK);
		E.setStroke(Color.BLACK);
		F.setStroke(Color.BLACK);
		G.setStroke(Color.BLACK);
		A.setStroke(Color.BLACK);
		B.setStroke(Color.BLACK);
		
		Csharp.setStroke(Color.BLACK);
		Dsharp.setStroke(Color.BLACK);
		Fsharp.setStroke(Color.BLACK);
		Gsharp.setStroke(Color.BLACK);
		Asharp.setStroke(Color.BLACK);
		
		noteList.add(C);
		noteList.add(D);
		noteList.add(E);
		noteList.add(F);
		noteList.add(G);
		noteList.add(A);
		noteList.add(B);
		noteList.add(Csharp);
		noteList.add(Dsharp);
		noteList.add(Fsharp);
		noteList.add(Gsharp);
		noteList.add(Asharp);
		
		this.getChildren().addAll(C,D,E,F,G,A,B,Csharp,Dsharp,Fsharp,Gsharp,Asharp);
	}
	public static void updatePiano(String[] userNotes) {
		C.setFill(Color.WHITE);
		D.setFill(Color.WHITE);
		E.setFill(Color.WHITE);
		F.setFill(Color.WHITE);
		G.setFill(Color.WHITE);
		A.setFill(Color.WHITE);
		B.setFill(Color.WHITE);
		Csharp.setFill(Color.BLACK);
		Dsharp.setFill(Color.BLACK);
		Fsharp.setFill(Color.BLACK);
		Gsharp.setFill(Color.BLACK);
		Asharp.setFill(Color.BLACK);
		for(String note:userNotes) {
			for(int i=0;i<noteList.size();i++) {
				if(noteList.get(i).getUserData().equals(note)) {
					noteList.get(i).setFill(Color.GREEN);
					break;
				}
			}
				
		}
	}
}
