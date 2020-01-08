import java.util.Random;

import javafx.scene.Group;
import javafx.scene.input.MouseEvent;

public class mouseMover {
	Group mouseDrawn;
	public mouseMover(Group mouseDrawn) {
		this.mouseDrawn=mouseDrawn;
	}
	public void handle(MouseEvent event) {
		Random rand=new Random();
		mouseDrawn.setTranslateX(rand.nextInt(440));
		mouseDrawn.setTranslateY(rand.nextInt(370));
	}

}
