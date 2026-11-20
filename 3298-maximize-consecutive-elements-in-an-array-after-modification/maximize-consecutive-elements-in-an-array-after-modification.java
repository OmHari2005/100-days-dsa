import java.util.*;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        Map<Integer, Integer> dp = new HashMap<>();

        int ans = 0;

        for (int num : nums) {

            int oldDpNum = dp.getOrDefault(num, 0);
            int oldDpNumMinusOne = dp.getOrDefault(num - 1, 0);

            dp.put(num, Math.max(oldDpNum, oldDpNumMinusOne + 1));
            
            dp.put(num + 1, Math.max(
                dp.getOrDefault(num + 1, 0),
                oldDpNum + 1
            ));

            ans = Math.max(ans, dp.get(num));
            ans = Math.max(ans, dp.get(num + 1));
        }

        return ans;
    }
}