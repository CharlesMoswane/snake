import java.util.LinkedList;
import java.util.List;

public class Snake {

    private LinkedList<SnakeComponent> snake;

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

    public LinkedList<SnakeComponent> getSnake(){
        return snake;
    }

    //(int direction)
    public void move(){
//        switch (direction){
//            case 1:
//                break;
//            case 2:
//                break;
//            case 3:
//                break;
//            default:
//                break;
//        }
//        for (int i = 0; i< size; i++){
//            snake.add(new SnakeComponent(startingRow, i));
//        }

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
