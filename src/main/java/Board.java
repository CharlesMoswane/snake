import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JFrame implements ActionListener, KeyListener {
    private final JLabel[][] board;
    private SnakeFood food;
    private Snake snake;
    private int boardSize = 20;

    public Board() {
        setTitle("Snake");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        food = new SnakeFood(boardSize);

        board = new JLabel[boardSize][boardSize];
        drawBoard();
        addKeyListener(this);
        snake = new Snake(7, 6, 5);
        drawSnake();
    }

    public void drawBoard() {
        JPanel panel = new JPanel();
        panel.setLayout(new java.awt.GridLayout(boardSize, boardSize));

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                board[i][j] = new JLabel("X");
                board[i][j].setOpaque(true);
                board[i][j].setVisible(false);
                panel.add(board[i][j]);
            }
        }

        add(panel);
    }

    public void drawSnake() {
        for (SnakeComponent snakeComponent : snake.getSnake()) {
            board[snakeComponent.getX()][snakeComponent.getY()].setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        generateFrame();
    }

    private void generateFrame(){
        board[food.getXPos()][food.getYPos()].setVisible(true);

        board[snake.getSnake().getLast().getX()][snake.getSnake().getLast().getY()].setVisible(false);
        board[snake.getSnake().getFirst().getX()][snake.getSnake().getFirst().getY()].setText("X");
        snake.move();

        if ((food.getXPos() == snake.getSnake().getLast().getX()) && (food.getYPos() == snake.getSnake().getLast().getY())){
            snake.eat(food);
            food = new SnakeFood(boardSize);
        }

//        drawSnake();
        board[snake.getSnake().getFirst().getX()][snake.getSnake().getFirst().getY()].setText("O");
//        board[snake.getSnake().getFirst().getX()][snake.getSnake().getFirst().getY()].setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case 37:
                snake.setDirection(Direction.LEFT);
                System.out.println("LEFT");
                break;
            case 38:
                snake.setDirection(Direction.UP);
                System.out.println("UP");
                break;
            case 39:
                snake.setDirection(Direction.RIGHT);
                System.out.println("RIGHT");
                break;
            case 40:
                snake.setDirection(Direction.DOWN);
                System.out.println("DOWN");
                break;
        }

        generateFrame();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
