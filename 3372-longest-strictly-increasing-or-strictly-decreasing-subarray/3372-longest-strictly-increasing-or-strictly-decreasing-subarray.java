class Solution {
    public int longestMonotonicSubarray(int[] nums) {
     if(nums.length==1) return 1;
     int max=Integer.MIN_VALUE;

     int count=1;
     for(int i =0;i<nums.length-1;i++){
        if(nums[i]<nums[i+1]) count++;
        max=Math.max(max,count);
        if(nums[i]>=nums[i+1]) count=1;
     } 

     for(int i=nums.length-1;i>0;i--){
         if(nums[i]<nums[i-1]) count++;
        max=Math.max(max,count);
        if(nums[i]>=nums[i-1]) count=1;
     }  
     return max;
    }
}