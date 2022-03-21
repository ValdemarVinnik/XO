import java.io.IOException;
import java.util.Scanner;

public class Game {
    public static Game game;
    public boolean aLive = true;
    private static GameWindow gameWindow;

    public static Board board = new Board();

    public static Game getInstance(){
        return game == null? game = new Game(): game;
    }

    private Game(){

    }

    public void drawX(int i) {
        switch (i) {
            case 1:
                board.setX(0, 0);
                break;
            case 2:
                board.setX(1, 0);
                break;
            case 3:
                board.setX(2, 0);
                break;
            case 4:
                board.setX(0, 1);
                break;
            case 5:
                board.setX(1, 1);
                break;
            case 6:
                board.setX(2, 1);
                break;
            case 7:
                board.setX(0, 2);
                break;
            case 8:
                board.setX(1, 2);
                break;
            case 9:
                board.setX(2, 2);
                break;
        }
    }
}