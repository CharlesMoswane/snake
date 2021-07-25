import java.util.LinkedList;
import java.util.List;

public class Snake {

    private List<SnakeComponent> snake;

    private int size;
    private int startingRow;

    public Snake(int size, int startingRow){
        this.size = size;
        this.startingRow = startingRow;
        snake = new LinkedList<>();

        for (int i = 0; i< size; i++){
            snake.add(new SnakeComponent(startingRow, i));
        }
    }

    public List<SnakeComponent> getSnake(){
        return snake;
    }

    public void move(){

    }

    public int getSize() {
        return size;
    }

    class SnakeComponent{

        private int x;
        private int y;

        public SnakeComponent(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
