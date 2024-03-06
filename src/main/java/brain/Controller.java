package brain;

import data.ModelPersistenceManager;
import enums.Direction;

import java.io.File;

public class Controller {
    private NeuralNetwork brain;

    public Controller(int inputNodes, int hiddenNodes, int outputNodes) {
        brain = new NeuralNetwork(inputNodes, new int[]{hiddenNodes, hiddenNodes, outputNodes},
                                    ActivationFunctions.sigmoid);

        File dir = new File("C:\\Users\\cmosw\\Desktop\\OneDrive\\My Documents\\8. Creation" +
                            "\\1. My Projects\\1. AI\\1. Snake\\1. Data\\models\\");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        ModelPersistenceManager modelPersistenceManager = new ModelPersistenceManager();
        modelPersistenceManager.saveModelToJsonFile(brain, dir + "\\model.json");
    }

    public Direction getDirection(int[] input) {
        double[] output = brain.forward(intToDouble(input));
        int maxIndex = 0;
        for (int i = 1; i < output.length; i++) {
            if (output[i] > output[maxIndex]) {
                maxIndex = i;
            }
        }
        return Direction.values()[maxIndex];
    }

    public double[] intToDouble(int[] input) {
        double[] output = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = input[i];
        }
        return output;
    }
}
