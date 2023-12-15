import java.util.HashMap;
import java.util.Map;

public class BaskinRobins {
    private static final Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int n = 31;
        int ways = findCombinations(n);
        System.out.println("Number of distinct ways the game can be played: " + ways);
    }

    public static int findCombinations(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }

        if (memo.containsKey(num)) {
            return memo.get(num);
        }

        int ways = findCombinations(num - 1) + findCombinations(num - 2);

        memo.put(num, ways);

        return ways;
    }
}
