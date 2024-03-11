package brain;

public class Layer {
    Neuron[] neurons;
    ActivationFunction<Double, Double> activationFunction;

    public Layer(int numNeurons, int numInputs, ActivationFunction<Double, Double> activationFunction) {
        neurons = new Neuron[numNeurons];
        for (int i = 0; i < numNeurons; i++) {
            neurons[i] = new Neuron(numInputs);
        }
        this.activationFunction = activationFunction;
    }

    public double[] calculateValues(double[] inputs) {
        double[] values = new double[neurons.length];
        for (int i = 0; i < neurons.length; i++) {
            values[i] = neurons[i].calculateValue(inputs, activationFunction);
        }
        return values;
    }
}
