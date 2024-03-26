package snake;

import java.security.SecureRandom;

public class SnakeFood {

    private final SecureRandom randomNumbers;
    private int xPos;
    private int yPos;

    public SnakeFood(int boardSize){
        randomNumbers = new SecureRandom();

        xPos = randomNumbers.nextInt(boardSize);
        yPos = randomNumbers.nextInt(boardSize);
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }
}
