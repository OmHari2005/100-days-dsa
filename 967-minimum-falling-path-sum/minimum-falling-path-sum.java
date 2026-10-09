class Solution {
    public int func(int x, int y, int[][] matrix, Integer[][] dp) {
        if (y<0 || y>=matrix[0].length) {
            return Integer.MAX_VALUE;
        }

        if (x==matrix.length-1) {
            return matrix[x][y];
        }

        if (dp[x][y]!=null) {
            return dp[x][y];
        }

        int l = func(x+1, y-1, matrix, dp);
        int d = func(x+1, y, matrix, dp);
        int r = func(x+1, y+1, matrix, dp);

        return dp[x][y] = matrix[x][y]+Math.min(l, Math.min(d, r));
    }


    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        Integer[][] dp = new Integer[n][n];

        for (int i=0;i<n;i++) {
            Arrays.fill(dp[i], null);
        }

        int ans=Integer.MAX_VALUE;
        for (int j=0; j<n;j++) {
            ans= Math.min(ans, func(0, j, matrix, dp));
        }
        return ans;
    }
}