import java.util.*;

class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);

        int len = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] - nums[l] <= 2 * k) {
                len = Math.max(len, r - l + 1);
            } else {
                l++;
            }
            r++;
        }
        return len;
    }
}