import java.util.Random;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 
 * @author hmann11
 * 
 * This method creates a mouse and then adds 1 unit to the points whenever the user clicks on the mouse.
 *
 *@param points stores the number of times the user clicked on the mouse
 */
public class CatchOneMouseWithScore extends Application {
	private int points = 0;

	/*
	 * Main method that sets up all the required components
	 * 
	 * @param rootPane is the main pain where everything happens.
	 * @param hbox is the box that houses the score counter.
	 */
	public void start(Stage primaryStage) {
		Mouse mouse = new Mouse(Color.PINK);
		Pane rootPane = new Pane(mouse.getGroup());
		rootPane.setMinSize(800, 600);
		Label score = new Label("Score: " + points);
		score.setFont(Font.font(24));
		HBox hbox = new HBox(score);
		hbox.setMinHeight(600);
		hbox.setTranslateX(675);
		hbox.setPadding(new Insets(20));
		hbox.setStyle("-fx-border-color: black");
		//Adding the hbox to the rootPane.
		rootPane.getChildren().addAll(hbox);
		Scene scene = new Scene(rootPane);
		scene.setFill(Color.WHITE);
		mouse.getGroup().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				mouseMover(e, mouse);
				points++;
				score.setText("Score: " + Integer.toString(points));
			}
		});
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/*
	 * This method moves the mouse to a new location within a given boundry.
	 */
	public void mouseMover(MouseEvent e, Mouse mouse) {
		Random rand = new Random();
		mouse.move(rand.nextInt(440), rand.nextInt(370));
	}
}
