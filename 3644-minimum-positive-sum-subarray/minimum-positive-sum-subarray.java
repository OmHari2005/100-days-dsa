class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int ans = Integer.MAX_VALUE;

        for (int len = l; len <= r; len++) {
            int sum = 0;

            for (int i = 0; i < len; i++) {
                sum += nums.get(i);
            }

            if (sum > 0) {
                ans = Math.min(ans, sum);
            }

            for (int i = len; i < n; i++) {
                sum += nums.get(i);
                sum -= nums.get(i - len);

                if (sum > 0) {
                    ans = Math.min(ans, sum);
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            return -1;
        }

        return ans;
    }
}