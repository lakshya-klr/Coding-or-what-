class Solution {
    public int minAddToMakeValid(String s) {
         char[] letters = s.toCharArray();
         int open=0;
         int close=0;
         for(char letter: letters){
            if(letter=='('){
                open++;
            }
            else if(letter==')' && open>0) open--;
            else if(letter==')' && open==0) close++;
         }
         return open+close;
         
    }
}