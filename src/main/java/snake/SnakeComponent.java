package snake;

public class SnakeComponent {
    private final int xPos, yPos;

    public SnakeComponent(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    @Override
    public String toString() {
        return "SnakeComponent{" +
                "xPos=" + xPos +
                ", yPos=" + yPos +
                '}';
    }
}
