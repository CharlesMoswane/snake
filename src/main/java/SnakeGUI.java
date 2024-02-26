import snake.Snake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class SnakeGUI extends JFrame implements ActionListener, KeyListener {

    private final JLabel[][] board;
    private SnakeFood food;
    private Snake snake;
    private LinkedList<Snake.SnakeComponent> snakeBody;
    private int boardSize;

    public SnakeGUI(int boardSize){
        super("snake.Snake");

        this.boardSize = boardSize;

        GridLayout gridLayout = new GridLayout(boardSize, boardSize);
        board = new JLabel[boardSize][boardSize];
        Timer timer = new Timer(200, this);

        addKeyListener(this);

        food = new SnakeFood(boardSize);
        snake = new Snake(7,3, boardSize);
        snakeBody = snake.getSnake();

        setGrid();
        setLayout(gridLayout);

        generateFrame();
        timer.start();
    }

    private void setGrid(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                board[i][j] = new JLabel("X");
                add(board[i][j]);
                board[i][j].setVisible(false);
            }
        }
        for (Snake.SnakeComponent snakeComponent: snakeBody){
            board[snakeComponent.getX()][snakeComponent.getY()].setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        generateFrame();
    }

    private void generateFrame(){
        board[food.getXPos()][food.getYPos()].setVisible(true);

        board[snakeBody.getFirst().getX()][snakeBody.getFirst().getY()].setVisible(false);
        board[snakeBody.getLast().getX()][snakeBody.getLast().getY()].setText("X");
        snake.move();

        if ((food.getXPos() == snakeBody.getLast().getX()) && (food.getYPos() == snakeBody.getLast().getY())){
            snake.eat(food);
            food = new SnakeFood(boardSize);
        }

        board[snakeBody.getLast().getX()][snakeBody.getLast().getY()].setVisible(true);
        board[snakeBody.getLast().getX()][snakeBody.getLast().getY()].setText("O");
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
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
