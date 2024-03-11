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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double[] getWeights() {
        return weights;
    }

    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }
}
