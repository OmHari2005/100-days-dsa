class Solution {
public:
int dp[31];
    int fib(int n) {
        memset(dp, -1, sizeof(dp));
        if(n==0) return 0;
        if(n==1) return 1;
        if(dp[n]!= -1){
            return dp[n];
        }

    int curr = fib(n-1) + fib(n-2);
    return dp[n]=curr;
    }
};