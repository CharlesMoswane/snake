import java.util.LinkedList;

public class Snake {

    private LinkedList<SnakeComponent> snakeBody;
    private Direction direction;

    public Snake(int x, int y, int boardSize) {
        snakeBody = new LinkedList<>();
        snakeBody.add(new SnakeComponent(x, y));
        this.direction = Direction.RIGHT;
    }

    public void eat(SnakeFood food) {
    }

    public void move() {

    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public LinkedList<SnakeComponent> getSnake() {
        return snakeBody;
    }
}

