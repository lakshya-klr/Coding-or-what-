class Solution {
    public int findNumbers(int[] nums) {
        int ans=0;
        for(int n:nums){
            if(check(n)) ans++;
        }
        return ans;
    }
    private boolean check(int n){
        int len=0;
        while(n>0){
            n=n/10;
            len++;
        }
        return len%2==0?true:false;
    }
}