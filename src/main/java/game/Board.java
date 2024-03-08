package game;

import brain.Controller;
import snake.Snake;
import snake.SnakeComponent;
import snake.SnakeFood;
import enums.Direction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JFrame implements ActionListener, KeyListener {
    private final JLabel[][] board;
    private SnakeFood food;
    private final Snake snake;
    private final int boardSize = 20;

    Controller controller;

    public Board() {
        setTitle("SnakeGui.Snake");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        food = new SnakeFood(boardSize);
        board = new JLabel[boardSize][boardSize];
        snake = new Snake(7, 6, 5, boardSize);
        controller = new Controller(4,14,4);

        drawBoard();
        generateFrame();
        addKeyListener(this);

        Timer timer = new Timer(200, this);
        timer.start();
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
            food = new SnakeFood(boardSize);
        }

        drawSnake();
        board[snake.getSnake().getFirst().getX()][snake.getSnake().getFirst().getY()].setText("O");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Direction direction = controller.getDirection((new int[]{ food.getXPos(), food.getYPos(), snake.getSnake().getFirst().getX(), snake.getSnake().getFirst().getY()}));
        System.out.println(direction);
        snake.setDirection(direction);
        generateFrame();
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
