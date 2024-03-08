package game;

import brain.Controller;
import enums.Direction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements ActionListener {
    private Board board;
    public Game(){
        Board board = new Board();
        board.setVisible(true);
    }

    public void start(){
        Timer timer = new Timer(200, this);
        timer.start();
    }

    public void pause(){

    }

    public void end(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Controller controller = new Controller(4,14,4);
        Direction direction = controller.getDirection((new int[]{ food.getXPos(), food.getYPos(), snake.getSnake().getFirst().getX(), snake.getSnake().getFirst().getY()}));
        System.out.println(direction);
        snake.setDirection(direction);
        generateFrame();
    }
}
