class Solution {
    public int maxProduct(int[] nums) {
        int max=0;
        int secmax =0;
        for(int num : nums){
            if(num>max){
                secmax=max;
                max=num;
            }
            else if(num>secmax){
                secmax=num;
            }
        }
        return (max-1)*(secmax-1);
    }
}