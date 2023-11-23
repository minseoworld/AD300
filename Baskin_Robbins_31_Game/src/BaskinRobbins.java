import java.util.HashMap;
import java.util.Map;

public class BaskinRobbins{

    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int n = 31;
        int ways = baskin(n);
    }

    public static int baskin(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int ways = baskin(n - 1) + baskin(n - 2);

        memo.put(n, ways);

        return ways;
    }
}
