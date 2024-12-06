class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
      HashSet<Integer> exclude = new HashSet<>();
      int setmax=0;
      for(int z : banned) {
        exclude.add(z);
      }
      int select=0;
      for(int i =1;i<=n;i++){
        if(!exclude.contains(i)){
            if(i>maxSum) break;
            select+=1;
            maxSum-=i;
        }
        
      }
      return select;

    }
}