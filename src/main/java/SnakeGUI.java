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

    //No argument constructor
    public SnakeGUI(int boardSize){
        super("Snake");
        this.boardSize = boardSize;
        gridLayout = new GridLayout(boardSize,boardSize);
        labels = new JLabel[20][20];
        food = new SnakeFood(boardSize);
        timer = new Timer(1000,this);

        setGrid(labels);
        setLayout(gridLayout);
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
        labels[food.generateXPos()][food.generateYPos()].setVisible(true);
    }
}
