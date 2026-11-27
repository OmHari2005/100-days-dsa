class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] bonus = new int[n];

        for (int i = 0; i < n; i++) {
            int factor = items[i][0];
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (j != i && items[j][0] % factor == 0) {
                    count++;
                }
            }

            bonus[i] = count;
        }

        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int freeCopies = bonus[i];

            int[] g = new int[budget + 1];

            for (int b = price; b <= budget; b++) {
                int buyFirstCopy = dp[b - price] + 1 + freeCopies;
                int buyMoreCopies = g[b - price] + 1;

                g[b] = Math.max(buyFirstCopy, buyMoreCopies);
            }

            for (int b = 0; b <= budget; b++) {
                dp[b] = Math.max(dp[b], g[b]);
            }
        }

        return dp[budget];
    }
}