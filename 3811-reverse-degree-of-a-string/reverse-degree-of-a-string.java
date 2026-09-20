class Solution {
    public int reverseDegree(String s) {
        int totalSum = 0;

        for (int i = 0; i < s.length(); i++) {
            int charRevIndex = 26 - (s.charAt(i) - 'a');
            int stringIndex = i + 1; // 1-indexed string position
            
            totalSum += charRevIndex * stringIndex;
        }

        return totalSum;
    }
}