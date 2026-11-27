class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int oldColor = image[sr][sc];
        if (oldColor == color) {
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{sr, sc});
        image[sr][sc] = color;

        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] cell = queue.remove();

            int row = cell[0];
            int col = cell[1];

            for (int i = 0; i < 4; i++) {
                int newRow = row + rowDir[i];
                int newCol = col + colDir[i];

                if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < m &&
                    image[newRow][newCol] == oldColor) {

                    image[newRow][newCol] = color;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }

        return image;
    }
}