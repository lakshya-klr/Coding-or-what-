class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] f1 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            f1[s.charAt(i) - 'a']++;
            f1[t.charAt(i) - 'a']--;
        }
        for (int n:f1) {
           if(n!=0) return false;
        }
        return true;
    }
}