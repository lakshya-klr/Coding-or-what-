class Solution {
    public long coloredCells(int n) {
        if(n==1){
            return 1;
        }
        long num=2*(n-1);
        long ans=(long)n*(num)+1;
        return ans;
    }
}