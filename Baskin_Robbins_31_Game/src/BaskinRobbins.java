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
        // Base case: if n is less than or equal to 0, there are no ways to play
        if (n <= 0) {
            return 0;
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
