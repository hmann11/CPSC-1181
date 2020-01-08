import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CatchTheMiceLevelUp extends Application {
	private int points = 0;
	private int levelInt = 1;
	private int numberOfMiceLeft=0;
	private ArrayList<Mouse> miceList;
	private Pane rootPane;
	private Label level;

	public void start(Stage primaryStage) {
		Mouse mouse = new Mouse(Color.PINK);
		Pane rootPane=new Pane();
		this.rootPane=rootPane;
		rootPane.getChildren().addAll(mouse.getGroup());
		rootPane.setMinSize(800, 600);
		Label score = new Label("Score: " + points);
		Label level = new Label("Level: " + levelInt);
		this.level=level;
		score.setFont(Font.font(24));
		level.setFont(Font.font(24));
		HBox hbox = new HBox(score);
		hbox.getChildren().addAll(level);
		level.setTranslateX(-83);
		level.setTranslateY(30);
		hbox.setMinHeight(600);
		hbox.setTranslateX(675);
		hbox.setPadding(new Insets(20));
		hbox.setStyle("-fx-border-color: black");
		rootPane.getChildren().addAll(hbox);
		Scene scene = new Scene(rootPane);
		scene.setFill(Color.WHITE);
		rootPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				double X=e.getX();
				double Y=e.getY();
				
				mouse.hide();
				points++;
				score.setText("Score: " + Integer.toString(points));
				//numberOfMiceLeft--;
				if (numberOfMiceLeft == 0) {
					gameState(0, levelInt, points);
				}
			}
		});
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void mouseLocationSetter(Mouse mouse) {
		Random rand = new Random();
		mouse.move(rand.nextInt(440), rand.nextInt(370));
	}

	public void gameState(int numberOfMiceLeft, int levelInt, int score) {
		levelInt++;
		level.setText("Level: " + Integer.toString(levelInt));
		Mouse mouse[] = new Mouse[levelInt];
		for (int i = 0; i <= levelInt; i++) {
			mouse[i] = new Mouse(Color.PINK);
			mouseLocationSetter(mouse[i]);
			//miceList.add(mouse[i]);
		}
		for (int i =0;i<miceList.size();i++) {
			rootPane.getChildren().add(miceList.get(i).getGroup());
		}
	}
}
