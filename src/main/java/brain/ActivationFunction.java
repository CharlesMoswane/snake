package brain;

import java.util.function.Function;

public class ActivationFunction {
    // Sigmoid activation function
    public static final Function<Double, Double> SIGMOID = x -> 1 / (1 + Math.exp(-x));
    public static final Function<Double, Double> SIGMOID_DERIVATIVE = x -> x * (1 - x);

    // ReLU activation function
    public static final Function<Double, Double> RELU = x -> Math.max(0, x);
    public static final Function<Double, Double> RELU_DERIVATIVE = x -> x > 0 ? 1 : 0;

    public static double tanh(double x) {
        return Math.tanh(x);
    }

    public static double tanhDerivative(double x) {
        return 1 - (x * x);
    }

    public static double leakyRelu(double x) {
        return Math.max(0.01 * x, x);
    }

    public static double leakyReluDerivative(double x) {
        return x > 0 ? 1 : 0.01;
    }

    public static double linear(double x) {
        return x;
    }

    public static double linearDerivative(double x) {
        return 1;
    }
}
