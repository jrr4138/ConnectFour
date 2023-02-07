package view;

import model.Checker;
import model.CheckerObserver;
import model.ConnectFour;
import model.ConnectFourException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * A Game of Connect Four using JavaFX.
 * 
 * To interact with the game, click any box in the column you'd like to drop your piece.
 * The command line will let the players know who's turn it is.
 * 
 * To end the game, simply stop the process from your IDE or close out of the pop-up window
 * created when the program was run.
 * 
 * @author Josh Ross
 */
public class ConnectFourGUI extends Application {
    private static final Image BLANK = new Image("file:media/images/blank.png");
    private static final Image BLACK = new Image("file:media/images/blackpiece.png");
    private static final Image SQUARE = new Image("file:media/images/blanksquare.png");
    private static final Image RED = new Image("file:media/images/redpiece.png");

    private ConnectFour game;


    /**
     * Creates a single "slot" (as a button) to place the ConnectFour pieces.
     * 
     * @param row Row the button will be placed on
     * @param col Column the button will be placed on
     * @return A button to be placed in the GridPane at the start
     */
    private Button makeConnectFourButton(int row, int col) {
        Checker checker = game.getChecker(row, col);
        Image image = BLANK;


        ImageView pieceView = new ImageView(image);

        // Fills selected slot dropped piece
        game.register((sq) -> {
            Checker piece = sq.getChecker(row, col);
            Image newImage = BLANK;
            if(piece == Checker.BLACK) {
                newImage = BLACK;
            } else if(piece == Checker.RED){
                newImage = RED;
            }
            pieceView.setImage(newImage);
        });

        Button butt = new Button("", pieceView);
        butt.setPadding(new Insets(0));

        butt.setBackground(new Background(
            new BackgroundImage(
                SQUARE, 
                BackgroundRepeat.NO_REPEAT, // X
                BackgroundRepeat.NO_REPEAT, // Y
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT)));

        butt.setPrefSize(72, 72);

        // When button is selected, drops piece into column and updates player turn
        butt.setOnAction((e) -> {
            Checker check = game.getChecker(row, col);
            try {
                game.move(row);
            } catch (ConnectFourException e1) {
                System.out.println(e1);
            }
            System.out.println(">> " + game.getCurrentPlayer() + "'s turn");
        });

        return butt;
    }
    

    /**
     * Starts the game.
     */
    @Override
    public void start(Stage stage) throws Exception {
        game = new ConnectFour();
        GridPane pane = new GridPane();

        // fills the gameboard with Slots (buttons)
        for(int col= 0; col < ConnectFour.COLS; col++){
            for(int row = 0; row < ConnectFour.ROWS; row++){
                Button button = makeConnectFourButton(col, row);
                pane.add(button, col, row);
            }
        }
        
        stage.setTitle("ConnectFour!");
        stage.setScene(new Scene(pane));
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
