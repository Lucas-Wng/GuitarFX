package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Stage stage = new Stage();
			VBox root = new VBox(3);
			//root.prefWidthProperty().bind(stage.widthProperty().multiply(0.80));
			NavigationBar navBar = new NavigationBar();
			Fretboard fretboard = new Fretboard();
			FretboardButtons fretboardButtons = new FretboardButtons();
			Button btn3 = new Button("Button 3");
			HBox fretBoardHbox = new HBox(2);
			fretBoardHbox.getChildren().addAll(fretboard,fretboardButtons);
			root.getChildren().addAll(navBar,fretBoardHbox,btn3);
			Scene scene = new Scene(root);
			String css = this.getClass().getResource("application.css").toExternalForm();
			scene.getStylesheets().add(css);
			stage.setTitle("Guitar");
			stage.setScene(scene);
			stage.setMaximized(true);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
