class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];

        int x3 = rec2[0];
        int y3 = rec2[1];
        int x4 = rec2[2];
        int y4 = rec2[3];

        // No overlap conditions
        if (x2 <= x3) return false;  // rect1 left of rect2
        if (x4 <= x1) return false;  // rect1 right of rect2
        if (y2 <= y3) return false;  // rect1 below rect2
        if (y4 <= y1) return false;  // rect1 above rect2

        // If none of the above, they overlap
        return true;
    }
}