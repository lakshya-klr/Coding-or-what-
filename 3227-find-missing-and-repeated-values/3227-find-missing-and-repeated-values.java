class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet<Integer> set= new HashSet<>();
        int ans[]= new int[2];
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[i].length;j++){
                if(set.contains(grid[i][j])){
                    ans[0]=grid[i][j];
                }
                set.add(grid[i][j]);
            }
        }
        int a =1;
        for(int num:set){
            if(!set.contains(a)) ans[1]=a;
            a++;
        }
        if(ans[1]==0) ans[1]=a;
        return ans;

    }
}