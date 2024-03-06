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
            out.name("name").value("sigmoid");
        } else {
            out.name("name").value("null");
        }
        out.endObject();
    }

    @Override
    public ActivationFunction<Double, Double> read(JsonReader in) throws IOException {
        in.beginObject();
        String name = null;
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "name":
                    name = in.nextString();
                    break;
            }
        }
        in.endObject();

        if (name == null) {
            throw new IOException("Missing name of ActivationFunction");
        }

        // Create an instance of the class
        if (name.equals("sigmoid")) {
            return ActivationFunctions.sigmoid;
        } else {
            throw new IOException("Unknown name of ActivationFunction: " + name);
        }
    }
}