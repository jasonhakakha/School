/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Jason
 */
public class Word extends Application {
    int count = 0;
    @Override
    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
        String[] temparr = {"read","bee","card","an","be","to"};
        ArrayList<String> wordstemp = new ArrayList<>(Arrays.asList(temparr));
        ArrayList<String> words = orderWords(wordstemp);
        
        count = words.size();
       
        
        GridPane root = new GridPane();
        TextField castro = new TextField("WORD: CASTRO");
        GridPane.setConstraints(castro,0,0);
        root.getChildren().add(castro);
        int rowcount = 2;
        ArrayList<Tile> wordTile = new ArrayList<>();
        for(String s: words){
            Tile temp = new Tile(s);
            wordTile.add(temp);
        }
        ArrayList<TextField> tf = new ArrayList<>();
        
        for(int i = 0; i < wordTile.size(); i++){
            boolean odd = i % 2 == 1;
            TextField temp = new TextField(wordTile.get(i).blank);
            tf.add(temp);
            if(odd)
               GridPane.setConstraints(temp,1, rowcount++);
            else
                GridPane.setConstraints(temp, 0, rowcount);
            root.getChildren().add(temp);
            
        }
        TextField answer = new TextField();
        Button enter = new Button("enter");
        enter.setOnAction(e->{
        if(words.contains(answer.getText())){
            for(int i = 0; i < wordTile.size(); i++){
                if(wordTile.get(i).word.equals(answer.getText())){
                    tf.get(i).setText(wordTile.get(i).word);
                    count--;
                    if(count == 0)
                        System.out.println("WIN");
                }
            }
        }
        answer.setText("");
        });
        GridPane.setConstraints(answer, 0, words.size() + 1);
        GridPane.setConstraints(enter, 1, words.size() + 1);
        root.getChildren().addAll(enter, answer);
        
       // StackPane root = new StackPane();
        //root.getChildren().add(btn);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Hello");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public class Tile{
        public String word;
        public String blank;
        public int ord;
        public Tile(String word){
            this.word = word;
            String temp = "";
            for(int i = 0; i < word.length();i++)
                temp += "_ ";
            blank = temp.substring(0, temp.length() - 1);
       
         }
    }
    public ArrayList<String> orderWords(ArrayList<String> x){
        int max = 0;
        ArrayList<String> temp = new ArrayList<>();
        for(String s: x) 
            if(s.length() > max) max = s.length();
        for(int i = max; i > 1; i--){
            for(String s: x)
                if (s.length() == i)temp.add(s);
        }
        return temp;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
