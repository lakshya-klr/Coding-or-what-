class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count=0;
        for(int i =0;i+1<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                
                        if(valid(words[i],words[j])) count++;
                
            }
        }
        return count;

    }
    private boolean valid(String a, String b){

        //check prefix
        
       if(b.indexOf(a)!=0) return false;

       if(!b.substring(b.length()-a.length()).equals(a)) return false;
      return true;
    }
}