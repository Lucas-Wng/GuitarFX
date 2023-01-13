package application;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class FretboardButtons extends GridPane{
	public FretboardButtons() {
		this.setHgap(10);
	    this.setVgap(10);
		Button button1 = new Button("Button 1");
		Button button2 = new Button("Button 2");
		Button button3 = new Button("Button 3");
		Button button4 = new Button("Button 4");
		Button button5 = new Button("Button 5");
		Button button6 = new Button("Button 6");
		button1.setOnAction(value ->  {
	           System.out.println("button1");
	        });
		this.add(button1, 0, 0, 1, 1);
		this.add(button2, 1, 0, 1, 1);
		this.add(button3, 2, 0, 1, 1);
		this.add(button4, 0, 1, 1, 1);
		this.add(button5, 1, 1, 1, 1);
		this.add(button6, 2, 1, 1, 1);
	}
}
