import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args){
        System.out.println("Hello snake.");
        startGame();

        //Gui Test
        SnakeGUI snakeFrame = new SnakeGUI();
        snakeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        snakeFrame.setSize(500, 500);
        snakeFrame.setVisible(true);
    }

    public static void startGame(){
        //
    }
}
