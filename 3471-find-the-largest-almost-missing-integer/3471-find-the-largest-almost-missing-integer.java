class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] arr = new int[51];
        int max = 0;

        if (nums.length == k) {
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
            }
            return max;
        }

        for (int i = 0; i <= nums.length - k; i++) {
            for (int j = i; j < k + i; j++) {
                arr[nums[j]]++;
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 1)
                return i;
        }
        return -1;
    }

}