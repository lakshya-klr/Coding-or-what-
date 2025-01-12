class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        
        // If the length of s is odd, it can never be valid
        if (n % 2 != 0) return false;

        // First pass: left to right
        int balance = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                balance += (s.charAt(i) == '(') ? 1 : -1;
            } else {
                // Treat unlocked as either '(' or ')'
                balance += 1; // Assume it's '('
            }
            // If balance goes negative, we have more ')' than '('
            if (balance < 0) return false;
        }

        // Second pass: right to left
        balance = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                balance += (s.charAt(i) == ')') ? 1 : -1;
            } else {
                // Treat unlocked as either ')' or '('
                balance += 1; // Assume it's ')'
            }
            // If balance goes negative, we have more '(' than ')'
            if (balance < 0) return false;
        }

        return true; // If we never went negative in both passes
    }
}