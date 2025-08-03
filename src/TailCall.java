import java.util.function.Supplier;
public interface TailCall<T> {
    boolean isComplete();
    T result();
    TailCall<T> apply();

    default T invoke() {
        TailCall<T> current = this;
        while (!current.isComplete()) {
            current = current.apply();
        }
        return current.result();
    }

    static <T> TailCall<T> done(T value) {
        return new TailCall<>() {
            public boolean isComplete() { return true; }
            public T result() { return value; }
            public TailCall<T> apply() {
                throw new UnsupportedOperationException("Already complete");
            }
        };
    }

    static <T> TailCall<T> call(Supplier<TailCall<T>> nextStep) {
        return new TailCall<>() {
            public boolean isComplete() { return false; }
            public T result() {
                throw new UnsupportedOperationException("Not yet complete");
            }
            public TailCall<T> apply() {
                return nextStep.get();
            }
        };
    }
}
