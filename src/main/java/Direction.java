public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public int getY() {
        if (this == LEFT)
            return -1;
        if (this == RIGHT)
            return 1;
        return 0;
    }

    public int getX() {
        if (this == UP)
            return -1;
        if (this == DOWN)
            return 1;
        return 0;
    }
}
