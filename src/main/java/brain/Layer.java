package brain;

public class Layer {
    ActivationFunction<Double, Double> activationFunction;
    Neuron[] neurons;

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
            values[i] = neurons[i].activate(inputs, activationFunction);
        }
        return values;
    }

    public ActivationFunction<Double, Double> getActivationFunction() {
        return activationFunction;
    }

    public void setActivationFunction(ActivationFunction<Double, Double> activationFunction) {
        this.activationFunction = activationFunction;
    }

    public Neuron[] getNeurons() {
        return neurons;
    }

    public void setNeurons(Neuron[] neurons) {
        this.neurons = neurons;
    }
}
