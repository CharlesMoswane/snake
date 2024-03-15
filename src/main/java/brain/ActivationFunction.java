package brain;

import java.util.function.Function;

public class ActivationFunction {
    // Sigmoid activation function
    public static final Function<Double, Double> sigmoid = x -> 1 / (1 + Math.exp(-x));
    public static final Function<Double, Double> sigmoidDerivative = x -> x * (1 - x);

    // ReLU activation function
    public static final Function<Double, Double> relu = x -> Math.max(0, x);
    public static final Function<Double, Double> reluDerivative = x -> (double) (x > 0 ? 1 : 0);

    // Hyperbolic tangent activation function
    public static final Function<Double, Double> tanh = Math::tanh;
    public static final Function<Double, Double> tanhDerivative = x -> 1 - (x * x);

    // Leaky ReLU activation function
    public static final Function<Double, Double> leakyRelu = x -> Math.max(0.01 * x, x);
    public static final Function<Double, Double> leakyReluDerivative = x ->  x > 0 ? 1 : 0.01;

    public static double linear(double x) {
        return x;
    }

    public static double linearDerivative(double x) {
        return 1;
    }
}
