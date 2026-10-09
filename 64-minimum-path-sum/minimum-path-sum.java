class Solution {
    public int func(int x, int y, int[][] grid, int[][] dp) {
        if (x==grid.length-1 && y==grid[0].length-1) {
            return grid[x][y];
        }
        if (x>=grid.length || y>=grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        int r = func(x, y+1, grid, dp);
        int d = func(x+1, y, grid, dp);

        return dp[x][y] = grid[x][y]+Math.min(r, d);
        
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