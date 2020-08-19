package snakepackage;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import enums.GridSize;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author jd-
 *
 */
public class SnakeApp {

    private static SnakeApp app;
    public static final int MAX_THREADS = 8;
    Snake[] snakes = new Snake[MAX_THREADS];
    private static final Cell[] spawn = {
        new Cell(1, (GridSize.GRID_HEIGHT / 2) / 2),
        new Cell(GridSize.GRID_WIDTH - 2,
        3 * (GridSize.GRID_HEIGHT / 2) / 2),
        new Cell(3 * (GridSize.GRID_WIDTH / 2) / 2, 1),
        new Cell((GridSize.GRID_WIDTH / 2) / 2, GridSize.GRID_HEIGHT - 2),
        new Cell(1, 3 * (GridSize.GRID_HEIGHT / 2) / 2),
        new Cell(GridSize.GRID_WIDTH - 2, (GridSize.GRID_HEIGHT / 2) / 2),
        new Cell((GridSize.GRID_WIDTH / 2) / 2, 1),
        new Cell(3 * (GridSize.GRID_WIDTH / 2) / 2,
        GridSize.GRID_HEIGHT - 2)};
    private JFrame frame;
    private static Board board;
    int nr_selected = 0;
    Thread[] thread = new Thread[MAX_THREADS];
    private int firstSnakeDead = -1;

    public SnakeApp() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame = new JFrame("The Snake Race");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(618, 640);
        frame.setSize(GridSize.GRID_WIDTH * GridSize.WIDTH_BOX + 17,
                GridSize.GRID_HEIGHT * GridSize.HEIGH_BOX + 40);
        frame.setLocation(dimension.width / 2 - frame.getWidth() / 2,
                dimension.height / 2 - frame.getHeight() / 2);
        board = new Board();

        frame.add(board, BorderLayout.CENTER);

        JPanel actionsBPabel = new JPanel();
        actionsBPabel.setLayout(new FlowLayout());
        JButton pauseButton = new JButton("Pause");
        JButton resumeButton = new JButton("Resume");
        actionsBPabel.add(pauseButton);
        actionsBPabel.add(resumeButton);
        frame.add(actionsBPabel, BorderLayout.SOUTH);

        pauseButton.addActionListener((actionEvent) -> {
            app.pauseGame();
        });
        resumeButton.addActionListener((actionEvent) -> {
            app.resumeGame();
        });

    }

    public static void main(String[] args) {
        app = new SnakeApp();
        app.init();
    }

    private void pauseGame() {
        Snake longest = snakes[0];
        int longestSnake = 1;
        for (Snake snake : snakes) {
            snake.pauseSnake();
        }

        for (int i = 0; i != MAX_THREADS; i++) {
            if (snakes[i].snakeSize() > longest.snakeSize()) {
                longest = snakes[i];
                longestSnake = i + 1;
            }

            if (firstSnakeDead == -1 && snakes[i].isSnakeEnd()) {
                firstSnakeDead = i + 1;
            }
        }

        if (firstSnakeDead != -1) {
            JOptionPane.showMessageDialog(frame, "Longest snake: " + longestSnake + ". Size: " + longest.snakeSize() + ". \nWorst snake: " + firstSnakeDead);
        } else {
            JOptionPane.showMessageDialog(frame, "Longest snake: " + longestSnake + ". Size: " + longest.snakeSize());
        }
    }

    private void resumeGame() {
        for (Snake snake : snakes) {
            snake.resumeSnake();
        }
    }

    private void init() {

        for (int i = 0; i != MAX_THREADS; i++) {

            snakes[i] = new Snake(i + 1, spawn[i], i + 1);
            snakes[i].addObserver(board);
            thread[i] = new Thread(snakes[i]);
            thread[i].start();
        }

        frame.setVisible(true);

        while (true) {
            int x = 0;
            for (int i = 0; i != MAX_THREADS; i++) {
                if (snakes[i].isSnakeEnd() == true) {
                    x++;
                }
            }
            if (x == MAX_THREADS) {
                break;
            }
        }

        System.out.println("Thread (snake) status:");
        for (int i = 0; i != MAX_THREADS; i++) {
            System.out.println("[" + i + "] :" + thread[i].getState());
        }
    }

    public static SnakeApp getApp() {
        return app;
    }

}
