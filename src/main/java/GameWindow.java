import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameWindow extends JFrame{
    private static GameWindow game_window;
    private Image background;
    private Image fild;
    private Image o;
    private Image x;

    public GameWindow() throws IOException {
        game_window = new GameWindow();
        this.background = ImageIO.read(GameWindow.class.getResourceAsStream("list.jpg"));
        this.fild = ImageIO.read(GameWindow.class.getResourceAsStream("background.png"));
        this.o = ImageIO.read(GameWindow.class.getResourceAsStream("o.png"));
        this.x = ImageIO.read(GameWindow.class.getResourceAsStream("x.png"));

    }
}
