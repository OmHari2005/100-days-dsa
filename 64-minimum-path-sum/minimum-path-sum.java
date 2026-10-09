class Solution {
    public int func(int i, int j, int[][] grid, int[][] dp) {
        if (i==grid.length-1 && j==grid[0].length-1) {
            return grid[i][j];
        }
        if (i>=grid.length || j>=grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int r = func(i, j+1, grid, dp);
        int d = func(i+1, j, grid, dp);

        return dp[i][j] = grid[i][j]+Math.min(r, d);
        
    }


    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i=0; i<m;i++) {
            for (int j=0; j<n;j++) {
                dp[i][j] = -1;
            }
        }

        return func(0, 0, grid, dp);
    }
}