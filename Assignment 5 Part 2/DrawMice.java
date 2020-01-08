import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 
 * @author hmann11
 * 
 *         This program draws 4 mice with different colored noses in a javafx
 *         window.
 *
 *@param mouseDrawn is the group of shapes that make the first mouse.
 *@param mouse2Drawn is the group of shapes that make the second mouse.
 *@param mouse3Drawn is the group of shapes that make the third mouse.
 *@param mouse4Drawn is the group of shapes that make the fourth mouse.
 */
public class DrawMice extends Application {

	public void start(Stage primaryStage) {
		Group mouseDrawn = (new Mouse(Color.PINK)).draw();
		Group mouse2Drawn = (new Mouse(Color.DODGERBLUE)).draw();
		Group mouse3Drawn = (new Mouse(Color.YELLOW)).draw();
		Group mouse4Drawn = (new Mouse(Color.GREEN)).draw();
		// This block of code sets different positions for the different mice.
		mouseDrawn.setTranslateX(100);
		mouseDrawn.setTranslateY(100);
		mouse2Drawn.setTranslateX(100);
		mouse2Drawn.setTranslateY(300);
		mouse3Drawn.setTranslateX(300);
		mouse3Drawn.setTranslateY(100);
		mouse4Drawn.setTranslateX(300);
		mouse4Drawn.setTranslateY(300);
		//This is a group of all the mice.
		Group miceGroup = new Group(mouseDrawn, mouse2Drawn, mouse3Drawn, mouse4Drawn);
		Scene scene = new Scene(miceGroup);
		primaryStage.setScene(scene);
		primaryStage.setMinWidth(600);
		primaryStage.setMinHeight(600);
		primaryStage.show();

	}

}
