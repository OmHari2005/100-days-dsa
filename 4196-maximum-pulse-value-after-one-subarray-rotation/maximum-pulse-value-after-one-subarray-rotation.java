import java.util.Arrays;

class Solution {
    private long[][][][] dp;

    private long fun(int i, int[] nums, int f, int sg, int pr) {
        if (i >= nums.length) {
            if (f == 1) return (long) -1e17;
            return 0;
        }

        int sgIdx;
        if (sg == 1) {
            sgIdx = 1;
        } else {
            sgIdx = 0;
        }

        if (dp[i][f][sgIdx][pr + 1] != (long) -1e18) {
            return dp[i][f][sgIdx][pr + 1];
        }

        long crr = 1L * nums[i] * sg;
        long m = (long) -1e17;

        if (f == 0) {
            long a = (-1 * crr) + fun(i + 1, nums, 1, sg, i % 2);
            long b = (crr) + fun(i + 1, nums, f, -1 * sg, pr);

            m = Math.max(m, a);
            m = Math.max(m, b);
        } 
        else if (f == 1) {
            long a = (crr) + fun(i + 1, nums, f, -1 * sg, pr);
            m = Math.max(m, a);

            if (i % 2 != pr) {
                long b = crr + fun(i + 1, nums, 2, sg, -1);
                m = Math.max(m, b);
            }
        } 
        else if (f == 2) {
            long a = (crr) + fun(i + 1, nums, f, -1 * sg, pr);
            m = Math.max(m, a);
        }

        return dp[i][f][sgIdx][pr + 1] = m;
    }

    public long maxValue(int[] nums) {
        int n = nums.length;
        dp = new long[n + 1][3][2][3];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 2; k++) {
                    Arrays.fill(dp[i][j][k], (long) -1e18);
                }
            }
        }

        return fun(0, nums, 0, 1, -1);
    }
}