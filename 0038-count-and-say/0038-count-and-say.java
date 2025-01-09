class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1 ; i < n ; i++) {
            s =  helper(s.toCharArray());
       }
        return s;
    }
    public String helper(char[] s) {
        StringBuilder str = new StringBuilder();
        int idx = 0;
        int count = 1;
        while(idx < s.length){
            int i = idx+1;
            while(i < s.length){
                if(s[idx] == s[i])
                count++;
                else break;

                i++;
            }
            str.append(count);
            str.append(s[idx]);
            idx = idx+count;
            count = 1;
        }
        return str.toString();
    }
}