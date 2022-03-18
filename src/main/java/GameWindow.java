import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameWindow extends JFrame{
    private static GameWindow game_window;
    private static Image background;
    private static Image fild;
    private static Image o;
    private static Image x;

    public static GameWindow getInstance() throws IOException {
        return game_window == null? game_window = new GameWindow(): game_window;
    }

    private GameWindow() throws IOException {
        this.background = ImageIO.read(GameWindow.class.getResourceAsStream("list.jpg"));
        this.fild = ImageIO.read(GameWindow.class.getResourceAsStream("background.png"));
        this.o = ImageIO.read(GameWindow.class.getResourceAsStream("o.png"));
        this.x = ImageIO.read(GameWindow.class.getResourceAsStream("x.png"));
        game_window.add(new GameField());
        game_window.setVisible(true);

    }

    private static class GameField extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
            repaint();
        }
    }

    private static  void onRepaint(Graphics g){
        g.drawImage(background,0 ,0,null);
//        long current_time = System.nanoTime();
//        float delta_time = (current_time - last_frame_time)*0.000000001f;
//        last_frame_time = current_time;
//        drop_top = drop_top + drop_v*delta_time;
//        g.drawImage(background, 0, 0, null);
//        g.drawImage(drop, (int) drop_left, (int) drop_top, null);
//        if(drop_top> gameWindow.getHeight()) g.drawImage(game_over, 150, 80, null);
    }

    public static void main(String[] args) throws IOException {
        getInstance();
    }
}
