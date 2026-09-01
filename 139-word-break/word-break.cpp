 int dp[301];

    bool fun(int i, string &s, vector<string> &wordDict) {
        if(i == s.size())
            return true;
        if(dp[i] != -1)
            return dp[i];
        string temp = "";
        for(int j = i; j < s.size(); j++) {
            temp += s[j];
            if(find(wordDict.begin(), wordDict.end(), temp) != wordDict.end()) {
                if(fun(j + 1, s, wordDict))
                return dp[i] = true;
            }
        }
        return dp[i] = false;
    }
class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {

        memset(dp, -1, sizeof(dp));

        return fun(0, s, wordDict);
    }
};