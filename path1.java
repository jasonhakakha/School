package application;
	
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;


public class Main extends Application {
	int x,y;
	x = y = 10;
	@Override
	public void start(Stage primaryStage) {
			Pane root = new Pane();
			boolean[][] arr = new boolean[50][50];
			
			Timeline tl = new Timeline(new KeyFrame(Duration.millis(500), e -> {
				
					int i = (int)(Math.random() * 4); 
					arr[x][y] = true;
					
					if (i == 0){
						if(!arr[x + 1][y] && x < 16)
							Line l = new Line(x*25,y*25,(++x)*25,y*25);
						}
					if(i==1){
						if(y < 16 && !arr[x][y + 1])
							Line l = new Line(x*25,y*25,x*25,(++y)*25);
						}
					if(i==2){
						if(x > 0 && !arr[x - 1][y]){
							Line l = new Line(x*25,y*25,(--x)*25,y*25);
						}
					if(i==4){
						if(y > 0 && !arr[x][y - 1]){
							Line l = new Line(x*25,y*25,(x)*25,(--y)*25);
						}
					else System.err.println("error");
					root.getChildren().add(l);
					
					//Circle c = new Circle(x,y,5);
				
			}));
			
			
			Scene scene = new Scene(root,500,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			anime.setCycleCount(Timeline.INDEFINITE);
			anime.play();
			
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
