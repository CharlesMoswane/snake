package game;

import brain.Controller;
import enums.Direction;
import snake.Snake;
import snake.SnakeFood;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements ActionListener {
    private final Timer timer;
    private final Snake snake;
    private final SnakeFood food;
    private final Board board;

    public Game(){
        int boardSize = 20;
        snake = new Snake(7,6,5, boardSize);
        food = new SnakeFood(boardSize);
        board = new Board(snake, food, boardSize);
        timer = new Timer(200, this);
        board.setVisible(true);
    }

    public void start(){
        timer.start();
    }

    public void pause(){
        timer.stop();
    }

    public void end(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        Controller controller = new Controller(4,14,4);
//        Direction direction = controller.getDirection((new int[]{ food.getXPos(), food.getYPos(), snake.getSnake().getFirst().getX(), snake.getSnake().getFirst().getY()}));
//        System.out.println(direction);
//        snake.setDirection(direction);
        board.generateFrame();
    }
}
