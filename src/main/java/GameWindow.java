import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GameWindow extends JFrame {
    private static GameWindow game_window;
    private static JButton try_again_button;
    private static Image background;
    private static Image field;
    private static Image o;
    private static Image x;
    private static JDialog try_again_dialog;
    private String title_message;


    public static GameWindow getInstance() throws IOException {
        return game_window == null ? game_window = new GameWindow() : game_window;
    }

    private GameWindow() throws IOException {
        background = ImageIO.read(GameWindow.class.getResourceAsStream("list.png"));
        field = ImageIO.read(GameWindow.class.getResourceAsStream("fild.png"));
        o = ImageIO.read(GameWindow.class.getResourceAsStream("o.png"));
        x = ImageIO.read(GameWindow.class.getResourceAsStream("x.png"));
       try_again_dialog = GameWindow.getTryAgainDialog();

    }

    public GameWindow setParam() {

        game_window.setTitle("Game XO");
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game_window.setLocation(200, 100);
        game_window.setSize(600, 478);
        game_window.setResizable(false);
       // try_again_button = new JButton("Try again...");
       // try_again_button.setBounds(10,10,200,50);
        //try_again_button.setDefaultCapable(false);

        game_window.add(getGameField());
       // game_window.add(try_again_button);
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

    private static JDialog getTryAgainDialog(){
        JDialog dialog = new JDialog();
        Button try_again_button = new Button("Try again...");
        try_again_button.setSize(50,80);
        try_again_button.setLocation(75,10);
        try_again_button.setVisible(true);
        dialog.setSize(200,200);
        Button end_button = new Button("end");
        try_again_button.setSize(50,80);
        try_again_button.setLocation(75,110);
        try_again_button.setVisible(true);
        dialog.setSize(200,200);
        dialog.add(try_again_button);
        dialog.add(end_button);
        return dialog;
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
        if (Game.board.isFull_Line()){

            try_again_dialog.setVisible(true);
        }
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
