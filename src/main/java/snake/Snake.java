package snake;

import enums.Direction;

import java.util.LinkedList;

public class Snake {

    private final LinkedList<SnakeComponent> snakeBody;
    private Direction direction;
    private final int boardSize;

    public Snake(int x, int y, int snakeLength, int boardSize) {
        snakeBody = new LinkedList<>();
        for (int i = 0; i < snakeLength; i++) {
            snakeBody.add(new SnakeComponent(x, y - i));
        }
        direction = Direction.RIGHT;
        this.boardSize = boardSize;
    }

    public void eat(SnakeFood food) {
    }

    public void move() {
        SnakeComponent head = snakeBody.getFirst();

        int newX = head.getX() + direction.getX();
        int newY = head.getY() + direction.getY();
        SnakeComponent newHead;

        if (newX == boardSize) {
            newHead = new SnakeComponent(0, head.getY());
        }
        else if (newX == -1) {
            newHead = new SnakeComponent(boardSize - 1, head.getY());
        }
        else if (newY == boardSize) {
            newHead = new SnakeComponent(head.getX(), 0);
        }
        else if (newY == -1) {
            newHead = new SnakeComponent(head.getX(), boardSize - 1);
        }
        else {
            newHead = new SnakeComponent(newX, newY);
        }

        snakeBody.addFirst(newHead);
        snakeBody.removeLast();
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public LinkedList<SnakeComponent> getSnake() {
        return snakeBody;
    }

    @Override
    public String toString() {
        return "Snake{" +
                "snakeHead=" + snakeBody.getFirst() +
                ", direction=" + direction +
                ", boardSize=" + boardSize +
                '}';
    }
}

