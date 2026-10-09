class Solution {

    public int func(int x,int y,List<List<Integer>> triangle,Integer[][] dp) {
        if (x==triangle.size()-1) {
            return triangle.get(x).get(y);
        }

        if (dp[x][y] != null) {
            return dp[x][y];
        }

        int l = func(x+1, y, triangle, dp);
        int r = func(x+1, y+1, triangle, dp);

        return dp[x][y] = triangle.get(x).get(y)+Math.min(l, r);
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];

        for (int i=0;i<n;i++) {
            Arrays.fill(dp[i], null);
        }

        return func(0, 0, triangle, dp);
    }
}