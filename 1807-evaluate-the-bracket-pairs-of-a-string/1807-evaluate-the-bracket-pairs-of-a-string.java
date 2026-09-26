class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        Map<String, String> map = new HashMap<>();

        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                StringBuilder substr = new StringBuilder();
                int j = i + 1;

                while (s.charAt(j) != ')') {
                    substr.append(s.charAt(j));
                    j++;
                }

                i = j;

                String result = map.getOrDefault(substr.toString(), "?");
                str.append(result);

            } else {
                str.append(s.charAt(i));
            }
        }

        return str.toString();
    }
}