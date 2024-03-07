package game;

import snake.Snake;
import snake.SnakeComponent;
import snake.SnakeFood;
import enums.Direction;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Board extends JFrame implements KeyListener {
    private final JLabel[][] board;
    private final SnakeFood food;
    private final Snake snake;
    private final int boardSize;
    private final String timestamp;
    private final File dir;

    public Board(Snake snake, SnakeFood food, int boardSize) {
        setTitle("SnakeGui.Snake");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board = new JLabel[boardSize][boardSize];

        this.snake = snake;
        this.food = food;
        this.boardSize = boardSize;

        Date currentDate = new Date();
        timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(currentDate);

        dir = new File("C:\\Users\\cmosw\\Desktop\\OneDrive\\My Documents\\8. Creation\\1. My Projects\\1. AI\\1. Snake\\1. Data\\");
        if (!dir.exists()){
            dir.mkdirs();
        }

        drawBoard();
        generateFrame();
        addKeyListener(this);
    }

    private void drawBoard() {
        JPanel panel = new JPanel();
        panel.setLayout(new java.awt.GridLayout(boardSize, boardSize));

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                board[i][j] = new JLabel("X");
                board[i][j].setOpaque(true);
                board[i][j].setVisible(false);
                panel.add(board[i][j]);
            }
        }

        add(panel);
    }

    private void drawSnake() {
        for (SnakeComponent snakeComponent : snake.getSnake()) {
            board[snakeComponent.getX()][snakeComponent.getY()].setVisible(true);
        }
    }

    public void generateFrame(){
        board[food.getXPos()][food.getYPos()].setVisible(true);

        board[snake.getSnake().getLast().getX()][snake.getSnake().getLast().getY()].setVisible(false);
        board[snake.getSnake().getFirst().getX()][snake.getSnake().getFirst().getY()].setText("X");
        snake.move();

        if ((food.getXPos() == snake.getSnake().getLast().getX()) && (food.getYPos() == snake.getSnake().getLast().getY())){
            snake.eat(food);
            food.generateNewFood();
        }

        drawSnake();
        board[snake.getSnake().getFirst().getX()][snake.getSnake().getFirst().getY()].setText("O");
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(dir + "keylog" + timestamp + ".txt", true))){
            switch (e.getKeyCode()){
                case 37:
                    snake.setDirection(Direction.LEFT);
                    break;
                case 38:
                    snake.setDirection(Direction.UP);
                    break;
                case 39:
                    snake.setDirection(Direction.RIGHT);
                    break;
                case 40:
                    snake.setDirection(Direction.DOWN);
                    break;
            }
            writer.write(snake + ", " + food + "\n");
        } catch (Exception ex){
            ex.printStackTrace();
        }

        generateFrame();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
