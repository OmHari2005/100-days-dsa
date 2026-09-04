class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] sufMin = new int[n];
        sufMin[n - 1] = nums[n - 1];

        for (int j = n - 2; j >= 0; j--)
            sufMin[j] = Math.min(nums[j], sufMin[j + 1]);

        int preMax = nums[0];
        for (int i = 0; i < n; i++) {
            preMax = Math.max(preMax, nums[i]);
            if (preMax - sufMin[i] <= k)
                return i;
        }
        return -1;
    }

}
