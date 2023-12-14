import java.util.HashMap;
import java.util.Map;

public class BaskinRobbins {

    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int n = 31;
        int ways = baskin(n);
        System.out.println("Number of distinct ways the game can be played: " + ways);
    }

    public static int baskin(int n) {
        // Base case: if n is less than 0, there are no ways to play
        if (n < 0) {
            return 0;
        }
        // Base case: if n is 0, there is one way to play (do not say anything)
        if (n == 0) {
            return 1;
        }
        // Base case: if n is 1, there are two ways to play (say "1" or "1, 2")
        if (n == 1) {
            return 2;
        }

        // Check if the result for the current n is already memoized
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Recursive case: count ways for saying "1" and "1, 2" and sum them up
        int ways = baskin(n - 1) + baskin(n - 2);

        // Memoize the result for the current n
        memo.put(n, ways);

        return ways;
    }
}
