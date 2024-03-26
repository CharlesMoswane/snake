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

    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    private double sigmoidDerivative(double x) {
        return x * (1 - x);
    }

    public void train(double[] inputs, double[] targets) {
        double[] hiddenOutputs = new double[hiddenNodes];
        double[] finalOutputs = new double[outputNodes];
        double[] outputErrors = new double[outputNodes];
        double[] hiddenErrors = new double[hiddenNodes];

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

        for (int i = 0; i < outputNodes; i++) {
            outputErrors[i] = targets[i] - finalOutputs[i];
        }

        for (int i = 0; i < hiddenNodes; i++) {
            double sum = 0;
            for (int j = 0; j < outputNodes; j++) {
                sum += weightsHiddenOutput[j][i] * outputErrors[j];
            }
            hiddenErrors[i] = sum;
        }

        for (int i = 0; i < outputNodes; i++) {
            for (int j = 0; j < hiddenNodes; j++) {
                double delta = outputErrors[i] * sigmoidDerivative(finalOutputs[i]) * hiddenOutputs[j];
                weightsHiddenOutput[i][j] += learningRate * delta;
            }
        }

        for (int i = 0; i < hiddenNodes; i++) {
            for (int j = 0; j < inputNodes; j++) {
                double delta = hiddenErrors[i] * sigmoidDerivative(hiddenOutputs[i]) * inputs[j];
                weightsInputHidden[i][j] += learningRate * delta;
            }
        }
    }


}
