class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] netShifts = new int[n + 1]; // One extra element to handle end ranges

        // Step 1: Calculate the net shifts using the prefix sum technique
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2] == 1 ? 1 : -1;

            netShifts[start] += direction;
            if (end + 1 < n) {
                netShifts[end + 1] -= direction;
            }
        }

        // Step 2: Apply the cumulative shifts to each character
        char[] splits = s.toCharArray();
        int cumulativeShift = 0;
        for (int i = 0; i < n; i++) {
            cumulativeShift += netShifts[i];
            int effectiveShift = (cumulativeShift % 26 + 26) % 26; // Handle negative shifts
            splits[i] = (char) ((splits[i] - 'a' + effectiveShift) % 26 + 'a');
        }

        // Convert the result to a string
        return new String(splits);
    }
}
