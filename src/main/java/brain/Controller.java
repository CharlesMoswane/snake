package brain;

public class Controller {
    private NeuralNetwork brain;

    public Controller(int inputNodes, int hiddenNodes, int outputNodes, double learningRate) {
        brain = new NeuralNetwork(inputNodes, hiddenNodes, outputNodes, learningRate);
    }

    public Direction getDirection(int[] input) {
        brain.feedForward(input);
    }
}
