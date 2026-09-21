class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];      // final counts for each remainder
        long[] dp = new long[k];       // dp[r] = #subarrays ending here with product % k == r

        for (int num : nums) {
            long[] newDp = new long[k];
            int numMod = num % k;

            // 1) Start new subarray at current index
            newDp[numMod]++;

            // 2) Extend all previous subarrays
            for (int r = 0; r < k; r++) {
                if (dp[r] == 0) continue;
                int newMod = (int)((1L * r * numMod) % k);
                newDp[newMod] += dp[r];
            }

            // 3) Add to answer
            for (int r = 0; r < k; r++) {
                ans[r] += newDp[r];
            }

            // 4) Move to next
            dp = newDp;
        }

        return ans;
    }
}