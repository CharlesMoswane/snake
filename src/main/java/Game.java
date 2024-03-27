import javax.swing.*;

public class Game {
    private Board board;
    public Game(){
        Board board = new Board();
        board.setVisible(true);
    }

    public void start(){
        Timer timer = new Timer(200, board);
        timer.start();
    }

    public void pause(){

    }

    public void end(){

    }
}
