class Solution {

    //not my solution
    
    static final long MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        return (int) combination(n + k - 1, 2 * k);
    }

    public long combination(int n, int r) {
        if (r > n - r) {
            r = n - r;
        }

        long result = 1;

        for (int i = 1; i <= r; i++) {
            result = result * (n - r + i) % MOD;
            result = result * modInverse(i) % MOD;
        }

        return result;
    }

    public long modInverse(long x) {
        return power(x, MOD - 2);
    }

    public long power(long a, long b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % MOD;
            }

            a = a * a % MOD;
            b >>= 1;
        }

        return result;
    }
}