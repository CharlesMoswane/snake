package game;

import snake.Snake;
import snake.SnakeComponent;
import snake.SnakeFood;
import enums.Direction;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JFrame implements KeyListener {
    private final JLabel[][] board;
    private final SnakeFood food;
    private final Snake snake;
    private final int boardSize;

    public Board(Snake snake, SnakeFood food, int boardSize) {
        setTitle("SnakeGui.Snake");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board = new JLabel[boardSize][boardSize];

        this.snake = snake;
        this.food = food;
        this.boardSize = boardSize;

        drawBoard();
        generateFrame();
        addKeyListener(this);
    }

    public void drawBoard() {
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

    public void drawSnake() {
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

        generateFrame();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
