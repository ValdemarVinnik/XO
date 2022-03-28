import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GameWindow extends JFrame {
    private static GameWindow game_window;

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

    private static JDialog getTryAgainDialog() {
        final JDialog dialog = new JDialog();
        dialog.setLocation(200, 300);

        // Панель содержимого
        Container container = dialog.getContentPane();
        // Устанавливаем менеджер последовательного расположения
        container.setLayout(new FlowLayout());

        Button try_again_button = new Button("Try again...");
        try_again_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                Game.getInstance().restartGame();
                try_again_dialog.setVisible(false);
                game_window.setTitleMessage("Game XO");

            }
        });
        try_again_button.setVisible(true);

        Button end_button = new Button("end");
        end_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Game.getInstance().isEnd = false;
               //dialog.dispose();
                System.exit(1);
            }
        });

        end_button.setVisible(true);


        container.add(try_again_button);
        container.add(end_button);
        dialog.setSize(200, 100);
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

        String[][] matrix = Game.getInstance().board.getField();
        //  String[][] matrix = new String[][]{{"O","X","+"},{"X","O","X"},{"X","X","O"},};
        g.drawImage(background, 0, 0, null);
        g.drawImage(field, 200, 30, null);

//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix.length; j++) {
//                System.out.print(matrix[j][i]);
//            }
//            System.out.println();
//        }
//        System.out.println();

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

        if (game_window.title_message != null) {
            game_window.setTitle(game_window.title_message);
        }
        if (!Game.getInstance().getAlive()|| Game.getInstance().board.isFull()) {
            try_again_dialog.setVisible(true);


        }
    }

    public void run() throws InterruptedException {
       // System.out.println("Run");
        // Game game = Game.getInstance();
        int count = 0;
        //System.out.println(Game.getInstance().getAlive());

        while (!Game.getInstance().isEnd) {


            while (Game.getInstance().getAlive()) {
                // System.out.println(count++);
                if (Game.getInstance().board.somebodyWin()) {
                    setTitleMessage("You win!!!");
                    break;
                }
                if (Game.getInstance().board.isFull()) {
                    setTitleMessage("Nobody wins...");
                    break;
                }

                Game.getInstance().board.analysisO();
                //game.board.printField();


                if (Game.getInstance().board.somebodyWin()) {
                    setTitleMessage("You wOn!!!");

                }
                if (Game.getInstance().board.isFull()) {
                    setTitleMessage("Nobody wins...");
                    break;
                }

            }

        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        getInstance().setParam().run();


    }
}
