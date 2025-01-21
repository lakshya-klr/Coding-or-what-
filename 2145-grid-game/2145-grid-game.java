class Solution {
    public long gridGame(int[][] grid) {
        long pref1=0;
        for(int i=0; i<grid[0].length; i++){
            pref1+=grid[0][i];
        }
        long max2=Long.MAX_VALUE;
        long pref2=0;
        for(int i=0; i<grid[0].length; i++){
            pref1 -= grid[0][i];
            max2 = Math.min(max2, Math.max(pref1,pref2));
            pref2 += grid[1][i];
        }
        return max2;
    }
}