class Solution {
    int mod = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        Integer[] dp = new Integer[high + 1]; // Memoization array
        return count(low, high, zero, one, 0, dp);
    }

    private int count(int low, int high, int zero, int one, int len, Integer[] dp) {
        if (len > high) return 0;
        if (dp[len] != null) return dp[len]; // Use memoized result

        // Recursive calls for `zero` and `one` increments
        int ans = (count(low, high, zero, one, len + zero, dp) % mod +
                   count(low, high, zero, one, len + one, dp) % mod) % mod;

        // Include current length if it is within the valid range
        if (len >= low) ans = (ans + 1) % mod;

        return dp[len] = ans; // Memoize result
    }
}
