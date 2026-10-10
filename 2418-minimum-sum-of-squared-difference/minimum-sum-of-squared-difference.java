class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        long[] freq = new long[100001];
        
        for (int i = 0; i < nums1.length; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            freq[d]++;
        }
        
        for (int d = 100000; d > 0 && k > 0; d--) {
            if (freq[d] > 0) {
                long take = Math.min(k, freq[d]);
                freq[d] -= take;
                freq[d - 1] += take;
                k -= take;
            }
        }
        
        long ans = 0;
        for (int d = 1; d <= 100000; d++) {
            if (freq[d] > 0) {
                ans += freq[d] * d * d;
            }
        }
        
        return ans;
    }
}