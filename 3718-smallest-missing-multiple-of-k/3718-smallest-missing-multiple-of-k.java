class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> multiples = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % k == 0)
                multiples.add(nums[i]);
        }

        for (int j = 1; j <= multiples.size(); j++) {

            if (!multiples.contains(k * j))
                return k * j;

        }
        return k * (multiples.size() + 1);

    }
}