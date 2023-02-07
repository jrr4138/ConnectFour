package view;


import java.util.ArrayList;

import model.ConnectFour;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

/**
 * A GUI that allows the user to play a game of ConnectFour.
 * 
 * Click on the buttons at the top labeled "DROP HERE" to drop a piece into that column.
 * 
 * To end the game, simply close out of the pop-up window that opened when you started the game (ran the program).
 * 
 * @author Josh Ross
 */

public class ConnectFourGUIattempt2 extends Application{
    private static final Image BLACK = new Image("file:media/images/blackpiece.png");
    private static final Image SQUARE = new Image("file:media/images/blanksquare.png");
    private static final Image RED = new Image("file:media/images/redpiece.png");

    private int c1 = 0;
    private int r1 = 5;
    private int c2 = 1;
    private int r2 = 5;
    private int c3 = 2;
    private int r3 = 5;
    private int c4 = 3;
    private int r4 = 5;
    private int c5 = 4;
    private int r5 = 5;
    private int c6 = 5;
    private int r6 = 5;

    private int colorChecker = 1;

    /**
     * Starts the game of ConnectFour.
     */
    @Override
    public void start(Stage stage) throws Exception {

        ArrayList<ImageView> imageArray = new ArrayList<>();
        for(int i = 0; i < ConnectFour.ROWS * ConnectFour.COLS; i++){
            ImageView image = new ImageView(SQUARE);
            imageArray.add(image);
        }

        int count = 0;
        GridPane pane = new GridPane();
        for(int i = 0; i < ConnectFour.ROWS; i++){
            for(int j = 0; j < ConnectFour.COLS; j++){
                pane.add(imageArray.get(count), i, j);
                count++;
            }
        }

        // Creates a horizontal box to add the "Drop" buttons above each column
        HBox colButtons = new HBox();

        // Creates the first column with a button to drop at the top
        Button col1 = new Button("DROP HERE");
        col1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        col1.setPadding(new Insets(5));
        col1.setOnAction((e) -> {
            if(r1 >= 0){
                if(colorChecker == 1){
                    pane.add(new ImageView(RED), c1, r1);
                    colorChecker++;
                    System.out.println("Player " + colorChecker + "'s turn!!");
                } else {
                    pane.add(new ImageView(BLACK), c1, r1);
                    colorChecker--;
                    System.out.println("Player " + colorChecker + "'s turn!!");
                }
                r1--;
            } else {
                System.out.println("Column 1 is full, try playing somewhere else :)");
            }
            
        });

        // Creates the second column with a button to drop at the top
        Button col2 = new Button("DROP HERE");
        col2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        col2.setPadding(new Insets(4));
        col2.setOnAction((e) -> {
            if(r2 >= 0){
                if(colorChecker == 1){
                    pane.add(new ImageView(RED), c2, r2);
                    colorChecker++;
                    System.out.println("Player " + colorChecker + "'s turn!!");
                } else {
                    pane.add(new ImageView(BLACK), c2, r2);
                    colorChecker--;
                    System.out.println("Player " + colorChecker + "'s turn!!");
                }
                r2--;
            } else {
                System.out.println("Column 2 is full, try playing somewhere else :)");
            }
        });

        // Creates the third column with a button to drop at the top
        Button col3 = new Button("DROP HERE");
        col3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        col3.setPadding(new Insets(5));
        col3.setOnAction((e) -> {
            if(r3 >= 0){
                if(colorChecker == 1){
                    pane.add(new ImageView(RED), c3, r3);
                    colorChecker++;
                    System.out.println("Player " + colorChecker + "'s turn!!");
                } else {
                    pane.add(new ImageView(BLACK), c3, r3);
                    colorChecker--;
                    System.out.println("Player " + colorChecker + "'s turn!!");
                }
                r3--;
            } else {
                System.out.println("Column 3 is full, try playing somewhere else :)");
            }
        });

        // Creates the fourth column with a button to drop at the top
        Button col4 = new Button("DROP HERE");
        col4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        col4.setPadding(new Insets(4));
        col4.setOnAction((e) -> {
            if(r4 >= 0){
                if(colorChecker == 1){
                    pane.add(new ImageView(RED), c4, r4);
                    colorChecker++;
                    System.out.println("Player " + colorChecker + "'s turn!!");
                } else {
                    pane.add(new ImageView(BLACK), c4, r4);
                    colorChecker--;
                    System.out.println("Player " + colorChecker + "'s turn!!");
                }
                r4--;
            } else {
                System.out.println("Column 4 is full, try playing somewhere else :)");
            }
        });

        // Creates the fifth column with a button to drop at the top
        Button col5 = new Button("DROP HERE");
        col5.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        col5.setPadding(new Insets(5));
        col5.setOnAction((e) -> {
            if(r5 >= 0){
                if(colorChecker == 1){
                    pane.add(new ImageView(RED), c5, r5);
                    colorChecker++;
                    System.out.println("Player " + colorChecker + "'s turn!!");
                } else {
                    pane.add(new ImageView(BLACK), c5, r5);
                    colorChecker--;
                    System.out.println("Player " + colorChecker + "'s turn!!");
                }
                r5--;
            } else {
                System.out.println("Column 5 is full, try playing somewhere else :)");
            }
        });

        // Creates the sixth column with a button to drop at the top
        Button col6 = new Button("DROP HERE");
        col6.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        col6.setPadding(new Insets(4));
        col6.setOnAction((e) -> {
            if(r6 >= 0){
                if(colorChecker == 1){
                    pane.add(new ImageView(RED), c6, r6);
                    colorChecker++;
                    System.out.println("Player " + colorChecker + "'s turn!!");
                } else {
                    pane.add(new ImageView(BLACK), c6, r6);
                    colorChecker--;
                    System.out.println("Player " + colorChecker + "'s turn!!");
                }
                r6--;
            } else {
                System.out.println("Column 6 is full, try playing somewhere else :)");
            }
        });

        colButtons.getChildren().addAll(
            col1, col2, col3, col4, col5, col6
        );

        VBox board = new VBox();
        board.getChildren().addAll(colButtons, pane);

        Scene scene = new Scene(board);
        stage.setScene(scene);
        stage.setTitle("Connect Four!!");
        stage.show();
    }

    /**
     * Launches a pop-up window for the game to be played in
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}

