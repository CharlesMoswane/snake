import java.util.LinkedList;

public class Snake {

    private final LinkedList<SnakeComponent> snakeBody;
    private Direction direction;

    public Snake(int x, int y, int snakeLength) {
        snakeBody = new LinkedList<>();
        for (int i = 0; i < snakeLength; i++) {
            snakeBody.add(new SnakeComponent(x, y - i));
        }
        direction = Direction.RIGHT;
    }

    public void eat(SnakeFood food) {
    }

    public void move() {
        SnakeComponent head = snakeBody.getFirst();
        SnakeComponent newHead = new SnakeComponent(head.getX() + direction.getX(), head.getY() + direction.getY());
        snakeBody.addFirst(newHead);
        snakeBody.removeLast();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public LinkedList<SnakeComponent> getSnake() {
        return snakeBody;
    }
}

