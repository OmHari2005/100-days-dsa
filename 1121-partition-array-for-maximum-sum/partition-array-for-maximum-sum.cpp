int dp[501][501];

int fun(int i,int p,vector<int>&nums,int m,int k){
    if(i>=nums.size()) return 0;
    int len=i-p+1;
    if(dp[i][p]!=-1) return dp[i][p];
    m=max(m,nums[i]);
    int ans=0;

    if(len==k){
       int a=m*len +fun(i+1,i+1,nums,0,k);
       ans=max(ans,a);
    }
    else{
        int a=m*len +fun(i+1,i+1,nums,0,k);
        int b=fun(i+1,p,nums,m,k);
        ans=max(ans,a);
        ans=max(ans,b);
    }
    return dp[i][p]=ans;
}

class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        memset(dp,-1,sizeof(dp));
        return fun(0,0,arr,0,k);
    }
};