import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.LinkedList;

public class SnakeGUI extends JFrame implements ActionListener {

    private final GridLayout gridLayout;
    private final JLabel[][] labels;
    private final SnakeFood food;
    private final int boardSize;
    private Timer timer;
    private int foodX;
    private int foodY;
    private Snake snake;
    private LinkedList<Snake.SnakeComponent> snakeBody;

    //Experiment 1
//    private int[][] snake;

    public SnakeGUI(int boardSize){
        super("Snake");
        this.boardSize = boardSize;
        gridLayout = new GridLayout(boardSize,boardSize);
        labels = new JLabel[boardSize][boardSize];
        food = new SnakeFood(boardSize);
        timer = new Timer(1000,this);
        foodX = food.generateXPos();
        foodY = food.generateYPos();
        snake = new Snake(7,3);
        snakeBody = snake.getSnake();

        //Experiment 1
//        snake = new int[4][4];


        setGrid(labels);
        setLayout(gridLayout);
        labels[foodX][foodY].setVisible(true);

        for (Snake.SnakeComponent snakeComponent: snakeBody){
            labels[snakeComponent.getX()][snakeComponent.getY()].setVisible(true);
        }
        play();
    }

    private void setGrid(JLabel[][] labels){
        for (int i = 0; i < labels.length; i++){
            for (int j = 0; j < labels.length; j++){
                labels[i][j] = new JLabel("X");
                add(labels[i][j]);
                labels[i][j].setVisible(false);
            }
        }
    }

    private void play(){
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        labels[foodX][foodY].setVisible(false);
        foodX = food.generateXPos();
        foodY = food.generateYPos();
        labels[foodX][foodY].setVisible(true);
//        printSnake();
    }

    private void printSnake(){
        labels[snakeBody.peekFirst().getX()][snakeBody.peekFirst().getY()].setVisible(false);
//        snake.move();
        labels[snakeBody.peekLast().getX()][snakeBody.peekLast().getY()].setVisible(false);
    }
}
