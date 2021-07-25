import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SnakeGUI extends JFrame implements ActionListener {

    private final GridLayout gridLayout;
    private final JLabel[][] labels;
    private final SnakeFood food;
    private final int boardSize;
    private Timer timer;
    private int foodX;
    private int foodY;

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

        //Experiment 1
//        snake = new int[4][4];


        setGrid(labels);
        setLayout(gridLayout);
        labels[foodX][foodX].setVisible(true);
        for (int i = 6; i < 15; i++){
            labels[2][i].setVisible(true);
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
        labels[foodX][foodX].setVisible(false);
        foodX = food.generateXPos();
        foodY = food.generateYPos();
        labels[foodX][foodX].setVisible(true);
    }
}
