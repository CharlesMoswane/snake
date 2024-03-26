package brain;

import enums.Direction;

public class Controller {
    private NeuralNetwork brain;

    public Controller(int inputNodes, int hiddenNodes, int outputNodes, double learningRate) {
        brain = new NeuralNetwork(inputNodes, hiddenNodes, outputNodes, learningRate);
    }

    public Direction getDirection(int[] input) {
        double[] output = brain.query(input);
        int maxIndex = 0;
        for (int i = 1; i < output.length; i++) {
            if (output[i] > output[maxIndex]) {
                maxIndex = i;
            }
        }
        return Direction.values()[maxIndex];
    }
}
