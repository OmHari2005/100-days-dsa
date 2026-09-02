int dp[301][5001];
int fun(int i,vector<int>& coins,int amount){
    if(amount == 0) return 1;
    if(i>= coins.size() || amount <0){
        return 0;
    }
    if(dp[i][amount]!= -1) return dp[i][amount];

    int take =  fun(i,coins,amount- coins[i]);
    int nottake = fun(i+1,coins,amount);
    return dp[i][amount] = take + nottake;
}
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        //vector<int> coins;
         memset(dp,-1,sizeof(dp));
         return fun(0,coins,amount);
    }
};