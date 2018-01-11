/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seeeev;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author jhakakha
 */
public class SEEEEV extends Application {
    final int n = 100*100;
    final int size = 30;
    boolean[] isC = new boolean[n + 1];
    GridPane root = new GridPane();
    Rectangle[] r = new Rectangle[n + 1];
    Color prime = Color.HOTPINK;
    Color nprime = Color.AQUAMARINE;
    
    @Override
    public void start(Stage primaryStage) {
        int x = 1;
        for(int i = 0; i < Math.sqrt(n); i++){
            for(int j = 0; j < Math.sqrt(n); j++){
                StackPane st = new StackPane();
                r[x] = new Rectangle(size, size);
                r[x].setFill(prime);
                //r[x].setStrokeWidth(1);
                st.setMinSize(size, size);
                st.getChildren().addAll(r[x], new Label("" + x++));
                root.add(st, j, i);
            }
        }
        isC[1] = true;
        r[1].setFill(nprime);
//        System.out.print("blakhgjhvhkck");
        new Thread(() -> {
//            System.out.print("black");
            for(int i = 1; i < Math.sqrt(n); i++){
//                System.out.print("black");
                r[i].setStroke(Color.BLACK);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SEEEEV.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(!isC[i]){
                    for(int j = i * i; j <= n; j+=i){
                        isC[j] = true;
                        r[j].setFill(nprime);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SEEEEV.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                r[i].setStroke(Color.TRANSPARENT);
            }
        }).start();
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("ŠÊÈËĘĘĒV");
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
