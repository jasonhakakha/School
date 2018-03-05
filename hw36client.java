/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jhakakha
 */
public class Client extends Application {
    DataOutputStream toServer;
    @Override
    public void start(Stage primaryStage) {
        Button color = new Button();
        color.setText("send color");
        Button inte = new Button();
        inte.setText("send string");
        TextField tf = new TextField();
        VBox root = new VBox();
        
        
        Scene scene = new Scene(root, 300, 250);
        root.getChildren().addAll(color,inte,tf);
        
        color.setOnAction(e -> {
            try {
                     toServer.writeUTF("0" + tf.getText());
               
              
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        inte.setOnAction(e -> {
            try {
                     toServer.writeUTF("1" + tf.getText());
               
              
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
       // connect("localhost", 8000);
        connect("172.16.40.64", 8000);
    }
    public void connect(String ip, int port){
        try {
            Socket socket = new Socket(ip, port);
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {}
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
