class Solution {
    public int maxScore(String s) {
        int one=0;
        int ans=0;
        for(char c:s.toCharArray()){
            if(c=='1') one++;
        }
        int score=0;
        int zero=0;
        for(int i =0;i<s.length()-1;i++){
            if(s.charAt(i)=='0') zero++;
            if(s.charAt(i)=='1') {
                one--;
                
            }
            score=one+zero;
            ans=Math.max(ans,score);
    }
    return ans;
    }
    
}