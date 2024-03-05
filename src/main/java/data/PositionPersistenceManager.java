package data;

import com.google.gson.Gson;
import snake.Snake;
import snake.SnakeFood;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class PositionPersistenceManager {
    private final Gson gson;
    private final  String dir;

    public PositionPersistenceManager(String dir) {
        this.gson = new Gson();
        this.dir = dir;
    }

    public void logPosition(Snake snake, SnakeFood food) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(dir + "\\keylog.json", true))){
            // Convert the snake and food objects to JSON strings
            String snakeJson = gson.toJson(snake);
            System.out.println(snakeJson);
            String foodJson = gson.toJson(food);
            System.out.println(foodJson);

            // Write the JSON strings to the file
            writer.write("Snake: " + snakeJson + ", Food: " + foodJson + "\n");
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public Map<String, List<double[]>> loadPositions(String filePath) {
        Map<String, List<double[]>> dataMap = new HashMap<>();
        dataMap.put("inputs", new ArrayList<>());
        dataMap.put("outputs", new ArrayList<>());

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String snakeJson = parts[0].substring(7); // Remove "Snake: " from the start
                String foodJson = parts[1].substring(6); // Remove "Food: " from the start

                // Convert the JSON strings back into objects
                Snake snake = gson.fromJson(snakeJson, Snake.class);
                SnakeFood food = gson.fromJson(foodJson, SnakeFood.class);

                // Extract necessary data from the snake and food objects and store them in double[] arrays
                double[] input = new double[]{ food.getXPos(), food.getYPos(), snake.getSnake().getFirst().getX(), snake.getSnake().getFirst().getY()};
                double[] output = new double[4];
                Arrays.fill(output, 0);
                output[snake.getDirection().ordinal()] = 1;

                // Add the double[] arrays to the corresponding lists in the Map
                dataMap.get("inputs").add(input);
                dataMap.get("outputs").add(output);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return dataMap;
    }
}
