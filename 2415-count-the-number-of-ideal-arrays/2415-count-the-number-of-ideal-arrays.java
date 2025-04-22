class Solution {
    static final int MOD = 1_000_000_007;
    int[] factMemo = new int[100001];
    int[][] dp = new int[10001][15];

    long power(long a, long b, long m) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % m;
            a = (a * a) % m;
            b >>= 1;
        }
        return res;
    }

    long fact(int x) {
        if (x == 0 || x == 1) return 1;
        if (factMemo[x] != 0) return factMemo[x];
        return factMemo[x] = (int)(fact(x - 1) * x % MOD);
    }

    long nCr(int n, int r) {
        if (r > n) return 0;
        return fact(n) * power(fact(r), MOD - 2, MOD) % MOD * power(fact(n - r), MOD - 2, MOD) % MOD;
    }

    public int idealArrays(int n, int maxVal) {
        int maxLen = Math.min(14, n);
        for (int i = 1; i <= maxVal; i++) {
            dp[i][1] = 1;
        }
        for (int len = 2; len <= maxLen; len++) {
            for (int i = 1; i <= maxVal; i++) {
                for (int mult = 2; i * mult <= maxVal; mult++) {
                    dp[i * mult][len] = (dp[i * mult][len] + dp[i][len - 1]) % MOD;
                }
            }
        }
        long res = 0;
        for (int val = 1; val <= maxVal; val++) {
            for (int len = 1; len <= maxLen; len++) {
                long ways = nCr(n - 1, len - 1);
                res = (res + ways * dp[val][len]) % MOD;
            }
        }
        return (int) res;
    }
}