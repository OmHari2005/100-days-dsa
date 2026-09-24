long long dp[100003][3][2][3];

long long fun(int i,vector<int>&nums,int f,int sg,int pr){
    if(i>=nums.size()){
        if(f==1) return -1e17;
        return 0;
    }

    if(dp[i][f][sg==1?1:0][pr+1]!=-1e18)
        return dp[i][f][sg==1?1:0][pr+1];

    long long crr=1LL*nums[i]*sg;

    long long m=-1e17;

    if(f==0){
        long long a=(-1*crr)+fun(i+1,nums,1,sg,i%2);
        long long b=(crr)+fun(i+1,nums,f,-1*sg,pr);

        m=max(m,a);
        m=max(m,b);
    }
    else if(f==1){
        long long a=(crr)+fun(i+1,nums,f,-1*sg,pr);
        m=max(m,a);

        if(i%2!=pr){
            long long b=crr+fun(i+1,nums,2,sg,-1);
            m=max(m,b);
        }
    }
    else if(f==2){
        long long a=(crr)+fun(i+1,nums,f,-1*sg,pr);
        m=max(m,a);
    }

    return dp[i][f][sg==1?1:0][pr+1]=m;
}


class Solution {
public:
    long long maxValue(vector<int>& nums) {
        for(int i=0;i<100003;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<2;k++){
                    for(int l=0;l<3;l++){
                        dp[i][j][k][l]=-1e18;
                    }
                }
            }
        }

        return fun(0,nums,0,1,-1);
    }
};