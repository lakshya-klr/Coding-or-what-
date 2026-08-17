class Solution {
    public String reverseVowels(String s) {
    StringBuilder str = new StringBuilder();

            Stack<Character> stack = new Stack<>();

    for(int i =0;i<s.length();i++){
    if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' ||
    s.charAt(i) == 'o' || s.charAt(i) == 'u' ||
    s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' ||
    s.charAt(i) == 'O' || s.charAt(i) == 'U') {

stack.push(s.charAt(i));
        }
    }
 for(int i =0;i<s.length();i++){
     if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' ||
    s.charAt(i) == 'o' || s.charAt(i) == 'u' ||
    s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' ||
    s.charAt(i) == 'O' || s.charAt(i) == 'U') {

            str.append(stack.pop());
        }
        else {
            str.append(s.charAt(i));
        }}

return str.toString();
    }
}