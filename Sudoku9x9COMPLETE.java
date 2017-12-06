

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Sudoku extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane board = new GridPane();
        Button bt = new Button("SOLVE");
        ArrayList<TextField> list = new ArrayList<>();
        int count = 0;

        for (int blockColumn = 0; blockColumn < 3 ; blockColumn++) {
            for (int blockRow = 0; blockRow < 3; blockRow++) {

                GridPane box = new GridPane();
                box.setStyle("-fx-background-color: black, -fx-control-inner-background; -fx-background-insets: 0, 2; -fx-padding: 2;");
                for (int column = 0; column < 3; column++) {
                    for (int row = 0 ; row < 3; row++) {
                        TextField textField = new TextField("0");
                        textField.setStyle("-fx-pref-width: 2em;");
                        GridPane.setConstraints(textField, column, row);
                        list.add(textField);
                        box.getChildren().add(textField);
                    }
                }

                GridPane.setConstraints(box, blockColumn, blockRow);
                board.getChildren().add(box);

            }
        }
        GridPane.setConstraints(bt, 0, 3);
        board.getChildren().add(bt);

        
        primaryStage.setScene(new Scene(board));
        primaryStage.show();
        System.out.println(list.size());
        bt.setOnAction(e->{
            int[][] tempi = listToBoard(list);
            solve(tempi);
            int countt = 0;
            ArrayList<String> temp = boardToList(tempi);
            System.out.println(temp.get(1));
            for(TextField x: list){
                x.setText(temp.get(countt));
                countt++;
            }
          
        });
        
        

    }

    public static void main(String[] args) {
        launch(args);
    }
    static boolean solve(int[][] a) {
		// find first free cell
		boolean found = false;
		int I = -1, J = -1;
		for (int i = 0; i < a.length && !found; i++) {
			for (int j = 0; j < a[i].length && !found; j++) {
				if (a[i][j] == 0) {
					found = true;
					I = i;
					J = j;
				}
			}
		}
		if (!found) return true; // solved!!!
		
		for (int num = 1; num <= 9; num++) {
			if (isOk(num, I, J,a)) {
				a[I][J] = num;
				if (solve(a)) return true;
                a[I][J] = 0;
			}
		}
		
		return false;
	}
	
	static boolean isOk(int num, int I, int J, int[][]a) {
        // check row
		for (int j = 0; j < a.length; j++) {
			if (j != J) {
				if (a[I][j] == num) 
					return false;
			}
		}
        // check column
		for (int i = 0; i < a.length; i++) {
			if (i != I) {
				if (a[i][J] == num)
					return false;
			}
		}
        // check square
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int currI = I % 3;
				int currJ = J % 3;
				if (I != currI && J != currJ && a[currI][currJ] == num) 
					return false;
			}
		}
		return true;
	}
        public static int[][] listToBoard(ArrayList<TextField> list){
            int[][] temp = new int[9][9];
            int count = 0;
            for(int row = 0; row < 9; row++){
                for(int col = 0; col < 9; col++)
                    temp[row][col] = Integer.parseInt(list.get(count++).getText());
            }
//            int count = 0;
//            for(int box = 1; box < 10; box++){
//                for(int row = 0; row < 3; row++){
//                    for(int col = 0; col < 3; col++){
//                        int rrow;
//                        int rcol;
//                        if(box == 1){
//                           temp[row][col] = Integer.parseInt(list.get(count).getText());                        }
//                        if(box == 2){
//                            temp[row + 3][col] = Integer.parseInt(list.get(count).getText());
//                        }
//                        if(box == 3){
//                            temp[row + 6][col] = Integer.parseInt(list.get(count).getText());
//                        }
//                        if(box == 4){
//                            temp[row][col + 3] = Integer.parseInt(list.get(count).getText());
//                        }
//                        if(box == 5){
//                            temp[row + 3][col + 3] = Integer.parseInt(list.get(count).getText());
//                        }
//                        if(box == 6){
//                            temp[row + 6][col + 3] = Integer.parseInt(list.get(count).getText());
//                        }
//                        if(box == 7){
//                            temp[row][col + 6] = Integer.parseInt(list.get(count).getText());
//                        }
//                        if(box == 8){
//                            temp[row + 3][col + 6] = Integer.parseInt(list.get(count).getText());
//                        }
//                        if(box == 9){
//                           temp[row + 6][col + 6] = Integer.parseInt(list.get(count).getText()); 
//                        }
//                        count++;
//                    }
//                }
//            }
            
            int countTwo = 0;
            for(int row = 0; row < 9; row++){
                for(int col = 0; col < 9; col++){
                    temp[row][col] = Integer.parseInt(list.get(countTwo++).getText());
                }
            }
            
            
            return temp;
        }
        public static ArrayList<String> boardToList(int[][] a){
            ArrayList<String> temp = new ArrayList<>();
//            for(int i[]: a){
//                for(int j: i)
//                    temp.add(String.valueOf(j));
//            }
  for(int box = 1; box < 10; box++){
                for(int row = 0; row < 3; row++){
                    for(int col = 0; col < 3; col++){
                        if(box == 1)
                           temp.add(String.valueOf(a[row][col]));
                        if(box == 2)
                        temp.add(String.valueOf(a[row][col+3]));
                        if(box == 3){
                            temp.add(String.valueOf(a[row][col+6]));
                        }
                        if(box == 4){
                            temp.add(String.valueOf(a[row+3][col]));
                        }
                        if(box == 5){
                            temp.add(String.valueOf(a[row+3][col+3]));
                        }
                        if(box == 6){
                            temp.add(String.valueOf(a[row+3][col+6]));
                        }
                        if(box == 7){
                            temp.add(String.valueOf(a[row+6][col]));
                        }
                        if(box == 8){
                            temp.add(String.valueOf(a[row+6][col+3]));
                        }
                        if(box == 9){
                            temp.add(String.valueOf(a[row+6][col+6]));
                        }
                    }
                }
            }
    
            return temp;
        }
}
