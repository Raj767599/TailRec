import java.math.BigInteger;

public class Power {

    public static TailCall<BigInteger> powerTail(BigInteger x, BigInteger n, BigInteger acc) {
        if (n.equals(BigInteger.ZERO)) {
            return TailCall.done(acc);
        }
        return TailCall.call(() -> powerTail(x, n.subtract(BigInteger.ONE), acc.multiply(x)));
    }

    public static BigInteger power(BigInteger x, BigInteger n) {
        return powerTail(x, n, BigInteger.ONE).invoke();
    }

    public static void main(String[] args) {
        BigInteger base = new BigInteger("2");
        BigInteger exp = new BigInteger("10000");
        System.out.println("2^10000 = ");
        System.out.println(power(base, exp));
    }
}
