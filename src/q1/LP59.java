package q1;

public class LP59 {
    public static void main(String[] args) {
        System.out.printf("%4s   %4s   %4s   %4s   %4s%n", "x^1", "x^2", "x^3", "x^4", "x^5");

        for (int x = 1; x <= 6; x++) {
            System.out.printf("%4d   %4d   %4d   %4d   %4d%n", (int)Math.pow(x, 1), (int)Math.pow(x, 2), (int)Math.pow(x, 3), (int)Math.pow(x, 4), (int)Math.pow(x, 5));
        }
    }
}
