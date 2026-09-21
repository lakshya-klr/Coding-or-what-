class Solution {
    public int reverseDegree(String s) {
        int result=0;
        for(int i = 0;i<s.length();i++){
            int val =0;
        val = 26 - (s.charAt(i) - 'a') ;  
          result += val*(i+1);
        }
        return result;
    }
}