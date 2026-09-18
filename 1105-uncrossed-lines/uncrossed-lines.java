/*class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
    }
}*/
class Solution {

    private int[][] dp;

    private int fun(int i, int j, int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (i >= n || j >= m) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans;
        if (nums1[i] == nums2[j]) {
            ans = 1 + fun(i + 1, j + 1, nums1, nums2);
        } 
        else {
            int c1 = fun(i + 1, j, nums1, nums2);
            int c2 = fun(i, j + 1, nums1, nums2);
            ans = Math.max(c1, c2);
        }
        dp[i][j] = ans;
        return ans;
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        return fun(0, 0, nums1, nums2);
    }
}