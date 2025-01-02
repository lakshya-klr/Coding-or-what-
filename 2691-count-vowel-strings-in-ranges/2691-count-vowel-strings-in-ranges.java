import java.util.Set;

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n + 1];  // prefix[i] stores the count of valid words up to index i-1
        
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

        // Preprocessing the words array to mark valid words
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (valid(words[i], set) ? 1 : 0);
        }

        int[] ans = new int[queries.length];
        
        // Answering the queries using the prefix sum array
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            ans[i] = prefix[end + 1] - prefix[start];  // Range sum query
        }

        return ans;
    }

    private boolean valid(String s, Set<Character> set) {
        // Check if both first and last characters are vowels
        return set.contains(s.charAt(0)) && set.contains(s.charAt(s.length() - 1));
    }
}
