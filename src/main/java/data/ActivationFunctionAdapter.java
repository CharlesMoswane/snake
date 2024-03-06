package data;

import brain.ActivationFunction;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class ActivationFunctionAdapter extends TypeAdapter<ActivationFunction<Double, Double>> {

    @Override
    public void write(JsonWriter out, ActivationFunction<Double, Double> value) throws IOException {
        // Implement serialization logic here
    }

    @Override
    public ActivationFunction<Double, Double> read(JsonReader in) throws IOException {
        // Implement deserialization logic here
        // Return an instance of a class that implements ActivationFunction
        return null;
    }
}