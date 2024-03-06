package data;

import brain.NeuralNetwork;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//@author Charles Moswane
public class ModelPersistenceManager {

    /**
     * Serializes the neural network model to a JSON string.
     *
     * @param network The neural network model to serialize.
     * @return The JSON string representation of the model.
     */
    private String serializeToJson(NeuralNetwork network) {
        Gson gson = new Gson();
        return gson.toJson(network);
    }

    /**
     * Saves the neural network model to a file in JSON format.
     *
     * @param network The neural network model to save.
     * @param filePath The file path where the model should be saved.
     */
    public void saveModelToJsonFile(NeuralNetwork network, String filePath) {
        String json = serializeToJson(network);
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deserializes a neural network model from a JSON string.
     *
     * @param json The JSON string to deserialize.
     * @return The deserialized neural network model.
     */
    private NeuralNetwork deserializeFromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, NeuralNetwork.class);
    }

    /**
     * Loads a neural network model from a JSON file.
     *
     * @param filePath The file path from which to load the model.
     * @return The loaded neural network model.
     */
    public NeuralNetwork loadModelFromJsonFile(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, NeuralNetwork.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

