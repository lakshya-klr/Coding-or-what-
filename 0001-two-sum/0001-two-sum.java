import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // (value, index)
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Find the number needed to reach the target
            if (map.containsKey(complement)) { // Check if the complement exists in the map
                return new int[] { map.get(complement), i }; // Return the pair of indices
            }
            map.put(nums[i], i); // Store the current number and its index in the map
        }
        return null;
    }
}