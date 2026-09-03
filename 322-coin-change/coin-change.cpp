int dp[13][10001];
int fun(int i,vector<int>& coins,int amount){
    if(amount == 0) return 0;
    if(i >= coins.size() || amount < 0){
        return 1e9;
    }
    if(dp[i][amount] != -1) return dp[i][amount];
    int take = 1+ fun(i,coins,amount-coins[i]);
    int notTake = fun(i+1,coins,amount);

    return dp[i][amount] = min(take,notTake);
}
class Solution {
public:  
    int coinChange( vector<int>& coins,int amount) {
        //vector<int> coins;
         memset(dp,-1,sizeof(dp));
         int ans = fun(0,coins,amount);
         if(ans==1e9) return -1;
         return ans;
    }
};