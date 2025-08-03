import java.math.BigInteger;

public class Factorial {

    public static TailCall<BigInteger> factorialTail(BigInteger n, BigInteger acc) {
        if (n.equals(BigInteger.ZERO)) {
            return TailCall.done(acc);
        }
        return TailCall.call(() -> factorialTail(n.subtract(BigInteger.ONE), n.multiply(acc)));
    }

    public static BigInteger factorial(BigInteger n) {
        return factorialTail(n, BigInteger.ONE).invoke();
    }

    public static void main(String[] args) {
        BigInteger number = new BigInteger("10000");
        System.out.println("Factorial of " + number + " is:");
        System.out.println(factorial(number));
    }
}
