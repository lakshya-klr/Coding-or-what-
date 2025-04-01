class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        dp[n - 1] = questions[n - 1][0];
        for(int i = n - 2; i >= 0; i--){
            long pick = questions[i][0];
            if(i + questions[i][1] + 1 < n)
                pick += dp[i + questions[i][1] + 1];
            long notPick = dp[i + 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[0];
    }
}