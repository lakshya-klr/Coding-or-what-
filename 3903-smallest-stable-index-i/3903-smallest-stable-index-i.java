class Solution {
    public int firstStableIndex(int[] nums, int k) {
        if(nums.length<2) return 0;
        for (int i = 0; i < nums.length; i++) {
            int max = findMax(0, i+1, nums);
            int min = findMin(i, nums.length, nums);
            if ((max - min) <= k)
                return i;

        }
        return -1;

    }

    private int findMin(int start, int end, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (nums[i] < min)
                min = nums[i];
        }
        return min;
    }

    private int findMax(int start, int end, int[] nums) {
        int MAX = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (nums[i] > MAX)
                MAX = nums[i];
        }
        return MAX;
    }
}