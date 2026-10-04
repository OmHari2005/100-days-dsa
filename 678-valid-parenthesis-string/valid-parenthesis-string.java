class Solution {
    Boolean[][][] dp;
    boolean func(String s, int i, int a, int b) {
        if (b>a) {
            return false;
        }
        if (i==s.length()) {
            return a==b;
        }

        if (dp[i][a][b] !=null) {
            return dp[i][a][b];
        }

        char ch = s.charAt(i);
        boolean ans;

        if (ch=='(') {
            ans = func(s, i+1, a+1, b);
        }
        else if (ch==')') {
            ans = func(s, i+1, a, b+1);
        }
        else {
            boolean c1 = func(s, i+1, a+1, b);
            boolean c2 = func(s, i+1, a, b+1);
            boolean c3 = func(s, i+1, a, b);

            ans = c1 || c2 || c3;
        }

        return dp[i][a][b]=ans;
    }

    public boolean checkValidString(String s) {
        int n = s.length();
        dp = new Boolean[n][n+1][n+1];

        return func(s, 0, 0, 0);
    }
}