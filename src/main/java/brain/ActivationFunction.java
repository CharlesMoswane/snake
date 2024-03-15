package brain;

public class ActivationFunction {
    public static double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    public static double sigmoidDerivative(double x) {
        return x * (1 - x);
    }

    public static double tanh(double x) {
        return Math.tanh(x);
    }

    public static double tanhDerivative(double x) {
        return 1 - (x * x);
    }

    public static double relu(double x) {
        return Math.max(0, x);
    }

    public static double reluDerivative(double x) {
        return x > 0 ? 1 : 0;
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
