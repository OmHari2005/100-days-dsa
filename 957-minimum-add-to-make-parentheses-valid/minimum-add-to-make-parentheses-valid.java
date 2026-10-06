class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;  // '('
        int close= 0; //  ')'
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                close++; // We need a ')' to balance this '('
            } else {
                if (close> 0) {
                    close--; // Matches an earlier '('
                } else {
                    open++; // Unmatched ')', so we need an extra '('
                }
            }
        }
        
        return open + close;
    }
}