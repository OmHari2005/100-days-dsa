import java.util.*;

class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        Integer[] suffix = new Integer[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            suffix[i] = i;
            rank[i] = nums[i];
        }

        for (int length = 1; length < n; length *= 2) {
            final int gap = length;
            final int[] currentRank = rank;

            Arrays.sort(suffix, (a, b) -> {
                if (currentRank[a] != currentRank[b]) {
                    return Integer.compare(currentRank[a], currentRank[b]);
                }

                int secondA = a + gap < n ? currentRank[a + gap] : -1;
                int secondB = b + gap < n ? currentRank[b + gap] : -1;

                return Integer.compare(secondA, secondB);
            });

            int[] nextRank = new int[n];

            for (int i = 1; i < n; i++) {
                int a = suffix[i - 1];
                int b = suffix[i];

                int secondA = a + gap < n ? rank[a + gap] : -1;
                int secondB = b + gap < n ? rank[b + gap] : -1;

                boolean different =
                    rank[a] != rank[b] || secondA != secondB;

                nextRank[b] = nextRank[a] + (different ? 1 : 0);
            }

            rank = nextRank;

            if (rank[suffix[n - 1]] == n - 1) {
                break;
            }
        }

        int[] position = new int[n];

        for (int i = 0; i < n; i++) {
            position[suffix[i]] = i;
        }

        int[] lcp = new int[n];
        int common = 0;

        for (int i = 0; i < n; i++) {
            int pos = position[i];

            if (pos == 0) {
                common = 0;
                continue;
            }

            int j = suffix[pos - 1];

            while (i + common < n &&
                   j + common < n &&
                   nums[i + common] == nums[j + common]) {
                common++;
            }

            lcp[pos] = common;

            if (common > 0) {
                common--;
            }
        }

        int answer = n;

        for (int i = 0; i < n; i++) {
            int previousLcp = lcp[i];
            int nextLcp = i + 1 < n ? lcp[i + 1] : 0;

            int needed = Math.max(previousLcp, nextLcp) + 1;
            int suffixLength = n - suffix[i];

            if (needed <= suffixLength) {
                answer = Math.min(answer, needed);
            }
        }

        return answer;
    }
}