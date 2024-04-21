package brain;

import java.util.function.Function;

public class ActivationFunctions {
    // Sigmoid activation function
    public static final ActivationFunction<Double, Double> sigmoid = x -> 1 / (1 + Math.exp(-x));
    public static final Function<Double, Double> sigmoidDerivative = x -> x * (1 - x);

    // ReLU activation function
    public static final ActivationFunction<Double, Double> relu = x -> Math.max(0, x);
    public static final Function<Double, Double> reluDerivative = x -> (x > 0 ? 1.0 : 0);

    // Hyperbolic tangent activation function
    public static final ActivationFunction<Double, Double> tanh = Math::tanh;
    public static final Function<Double, Double> tanhDerivative = x -> 1 - (x * x);

    // Leaky ReLU activation function
    public static final ActivationFunction<Double, Double> leakyRelu = x -> Math.max(0.01 * x, x);
    public static final Function<Double, Double> leakyReluDerivative = x ->  x > 0 ? 1 : 0.01;

    // Linear activation function
    public static final ActivationFunction<Double, Double> linear = x -> x;
    public static final Function<Double, Double> linearDerivative = x -> 1.0;
}
