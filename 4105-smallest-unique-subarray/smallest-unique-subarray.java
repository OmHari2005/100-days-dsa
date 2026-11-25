import java.util.*;

class Solution {
    private static final long MOD1 = 1_000_000_007L;
    private static final long MOD2 = 1_000_000_009L;
    private static final long BASE = 100_003L;

    private long[] hash1;
    private long[] hash2;
    private long[] power1;
    private long[] power2;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        hash1 = new long[n + 1];
        hash2 = new long[n + 1];
        power1 = new long[n + 1];
        power2 = new long[n + 1];

        power1[0] = 1;
        power2[0] = 1;

        for (int i = 0; i < n; i++) {
            hash1[i + 1] = (hash1[i] * BASE + nums[i]) % MOD1;
            hash2[i + 1] = (hash2[i] * BASE + nums[i]) % MOD2;

            power1[i + 1] = power1[i] * BASE % MOD1;
            power2[i + 1] = power2[i] * BASE % MOD2;
        }

        int low = 1;
        int high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (hasUnique(mid, n)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean hasUnique(int len, int n) {
        Map<Long, Integer> frequency = new HashMap<>();

        for (int start = 0; start + len <= n; start++) {
            int end = start + len;

            long first = (
                hash1[end] - hash1[start] * power1[len] % MOD1 + MOD1
            ) % MOD1;

            long second = (
                hash2[end] - hash2[start] * power2[len] % MOD2 + MOD2
            ) % MOD2;

            long key = (first << 32) | second;

            frequency.put(key, frequency.getOrDefault(key, 0) + 1);
        }

        for (int count : frequency.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}