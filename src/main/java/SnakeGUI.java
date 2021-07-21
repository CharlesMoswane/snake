import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class SnakeGUI extends JFrame{

    private final JTextArea displayArea; // displays demo string
    private final JButton startButton; // initiates copying of text

    //No argument constructor
    public SnakeGUI(){
        super("Snake");
        Box box = Box.createVerticalBox(); // create box
        String demo = "This is a demo string to\n" +
                "illustrate copying text\nfrom one textarea to \n" +
                "another textarea using an\nexternal event\n";
        displayArea = new JTextArea(demo, 20, 20);
        displayArea.setEditable(false);
        box.add(displayArea); // add scrollpane

        startButton = new JButton("Start"); // create copy button
        box.add(startButton); // add copy button to box
        startButton.addActionListener(
                new ActionListener() {
                    // set text in textArea2 to selected text from displayArea
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        //reset screen
//                        startButton.setText("Stop");
                        if (startButton.getText() == "Start")
                            startButton.setText("Stop");
                        else
                            startButton.setText("Start");
                    }
                });

        add(box);
    }


}
