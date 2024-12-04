class Solution {
    public String reverseWords(String s) {
        String[] words=s.split(" ");
        int spacecount=0;
        StringBuilder str=new StringBuilder();
        for(String word:words){
            for(int i=word.length()-1;i>=0;i--){
                str.append(word.charAt(i));
            }
            if(spacecount<words.length-1) {
                        str.append(" ");
                        spacecount++;}

        }
        return str.toString();
    }
}