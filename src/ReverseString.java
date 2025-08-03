public class ReverseString {

    public static TailCall<String> reverseTail(String input, String acc) {
        if (input.isEmpty()) {
            return TailCall.done(acc);
        }
        return TailCall.call(() -> reverseTail(input.substring(1), input.charAt(0) + acc));
    }

    public static String reverse(String input) {
        return reverseTail(input, "").invoke();
    }

    public static void main(String[] args) {
        String text = "trampoline";
        System.out.println("Reversed: " + reverse(text));
    }
}
