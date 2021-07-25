import java.security.SecureRandom;

public class SnakeFood {

    private final int boardSize;
    private final SecureRandom randomNumbers;

    public SnakeFood(int boardSize){
        this.boardSize = boardSize;
        randomNumbers = new SecureRandom();
    }

    public int generateXPos(){
        int x = randomNumbers.nextInt(boardSize);
        return x;
    }

    public int generateYPos(){
        int y = randomNumbers.nextInt(boardSize);
        return y;
    }

}
