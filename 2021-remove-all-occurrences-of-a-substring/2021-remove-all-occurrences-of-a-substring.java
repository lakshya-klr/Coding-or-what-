class Solution {
    public String removeOccurrences(String s, String part) {
        return rec(s, part);
    }

    public String rec(String str, String part) {
        if (str.contains(part)) {
            str = str.replaceFirst(part, ""); // Use replaceFirst or replaceAll
            return rec(str, part); // Recur with updated string
        } 
        return str; // Base case: return when no more occurrences
    }
}
