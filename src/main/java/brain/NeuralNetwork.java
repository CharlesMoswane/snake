package brain;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {
    private Layer inputLayer;
    private Layer hiddenLayer;
    private Layer outputLayer;

    private List<Layer> layers = new ArrayList<>();

    public NeuralNetwork(int inputNodes, int hiddenNodes, int outputNodes) {
        inputLayer = new Layer(inputNodes, 0, (v) -> v);
        hiddenLayer = new Layer(hiddenNodes, inputNodes, (v) -> 1 / (1 + Math.exp(-v)));
        outputLayer = new Layer(outputNodes, hiddenNodes, (v) -> 1 / (1 + Math.exp(-v)));
    }

    public double[] query(int[] inputs) {
        double[] inputValues = new double[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            inputValues[i] = inputs[i];
        }
        double[] hiddenValues = hiddenLayer.calculateValues(inputValues);
        double[] outputValues = outputLayer.calculateValues(hiddenValues);
        return outputValues;
    }
}
