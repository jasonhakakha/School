/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Jason
 */

public class binaryfx extends Application {
    GridPane root = new GridPane();
     Random rand = new Random();
     int size = rand.nextInt(100) + 100;
     int s = 40;
     int[] a = new int[size];
     Rectangle[] r = new Rectangle[size];
     int[] values = new int[size];
     Color good = Color.HOTPINK;
     Color bad = Color.AQUAMARINE;
     
    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        int x = 0;
               for(int i = 0; i < size; i++){
                   values[i] = rand.nextInt(999);
               }
               Arrays.sort(values);
               for(int i = 0; i < size; i++){
               StackPane st = new StackPane();
     
               r[x] = new Rectangle(s,s);
               r[x].setFill(good);
               st.setMinSize(s,s);
               st.getChildren().addAll(r[x], new Label("" + values[x++]));
               root.add(st, i % 10, i / 10);
               }
               
        int search = (int)Math.random() * size;
        r[search].setFill(Color.PURPLE);
       
       
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
                Search(values,values[search]);

    }
    public  void setMin(int x){
        for (int i = 0; i < size; i++) {
            if(values[i] < x) r[i].setFill(Color.TRANSPARENT);
        }
    }
    public  void setMax(int x){
        for (int i = 0; i < size; i++) {
            if(values[i] > x) r[i].setFill(Color.TRANSPARENT);
        }
    }
    public boolean Search(int[] x, int search) {
         
        int start = 0;
        int end = x.length - 1;
        while (start <= end) {
           try {
                Thread.sleep(1000);
        } catch (InterruptedException ex) {
                Logger.getLogger(binaryfx.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            int mid = (start + end) / 2;
            if (search == x[mid]) {
                                r[search].setFill(Color.WHITE);

                return true;
            }
            if (search < x[mid]) {
                end = mid - 1;
               setMin(end);
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
