import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Adding extends Application {
	public void start(Stage primaryStage) throws Exception {
		HBox main = new HBox();
		ButtonClickHandler addIt=new ButtonClickHandler();
		main.setMaxSize(350, 100);
		main.setMinSize(350, 100);
		TextField leftInput=new TextField();
		Button action = new Button("+");
		action.getI
		TextField rightInput=new TextField();
		Label answer=new Label("=");
		answer.setPadding(new Insets(0,0,0,10));
		main.getChildren().addAll(leftInput,action,rightInput,answer);
		Scene scene=new Scene(main);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
