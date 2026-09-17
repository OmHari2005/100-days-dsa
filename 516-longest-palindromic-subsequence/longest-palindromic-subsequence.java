class Solution {

    private int[][] dp;
    private int lcs(int i, int j, String s, String t) {
        int n = s.length();
        int m = t.length();

        if (i >= n || j >= m) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans;
        if (s.charAt(i) == t.charAt(j)) {
            ans = 1 + lcs(i + 1, j + 1, s, t);
        } 
        else {
            int c1 = lcs(i + 1, j, s, t);
            int c2 = lcs(i, j + 1, s, t);
            ans = Math.max(c1, c2);
        }

        dp[i][j] = ans;
        return ans;
    }

    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString(); 

        int n = s.length();
        int m = t.length();
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        return lcs(0, 0, s, t);
    }
}