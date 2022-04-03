import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Random;

public class GameWindow extends JFrame {
    private static GameWindow game_window;
    private static Game game = Game.getInstance();
    private static Random random = new Random();

    private static Image background;
    private static Image field;
    private static Image o;
    private static Image x;
    private static Image red_line;
    private static Image red_column;
    private static Image red_diagonal;
    private static Image red_main_diagonal;
    private static Image hand;
    private static Image avers;
    private static Image revers;

    private static JDialog try_again_dialog;
    private static JDialog define_queue_dialog;
    private static JDialog define_queue_dialog_final;

    private String title_message;

    public static GameWindow getInstance() throws IOException {
        return game_window == null ? game_window = new GameWindow() : game_window;
    }

    private GameWindow() throws IOException {
        background = ImageIO.read(GameWindow.class.getResourceAsStream("list.png"));
        field = ImageIO.read(GameWindow.class.getResourceAsStream("field.png"));
        o = ImageIO.read(GameWindow.class.getResourceAsStream("o.png"));
        x = ImageIO.read(GameWindow.class.getResourceAsStream("x.png"));

        hand = ImageIO.read(GameWindow.class.getResourceAsStream("hand.png"));
        avers = ImageIO.read(GameWindow.class.getResourceAsStream("avers.png"));
        revers = ImageIO.read(GameWindow.class.getResourceAsStream("revers.png"));

        red_line = ImageIO.read(GameWindow.class.getResourceAsStream("red_line.png"));
        red_column = ImageIO.read(GameWindow.class.getResourceAsStream("red_column.png"));
        red_diagonal = ImageIO.read(GameWindow.class.getResourceAsStream("diagonal.png"));
        red_main_diagonal = ImageIO.read(GameWindow.class.getResourceAsStream("main_diagonal.png"));
        try_again_dialog = GameWindow.getTryAgainDialog();
        define_queue_dialog = GameWindow.getDefineQueueDialog();
        define_queue_dialog_final = GameWindow.getDefineQueueDialogFinal();

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
                        game.drawX(1);
                    }
                    if (x > 320 && x < 420) {
                        game.drawX(2);
                    }
                    if (x > 420 && x < 520) {
                        game.drawX(3);
                    }
                }
                if (y > 160 && y < 260) {
                    if (x > 220 && x < 320) {
                        game.drawX(4);
                    }
                    if (x > 320 && x < 420) {
                        game.drawX(5);
                    }
                    if (x > 420 && x < 520) {
                        game.drawX(6);
                    }
                }
                if (y > 260 && y < 360) {
                    if (x > 220 && x < 320) {
                        game.drawX(7);
                    }
                    if (x > 320 && x < 420) {
                        game.drawX(8);
                    }
                    if (x > 420 && x < 520) {
                        game.drawX(9);
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

                Runtime.getRuntime().gc();
                game.restartGame();
                try_again_dialog.setVisible(false);
                game_window.setTitleMessage("Game XO");

            }
        });

        try_again_button.setVisible(true);

        Button end_button = new Button("end");
        end_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Game.getInstance().isEnd = false;
                Runtime.getRuntime().exit(0);
            }
        });

        end_button.setVisible(true);
        container.add(try_again_button);
        container.add(end_button);
        dialog.setSize(200, 100);
        return dialog;
    }

    private static JDialog getDefineQueueDialog() {
        final JDialog dialog = new JDialog();
        dialog.setLocation(200, 300);

        // Панель содержимого
        Container container = dialog.getContentPane();
        // Устанавливаем менеджер последовательного расположения
        container.setLayout(new FlowLayout());

        Button toss_acoin_button = new Button("Toss a coin...");
        toss_acoin_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                define_queue_dialog.setVisible(false);
                game.status = Status.DEFINE_A_QUEUE;
                game.coin = (random.nextBoolean()) ? Coin.REVERS : Coin.AVERS;


            }
        });
        toss_acoin_button.setVisible(true);
        container.add(toss_acoin_button);

        dialog.setSize(200, 100);
        return dialog;
    }

    private static JDialog getDefineQueueDialogFinal() {
        final JDialog dialog = new JDialog();
        dialog.setLocation(200, 300);

        // Панель содержимого
        Container container = dialog.getContentPane();
        // Устанавливаем менеджер последовательного расположения
        container.setLayout(new FlowLayout());

        Button continue_button = new Button("Continue");
        continue_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                Game game = Game.getInstance();
                define_queue_dialog_final.setVisible(false);

                if (game.coin == Coin.AVERS) {
                    game.status = Status.ATTACK;
                    game.board.is_step_possible = true;
                } else {
                    game.status = Status.PROTECTION;
                }


            }
        });
        continue_button.setVisible(true);
        container.add(continue_button);

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
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    private static void onRepaint(Graphics g) {

        g.drawImage(background, 0, 0, null);

        if (game.status == Status.BEGIN) {
            game_window.defineQueue(g);
        } else if (game.status == Status.DEFINE_A_QUEUE) {
            game_window.printCoin(g);
        } else {
            game_window.printField(g);
        }

        if (!game.getAlive()) {
            game_window.drawRedLine(g);
        }

        if (game_window.title_message != null) {
            game_window.setTitle(game_window.title_message);
        }
        if (!game.getAlive() || game.board.isFull()) {
            try_again_dialog.setVisible(true);
        }
    }

    public void printField(Graphics g) {
        g.drawImage(field, 200, 30, null);
        String[][] matrix = game.board.getField();
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
    }

    public void printCoin(Graphics g) {
        define_queue_dialog_final.setVisible(true);
        String title = (game.coin == Coin.REVERS) ? "You will be the first..." : "I'll be the first...";
        define_queue_dialog_final.setTitle(title);

        if (game.coin == Coin.AVERS) {
            g.drawImage(avers, 280, 100, null);
        }

        if (game.coin == Coin.REVERS) {
            g.drawImage(revers, 280, 100, null);
        }
    }

    public void drawRedLine(Graphics g) {
        int line_winner = Game.getInstance().board.getLine_winner();
        if (line_winner > 0 && line_winner < 4) {
            g.drawImage(red_line, 240, 80 + (100 * (line_winner - 1)), null);
        }

        if (line_winner > 3 && line_winner < 7) {
            g.drawImage(red_column, 240 + (100 * (line_winner - 4)), 80, null);
        }

        if (line_winner == 7) {
            g.drawImage(red_main_diagonal, 210, 50, null);
        }
        if (line_winner == 8) {
            g.drawImage(red_diagonal, 240, 50, null);
        }
    }

    public void defineQueue(Graphics g) {
        g.drawImage(hand, 260, 50, null);
        define_queue_dialog.setVisible(true);
    }

    public void run() {

        while (!game.isEnd) {
            System.out.checkError();// без взбадривания System.out - не видит статуса.

            if (game.status == Status.PROTECTION) {
                protectedRun();
            }

            if (game.status == Status.ATTACK) {
                attackRun();
            }
        }
    }

    private void protectedRun() {


        while (game.getAlive() && !game.board.isFull()) {

            game.analysisProtection();

            if (game.board.somebodyWin() && game.board.getIs_X_win()) {
                setTitleMessage("You win!!!");
                break;
            }

            if (game.board.somebodyWin() && game.board.getIs_O_win()) {
                setTitleMessage("You wOn!!!");
                break;

            }

            if (game.board.isFull()) {
                setTitleMessage("Nobody wins...");
                break;
            }

        }

    }

    private void attackRun() {

        while (game.getAlive() && !game.board.isFull()) {

            game.analysisAttack();

            if (game.board.somebodyWin() && game.board.getIs_X_win()) {
                setTitleMessage("You win!!!");
                break;
            }

            if (game.board.somebodyWin() && game.board.getIs_O_win()) {
                setTitleMessage("You wOn!!!");
                break;

            }

            if (Game.getInstance().board.isFull()) {
                setTitleMessage("Nobody wins...");
                break;
            }

        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        getInstance().setParam().run();


    }
}
