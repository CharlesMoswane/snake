package brain;

public class NeuralNetwork {
    private int inputNodes;
    private int hiddenNodes;
    private int outputNodes;
    private double learningRate;
    private double[][] weightsInputHidden;
    private double[][] weightsHiddenOutput;

    public NeuralNetwork(int inputNodes, int hiddenNodes, int outputNodes, double learningRate) {
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

    public double[] query(int[] inputs) {
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

    public double[][] getWeightsInputHidden() {
        return weightsInputHidden;
    }

    public double[][] getWeightsHiddenOutput() {
        return weightsHiddenOutput;
    }

    public void setWeightsInputHidden(double[][] weightsInputHidden) {
        this.weightsInputHidden = weightsInputHidden;
    }

    public void setWeightsHiddenOutput(double[][] weightsHiddenOutput) {
        this.weightsHiddenOutput = weightsHiddenOutput;
    }

    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public int getInputNodes() {
        return inputNodes;
    }

    public int getHiddenNodes() {
        return hiddenNodes;
    }

    public int getOutputNodes() {
        return outputNodes;
    }

    public void setInputNodes(int inputNodes) {
        this.inputNodes = inputNodes;
    }

    public void setHiddenNodes(int hiddenNodes) {
        this.hiddenNodes = hiddenNodes;
    }

    public void setOutputNodes(int outputNodes) {
        this.outputNodes = outputNodes;
    }

    public void setWeights(double[][] weightsInputHidden, double[][] weightsHiddenOutput) {
        this.weightsInputHidden = weightsInputHidden;
        this.weightsHiddenOutput = weightsHiddenOutput;
    }

    public void setWeights(int inputNodes, int hiddenNodes, int outputNodes) {
        this.inputNodes = inputNodes;
        this.hiddenNodes = hiddenNodes;
        this.outputNodes = outputNodes;
    }

    public void setWeights(double[][] weightsInputHidden, double[][] weightsHiddenOutput, int inputNodes, int hiddenNodes, int outputNodes) {
        this.weightsInputHidden = weightsInputHidden;
        this.weightsHiddenOutput = weightsHiddenOutput;
        this.inputNodes = inputNodes;
        this.hiddenNodes = hiddenNodes;
        this.outputNodes = outputNodes;
    }

    public void setWeights(int inputNodes, int hiddenNodes, int outputNodes, double learningRate) {
        this.inputNodes = inputNodes;
        this.hiddenNodes = hiddenNodes;
        this.outputNodes = outputNodes;
        this.learningRate = learningRate;
    }

    public void setWeights(double[][] weightsInputHidden, double[][] weightsHiddenOutput, int inputNodes, int hiddenNodes, int outputNodes, double learningRate) {
        this.weightsInputHidden = weightsInputHidden;
        this.weightsHiddenOutput = weightsHiddenOutput;
        this.inputNodes = inputNodes;
        this.hiddenNodes = hiddenNodes;
        this.outputNodes = outputNodes;
        this.learningRate = learningRate;
    }

    public void setWeights(int inputNodes, int hiddenNodes, int outputNodes, double learningRate, double[][] weightsInputHidden, double[][] weightsHiddenOutput) {
        this.inputNodes = inputNodes;
        this.hiddenNodes = hiddenNodes;
        this.outputNodes = outputNodes;
        this.learningRate = learningRate;
        this.weightsInputHidden = weightsInputHidden;
        this.weightsHiddenOutput = weightsHiddenOutput;
    }
}
