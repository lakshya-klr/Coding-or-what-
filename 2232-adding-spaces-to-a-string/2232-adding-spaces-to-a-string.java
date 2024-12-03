class Solution {
    public String addSpaces(String s, int[] spaces) {
        Boolean[] bolo=new Boolean[s.length()];
        StringBuilder str = new StringBuilder();
        for(int i =0;i<bolo.length;i++) bolo[i]=false;
        for(int i =0;i<spaces.length;i++){
            bolo[spaces[i]]=true;
        }
        for(int i =0;i<s.length();i++){
            if(bolo[i]==true){
                str.append(" ");
                str.append(s.charAt(i));
            }
            else str.append(s.charAt(i));
        }
        return str.toString();
    }
}