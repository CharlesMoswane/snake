package snake;

import java.security.SecureRandom;

public class SnakeFood {

    private final SecureRandom randomNumbers;

    private final int boardSize;
    private int xPos;
    private int yPos;

    public SnakeFood(int boardSize){
        randomNumbers = new SecureRandom();
        this.boardSize = boardSize;

        xPos = randomNumbers.nextInt(boardSize);
        yPos = randomNumbers.nextInt(boardSize);
    }

    public void generateNewFood(){
        xPos = randomNumbers.nextInt(boardSize);
        yPos = randomNumbers.nextInt(boardSize);
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    @Override
    public String toString() {
        return "SnakeFood{" +
                "xPos=" + xPos +
                ", yPos=" + yPos +
                '}';
    }
}
