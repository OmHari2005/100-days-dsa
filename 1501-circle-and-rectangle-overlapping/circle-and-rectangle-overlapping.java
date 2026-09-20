class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // Find the point inside/on the rectangle closest to the circle's center
        int nearestX = Math.max(x1, Math.min(xCenter, x2));
        int nearestY = Math.max(y1, Math.min(yCenter, y2));
        
        // Calculate squared Euclidean distance
        int dx = xCenter - nearestX;
        int dy = yCenter - nearestY;
        
        // Overlap occurs if distance <= radius
        if((dx * dx + dy * dy) <= (radius * radius)){
            return true;
        }
        return false;
    }
}