package hungryballs;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class HungryBalls extends Application implements Constants {
    
    DataInputStream in;
    DataOutputStream out;
    Circle player1, player2, target;
    Pane pane = new Pane();
    
    @Override
    public void start(Stage primaryStage) {

        pane.setStyle("-fx-border-color: red");
        pane.setPrefSize(WIDTH, HEIGHT);
        
        VBox root = new VBox(100);
        root.getChildren().addAll(pane);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Hungry Balls");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            System.exit(0);
            Platform.exit();
        });
        
        pane.requestFocus();
        pane.setOnKeyPressed(e -> {
            switch (e.getCode())
            {
                case UP:
                    if (player1.getCenterY() - PLAYER_SIZE - SPEED > 0){
                    {player1.setCenterY(player1.getCenterY() - SPEED);
                    
                   }
                try {out.writeInt(UP);} catch (IOException ex) {
                
                }
                    }
                    break;
                case DOWN:
                    if (SPEED + player1.getCenterY() + PLAYER_SIZE  < HEIGHT){
                    {player1.setCenterY(SPEED + player1.getCenterY());
                    }
                try {out.writeInt(DOWN);} catch (IOException ex) {
                
                }
                    }
                    break;
                case LEFT:
                    if (player1.getCenterX() - PLAYER_SIZE - SPEED > 0)
                    {player1.setCenterX(player1.getCenterX() - SPEED);
                try {out.writeInt(LEFT);} catch (IOException ex) {
                
                }
                    }
                    break;
                case RIGHT:
                    if (player1.getCenterX() + SPEED + PLAYER_SIZE < WIDTH)
                    {player1.setCenterX(SPEED + player1.getCenterX());
                try {out.writeInt(RIGHT);} catch (IOException ex) {
                
                }
                    }
                    break;
                }
        });
        
        new Thread(() -> {
            startServer();
            play();
        }).start();
    }
    
    void play () 
    {
        while (true) {
            int signal = 0;
            try{signal = in.readInt();} catch (IOException ex) {}
            switch(signal)
            {
                case UP:
                    player2.setCenterY(player2.getCenterY() - SPEED); break;
                case DOWN:
                    player2.setCenterY(SPEED + player2.getCenterY()); break;
                case LEFT:
                    player2.setCenterX(player2.getCenterX() - SPEED); break;
                case RIGHT:
                    player2.setCenterX(SPEED +  player2.getCenterX()); break;
                }

        }
    }

   
    void startServer() 
    {
        try {
            
            ServerSocket serverSocket = new ServerSocket(8002);
            System.out.println("here");
            double x = Math.random() * (WIDTH - 2 * PLAYER_SIZE - 6) + PLAYER_SIZE + 3;
            double y = Math.random() * (HEIGHT - 2 * PLAYER_SIZE - 6) + PLAYER_SIZE + 3;
            player1 = new Circle (x, y, PLAYER_SIZE, Color.MAROON);
            Platform.runLater(() -> pane.getChildren().add(player1));
            Socket socket = serverSocket.accept();
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            x = in.readDouble();
            y = in.readDouble();
            player2 = new Circle(x, y, PLAYER_SIZE, Color.NAVY);
            x = in.readDouble();
            y = in.readDouble();
            target = new Circle(x, y, TARGET_SIZE);
            Platform.runLater(() -> pane.getChildren().addAll(player2, target));
            out.writeDouble(player1.getCenterX());
            out.writeDouble(player1.getCenterY());
        } catch (IOException ex) {}
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
