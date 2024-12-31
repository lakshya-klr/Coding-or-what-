class Solution {
      HashSet<Integer> set = new HashSet<>();
    public int mincostTickets(int[] days, int[] costs) {
      
    int lastday=days[days.length-1]+30;
    int[] dp = new int[lastday+1];
    Arrays.fill(dp,-1);



        for(int day:days){
            set.add(day);
        }
        return recur(dp,days, costs, days[0]);
    }
    private int recur(int[] dp, int[] days,int[] costs, int currday){
        if(currday>days[days.length-1]) {
            // dp[currday]=0;
            return 0;
            }
        if(dp[currday]!=-1){
            return dp[currday];
        }

        if(!set.contains(currday)){
            dp[currday]=recur(dp,days,costs,currday+1);
            return dp[currday];
        }
        int oneday=costs[0]+recur(dp,days,costs,currday+1);
        int sevenday=costs[1]+recur(dp,days,costs,currday+7);
        int thirtyday=costs[2]+recur(dp,days,costs,currday+30);
        dp[currday]= Math.min(oneday,Math.min(sevenday,thirtyday));
        return dp[currday];
    }
}