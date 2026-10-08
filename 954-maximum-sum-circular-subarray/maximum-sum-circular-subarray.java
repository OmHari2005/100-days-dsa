class Solution {
    public int maxSubarraySumCircular(int[] arr) {
    int curMax = arr[0], globMax = arr[0];
    int curMin = arr[0], globMin = arr[0];
    int total = arr[0];

    for (int i = 1; i < arr.length; i++) {
        int x = arr[i];

        // Kadane for maximum
        curMax = Math.max(x, curMax + x);
        globMax = Math.max(globMax, curMax);

        // Kadane for minimum
        curMin = Math.min(x, curMin + x);
        globMin = Math.min(globMin, curMin);

        total += x;
    }

    if (globMax < 0) return globMax; // it is for all negative

    return Math.max(globMax, total - globMin);
}
    }
