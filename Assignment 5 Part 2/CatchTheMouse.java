import java.util.Random;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CatchTheMouse extends Application {
	
	public void start(Stage primaryStage) {
		
		Group mouseDrawn = (new Mouse(Color.PINK)).draw();
		mouseMover mover= new mouseMover(mouseDrawn);
		mouseDrawn.setOnMouseClicked(mover);
		Scene scene = new Scene(mouseDrawn);
		primaryStage.setScene(scene);
		primaryStage.setMinWidth(600);
		primaryStage.setMinHeight(600);
		primaryStage.show();
		
	}
}
