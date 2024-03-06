package data;

import brain.ActivationFunction;
import brain.ActivationFunctions;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class ActivationFunctionAdapter extends TypeAdapter<ActivationFunction<Double, Double>> {

    @Override
    public void write(JsonWriter out, ActivationFunction<Double, Double> value) throws IOException {
        System.out.println("Writing ActivationFunction");
        out.beginObject();
        if (value != null) {
            out.name("value").value(value.getClass().getName());
        } else {
            out.name("value").value("null");
        }
        out.endObject();
    }

    @Override
    public ActivationFunction<Double, Double> read(JsonReader in) throws IOException {
        in.beginObject();
        String value = null;
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "value":
                    value = in.nextString();
                    break;
            }
        }
        in.endObject();

        if (value == null) {
            throw new IOException("Missing value of ActivationFunction");
        }

        // Create an instance of the class
        if (value.equals(ActivationFunctions.sigmoid.getClass().getName())) {
            return ActivationFunctions.sigmoid;
        } else {
            throw new IOException("Unknown value of ActivationFunction: " + value);
        }
    }
}