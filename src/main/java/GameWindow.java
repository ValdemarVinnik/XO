import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameWindow extends JFrame{
    private static GameWindow game_window;
    private static Image background;
    private static Image field;
    private static Image o;
    private static Image x;

    public static GameWindow getInstance() throws IOException {
        return game_window == null? game_window = new GameWindow(): game_window;
    }

    private GameWindow() throws IOException {
        background = ImageIO.read(GameWindow.class.getResourceAsStream("list.png"));
        field = ImageIO.read(GameWindow.class.getResourceAsStream("fild.png"));
        o = ImageIO.read(GameWindow.class.getResourceAsStream("o.png"));
        x = ImageIO.read(GameWindow.class.getResourceAsStream("x.png"));
       //setParam();

    }

    private static void setParam(){
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game_window.setLocation(200, 100);
        game_window.setSize(600,478);
        game_window.setResizable(false);
        GameField gameField = new GameField();
        game_window.add(gameField);
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
//        String[][] matrix = Game.board.getField();
        String[][] matrix = new String[][]{{"O","X","X"},{"X","O","X"},{"X","X","O"},};
        g.drawImage(background,0 ,0,null);
        g.drawImage(field,200 ,30,null);

        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if (matrix[j][i].equals("X")){
                    g.drawImage(x, 250+(i*100), 70+(100*j), null);
                }
                if (matrix[j][i].equals("O")){
                    g.drawImage(o, 250+(i*100), 70+(100*j), null);
                }
            }
        }

//        //1
//        g.drawImage(o,240 ,70,null);
//       // g.drawImage(x,240 ,70,null);
//        //2
//        //g.drawImage(o,350 ,70,null);
//         g.drawImage(x,350 ,70,null);
//         //3
//        g.drawImage(o,460 ,70,null);
//        //g.drawImage(x,460 ,70,null);
//        //4
//        g.drawImage(o,240 ,170,null);
//        // g.drawImage(x,240 ,70,null);
//        //5
//        //g.drawImage(o,350 ,70,null);
//        g.drawImage(x,350 ,170,null);
//        //6
//        g.drawImage(o,460 ,170,null);
//        //g.drawImage(x,460 ,70,null);
//        //7
//        g.drawImage(o,240 ,270,null);
//        // g.drawImage(x,240 ,70,null);
//        //8
//        //g.drawImage(o,350 ,70,null);
//        g.drawImage(x,350 ,270,null);
//        //9
//        g.drawImage(o,460 ,270,null);
        //g.drawImage(x,460 ,70,null);
//        long current_time = System.nanoTime();
//        float delta_time = (current_time - last_frame_time)*0.000000001f;
//        last_frame_time = current_time;
//        drop_top = drop_top + drop_v*delta_time;
//        g.drawImage(background, 0, 0, null);
//        g.drawImage(drop, (int) drop_left, (int) drop_top, null);
//        if(drop_top> gameWindow.getHeight()) g.drawImage(game_over, 150, 80, null);
    }

    public static void main(String[] args) throws IOException {
        getInstance().setParam();

    }
}
