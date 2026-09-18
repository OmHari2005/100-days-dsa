import java.util.*;

class Solution {

    public long shadowPairs(int[] nums) {
        long ans = 0;
        ArrayList<Integer> s1 = new ArrayList<>();

        for (int x : nums) {
            // Remove elements from the back that are greater than x
            while (!s1.isEmpty() && s1.get(s1.size() - 1) > x) {
                s1.remove(s1.size() - 1);
            }

            // Insert x; s1 remains sorted
            s1.add(x);

            // Count elements in s1 that are < x
            int j = lowerBound(s1, x);
            ans += j;
        }

        return ans;
    }

    /**
     * Returns the first index in the sorted list where list.get(idx) >= key.
     * If all elements are < key, returns list.size().
     */
    private int lowerBound(ArrayList<Integer> list, int key) {
        int left = 0;
        int right = list.size(); // search range is [left, right)

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) >= key) {
                // mid might be the answer, but try to find an earlier one
                right = mid;
            } else {
                // all elements up to mid are < key, so answer is to the right
                left = mid + 1;
            }
        }

        return left;
    }
}