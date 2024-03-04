package brain;

import data.ModelPersistenceManager;
import data.PositionPersistenceManager;

import java.util.List;

public class NeuralNetworkTrainer {
    private NeuralNetwork neuralNetwork;
    private PositionPersistenceManager positionPersistenceManager;
    private ModelPersistenceManager modelPersistenceManager = new ModelPersistenceManager();

    public NeuralNetworkTrainer(NeuralNetwork neuralNetwork, PositionPersistenceManager positionPersistenceManager) {
        this.neuralNetwork = neuralNetwork;
        this.positionPersistenceManager = positionPersistenceManager;
    }

    public void train(String filePath, int epochs, double learningRate) {
        List<double[]> inputs = positionPersistenceManager.loadPositions(filePath).get("inputs");
        List<double[]> outputs = positionPersistenceManager.loadPositions(filePath).get("outputs");

        for (int epoch = 0; epoch < inputs.size(); epoch++) {
            for (int i = 0; i < inputs.size(); i++) {
                double[] input = inputs.get(i);
                double[] output = outputs.get(i);

                // Forward propagation
                double[] predictedOutput = neuralNetwork.forward(input);

                // Calculate error
                double[] error = calculateError(output, predictedOutput);

                // Backpropagation
                for (int layerIndex = neuralNetwork.getLayers().size() - 1; layerIndex >= 0; layerIndex--) {
                    Layer layer = neuralNetwork.getLayers().get(layerIndex);
                    double[] nextError = new double[layer.getNeurons()[0].getWeights().length];

                    for (int neuronIndex = 0; neuronIndex < layer.getNeurons().length; neuronIndex++) {
                        Neuron neuron = layer.getNeurons()[neuronIndex];

                        // Calculate derivative of the error with respect to the weights
                        double delta = error[neuronIndex] * neuron.getActivationFunction().applyDerivative(predictedOutput[neuronIndex]);

                        // Update weights
                        double[] weights = neuron.getWeights();
                        for (int weightIndex = 0; weightIndex < weights.length; weightIndex++) {
                            nextError[weightIndex] += weights[weightIndex] * delta;
                            weights[weightIndex] += learningRate * delta * (layerIndex > 0 ? neuralNetwork.getLayers().get(layerIndex - 1).getNeurons().get(weightIndex).getOutput() : input[weightIndex]);
                        }
                    }

                    error = nextError;
                }
            }
        }

        modelPersistenceManager.saveModelToJsonFile(neuralNetwork,"C:\\Users\\cmosw\\Desktop\\OneDrive\\My Documents\\8. Creation\\1. My Projects\\1. AI\\1. Snake\\1. Data\\models\\trained-model.json");
    }

    private static double[] calculateError(double[] output, double[] predictedOutput) {
        double[] error = new double[output.length];
        for (int j = 0; j < output.length; j++) {
            error[j] = output[j] - predictedOutput[j];
        }
    }
}