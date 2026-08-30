class Solution {
    public int minimumDeletions(int[] nums) {

        int len = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minindex = 0;
        int maxindex = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minindex = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                maxindex = i;
            }
        }

        int fromLeft = Math.max(minindex, maxindex) + 1;

        int fromRight = len - Math.min(minindex, maxindex);

        int mixed = Math.min(
            minindex + 1 + len - maxindex,
            maxindex + 1 + len - minindex
        );

        return Math.min(fromLeft, Math.min(fromRight, mixed));
    }
}