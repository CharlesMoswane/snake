import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SnakeGUI extends JFrame{

    private final JButton startButton; // initiates copying of text
    private final JLabel startLabel;

    //No argument constructor
    public SnakeGUI(){
        super("Snake");
        Box box = Box.createVerticalBox(); // create box

        startLabel = new JLabel("X");
        startLabel.setSize(20,20);
        startLabel.setBackground(Color.black);
        box.add(startLabel);

        startButton = new JButton("Start"); // create copy button
        box.add(startButton); // add copy button to box
        startButton.addActionListener(this::actionPerformed);

        add(box);
    }

    public void actionPerformed(ActionEvent event) {

        if (startButton.getText() == "Start") {
            startButton.setText("Stop");
            startLabel.setVisible(true);
        }
        else {
            startButton.setText("Start");
            startLabel.setVisible(false);
        }
    }

}
