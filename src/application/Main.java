package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Stage stage = new Stage();
			
			
			
			
			
			AnalyzerPane analyzerpane = new AnalyzerPane();
			ScalePane scalepane = new ScalePane();
			ChordFingeringPane chordpane = new ChordFingeringPane();
			
			
			
			Scene scene = new Scene(analyzerpane);
			String css = this.getClass().getResource("application.css").toExternalForm();
			
			SceneController sceneController = new SceneController(scene);
			sceneController.addScreen("analyzer", analyzerpane);
			sceneController.addScreen("scales", scalepane);
			sceneController.addScreen("chord library", chordpane);
			SceneController.activate("chord library");
			
			
			scene.getStylesheets().add(css);
			stage.setTitle("Guitar");
			stage.setScene(scene);
			stage.setHeight(720);
			stage.setWidth(1200);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
