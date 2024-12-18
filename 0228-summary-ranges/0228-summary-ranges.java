class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ls = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int start = nums[i];
            while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            if (start != nums[i])
                ls.add("" + start + "->" + nums[i]);
            else {
                ls.add("" + start);
            }

        }
                    return ls;
    }
}