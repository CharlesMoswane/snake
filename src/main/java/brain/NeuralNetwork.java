package brain;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {
    private List<Layer> layers = new ArrayList<>();

    public NeuralNetwork(int inputSize, int[] layerSizes, ActivationFunction<Double, Double> activationFunction) {
        // First layer
        layers.add(new Layer(layerSizes[0], inputSize, activationFunction));

        // Subsequent layers
        for (int i = 1; i < layerSizes.length; i++) {
            layers.add(new Layer(layerSizes[i], layerSizes[i - 1], activationFunction));
        }
    }

    public double[] forward(double[] inputs) {
        double[] values = inputs;
        for (Layer layer : layers) {
            values = layer.calculateValues(values);
        }
        return softmax(values);
    }

    public double[] softmax(double[] values) {
        double[] softmaxValues = new double[values.length];
        double sum = 0.0;

        for (int i = 0; i < values.length; i++) {
            softmaxValues[i] = Math.exp(values[i]);
            sum += softmaxValues[i];
        }

        for (int i = 0; i < softmaxValues.length; i++) {
            softmaxValues[i] = softmaxValues[i] / sum;
        }

        return softmaxValues;
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }
}
