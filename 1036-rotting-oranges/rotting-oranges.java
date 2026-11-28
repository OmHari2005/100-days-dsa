class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int minutes = 0;

        while (true) {
            boolean anyRotten = false;
            boolean anyFresh = false;

            // Step 1: find fresh oranges that will rot in this minute
            boolean[][] willRot = new boolean[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    if (grid[i][j] == 1) {
                        anyFresh = true;
                    }

                    if (grid[i][j] == 2) {
                        anyRotten = true;

                        int[] rowDir = {-1, 1, 0, 0};
                        int[] colDir = {0, 0, -1, 1};

                        for (int d = 0; d < 4; d++) {
                            int newRow = i + rowDir[d];
                            int newCol = j + colDir[d];

                            if (newRow >= 0 && newRow < rows &&
                                newCol >= 0 && newCol < cols &&
                                grid[newRow][newCol] == 1) {

                                willRot[newRow][newCol] = true;
                            }
                        }
                    }
                }
            }

            // Step 2: rot them after scanning
            boolean changed = false;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (willRot[i][j]) {
                        grid[i][j] = 2;
                        changed = true;
                    }
                }
            }

            if (!changed) {
                break;
            }

            minutes++;
        }

        // Step 3: check if fresh oranges are still left
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minutes;
    }
}