class Solution {
    public String maxSumOfSquares(int num, int sum) {

        // Impossible: maximum possible digit sum is 9 * num
        if (sum > 9 * num) {
            return "";
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < num; i++) {
            int digit = Math.min(9, sum);

            ans.append(digit);
            sum -= digit;
        }

        return ans.toString();
    }
}