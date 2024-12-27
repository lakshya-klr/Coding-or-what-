class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int res=0;
        int n =values.length;
        int leftmax= values[0]+0;
        for(int j =1;j<n;j++){
            int righval=values[j]-j;
            res=Math.max(leftmax+righval,res);
            leftmax=Math.max(leftmax,values[j]+j);


        }
        return res;
    }
}