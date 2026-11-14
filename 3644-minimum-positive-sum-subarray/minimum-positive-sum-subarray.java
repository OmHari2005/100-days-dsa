class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int ans = Integer.MAX_VALUE;

        for (int start = 0; start < n; start++) {
            int sum = 0;

            for (int end = start; end < n; end++) {
                sum += nums.get(end);

                int length = end - start + 1;

                if (length >= l && length <= r && sum > 0) {
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