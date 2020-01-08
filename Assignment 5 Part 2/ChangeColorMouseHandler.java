import java.security.acl.Group;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;

public class ChangeColorMouseHandler implements EventHandler<MouseEvent> {
  @SuppressWarnings("deprecation")
private Group target;
  private Paint defaultFill;
  private Paint defaultStroke;

// 8) Add constructor that takes a Shape and store it as this.target
  // 9) In the constructor,
  //     1. store the target's current fill as this.defaultFill
  //     2. store the target's current stroke as this.defaultStroke
  public ChangeColorMouseHandler(javafx.scene.Group mouseDrawn) {
	  this.target=(Group) mouseDrawn;
  }

  public void handle(MouseEvent event) {
 
      // 10) Change target's fill to YELLOW and stroke to GOLD
    	((Node) target).setTranslateX(150);
  }
}
