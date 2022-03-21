import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GameWindow extends JFrame {
    private static GameWindow game_window;
    private static Image background;
    private static Image field;
    private static Image o;
    private static Image x;
    private String title_message;

    public static GameWindow getInstance() throws IOException {
        return game_window == null ? game_window = new GameWindow() : game_window;
    }

    private GameWindow() throws IOException {
        background = ImageIO.read(GameWindow.class.getResourceAsStream("list.png"));
        field = ImageIO.read(GameWindow.class.getResourceAsStream("fild.png"));
        o = ImageIO.read(GameWindow.class.getResourceAsStream("o.png"));
        x = ImageIO.read(GameWindow.class.getResourceAsStream("x.png"));
        //setParam();

    }

    public GameWindow setParam() {
        game_window.setTitle("Game XO");
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game_window.setLocation(200, 100);
        game_window.setSize(600, 478);
        game_window.setResizable(false);

        game_window.add(getGameField());
        game_window.setVisible(true);
        return game_window;
    }

    private static GameField getGameField() {
        GameField gameField = new GameField();
        gameField.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();


                if (y > 60 && y < 160) {
                    if (x > 220 && x < 320) {
                        Game.getInstance().drawX(1);
                    }
                    if (x > 320 && x < 420) {
                        Game.getInstance().drawX(2);
                    }
                    if (x > 420 && x < 520) {
                        Game.getInstance().drawX(3);
                    }
                }
                if (y > 160 && y < 260) {
                    if (x > 220 && x < 320) {
                        Game.getInstance().drawX(4);
                    }
                    if (x > 320 && x < 420) {
                        Game.getInstance().drawX(5);
                    }
                    if (x > 420 && x < 520) {
                        Game.getInstance().drawX(6);
                    }
                }
                if (y > 260 && y < 360) {
                    if (x > 220 && x < 320) {
                        Game.getInstance().drawX(7);
                    }
                    if (x > 320 && x < 420) {
                        Game.getInstance().drawX(8);
                    }
                    if (x > 420 && x < 520) {
                        Game.getInstance().drawX(9);
                    }
                }


            }
        });
        return gameField;
    }

    public void setTitleMessage(String message) {
       title_message = message;
    }

    private static class GameField extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
            repaint();
        }
    }

    private static void onRepaint(Graphics g) {
        String[][] matrix = Game.board.getField();
        //  String[][] matrix = new String[][]{{"O","X","+"},{"X","O","X"},{"X","X","O"},};
        g.drawImage(background, 0, 0, null);
        g.drawImage(field, 200, 30, null);


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i].equals("X")) {
                    g.drawImage(x, 250 + (j * 100), 70 + (100 * i), null);
                }
                if (matrix[j][i].equals("O")) {
                    g.drawImage(o, 250 + (j * 100), 70 + (100 * i), null);
                }
            }
        }

        if (game_window.title_message != null){ game_window.setTitle(game_window.title_message);}


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

    public void run() {
        Game game = Game.getInstance();
        //board.printField();


        while (true) {

            if (game.board.somebodyWin()) {
                setTitleMessage("You win!!!");
                break;
            }
            if (game.board.isFull()) {
                setTitleMessage("Nobody wins...");
                break;
            }
            //Thread.sleep(1000);

            game.board.analysisO();

            if (game.board.somebodyWin()) {
                setTitleMessage("You wOn!!!");
                break;
            }
            if (game.board.isFull()) {
                setTitleMessage("Nobody wins...");
                break;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        getInstance().setParam().run();


    }
}
