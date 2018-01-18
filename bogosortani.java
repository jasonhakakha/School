/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dankbogosort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Jason
 */
public class bogosort extends Application {
    ArrayList<Rectangle> a = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) {
        
        for(int i = 1; i < 21; i++){
            a.add(new Rectangle(10, i*10));
        }
        Collections.shuffle(a);
        boolean sorted = false;
       Pane root = new Pane();
       new Thread(() -> {
         sort();
        }).start();
        for(Rectangle x: a)
            root.getChildren().add(x);
       
        
        //root.getChildren().add(btn);
//         for(int i = 0; i < 20; i++){
//            a.get(i).setX((i + 1) * 20 - 5);
//            a.get(i).setY(100);
//            
//        }
         System.out.println(a);
        Scene scene = new Scene(root, 200, 200);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    public boolean isAscending(){
        for(int i = 0; i < a.size() - 1; i++){
            if(a.get(i).getHeight() > a.get(i+1).getHeight())
                return false;
        }
            
        return true;
    }
    public void sort(){
            boolean sorted = false;
          while(!sorted){
               try {
                   Thread.sleep(200);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Dankbogosort.class.getName()).log(Level.SEVERE, null, ex);
               }
             Collections.shuffle(a);
             for(int i = 0; i < a.size(); i++){
                 a.get(i).setTranslateX((i) * 10);
                 a.get(i).setTranslateY(200 - (a.get(i).getHeight()));
                 a.get(i).setFill(Color.BLUE);
             }
             sorted = isAscending();
           }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
