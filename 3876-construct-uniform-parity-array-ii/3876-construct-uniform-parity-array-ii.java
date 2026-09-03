class Solution {
    public boolean uniformArray(int[] nums1) {
        int even = 0, odd = 0;
        int minodd = nums1[0];
        for (int n : nums1) {
            if (n % 2 == 0)
                even++;
            else {
                if (minodd % 2 == 0)
                    minodd = n;
                odd++;
                if (n < minodd) {
                    minodd = n;
                }
            }
        }

        if (even == nums1.length || odd == nums1.length)
            return true;
        else {
            for (int i = 0; i < nums1.length; i++) {
                if (nums1[i] % 2 == 0) {
                    if ((nums1[i] - minodd) >= 1)
                        continue;
                    else
                        return false;
                }
            }
        }
        return true;
    }
}