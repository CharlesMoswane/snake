import javax.swing.*;

public class Board extends JFrame {
    private JLabel[][] board;

    public Board() {
        setTitle("Snake");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board = new JLabel[20][20];
        drawBoard();
    }

    public void drawBoard() {
        JPanel panel = new JPanel();
        panel.setLayout(new java.awt.GridLayout(20, 20));

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                board[i][j] = new JLabel("x");
                board[i][j].setOpaque(true);
                board[i][j].setVisible(true);
                board[i][j].setBackground(java.awt.Color.WHITE);
                panel.add(board[i][j]);
            }
        }

        add(panel);
    }
}
