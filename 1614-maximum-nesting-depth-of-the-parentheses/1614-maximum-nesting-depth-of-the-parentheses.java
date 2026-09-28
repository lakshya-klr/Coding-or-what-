class Solution {
    public int maxDepth(String s) {
        char[] ch= s.toCharArray();
        int count=0;
        
        int maxcount=0;
        for(char c:ch){
            if(c=='('){
            count++;
            maxcount=Math.max(maxcount,count);}
            else if(c==')')
            count--;
        }
        return maxcount;
    }
}