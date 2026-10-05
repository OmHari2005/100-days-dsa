class Solution {
    long[][][] dp;
    public long func(int i, int s, int d, int[] nums){
        if(i==nums.length) return Long.MIN_VALUE/2;

        if(dp[i][s][d] !=Long.MIN_VALUE){
            return dp[i][s][d];
        }

        long v;
        
        if(s==0){
            v=nums[i];
        }
        else{
            v=-nums[i];
        }

        long t=v;
        if(i+1<nums.length){
            t=Math.max(t, v+func(i+1,1-s,d,nums));
        }

        long delete=Long.MIN_VALUE/2;

        if(d==0&& i+1<nums.length){
            delete=func(i+1,s,1,nums);
        }

        return dp[i][s][d] =Math.max(t,delete);
    }
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        dp=new long[n][2][2];

        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j], Long.MIN_VALUE);
            }
        }
        long ans=Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.max(ans, func(i,0,0,nums));
        }
        return ans;
    }
}