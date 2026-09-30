class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int k = 0;
        int[] ans = new int[seq.length()];

        for (int i = 0; i < seq.length(); i++) {
            char ch = seq.charAt(i);
            if (ch == '(') {
                k++;
                ans[i] = k % 2;
            } else {
                ans[i] = k % 2;
                k--;
            }
        }

        return ans;
    }
}