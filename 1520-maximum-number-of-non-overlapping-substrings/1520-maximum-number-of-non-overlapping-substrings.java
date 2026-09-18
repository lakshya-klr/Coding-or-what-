class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        List<String> result = new ArrayList<>();
        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);

        // Find first and last occurrence of every character
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            if (first[c] == -1) {
                first[c] = i;
            }

            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Find all valid substrings
        for (int i = 0; i < n; i++) {

            int c = s.charAt(i) - 'a';

            // Only start from the first occurrence
            if (first[c] != i) {
                continue;
            }

            int end = last[c];
            boolean valid = true;

            for (int j = i; j <= end; j++) {

                int current = s.charAt(j) - 'a';

                // This character appeared before i
                if (first[current] < i) {
                    valid = false;
                    break;
                }

                // Need to include all occurrences of this character
                end = Math.max(end, last[current]);
            }

            if (valid) {
                intervals.add(new int[]{i, end});
            }
        }

        // Earliest ending substring first
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        // Pick maximum number of non-overlapping substrings
        int prevEnd = -1;

        for (int[] interval : intervals) {

            if (interval[0] > prevEnd) {
                result.add(s.substring(interval[0], interval[1] + 1));
                prevEnd = interval[1];
            }
        }

        return result;
    }
}