import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class DrawSomeShapes extends Application {
  public void start(Stage primaryStage) {

    // https://docs.oracle.com/javase/9/docs/api/javafx/scene/shape/Circle.html#constructor.detail
    // 1) Create a circle centered at (100, 100) with a radius of 50
    Circle circle = new Circle(100,100,50);
    circle.setFill(Color.BROWN);
    circle.setStroke(Color.CORAL);

    // https://docs.oracle.com/javase/9/docs/api/javafx/scene/shape/Rectangle.html#constructor.detail
    // 2) Create a rectangle with top-left corner at (50, 100) with width 100 and height 50
    // 3) Make the rectangle fill TRANSPARENT
    // 4) Make the rectangle stroke GREEN
    Rectangle rectangle = new Rectangle(50,100,100,50);
    rectangle.setStrokeWidth(10);
    rectangle.setFill(Color.TRANSPARENT);
    rectangle.setStroke(Color.GREEN);

    Path path = new Path(
        new MoveTo(50, 160),
        new LineTo(150, 160),
        new LineTo(100, 260),
        new ClosePath()
    );
    path.setStrokeType(StrokeType.INSIDE);
    // 5) Make the fill ORANGE
    // 6) Make the stroke RED
    path.setFill(Color.ORANGE);
    path.setStrokeWidth(5);
    path.setStroke(Color.RED);
    // 12) Create a ChangeColorMouseHandler with `path` as its argument
    ChangeColorMouseHandler changer=new ChangeColorMouseHandler(path);
    // 13) Use `path.setOnMouseEntered` to register the handler you just created
    path.setOnMouseClicked(changer);
    // 14) Use `path.setOnMouseExited` to register the handler you just created
    path.setOnMouseExited(changer);
    // 15 Bonus) Make the top part (circle + rectangle) move up when your mouse hover on top of the triangle
    //        - you need to create a group contains only circle and rectangle
    //        - you need to create another MouseHandler that changes the group's translateY
    Group TopPart= new Group(circle,rectangle);

    Group group = new Group(circle, rectangle, path);

    // 7) Translate "group" in the Y direction by -50 (setTranslateY)
    group.setTranslateY(-50);

    Scene scene = new Scene(group);
    scene.setFill(Color.BEIGE);
    primaryStage.setScene(scene);
    primaryStage.setMinWidth(200);
    primaryStage.setMinHeight(400);
    primaryStage.show();
  }
}
