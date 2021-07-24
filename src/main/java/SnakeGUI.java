import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SnakeGUI extends JFrame{

    private final JButton startButton; // initiates copying of text
    private final JLabel startLabel;
    private final JLabel startLabel2;
    private final GridLayout gridLayout;

    //No argument constructor
    public SnakeGUI(){
        super("Snake"); // create box
        gridLayout = new GridLayout(2,2);
        startLabel = new JLabel("X");
        startLabel2 = new JLabel("X");
        startButton = new JButton("Stop");

        startButton.addActionListener(this::actionPerformed);
        setLayout(gridLayout);
        add(startLabel);
        add(startLabel2);
        add(startButton);
    }

    public void actionPerformed(ActionEvent event) {
        if (startButton.getText().equals("Start")) {
            startButton.setText("Stop");
            startLabel.setVisible(true);
        }
        else {
            startButton.setText("Start");
            startLabel.setVisible(false);
        }
    }

}
