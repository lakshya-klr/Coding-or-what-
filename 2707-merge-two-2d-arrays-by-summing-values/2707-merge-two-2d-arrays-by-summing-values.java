import java.util.*;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Add elements from nums1
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i][0], nums1[i][1]);
        }

        // Add elements from nums2 and merge with existing values
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i][0], map.getOrDefault(nums2[i][0], 0) + nums2[i][1]);
        }

        // Convert HashMap to sorted 2D array
        int[][] ans = new int[map.size()][2];
        int i = 0;
        
        // Sort keys before inserting into the array
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for (int key : keys) {
            ans[i][0] = key;
            ans[i][1] = map.get(key);
            i++;
        }
        
        return ans;
    }
}
