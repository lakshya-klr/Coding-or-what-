class Solution {
    public boolean canChange(String start, String target) {
        if (start.length() != target.length()) return false;

        int i = 0, j = 0;
        int n = start.length();

        while (i < n || j < n) {
            // Skip underscores in `start`
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            // Skip underscores in `target`
            while (j < n && target.charAt(j) == '_') {
                j++;
            }

            // If both reach the end, return true
            if (i == n && j == n) return true;

            // If one reaches the end but not the other, return false
            if (i == n || j == n) return false;

            // Characters must match at the current indices
            if (start.charAt(i) != target.charAt(j)) return false;

            // Placement rules for 'L' and 'R'
            if ((target.charAt(j) == 'L' && i < j) || (target.charAt(j) == 'R' && i > j)) {
                return false;
            }

            // Move both pointers
            i++;
            j++;
        }

        return true;
    }
}
