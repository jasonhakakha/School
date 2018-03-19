
package hungryballs;

import static hungryballs.Constants.HEIGHT;
import static hungryballs.Constants.PLAYER_SIZE;
import static hungryballs.Constants.WIDTH;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author jhakakha
 */
public class Client extends Application implements Constants {
    
        
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
        
        primaryStage.setTitle("Hungry Balls: Client");
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
                    if (player2.getCenterY() - PLAYER_SIZE - SPEED > 0){
                    }{player2.setCenterY(player2.getCenterY() - SPEED);
                try {out.writeInt(UP);} catch (IOException ex) {
                
                }
                    }
                    break;
                case DOWN:
                    if (player2.getCenterY() + PLAYER_SIZE + SPEED < HEIGHT){
                    {player2.setCenterY(SPEED + player2.getCenterY());
                    }
                try {out.writeInt(DOWN);} catch (IOException ex) 
                
                
                    }
                    break;
                case LEFT:
                    if (player2.getCenterX() - PLAYER_SIZE - SPEED > 0){
                    {player2.setCenterX(player2.getCenterX() - SPEED);
                    
                    }
                try {out.writeInt(LEFT);} catch (IOException ex) {
                
                }
                    }
                    break;
                case RIGHT:
                    if (player2.getCenterX() + PLAYER_SIZE + SPEED < WIDTH){
                    
                    {player2.setCenterX(SPEED +player2.getCenterX());
                    
                    }
                try {out.writeInt(RIGHT);} catch (IOException ex) {}
                    }
                    break;
                }
        });
        
        new Thread(() -> {
            connectToServer();
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
                    player1.setCenterY(player1.getCenterY() - SPEED); break;
                case DOWN:
                    player1.setCenterY(SPEED + player1.getCenterY()); break;
                case LEFT:
                    player1.setCenterX(player1.getCenterX() - SPEED); break;
                case RIGHT:
                    player1.setCenterX(SPEED + player1.getCenterX()); break;
                }

        }
    }

    void connectToServer()
    {
        try {
            Socket socket = new Socket("localhost", 8002);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            double x = Math.random() * (WIDTH - 2 * PLAYER_SIZE - 6) + PLAYER_SIZE + 3;
            double y = Math.random() * (HEIGHT - 2 * PLAYER_SIZE - 6) + PLAYER_SIZE + 3;
            player2 = new Circle (x, y, PLAYER_SIZE, Color.NAVY);
            x = Math.random() * (WIDTH - 2 * TARGET_SIZE - 6) + PLAYER_SIZE + 3;
            y = Math.random() * (HEIGHT - 2 * TARGET_SIZE - 6) + PLAYER_SIZE + 3;
            target = new Circle (x, y, TARGET_SIZE);
            Platform.runLater(() -> pane.getChildren().addAll(player2, target));
            out.writeDouble(player2.getCenterX());
            out.writeDouble(player2.getCenterY());
            out.writeDouble(target.getCenterX());
            out.writeDouble(target.getCenterY());
            x = in.readDouble();
            y = in.readDouble();
            player1 = new Circle (x, y, PLAYER_SIZE, Color.MAROON);
            Platform.runLater(() -> pane.getChildren().add(player1));
        } catch (IOException ex) {}
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
