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

/*
* Time Complexity
* - With no memorization(initial)
* Time: A lot, grows quickly with n.
* Reason: Repeats calculations, slow for big n.
*
* - With memorization
* Time: Faster, grows linearly with n.
* Reason: Remembers past results, avoids doing the same thing many times.
*
* Time Complexity with Memoization
* Recomputations: Remembering old answers stops doing the same work again.
* Map Operations: Using the memory map is quick but adds a bit of work.
*
* Space Complexity
* - With no memoization(initial)
* Space: Grows with n.
* Reason: Keeps track of where it is in a big list.
*
* - With memorization
* Space: Grows with n.
* Reason: Keeps old answers, uses extra memory for efficiency.
*
* Comparison of Space Complexity
* Same space for both, but memoization makes it much faster, especially for big n.
*
 */
