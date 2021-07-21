import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args){
        System.out.println("Hello snake.");
        startGame();

        //Gui Test
        SnakeGUI textAreaFrame = new SnakeGUI();
        textAreaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textAreaFrame.setSize(425, 200);
        textAreaFrame.setVisible(true);
    }

    public static void startGame(){
        JOptionPane.showMessageDialog(null,"Hey world");
    }
}
