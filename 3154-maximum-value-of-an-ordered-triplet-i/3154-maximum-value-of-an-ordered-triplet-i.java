class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxVal = 0;

        // Fixing 'j' in the middle
        for (int j = 1; j < n - 1; j++) {
            int maxBefore = 0;  // Best nums[i] before j
            for (int i = 0; i < j; i++) {
                maxBefore = Math.max(maxBefore, nums[i]);
            }

            int maxAfter = 0;  // Best nums[k] after j
            for (int k = j + 1; k < n; k++) {
                maxAfter = Math.max(maxAfter, nums[k]);
            }

            // Compute the triplet value
            maxVal = Math.max(maxVal, (long) (maxBefore - nums[j]) * maxAfter);
        }

        return maxVal;
    }
}