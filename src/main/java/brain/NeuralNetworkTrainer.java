package brain;

import data.ModelPersistenceManager;
import data.PositionPersistenceManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NeuralNetworkTrainer {
    private NeuralNetwork neuralNetwork;
    private PositionPersistenceManager positionPersistenceManager;
    private ModelPersistenceManager modelPersistenceManager = new ModelPersistenceManager();

    public NeuralNetworkTrainer(NeuralNetwork neuralNetwork, PositionPersistenceManager positionPersistenceManager) {
        this.neuralNetwork = neuralNetwork;
        this.positionPersistenceManager = positionPersistenceManager;
    }

    public void train(String filePath) {
        List<double[]> inputs = new ArrayList<>();
        List<double[]> outputs = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                double[] input = new double[4];
                double[] output = new double[1];

                for (int i = 0; i < 4; i++) {
                    input[i] = Double.parseDouble(parts[i]);
                }

                output[0] = Double.parseDouble(parts[4]);

                inputs.add(input);
                outputs.add(output);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < inputs.size(); i++) {
            double[] input = inputs.get(i);
            double[] output = outputs.get(i);

            double[] predictedOutput = neuralNetwork.forward(input);
            double error = output[0] - predictedOutput[0];

            // Update the weights of the neural network using gradient descent
            // This is a simplified example and does not include the actual implementation of gradient descent
            for (Layer layer : neuralNetwork.getLayers()) {
                for (Neuron neuron : layer.getNeurons()) {
                    double[] weights = neuron.getWeights();
                    double[] newWeights = new double[weights.length];

                    for(int j = 0; j < weights.length; j++){
                        newWeights[j] = weights[j] + 0.01 * error;
                    }

                    neuron.setWeights(newWeights);
                }
            }
        }

        modelPersistenceManager.saveModelToJsonFile(neuralNetwork,"\"C:\\Users\\cmosw\\Desktop\\OneDrive\\My Documents\\8. Creation\\1. My Projects\\1. AI\\1. Snake\\1. Data\\models\\trained-model.json\"");
    }
}