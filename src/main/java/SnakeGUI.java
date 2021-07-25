import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SnakeGUI extends JFrame{

    private final GridLayout gridLayout;
    private final JLabel[][] labels;

    //No argument constructor
    public SnakeGUI(){
        super("Snake");
        gridLayout = new GridLayout(20,20);
        labels = new JLabel[20][20];

        setGrid(labels);
        labels[17][15].setVisible(true);
        setLayout(gridLayout);
    }

    private void setGrid(JLabel[][] labels){
        for (int i = 0; i < labels.length; i++){
            for (int j = 0; j < labels.length; j++){
                labels[i][j] = new JLabel("X");
                add(labels[i][j]);
                labels[i][j].setVisible(false);
            }
        }
        labels[15][17].setVisible(true);
    }

}
