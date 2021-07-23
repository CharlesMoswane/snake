import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SnakeGUI extends JFrame{

    private final JTextArea displayArea; // displays demo string
    private final JButton startButton; // initiates copying of text
    private final JLabel startLabel;

    //No argument constructor
    public SnakeGUI(){
        super("Snake");
        Box box = Box.createVerticalBox(); // create box
        String demo = "Snakes poisson. Pitbulls are the pits.";
        displayArea = new JTextArea(demo, 40, 40);
        displayArea.setEditable(false);
        box.add(displayArea); // add scrollpane

        startLabel = new JLabel("X");
        startLabel.setSize(1,1);
        box.add(startLabel);

        startButton = new JButton("Start"); // create copy button
        box.add(startButton); // add copy button to box
        startButton.addActionListener(
                new ActionListener() {
                    // set text in textArea2 to selected text from displayArea
                    @Override
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
                });

        add(box);
    }


}
