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

public class ConnectFourGUI extends Application {
    private static final Image BLANK = new Image("file:media/images/blank.png");
    private static final Image BLACK = new Image("file:media/images/blackpiece.png");
    private static final Image SQUARE = new Image("file:media/images/blanksquare.png");
    private static final Image RED = new Image("file:media/images/redpiece.png");

    private ConnectFour game;


    private Button makeConnectFourButton(int row, int col) {
        Checker checker = game.getChecker(row, col);
        Image image = BLANK;


        ImageView pieceView = new ImageView(image);

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
    

    @Override
    public void start(Stage stage) throws Exception {
        game = new ConnectFour();
        GridPane pane = new GridPane();

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

    public static void main(String[] args) {
        launch(args);
    }
}
