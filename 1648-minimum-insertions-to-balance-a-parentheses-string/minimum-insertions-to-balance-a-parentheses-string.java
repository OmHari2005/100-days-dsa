class Solution {
    public int minInsertions(String s) {
        int close = 0;
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (close % 2 == 1) {
                    open++;
                    close--;
                }
                close += 2;
            } else {
                close--;
                if (close < 0) {
                    open++;
                    close = 1;
                }
            }
        }
        return open + close;
    }
}