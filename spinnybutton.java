/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spinnybutton;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Jason
 */
public class Spinnybutton extends Application {
    boolean spin = false;
    @Override
    public void start(Stage primaryStage) {
                Button btn = new Button();
                

         Thread th;
            th = new Thread(new Runnable() {
                @Override
                public void run() {
                   
                    RotateTransition rotation;
                    rotation = new RotateTransition(Duration.millis(3000), btn);
                    rotation.setCycleCount(Animation.INDEFINITE);
                    rotation.setByAngle(360);
                    rotation.play();
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                
                }
            }
                    
            );
        btn.setText("Say 'Hello World'");
        btn.setOnAction(e -> {
            if(spin){
               th.stop();
               spin = false;
            }
            else
            {
                th.run();
                spin = true;
            }
            
           
        });
       
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
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
