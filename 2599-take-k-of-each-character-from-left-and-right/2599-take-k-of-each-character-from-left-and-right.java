class Solution {
    public int takeCharacters(String s, int k) {
        int[] count = new int[3];
        
        // Count the total occurrences of each character in the string
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        // If any character has less than `k` occurrences, it's impossible
        if (count[0] < k || count[1] < k || count[2] < k) return -1;
        
        // Sliding window to find the longest valid substring
        int maxValidLength = 0;
        int start = 0;
        int[] windowCount = new int[3];
        
        for (int end = 0; end < s.length(); end++) {
            windowCount[s.charAt(end) - 'a']++;
            
            // Shrink the window if it makes any character count invalid
            while (windowCount[0] > count[0] - k || 
                   windowCount[1] > count[1] - k || 
                   windowCount[2] > count[2] - k) {
                windowCount[s.charAt(start) - 'a']--;
                start++;
            }
            
            // Update the max valid length
            maxValidLength = Math.max(maxValidLength, end - start + 1);
        }
        
        // Minimum length to remove is total length minus the max valid length
        return s.length() - maxValidLength;
    }
}
