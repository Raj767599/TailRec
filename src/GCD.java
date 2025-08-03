import java.math.BigInteger;

public class GCD {

    public static TailCall<BigInteger> gcdTail(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return TailCall.done(a);
        }
        return TailCall.call(() -> gcdTail(b, a.mod(b)));
    }

    public static BigInteger gcd(BigInteger a, BigInteger b) {
        return gcdTail(a, b).invoke();
    }

    public static void main(String[] args) {
        BigInteger a = new BigInteger("48");
        BigInteger b = new BigInteger("18");
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd(a, b));
    }
}
