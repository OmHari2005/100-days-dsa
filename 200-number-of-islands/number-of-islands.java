class Solution {
    public boolean is(char grid[][],int i,int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n) return false;
        if(grid[i][j] == '0') return true;
        grid[i][j] = '0';
        boolean up = is(grid,i-1,j);
        boolean down = is(grid,i+1,j);
        boolean left = is(grid,i,j-1);
        boolean right = is(grid,i,j+1);
        return up || down || left || right;

    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        if(m == 1 && n == 1){
            if(grid[0][0] == '1') return 1;
            return 0;
        }
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == '1'){
                    if(is(grid,i,j)) ans++;
                }
            }
        }
        return ans;
    }
}