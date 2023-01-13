package application;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class NavigationBar extends HBox{
	public NavigationBar() {
		Button btn1 = new Button("Button 1");
		Button btn2 = new Button("Button 2");
		Button btn3 = new Button("Button 3");
		this.getChildren().addAll(btn1,btn2,btn3);
	}
}
