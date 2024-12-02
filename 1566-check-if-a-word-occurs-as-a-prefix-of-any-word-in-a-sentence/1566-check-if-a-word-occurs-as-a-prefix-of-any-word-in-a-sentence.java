class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int countspaces=0;
        boolean flag=false;
       String[] arr = sentence.split(" ");
    for(String str:arr){
        
            if(hasprefix(str,searchWord)) return countspaces+1;
            countspaces++;
    }
    return -1;
}

    private boolean hasprefix(String str, String searchword){

    if(str.length()<searchword.length()) return false;

    for(int i =0;i<searchword.length();i++){
        if(!(searchword.charAt(i)==str.charAt(i))) return false;
    }
return true;
    }
}