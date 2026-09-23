class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum - x;

        // If target is negative, x is strictly greater than the array sum
        if (target < 0) {
            return -1;
        }

        int i = 0, j = 0;
        int currentSum = 0;
        int maxLen = -1;

        while (j < nums.length) {
            currentSum += nums[j];

            // Use i <= j so the window can collapse completely if nums[j] > target
            while (currentSum > target && i <= j) {
                currentSum -= nums[i];
                i++;
            }

            if (currentSum == target) {
                maxLen = Math.max(maxLen, j - i + 1);
            }

            j++;
        }

        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}