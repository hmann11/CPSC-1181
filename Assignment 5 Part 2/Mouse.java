import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
/**
 * 
 * @author hmann11
 * 
 * This class constructs a mouse by taking in the color of the nose and adding the other details.
 * 
 * @param mouseNose is the color of the mouse's nose
 * @param baseColor is the color of the mouse's body
 * @param eyes is the color of the mouse's eyes
 *
 */
public class Mouse {
	
	private Color mouseNose;
	private Color baseColor=Color.DARKGREY;
	private Color eyes=Color.BLACK;
	
	public Mouse(Color mouseNose) {
	this.mouseNose=mouseNose;
	}
	
	public Group draw() {
		Path faceBase = new Path(
				new MoveTo(25, 25), 
				new LineTo(115, 25), 
				new LineTo(70,125), 
				new ClosePath()
				);
		Circle leftEar = new Circle(25, 25, 25, baseColor);
		Circle rightEar = new Circle(115, 25, 25, baseColor);
		Circle leftEye= new Circle(50,50,5,eyes);
		Circle rightEye= new Circle(90,50,5,eyes);
		Circle nose= new Circle(70,125,10,mouseNose);
		Circle body= new Circle(70,125,60,baseColor);
		
		faceBase.setStrokeType(StrokeType.OUTSIDE);
		faceBase.setFill(baseColor);
		faceBase.setStrokeWidth(2);
		faceBase.setStroke(Color.GREY);

		Group group = new Group(body, faceBase,leftEar, rightEar, leftEye, rightEye, nose);
		return group;

	}
}
