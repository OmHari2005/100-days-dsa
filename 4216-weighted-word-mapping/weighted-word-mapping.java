class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();

        for (String w : words) {
            int sum = 0;
            for (char c : w.toCharArray()) {
                sum += weights[c - 'a'];
            }
            int r = sum % 26;
            char mapped = (char) ('a' + (25 - r));
            ans.append(mapped);
        }

        return ans.toString();
    }
}