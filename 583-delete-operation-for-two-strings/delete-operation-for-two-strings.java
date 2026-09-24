class Solution {

    public int[][] dp;

    public int fun(int i, int j, String word1, String word2 ) {
        int n = word1.length();
        int m = word2.length();
        if (i >= n || j >= m) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans;
        if (word1.charAt(i) == word2.charAt(j)) {
            ans = 1 + fun(i + 1, j + 1, word1, word2);
        } 
        else {
            int c1 = fun(i + 1, j, word1, word2);
            int c2 = fun(i, j + 1, word1, word2);
            ans = Math.max(c1, c2);
        }
        dp[i][j] = ans;
        return ans;
    }

     public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();

        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        int lcs=fun(0,0,word1,word2);
        return n+m -2*lcs;
    }
}



