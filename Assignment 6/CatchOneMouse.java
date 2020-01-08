import java.util.Random;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 * 
 * @author hmann11
 *
 *This method creates a mouse and then randomly moves then to a new location when the mouse is clicked on.
 */
public class CatchOneMouse extends Application {

	public void start(Stage primaryStage) {
		Mouse mouse = new Mouse(Color.PINK);
		Pane pane = new Pane(mouse.getGroup());
		pane.setMinWidth(800);
		pane.setMinHeight(600);
		Scene scene = new Scene(pane);
		scene.setFill(Color.WHITE);
		// The following line handles the mouse click event and calls the mouseMover method.
		mouse.getGroup().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				mouseMover(e, mouse);
			}
		});
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	/*
	 * This method randomly moves the mouse within the bounds of the javafx window.
	 */
	public void mouseMover(MouseEvent e, Mouse mouse) {
		Random rand = new Random();
		mouse.move(rand.nextInt(440), rand.nextInt(370));
	}
}
