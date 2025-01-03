class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long sum=0;
        for(int z:nums){
            sum+=z;
        }
        int count=0;
        long prefix_sum=0;
        for(int i =0;i<n-1;i++){
            prefix_sum+=nums[i];
            if(prefix_sum>=sum - prefix_sum){
                count++;
            }
        }
        return count;


    }
}