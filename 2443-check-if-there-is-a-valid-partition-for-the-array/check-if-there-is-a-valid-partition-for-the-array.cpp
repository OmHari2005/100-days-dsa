class Solution {
public:
    bool validPartition(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n + 1, -1);
        return fun(nums, 0, dp);
    }
private:
    bool fun(vector<int>& nums, int i, vector<int>& dp) {
        int n = nums.size();

        if (i == nums.size()) {
            return true;
        }
        if (i + 1 >= nums.size()) {
            return false;
        }
        if (dp[i] != -1) {
            return dp[i] == 1;
        }

        // Condition 1: nums[i] == nums[i+1]
        if (i + 1 < nums.size() && nums[i + 1] == nums[i]) {
            if (fun(nums, i + 2, dp)) {
                dp[i] = 1;
                return true;
            }
        }
        if (i + 2 >= nums.size()) {
            dp[i] = 0;
            return false;
        }
        // Condition 2: nums[i] == nums[i+1] == nums[i+2]
        if (nums[i + 2] == nums[i + 1] && nums[i + 1] == nums[i]) {
            if (fun(nums, i + 3, dp)) {
                dp[i] = 1;
                return true;
            }
        }
        // Condition 3: nums[i+1] == nums[i] + 1 && nums[i+2] == nums[i] + 2
        if (nums[i + 1] == nums[i] + 1 && nums[i + 2] == nums[i] + 2) {
            if (fun(nums, i + 3, dp)) {
                dp[i] = 1;
                return true;
            }
        }

        dp[i] = 0;
        return false;
    }
};