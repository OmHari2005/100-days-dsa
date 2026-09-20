class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        
        // CASE 1: Circle center is inside the rectangle
        if (xCenter >= x1 && xCenter <= x2 && yCenter >= y1 && yCenter <= y2) {
            return true;
        }

        // CASE 2: Any of the 4 rectangle corners are inside/on the circle
        int[][] corners = {
            {x1, y1}, // Bottom-left
            {x1, y2}, // Top-left
            {x2, y1}, // Bottom-right
            {x2, y2}  // Top-right
        };

        for (int[] corner : corners) {
            int dx = xCenter - corner[0];
            int dy = yCenter - corner[1];
            if (dx * dx + dy * dy <= radius * radius) {
                return true;
            }
        }

        // CASE 3: Circle touches/intersects the edges (vertical or horizontal sides)
        // Check horizontal overlap (circle center aligns between x1 and x2)
        if (xCenter >= x1 && xCenter <= x2) {
            if (Math.abs(yCenter - y1) <= radius || Math.abs(yCenter - y2) <= radius) {
                return true;
            }
        }

        // Check vertical overlap (circle center aligns between y1 and y2)
        if (yCenter >= y1 && yCenter <= y2) {
            if (Math.abs(xCenter - x1) <= radius || Math.abs(xCenter - x2) <= radius) {
                return true;
            }
        }

        // If none of the conditions met, they do not overlap
        return false;
    }
}