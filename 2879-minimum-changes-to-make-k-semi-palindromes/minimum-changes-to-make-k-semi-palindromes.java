import java.util.Arrays;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();

        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                cost[i][j] = getCost(s, i, j);
            }
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int parts = 0; parts < k; parts++) {
                if (dp[i][parts] == Integer.MAX_VALUE) {
                    continue;
                }

                for (int j = i + 1; j < n; j++) {
                    int newCost = dp[i][parts] + cost[i][j];

                    if (newCost < dp[j + 1][parts + 1]) {
                        dp[j + 1][parts + 1] = newCost;
                    }
                }
            }
        }

        return dp[n][k];
    }
    int getCost(String s, int start, int end) {
    int len = end - start + 1;
    int best = Integer.MAX_VALUE;

    for (int d = 1; d < len; d++) {
        if (len % d != 0) {
            continue;
        }

        int currentCost = 0;

        for (int r = 0; r < d; r++) {
            int left = start + r;
            int right = start + ((len - 1 - r) / d) * d + r;

            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    currentCost++;
                }

                left += d;
                right -= d;
            }
        }

        best = Math.min(best, currentCost);
    }

    return best;
  }
}