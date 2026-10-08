class Solution {
    public String removeOuterParentheses(String s) {
        int level = 0;
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                if (level > 0) {
                    str.append(s.charAt(i));
                }
                level++;
            } else if (s.charAt(i) == ')') {
                level--;
                  if (level > 0) {
                    str.append(s.charAt(i));
                }
            }

        }
        return str.toString();
    }
}