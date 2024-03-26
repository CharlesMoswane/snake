package neuralNet;

public class neuralNetwork {
    private int inputNodes;
    private int hiddenNodes;
    private int outputNodes;
    private double learningRate;
    private double[][] weightsInputHidden;
    private double[][] weightsHiddenOutput;

    public neuralNetwork(int inputNodes, int hiddenNodes, int outputNodes, double learningRate) {
        this.inputNodes = inputNodes;
        this.hiddenNodes = hiddenNodes;
        this.outputNodes = outputNodes;
        this.learningRate = learningRate;

        weightsInputHidden = new double[hiddenNodes][inputNodes];
        weightsHiddenOutput = new double[outputNodes][hiddenNodes];

        for (int i = 0; i < hiddenNodes; i++) {
            for (int j = 0; j < inputNodes; j++) {
                weightsInputHidden[i][j] = Math.random() - 0.5;
            }
        }

        for (int i = 0; i < outputNodes; i++) {
            for (int j = 0; j < hiddenNodes; j++) {
                weightsHiddenOutput[i][j] = Math.random() - 0.5;
            }
        }
    }

    public double[] query(double[] inputs) {
        double[] hiddenOutputs = new double[hiddenNodes];
        double[] finalOutputs = new double[outputNodes];

        for (int i = 0; i < hiddenNodes; i++) {
            double sum = 0;
            for (int j = 0; j < inputNodes; j++) {
                sum += weightsInputHidden[i][j] * inputs[j];
            }
            hiddenOutputs[i] = sigmoid(sum);
        }

        for (int i = 0; i < outputNodes; i++) {
            double sum = 0;
            for (int j = 0; j < hiddenNodes; j++) {
                sum += weightsHiddenOutput[i][j] * hiddenOutputs[j];
            }
            finalOutputs[i] = sigmoid(sum);
        }

        return finalOutputs;
    }
}
