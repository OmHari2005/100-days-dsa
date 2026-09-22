import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = 1000000000; // Represents infinity (no valid subarray found)
        
        // best[i] stores the shortest valid subarray length found at or before index i
        int[] best = new int[n];
        for (int i = 0; i < n; i++) {
            best[i] = INF;
        }
        
        int ans = INF;
        int currentSum = 0;
        int left = 0;
        
        // Main loop moving the right pointer one step at a time
        for (int right = 0; right < n; right = right + 1) {
            // Step 1: Add current element to window sum
            currentSum = currentSum + arr[right];
            
            // Step 2: Shrink window from the left if sum exceeds target
            while (currentSum > target) {
                currentSum = currentSum - arr[left];
                left = left + 1;
            }
            
            // Step 3: If window sum equals target
            if (currentSum == target) {
                int currentLen = right - left + 1;
                
                // Check if there is a valid non-overlapping subarray before 'left'
                if (left > 0) {
                    if (best[left - 1] != INF) {
                        int totalLen = currentLen + best[left - 1];
                        if (totalLen < ans) {
                            ans = totalLen;
                        }
                    }
                }
                
                // Update best[right]
                int prevBest = INF;
                if (right > 0) {
                    prevBest = best[right - 1];
                }
                
                if (currentLen < prevBest) {
                    best[right] = currentLen;
                } else {
                    best[right] = prevBest;
                }
            } else {
                // If sum is not target, pass forward the best result from previous index
                if (right > 0) {
                    best[right] = best[right - 1];
                }
            }
        }
        
        if (ans >= INF) {
            return -1;
        } else {
            return ans;
        }
    }
}