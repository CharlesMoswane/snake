package brain;

@FunctionalInterface
public interface ActivationFunction<T,V> {
    T activate(double V);
}
