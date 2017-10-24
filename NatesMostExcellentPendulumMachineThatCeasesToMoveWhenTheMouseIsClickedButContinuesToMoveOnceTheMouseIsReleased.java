package pendulum;

import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Jason
 */
public class NatesMostExcellentPendulumMachineThatCeasesToMoveWhenTheMouseIsClickedButContinuesToMoveOnceTheMouseIsReleased extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        Pane root = new Pane();
        Arc arc = new Arc(250, 300, 50, 50, 180, 180);
        arc.setFill(Color.TRANSPARENT);
        arc.setStroke(Color.RED);
        Circle c = new Circle(arc.getCenterX() - arc.getRadiusX(), arc.getCenterY(), 15);
       
        PathTransition pt = new PathTransition();
        pt.setPath(arc);
        pt.setNode(c);
        pt.setOrientation(OrientationType.NONE);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();
        
        root.getChildren().addAll(c, arc);
        
        root.setOnMousePressed(e ->{
            pt.stop();
        });
        root.setOnMouseReleased(e ->{
            pt.play();
        });
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Pendulum!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
