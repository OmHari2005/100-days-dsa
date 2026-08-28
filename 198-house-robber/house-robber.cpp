class Solution {
public:
int dp[101];

int fun(vector<int> &nums,int i){
    if(i>=nums.size()) return 0;
    if (dp[i] != -1)
     return dp[i];
    int c1= nums[i] + fun(nums,i+2);
    int c2 = fun(nums,i+1);
    return dp[i] = max(c1,c2);
}
    int rob(vector<int>& nums) {
       memset(dp, -1, sizeof(dp));
       return fun(nums,0); 
    }
};