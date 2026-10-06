class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;  // '('
        int close= 0; //  ')'
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                close++; //  need  ')' to balance '('
            } else {
                if (close> 0) {
                    close--; // Matches  early '('
                } else {
                    open++; // Unmatched ')' need  extra '('
                }
            }
        }
        
        return open + close;
    }
}