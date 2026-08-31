int dp[13][10001];
int fun(int i,vector<int>& coins,int amount){
    if(amount == 0) return 0;
    if(i >= coins.size() || amount < 0){
        return INT_MAX;
    }
    
    
     int take = INT_MAX;
    if(dp[i][amount]!= -1) return dp[i][amount];
    if(coins[i]<=amount){
        
       int x =  fun(i,coins,amount- coins[i]);
       if(x!= INT_MAX){
        take = 1+x;
       }
    }
    
    int nottake = fun(i+1,coins,amount);
    return dp[i][amount] = min(take,nottake);
}
class Solution {
public:  
    int coinChange( vector<int>& coins,int amount) {
        //vector<int> coins;
         memset(dp,-1,sizeof(dp));
         int ans = fun(0,coins,amount);
         if(ans == INT_MAX) return -1;
         return ans;
    }
};