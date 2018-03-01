/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author jhakakha
 */
public class JavaFXApplication1 extends Application {
            Label lbl = new Label("...");
            DataInputStream fromClient;
            StackPane root;

    @Override
    public void start(Stage primaryStage) {
        root = new StackPane();
        root.getChildren().add(lbl);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e->{
            System.exit(0);
            Platform.exit();
            
        
        
        });
        
        new Thread (()->{
                startServer(8000);
                recieve();

        }).start();
    }
    public void recieve(){
        while(!false){
            try {
//                int x = fromClient.readInt();
//                Platform.runLater(() -> lbl.setText(lbl.getText() + "\nI got " + x));
                  String color = fromClient.readUTF();
                  Platform.runLater(() -> root.setStyle("-fx-background-color: " + color));
            } catch (IOException ex) {}
        }
    }
    
    public void startServer(int port)  {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
           Platform.runLater(()-> lbl.setText("Server started B!"));
            Socket socket = serverSocket.accept();
           Platform.runLater(()->  lbl.setText(lbl.getText() + "\n OH DAMN SOMEONE CONNECTED BB"));
           fromClient = new DataInputStream(socket.getInputStream());
        }catch (BindException ex){
            Platform.runLater(()-> lbl.setText("Port " + port + " is busy."));
        }
        catch (IOException ex) {}
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
