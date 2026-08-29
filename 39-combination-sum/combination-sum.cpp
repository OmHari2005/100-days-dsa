class Solution {
    void solve(int index, int target, vector<int>& candidates,vector<int>& current,vector<vector<int>>& answer) {
        // Combination का sum target हो गया
        if (target == 0) {
            answer.push_back(current);
            return;
        }
        // Invalid path
        if (target < 0 || index >= candidates.size()) {
            return;
        }
        // Current candidate को choose करो
        current.push_back(candidates[index]);
        // Same candidate दोबारा use कर सकते हैं
        solve(index, target - candidates[index],
              candidates, current, answer);
        // Undo choice
        current.pop_back();
        // Current candidate को skip करो
        solve(index + 1, target,
              candidates, current, answer);
    }

public:
    vector<vector<int>> combinationSum(vector<int>& candidates,int target) {
        vector<vector<int>> answer;
        vector<int> current;
        solve(0, target, candidates, current, answer);
        return answer;
    }
};