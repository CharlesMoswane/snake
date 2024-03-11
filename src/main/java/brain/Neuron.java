package brain;

public class Neuron {
    private double value;
    private double[] weights;
    private double bias;

    public Neuron(int numInputs) {
        weights = new double[numInputs];
        for (int i = 0; i < numInputs; i++) {
            weights[i] = Math.random() * 2 - 1;
        }
        bias = Math.random() * 2 - 1;
    }
}
