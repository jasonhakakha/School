/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jhakakha
 */
public class Client extends Application {
        Socket socket;
        DataInputStream in;
        DataOutputStream out;
        TextArea ta = new TextArea();
    @Override
    public void start(Stage primaryStage) {
        TextField tf = new TextField();
        
        ta.setEditable(false);

        
        VBox root = new VBox(10);
        root.getChildren().addAll(ta,tf);
        
        tf.setOnAction(e->{
           try {
               out.writeUTF(tf.getText());
               ta.appendText("\nme: " + tf.getText());
               tf.clear();
           } catch (IOException ex) {}
        });
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("client");
        primaryStage.setScene(scene);
        primaryStage.show();
          primaryStage.setOnCloseRequest(e->{
            System.exit(0);
            Platform.exit();
        });
        new Thread(()->{
           connectToServer();
           communicate();
        }).start();
    }
    void connectToServer(){
            try { 
                socket = new Socket("localhost", 8000);
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException ex) {}
    }
    void communicate(){
        while(true){
            try {
                String msg = in.readUTF();
                //System.out.println(msg);
                Platform.runLater(()-> ta.appendText("\nthem: " + msg));
            } catch (IOException ex) {}
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
