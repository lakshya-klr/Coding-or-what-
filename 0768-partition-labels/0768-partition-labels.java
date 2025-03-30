class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        char[] c = s.toCharArray();

        List<Integer> ans = new ArrayList<>();

        HashMap<Character, Integer> pos = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // put the latest index in that character
            pos.put(c[i], i);
        }

        // all the positions of each character are there
        // build substring from the start and break it whenever possible
        int low = 0, high = 0;
        for (int i = 0; i < n; i++) {
            high = Math.max(high, pos.get(c[i]));
            if (i == high) {
                // breaking is possible
                int len = high - low + 1;
                ans.add(len);
                low = i + 1;
                high = i + 1;
            }
        }

        return ans;
    }
}