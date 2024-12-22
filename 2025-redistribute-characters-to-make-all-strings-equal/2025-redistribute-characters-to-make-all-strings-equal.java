class Solution {
    public boolean makeEqual(String[] words) {
        int len_words = words.length;

        if (len_words == 1) {
            return true;
        }

        int total_char = 0;
        for (String word: words) {
            total_char += word.length();
        }

        if (total_char % len_words != 0) {
            return false;
        }

        int[] freq = new int[26];
        for (String word: words) {
            for (char c: word.toCharArray()) {
                freq[c - 'a']++;
            }
        }

        for (int i: freq) {
            if (i % len_words != 0) {
                return false;
            }
        }

        return true;
    }
}